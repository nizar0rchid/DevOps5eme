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

public class OperateurServiceImplMockTest {
    @Autowired
    OperateurServiceImpl operateurServiceImpl;
    @MockBean
    OperateurRepository operateurRepository;

    @Test
    @Order(1)
    public void saveCategorieTest() {
        Operateur cat = new Operateur("Nizar", "Ferchichi", "devops123");
        Mockito.when(operateurRepository.save(cat)).thenReturn(cat);
        assertEquals(cat, operateurServiceImpl.addOperateur(cat));
    }

    @Test
    @Order(2)
    public void getOperateursTest() {
        Mockito.when(operateurRepository.findAll()).thenReturn(Stream
                .of(new Operateur("Nizar", "Ferchichi", "devops123"), new Operateur("Yassine", "Derbel", "devops123"))
                .collect(Collectors.toList()));
        assertEquals(2, operateurServiceImpl.retrieveAllOperateurs().size());
        List<Operateur> listOperateurs = operateurServiceImpl.retrieveAllOperateurs();
        log.info("==>size:" + listOperateurs.size());
        for (int i = 0; i < listOperateurs.size(); i++) {
            log.info("==>" + listOperateurs.get(i).getNom());
        }
    }

    @Test
    @Order(3)
    public void deleteOperateurTest() {
        Operateur cat = new Operateur("Nizar", "Ferchichi", "devops123");
        operateurServiceImpl.deleteOperateur(cat.getIdOperateur());
        log.info("Operateur supprimé avec success");
    }

}
