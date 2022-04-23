package com.jnote.backend.service;

import com.jnote.backend.model.interfaces.INote;
import com.jnote.backend.notestore.NoteStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

@Component
//TODO: Could make this StorageService<INote> if I end up with multiple StorageServices
public class NoteStorageService {

    final NoteStore noteStore;

    public NoteStorageService(@Autowired final NoteStore noteStore) {
        this.noteStore = notNull(noteStore, "noteStore must not be null");
    }

    public INote saveNote(final INote note) {
        notNull(note, "note must not be null");
        return noteStore.saveNote(note);
    }

    public List<INote> getNotes() {
        return noteStore.getNotes();
    }

}
