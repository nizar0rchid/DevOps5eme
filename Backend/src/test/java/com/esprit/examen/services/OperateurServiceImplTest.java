package com.esprit.examen.services;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;


import lombok.extern.slf4j.Slf4j;



@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j


public class OperateurServiceImplTest {
	@Autowired
	IOperateurService operateurService;

	
	@Test
	public void testAddOperateur() throws ParseException {

	
		Operateur o = new Operateur ();
		o.setNom("Nizar");
		o.setPrenom("Ferchichi");
		o.setPassword("devops123");
		Operateur operateur = operateurService.addOperateur(o);
		System.out.print("client "+operateur);
		assertNotNull(operateur.getIdOperateur());
		assertTrue(operateur.getNom().length() > 0);
		assertTrue(operateur.getPrenom().length() > 0);
		assertTrue(operateur.getPassword().length() > 0);
		operateurService.deleteOperateur(operateur.getIdOperateur());

	}
}
