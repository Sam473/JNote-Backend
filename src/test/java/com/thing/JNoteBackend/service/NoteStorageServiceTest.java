package com.thing.JNoteBackend.service;

import com.thing.JNoteBackend.NoteStore;
import com.thing.JNoteBackend.model.interfaces.INote;
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
class NoteStorageServiceTest {

    private NoteStorageService noteStorageService;

    @Mock
    private NoteStore noteStore;

    @BeforeEach
    void beforeEach() {
        noteStorageService = new NoteStorageService(noteStore);
    }

    @Nested
    class ConstructorPreconditions {
        @Test
        void noteStoreMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new NoteStorageService(null))
            .withMessage("noteStore must not be null");
        }
    }

    @Nested
    class Get {

        @Test
        void getNotesWillReturnAllNotes(@Mock final List<INote> notes) {
            given(noteStore.getNotes()).willReturn(notes);
            assertThat(noteStorageService.getNotes()).isEqualTo(notes);
        }

    }

    @Nested
    class Save {
        @Nested
        class Preconditions {
            @Test
            void noteMustNotBeNull() {
                assertThatNullPointerException()
                        .isThrownBy(() -> noteStorageService.saveNote(null))
                        .withMessage("note must not be null");
            }
        }

        @Test
        void saveNoteWillAddToNotes(@Mock final INote note) {
            given(noteStore.saveNote(note)).willReturn(note);
            assertThat(noteStorageService.saveNote(note)).isEqualTo(note);
        }
    }

}