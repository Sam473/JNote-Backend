package com.jnote.backend.service;

import com.jnote.backend.model.interfaces.INote;
import com.jnote.backend.notestore.InMemoryNoteStore;
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
    private InMemoryNoteStore inMemoryNoteStore;

    @BeforeEach
    void beforeEach() {
        noteStorageService = new NoteStorageService(inMemoryNoteStore);
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
            given(inMemoryNoteStore.getNotes()).willReturn(notes);
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
            given(inMemoryNoteStore.saveNote(note)).willReturn(note);
            assertThat(noteStorageService.saveNote(note)).isEqualTo(note);
        }
    }

}