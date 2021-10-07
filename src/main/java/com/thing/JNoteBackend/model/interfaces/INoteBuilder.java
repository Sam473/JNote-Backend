package com.thing.JNoteBackend.model.interfaces;

import com.thing.JNoteBackend.model.Note;

import static com.thing.JNoteBackend.model.Note.NoteBuilder;

public interface INoteBuilder {

    NoteBuilder withTitle(String title);

    NoteBuilder withBody(String body);

    Note build();
}
