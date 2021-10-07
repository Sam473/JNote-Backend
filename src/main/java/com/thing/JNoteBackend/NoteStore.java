package com.thing.JNoteBackend;

import com.thing.JNoteBackend.model.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteStore {

    List<Note> notes = new ArrayList<>();

    public Note saveNote(final Note note) {
        //TODO: fix for case of note already stored
        notes.add(note);
        return note;
    }


    public List<Note> getNotes() {
        return notes;
    }
}
