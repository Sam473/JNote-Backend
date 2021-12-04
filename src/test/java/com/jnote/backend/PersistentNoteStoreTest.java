//package com.jnote.backend;
//
//import com.jnote.backend.jpa.NoteEntity;
//import com.jnote.backend.model.interfaces.INote;
//import com.jnote.backend.notestore.InMemoryNoteStore;
//import com.jnote.backend.notestore.PersistentNoteStore;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatNullPointerException;
//
//@ExtendWith(MockitoExtension.class)
//class PersistentNoteStoreTest {
//
//    PersistentNoteStore persistentNoteStore;
//
//    @Mock
//    JpaRepository<NoteEntity, Long> repository;
//
//    @Nested
//    class ConstructorPreconditions {
//        @Test
//        void notesMustNotBeNull() {
//        assertThatNullPointerException()
//            .isThrownBy(() -> new InMemoryNoteStore(null))
//            .withMessage("notes must not be null");
//        }
//    }
//
//    @BeforeEach
//    void beforeEach() {
//        persistentNoteStore = new InMemoryNoteStore(notes);
//    }
//
//    //TODO: Test this
////    @Nested
////    class Get {
////
////        @Test
////        void getNotesWillReturnAllNotes() {
////            assertThat(persistentNoteStore.getNotes()).isEqualTo(notes);
////        }
////
////    }
//
//    @Nested
//    class Save {
//        @Nested
//        class Preconditions {
//            @Test
//            void noteMustNotBeNull() {
//                assertThatNullPointerException()
//                        .isThrownBy(() -> persistentNoteStore.saveNote(null))
//                        .withMessage("note must not be null");
//            }
//        }
//
//        @Test
//        void saveNoteWillSave(@Mock final INote note) {
//            assertThat(persistentNoteStore.saveNote(note)).isEqualTo(note);
//        }
//    }
//}