package com.jnote.backend.notestore;

import com.google.common.collect.ImmutableList;
import com.jnote.backend.model.interfaces.INote;

public interface NoteStore {

    INote saveNote(final INote note);

    ImmutableList<INote> getNotes();
}
