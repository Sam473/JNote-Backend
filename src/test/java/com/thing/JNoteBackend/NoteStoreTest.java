package com.thing.JNoteBackend;

import com.thing.JNoteBackend.model.Note;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NoteStoreTest {

    NoteStore noteStore = new NoteStore();

    @Test
    void saveNoteWillSave(@Mock Note note) {
        assertThat(noteStore.saveNote(note)).isEqualTo(note);
    }
}