package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImpTest {
    
    @Autowired
    private IProduitService service;
    
    @Test
    public void addProduitWithSuccess() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2022");
        Produit produit = new Produit();
        produit.setPrix(11);
        produit.setDateCreation(dateCreation);
        produit.setDateDerniereModification(dateDerniereModification);
        produit.setLibelleProduit("libelleProduitrr8");
        produit.setCodeProduit("code221");
        Produit p = service.addProduit(produit);
        System.out.print("Produit"+p);
        assertNotNull(produit.getCodeProduit());
        assertNotNull(produit.getPrix());
        assertTrue(produit.getLibelleProduit().length() > 0 );
    }
    
    public void deleteClientWithSuccess() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2021");
        Produit produit = new Produit();
        produit.setPrix(11);
        produit.setDateCreation(dateCreation);
        produit.setDateDerniereModification(dateDerniereModification);
        produit.setLibelleProduit("libelleProduit");
        produit.setCodeProduit("code2212222");
        Produit p = service.addProduit(produit);
        service.deleteProduit(p.getIdProduit());
        assertNull(service.retrieveProduit(p.getIdProduit()));


    }
    
    public void retrieveAllProduits() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2022");
        List<Produit> produits = service.retrieveAllProduits();
        int expected = produits.size(); 
        Produit produit = new Produit();
        produit.setPrix(11);
        produit.setDateCreation(dateCreation);
        produit.setDateDerniereModification(dateDerniereModification);
        produit.setLibelleProduit("markaa");
        produit.setCodeProduit("code2212222");
        Produit p = service.addProduit(produit);
        assertEquals(expected + 1,service.retrieveAllProduits().size());
        service.deleteProduit(p.getIdProduit());

    }
    
}
