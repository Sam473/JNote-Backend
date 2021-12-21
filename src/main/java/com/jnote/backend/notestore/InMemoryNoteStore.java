package com.jnote.backend.notestore;

import com.jnote.backend.model.interfaces.INote;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

@Component
@Profile("inmemory")
@Deprecated()
public class InMemoryNoteStore implements NoteStore{

    final List<INote> notes;

    public InMemoryNoteStore(final List<INote> notes) {
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
