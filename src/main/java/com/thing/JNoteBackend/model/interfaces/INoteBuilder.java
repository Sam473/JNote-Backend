package com.thing.JNoteBackend.model.interfaces;

import com.thing.JNoteBackend.model.Note;

import java.time.LocalDateTime;

import static com.thing.JNoteBackend.model.Note.NoteBuilder;

public interface INoteBuilder {

    NoteBuilder withTitle(String title);

    NoteBuilder withBody(String body);

    NoteBuilder withDateCreated(LocalDateTime created);

    NoteBuilder withDateLastModified(LocalDateTime modified);

    Note build();
}
