package com.jnote.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"test", "h2"})
public class MainControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    final String note1Json = "{" +
            "\"title\":\"PSA:\"," +
            "\"body\":\"Test Driven Development is the BEANS\"," +
            "\"dateCreated\":\"2021-12-04T14:11:43.38\"," +
            "\"dateLastModified\":\"2021-12-04T14:11:43.38\"" +
            "}";
    final String note2Json = "{" +
            "\"title\":\"PSA:\"," +
            "\"body\":\"Test Driven Development is the BIG BEANS\"," +
            "\"dateCreated\":\"2021-12-04T14:17:32.89\"," +
            "\"dateLastModified\":\"2021-12-04T14:17:32.89\"" +
            "}";
    final String allNotesJson = "[" + note1Json + "," + note2Json + "]";


    @Test
    @DirtiesContext
    void canSaveNote() throws Exception {
        this.mockMvc.perform(post("/api/v1/note").contentType("application/json").content(note1Json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(note1Json));
    }

    @Test
    @DirtiesContext
    void canRetrieveAllSavedNotes() throws Exception {
        this.mockMvc.perform(post("/api/v1/note").contentType("application/json").content(note1Json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(note1Json));
        this.mockMvc.perform(post("/api/v1/note").contentType("application/json").content(note2Json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(note2Json));
        this.mockMvc.perform(get("/api/v1/note"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(allNotesJson));
    }
}