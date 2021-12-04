package com.thing.JNoteBackend;

import com.thing.JNoteBackend.model.interfaces.INote;
import com.thing.JNoteBackend.notestore.InMemoryNoteStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@ExtendWith(MockitoExtension.class)
class InMemoryNoteStoreTest {

    InMemoryNoteStore inMemoryNoteStore;

    @Mock
    private List<INote> notes;

    @Nested
    class ConstructorPreconditions {
        @Test
        void notesMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new InMemoryNoteStore(null))
            .withMessage("notes must not be null");
        }
    }

    @BeforeEach
    void beforeEach() {
        inMemoryNoteStore = new InMemoryNoteStore(notes);
    }

    @Nested
    class Get {

        @Test
        void getNotesWillReturnAllNotes() {
            assertThat(inMemoryNoteStore.getNotes()).isEqualTo(notes);
        }

    }

    @Nested
    class Save {
        @Nested
        class Preconditions {
            @Test
            void noteMustNotBeNull() {
                assertThatNullPointerException()
                        .isThrownBy(() -> inMemoryNoteStore.saveNote(null))
                        .withMessage("note must not be null");
            }
        }

        @Test
        void saveNoteWillSave(@Mock final INote note) {
            assertThat(inMemoryNoteStore.saveNote(note)).isEqualTo(note);
        }
    }
}