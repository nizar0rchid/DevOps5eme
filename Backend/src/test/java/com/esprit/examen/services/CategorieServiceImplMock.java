package com.esprit.examen.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class CategorieServiceImplMock {

	@Autowired
	CategorieProduitServiceImpl categorieProduitServiceImpl;
	@MockBean
	CategorieProduitRepository categorieProduitRepository;

	@Test
	@Order(1)
	public void saveCategorieTest() {
		CategorieProduit cat = new CategorieProduit("cat1", "categorie 1");
		Mockito.when(categorieProduitRepository.save(cat)).thenReturn(cat);
		assertEquals(cat, categorieProduitServiceImpl.addCategorieProduit(cat));
	}
	
	@Test
	@Order(2)
	public void getUsersTest() {
		Mockito.when(categorieProduitRepository.findAll()).thenReturn(Stream
				.of(new CategorieProduit("cat2", "categorie 2"), new CategorieProduit("cat2", "categorie 3")).collect(Collectors.toList()));
		assertEquals(2, categorieProduitServiceImpl.retrieveAllCategorieProduits().size());
		List<CategorieProduit> listCategorie = categorieProduitServiceImpl.retrieveAllCategorieProduits();
		log.info("==>size:"+listCategorie.size());
		for(int i=0;i<listCategorie.size();i++){
			log.info("==>"+listCategorie.get(i).getLibelleCategorie());
		}
	}

	@Test
	@Order(3)
	public void deleteUserTest() {
		CategorieProduit cat = new CategorieProduit("cat4", "categorie 4");
		categorieProduitServiceImpl.deleteCategorieProduit(cat.getIdCategorieProduit());
		log.info("categorie supprimer avec success");
	}
}