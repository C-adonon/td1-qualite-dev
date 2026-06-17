package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getStatistiques() throws Exception {
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Ferrari", 100000));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(1, 100000));
        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(1))
                .andExpect(jsonPath("$.prixMoyen").value(100000))
                .andReturn();
    }
}
