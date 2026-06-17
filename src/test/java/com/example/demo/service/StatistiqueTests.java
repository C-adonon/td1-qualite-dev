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
        statistiqueImpl.ajouter(ferrari);
        Echantillon echantillon = statistiqueImpl.prixMoyen();
        assertEquals(1, echantillon.getNombre());
        assertEquals(5000, echantillon.getPrixMoyen());
    }

    @Test
    void statistique2Voitures(){
        statistiqueImpl.ajouter(ferrari);
        statistiqueImpl.ajouter(porsche);
        Echantillon echantillon = statistiqueImpl.prixMoyen();
        assertEquals(2, echantillon.getNombre());
        assertEquals(4000, echantillon.getPrixMoyen());
    }

    @Test
    void statistique0Voiture(){
        assertThrows(ArithmeticException.class, () -> {
            statistiqueImpl.prixMoyen();
        });
    }

    @Test
    void rdmNbrVoitures(){
        int nbrVoiture = (int)(Math.random() * 21);
        for(int i = 0; i < nbrVoiture; i++){
            statistiqueImpl.ajouter(ferrari);
        }
        Echantillon echantillon = statistiqueImpl.prixMoyen();
        assertEquals(nbrVoiture, echantillon.getNombre());
        assertEquals(5000, echantillon.getPrixMoyen());
    }

    @Test
    public void testPrixMoyen() {
        statistiqueImpl.ajouter(ferrari);
        statistiqueImpl.ajouter(porsche);

        Echantillon echantillon = statistiqueImpl.prixMoyen();
        assertEquals(4000, echantillon.getPrixMoyen());
    }
}
