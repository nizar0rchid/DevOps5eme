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

import com.esprit.examen.entities.Operateur;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

@TestMethodOrder(OrderAnnotation.class)
public class OperateurServiceImplTest {
	@Autowired
	IOperateurService operateurService;

	@Test
	@Order(1)
	public void testAddOperateur() throws ParseException {

		Operateur o = new Operateur();
		o.setNom("Nizar");
		o.setPrenom("Ferchichi");
		o.setPassword("devops123");
		Operateur operateur = operateurService.addOperateur(o);
		System.out.print("client " + operateur);
		assertNotNull(operateur.getIdOperateur());
		assertTrue(operateur.getNom().length() > 0);
		assertTrue(operateur.getPrenom().length() > 0);
		assertTrue(operateur.getPassword().length() > 0);
		log.info("Operateur ajouter avec success");

	}

	@Test
	@Order(2)
	public void testModifierOperateur() throws ParseException {
		Operateur o = new Operateur();
		o.setNom("Nizar");
		o.setPrenom("Ferchichi");
		o.setPassword("devops123");
		Operateur operateur = operateurService.addOperateur(o);
		System.out.print("client " + operateur);

		log.info("Operateur ajouter avec success");

		o.setNom("Yassine");
		o.setPrenom("Derbel");
		Operateur x = operateurService.updateOperateur(o);
		assertNotNull(operateur.getIdOperateur());
		assertTrue(operateur.getNom().length() > 0);
		assertTrue(operateur.getPrenom().length() > 0);
		log.info("categorie modifier avec success");
	}

	@Test
	@Order(3)
	public void testRetrieveAllOperateurs() throws ParseException {
		List<Operateur> listOperateur = operateurService.retrieveAllOperateurs();
		Assertions.assertNotEquals(0, listOperateur.size());
		log.info("Nombre operateurs: " + listOperateur.size() + " \n");
		for (int i = 0; i < listOperateur.size(); i++) {
			log.info("==>" + listOperateur.get(i).getNom());
		}
	}

	@Test
	@Order(4)
	public void testDeleteOperateur() throws ParseException {
		Operateur o = new Operateur();
		o.setNom("Nizar");
		o.setPrenom("Ferchichi");
		o.setPassword("devops123");
		operateurService.addOperateur(o);
		operateurService.deleteOperateur(o.getIdOperateur());
		log.info("Operateur supprimé avec success");
	}
}
