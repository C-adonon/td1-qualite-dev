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
    public void getStatistiques() throws Exception {
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Ferrari", 100000));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(1, 100000));
        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(1))
                .andExpect(jsonPath("$.prixMoyen").value(100000));
                .andReturn();
    }

}
