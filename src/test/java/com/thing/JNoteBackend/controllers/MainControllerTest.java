package com.thing.JNoteBackend.controllers;

import com.thing.JNoteBackend.model.interfaces.INote;
import com.thing.JNoteBackend.service.NoteStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    MainController mainController;

    @Mock
    NoteStorageService noteStorageService;

    @BeforeEach
    void beforeEach() {
        mainController = new MainController(noteStorageService);
    }

    @Nested
    class ConstructorPreconditions {
        @Test
        void noteStorageServiceMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new MainController(null))
            .withMessage("noteStorageService must not be null");
        }
    }
    
    @Nested
    class Get {
        @Test
        void getNotesWillReturnAllNotes(@Mock final List<INote> notes) {
            given(noteStorageService.getNotes()).willReturn(notes);
            assertThat(mainController.getNotes()).isEqualTo(notes);
        }
    }

    @Nested
    class Add {
        @Nested
        class Preconditions {
            @Test
            void noteMustNotBeNull() {
                assertThatNullPointerException()
                        .isThrownBy(() -> mainController.addNote(null))
                        .withMessage("note must not be null");
            }
        }

        @Test
        void addNoteWillAddToNotes(@Mock final INote note) {
            given(noteStorageService.saveNote(note)).willReturn(note);
            assertThat(mainController.addNote(note)).isEqualTo(note);
        }
    }
}