package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

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

}
