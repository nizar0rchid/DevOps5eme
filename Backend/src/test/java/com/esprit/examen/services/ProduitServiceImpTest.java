package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;

import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
@Slf4j

public class ProduitServiceImpTest {
    @Autowired
    private IProduitService service;
    @Autowired
    //private ProduitServiceImpl repo;   
    /*
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach void setUp()
    {
        this.service= new ProduitServiceImpl();
    }

    @Test   
    public void addProduitTest() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2021");
        //Produit produit = new Produit("cosesouna","libelleProduit",11,dateCreation,dateDerniereModification);
        Produit produitt = new Produit();
        produitt.setPrix(11);
        produitt.setDateCreation(dateCreation);
        produitt.setDateDerniereModification(dateDerniereModification);
        produitt.setLibelleProduit("libelleProduit");
        produitt.setCodeProduit("code221ayassine");
        System.out.print("Produit//////////////////////////////////////////////////////////////////////////////////////////////////////////"+produitt.getCodeProduit());

        service.addProduit(produitt);
        produit.setPrix(11);
        produit.setDateCreation(dateCreation);
        produit.setDateDerniereModification(dateDerniereModification);
        //produit.setLibelleProduit("libelleProduit");
        //produit.setCodeProduit("code221ayassine");
        Produit p = service.addProduit(produitt);
        System.out.print("Produit"+p);
        assertNotNull(p.getCodeProduit());
        assertNotNull(p.getPrix());
        assertTrue(p.getLibelleProduit().length() > 0 );
        //verify(service,times(1)).addProduit(produitt);
    }

    
    
    
    @Autowired
    private IProduitService service;
    */
    @Test
    public void addProduitTest() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2021");
        Produit produit = new Produit("78463145575","libelleProduit",11,dateCreation,dateDerniereModification);
        //produit.setLibelleProduit("libelleProduit");
        //produit.setCodeProduit("code221ayassine");
        Produit p = service.addProduit(produit);
        System.out.print("Produit"+p);
        assertNotNull(produit.getCodeProduit());
        assertNotNull(produit.getPrix());
        assertTrue(produit.getLibelleProduit().length() > 0 );
    }
    @Test

    public void deleteClientTest() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2021");
        Produit produit = new Produit("code2288888888881","libelleProduit",11,dateCreation,dateDerniereModification);
        Produit p = service.addProduit(produit);
        service.deleteProduit(p.getIdProduit());
        assertNull(service.retrieveProduit(p.getIdProduit()));
    }
    
    @Test
    public void retrieveAllProduitsTest() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2022");
        List<Produit> produits = service.retrieveAllProduits();
        int expected = produits.size(); 
        Produit produit = new Produit("code2288888888881","markaa",11,dateCreation,dateDerniereModification);
        Produit p = service.addProduit(produit);
        assertEquals(expected + 1,service.retrieveAllProduits().size());
        service.deleteProduit(p.getIdProduit());
    }
    
    @Test
    public void updateProduitTest() throws ParseException{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2021");
        Produit produit = new Produit("code2288888888881","markaa",11,dateCreation,dateDerniereModification);
        Produit p = service.addProduit(produit);
        Produit p2 = service.retrieveProduit(p.getIdProduit());
        log.info("produit :::::::::::::" + p2.getIdProduit());
        log.info("produit :::::::::::::" + p.getIdProduit());
        String code = "codePPPPPPPPPP";
        p2.setCodeProduit(code);

        service.updateProduit(p2);
        Produit p3 = service.retrieveProduit(p.getIdProduit());

        //assertNotEquals(p2,p);
        assertThat(p3.getCodeProduit()).isEqualTo(code);

        
    }

    
}





