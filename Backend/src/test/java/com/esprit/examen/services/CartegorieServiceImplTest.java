package com.esprit.examen.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@TestMethodOrder(OrderAnnotation.class)
public class CartegorieServiceImplTest {
    @Autowired
    ICategorieProduitService categorieProduitService;
    
    @Test
    @Order(1)
    public void testAddCategorie() throws ParseException {
        CategorieProduit cat = new CategorieProduit();
        cat.setCodeCategorie("CAT1");
        cat.setLibelleCategorie("categorie 1");
        CategorieProduit x = categorieProduitService.addCategorieProduit(cat);
        assertNotNull(x.getCodeCategorie());
        assertNotNull(x.getLibelleCategorie());
        log.info("categorie ajouter avec success");
    }
    
    @Test
    @Order(2)
    public void testModifierCategorie() throws ParseException {
        CategorieProduit cat = new CategorieProduit();
        cat.setCodeCategorie("CAT2");
        cat.setLibelleCategorie("categorie 2");
        categorieProduitService.addCategorieProduit(cat);
        log.info("categorie ajouter avec success");
        cat.setCodeCategorie("CAT5");
        cat.setLibelleCategorie("categorie 5");
        CategorieProduit x = categorieProduitService.updateCategorieProduit(cat);
        assertNotNull(x.getCodeCategorie());
        assertNotNull(x.getLibelleCategorie());
        log.info("categorie modifier avec success");
    }
    
    @Test
    @Order(3)
    public void testRetrieveAllCategorie() throws ParseException {
        List<CategorieProduit> listCategorie = categorieProduitService.retrieveAllCategorieProduits();
        Assertions.assertNotEquals(0, listCategorie.size());
        log.info("Nombre categorie: " + listCategorie.size()+" \n");
        for(int i=0;i<listCategorie.size();i++){
            log.info("==>"+listCategorie.get(i).getLibelleCategorie());
        }
    }
    
    @Test
    @Order(4)
    public void testDeleteCategorie() throws ParseException {
        CategorieProduit cat = new CategorieProduit();
        cat.setCodeCategorie("CAT2");
        cat.setLibelleCategorie("categorie");
        categorieProduitService.addCategorieProduit(cat);
        categorieProduitService.deleteCategorieProduit(cat.getIdCategorieProduit());
        log.info("categorie supprimer avec success");
    }
    
    
}
