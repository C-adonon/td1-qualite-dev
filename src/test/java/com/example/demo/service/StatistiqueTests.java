package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatistiqueTests {

    private StatistiqueImpl statistiqueImpl;
    private Voiture ferrari;
    private Voiture porsche;

    @BeforeEach
    void setUp() {
        statistiqueImpl = new StatistiqueImpl();
        ferrari = new Voiture("Ferrari", 5000);
        porsche = new Voiture("Porsche", 3000);
    }

    @Test
    void statistique1Voiture(){
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Ferrari", 5000));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(1, 5000));
    }

    @Test
    void statistique2Voitures(){
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Ferrari", 5000));
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Porsche", 3000));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(2, 4000));
    }

    @Test
    void statistique0Voiture(){
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());
    }

    @Test
    void rdmNbrVoitures(){
        int nbrVoiture = (int)(Math.random() * 21);
        for(int i = 0; i < nbrVoiture; i++){
            doNothing().when(statistiqueImpl).ajouter(new Voiture("Ferrari", 5000));
        }
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(nbrVoiture, 5000));
    }

    @Test
    public void testPrixMoyen() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        Voiture voiture1 = new Voiture("Toyota", 5000);
        statistique.ajouter(voiture1);

        Voiture voiture2 = new Voiture("Honda",  7000);
        statistique.ajouter(voiture2);

        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(6000, echantillon.getPrixMoyen());
    }
}
