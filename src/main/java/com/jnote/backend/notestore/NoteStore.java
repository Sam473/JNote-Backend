package com.jnote.backend.notestore;

import com.jnote.backend.model.interfaces.INote;

import java.util.List;

public interface NoteStore {

    INote saveNote(final INote note);

    List<INote> getNotes();
}
