package com.thing.JNoteBackend;

import com.thing.JNoteBackend.model.interfaces.INote;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

@Component
public class NoteStore {

    final List<INote> notes;

    public NoteStore (final List<INote> notes) {
        this.notes = notNull(notes, "notes must not be null");
    }

    public INote saveNote(final INote note) {
        notNull(note, "note must not be null");
        notes.add(note);
        return note;
    }

    public List<INote> getNotes() {
        return notes;
    }
}
