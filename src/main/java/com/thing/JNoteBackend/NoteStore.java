package com.thing.JNoteBackend;

import com.thing.JNoteBackend.model.Note;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class NoteStore {

    Set<Note> notes = new HashSet<>();

    public Note saveNote(final Note note) {
        //TODO: fix for case of note already stored
        notes.add(note);
        return note;
    }


    public Set<Note> getNotes() {
        return notes;
    }
}
