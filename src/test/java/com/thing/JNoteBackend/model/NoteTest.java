package com.thing.JNoteBackend.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.thing.JNoteBackend.model.Note.NoteBuilder;

@ExtendWith(MockitoExtension.class)
public class NoteTest {
    Note testNote;

    @BeforeAll
    void beforeAll(){
        //TODO: Build this properly for the testing
        testNote = new NoteBuilder()
                .withTitle("")
                .withBody("")
                .build();
    }

}
