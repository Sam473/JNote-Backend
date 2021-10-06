package com.thing.JNoteBackend.service;

import com.thing.JNoteBackend.NoteStore;
import com.thing.JNoteBackend.model.Note;
import io.micrometer.core.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class NoteStorageService {

    @NonNull
    NoteStore noteStore;

    public NoteStorageService(@Autowired final NoteStore noteStore) {
        this.noteStore = noteStore;
    }

    public Note saveNote(final Note note) {
        return noteStore.saveNote(note);
    }

    public Set<Note> getNotes() {
        return noteStore.getNotes();
    }

}
