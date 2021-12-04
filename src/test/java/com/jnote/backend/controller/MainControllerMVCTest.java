package com.jnote.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainControllerMVCTest {

    @Autowired
    private MainController mainController;

    final String note1Json = "";
    final String note2Json = "";
    final String allNotesJson = "[" + note1Json + "," + note2Json + "]";


    @Test
    void canSaveNote() {

    }

    @Test
    void canRetrieveAllSavedNotes() {

    }

}
