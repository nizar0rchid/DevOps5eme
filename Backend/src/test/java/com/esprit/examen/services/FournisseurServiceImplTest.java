package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Fournisseur;

import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

@TestMethodOrder(OrderAnnotation.class)
public class FournisseurServiceImplTest {
    @Autowired
    IFournisseurService fournisseurService;

    @Test
    @Order(1)
    public void testAddOperateur() throws ParseException {

        Fournisseur o = new Fournisseur();
        o.setCode("Nizar");
        o.setLibelle("Ferchichi");
        Fournisseur fournisseur = fournisseurService.addFournisseur(o);
        System.out.print("four " + fournisseur);
        assertNotNull(fournisseur.getIdFournisseur());
        assertTrue(fournisseur.getCode().length() > 0);
        assertTrue(fournisseur.getLibelle().length() > 0);
        log.info("Fournisseur ajouter avec success");

    }

    @Test
    @Order(2)
    public void testModifierFournisseur() throws ParseException {
        Fournisseur o = new Fournisseur();
        o.setCode("Nizar");
        o.setLibelle("Ferchichi");

        Fournisseur fournisseur = fournisseurService.addFournisseur(o);
        System.out.print("four " + fournisseur);

        log.info("Fournisseur ajouter avec success");

        o.setCode("Yassine");
        o.setLibelle("Derbel");
        Fournisseur x = fournisseurService.updateFournisseur(o);
        assertNotNull(fournisseur.getIdFournisseur());
        assertTrue(fournisseur.getCode().length() > 0);
        assertTrue(fournisseur.getLibelle().length() > 0);
        log.info("fournisseur modifier avec success");
    }

    @Test
    @Order(3)
    public void testRetrieveAllfournisseur() throws ParseException {
        List<Fournisseur> listfournisseur = fournisseurService.retrieveAllFournisseurs();
        Assertions.assertNotEquals(0, listfournisseur.size());
        log.info("Nombre fournisseur: " + listfournisseur.size() + " \n");
        for (int i = 0; i < listfournisseur.size(); i++) {
            log.info("==>" + listfournisseur.get(i).getCode());
        }
    }

    @Test
    @Order(4)
    public void testDeleteFournisseur() throws ParseException {
        Fournisseur o = new Fournisseur();
        o.setCode("Nizar");
        o.setLibelle("Ferchichi");
        fournisseurService.addFournisseur(o);
        fournisseurService.deleteFournisseur(o.getIdFournisseur());
        log.info("Operateur supprimé avec success");
    }
}
