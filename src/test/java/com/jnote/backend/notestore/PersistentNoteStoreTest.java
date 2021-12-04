package com.jnote.backend.notestore;

import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.Note;
import com.jnote.backend.model.interfaces.INote;
import com.jnote.backend.model.tranformer.OneToOneTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PersistentNoteStoreTest {

    PersistentNoteStore persistentNoteStore;

    @Mock
    JpaRepository<NoteEntity, Long> repository;

    @Mock
    OneToOneTransformer<INote, NoteEntity> noteLDMToEntity;

    @Mock
    OneToOneTransformer<NoteEntity, INote> noteEntityToLDM;

    @Nested
    class ConstructorPreconditions {
        @Test
        void repositoryMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new PersistentNoteStore(null, noteLDMToEntity, noteEntityToLDM))
            .withMessage("repository must not be null");
        }

        @Test
        void noteLDMToEntityMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new PersistentNoteStore(repository, null, noteEntityToLDM))
            .withMessage("noteLDMToEntity must not be null");
        }
        @Test
        void noteEntityToLDMMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new PersistentNoteStore(repository, noteLDMToEntity, null))
            .withMessage("noteEntityToLDM must not be null");
        }
    }

    @BeforeEach
    void beforeEach() {
        persistentNoteStore = new PersistentNoteStore(repository, noteLDMToEntity, noteEntityToLDM);
    }

    @Nested
    class Get {

        @Test
        void getNotesWillReturnAllNotes(@Mock final NoteEntity noteEntity, @Mock final Note note) {
            final List<NoteEntity> noteEntities = List.of(noteEntity);

            given(repository.findAll()).willReturn(noteEntities);
            given(noteEntityToLDM.transform(noteEntity)).willReturn(note);
            assertThat(persistentNoteStore.getNotes()).isEqualTo(List.of(note));
        }

    }

    @Nested
    class Save {
        @Nested
        class Preconditions {
            @Test
            void noteMustNotBeNull() {
                assertThatNullPointerException()
                        .isThrownBy(() -> persistentNoteStore.saveNote(null))
                        .withMessage("note must not be null");
            }
        }

        @Test
        void saveNoteWillSave(@Mock final INote note, @Mock final NoteEntity noteEntity) {
            given(noteLDMToEntity.transform(note)).willReturn(noteEntity);
            given(repository.save(noteEntity)).willReturn(noteEntity);
            given(noteEntityToLDM.transform(noteEntity)).willReturn(note);
            assertThat(persistentNoteStore.saveNote(note)).usingRecursiveComparison().isEqualTo(note);
        }
    }
}