package com.thing.JNoteBackend.service;

import com.thing.JNoteBackend.NoteStore;
import com.thing.JNoteBackend.model.interfaces.INote;
import io.micrometer.core.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

@Component
public class NoteStorageService {

    @NonNull
    NoteStore noteStore;

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
