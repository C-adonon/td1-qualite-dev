package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture() {
        Voiture voiture = new Voiture("Porsche", 70000);
        Assert.isTrue(voiture.getMarque().equals("Porsche"), "Doit être Porsche");
        Assert.isTrue(voiture.getPrix() == 70000, "Prix doit être 70000");
        Assert.isTrue(voiture.getId() == 0, "Doit être 0");
    }

    @Test
    void creerVoitureAvecId() {
        Voiture voiture = new Voiture("Fiat", 7000);
        Assert.isTrue(voiture.getMarque().equals("Fiat"), "Doit être une Fiat");
        Assert.isTrue(voiture.getPrix() == 7000, "Prix doit être 7000");
        Assert.isTrue(voiture.setId(2), "Doit être 2");
    }

    @Test
    void creerVoitureSansParams() {
        Voiture voiture = new Voiture();
        Assert.isTrue(voiture.getMarque() == null, "Doit être null");
        Assert.isTrue(voiture.getPrix() == 0, "Prix doit être 0");
        Assert.isTrue(voiture.getId() == 0, "Doit être 0");
    }

    @Test
    void setMarque() {
        Voiture voiture = new Voiture();
        voiture.setMarque("Tesla");
        Assert.isTrue(voiture.getMarque().equals("Tesla"), "Doit être Tesla");
    }

    @Test
    void toStringVoiture() {
        Voiture voiture = new Voiture("Renault", 15000);
        voiture.setId(1);
        String expected = "Car{marque='Renault', prix=15000, id=1}";
        assertEquals(expected, voiture.toString(), "Affiche les infos de la voiture de la bonne forme");
    }

}
