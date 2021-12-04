package com.thing.JNoteBackend.notestore;

import com.thing.JNoteBackend.model.interfaces.INote;

import java.util.List;

public interface NoteStore {

    INote saveNote(final INote note);

    List<INote> getNotes();
}
