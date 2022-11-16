package com.esprit.examen.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.OperateurRepository;

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


public class FournisseurServiceImplMockTest {
    @Autowired
    FournisseurServiceImpl fournisseurServiceImpl;
    @MockBean
    FournisseurRepository fournisseurRepository;

    @Test
    @Order(1)
    public void saveFournisseurTest() {
        Fournisseur Fou = new Fournisseur();
        Fou.setCode("sami");
        Fou.setLibelle("tfifha");
        Mockito.when(fournisseurRepository.save(Fou)).thenReturn(Fou);
        assertEquals(Fou, fournisseurServiceImpl.addFournisseur(Fou));
    }

    @Test
    @Order(2)
    public void getOperateursTest() {
        Mockito.when(fournisseurRepository.findAll()).thenReturn(Stream
                .of(new Fournisseur("Nizar", "Ferchichi"), new Fournisseur("Yassine", "Derbel"))
                .collect(Collectors.toList()));
        assertEquals(2, fournisseurServiceImpl.retrieveAllFournisseurs().size());
        List<Fournisseur> listFournisseur = fournisseurServiceImpl.retrieveAllFournisseurs();
        log.info("==>size:" + listFournisseur.size());
        for (int i = 0; i < listFournisseur.size(); i++) {
            log.info("==>" + listFournisseur.get(i).getCode());
        }
    }

    @Test
    @Order(3)
    public void deleteFournisseurTest() {
        Fournisseur Fou = new Fournisseur("Nizar", "Ferchichi");
        fournisseurServiceImpl.deleteFournisseur(Fou.getIdFournisseur());
        log.info("Fournisseur supprimé avec success");
    }

}
