package com.thing.JNoteBackend.model.interfaces;

import com.thing.JNoteBackend.model.Note;

import java.time.LocalDateTime;

import static com.thing.JNoteBackend.model.Note.NoteBuilder;

public interface INoteBuilder {

    NoteBuilder withTitle(String title);

    NoteBuilder withBody(String body);

    NoteBuilder withDateCreated(final LocalDateTime dateCreated);

    NoteBuilder withDateLastModified(final LocalDateTime dateLastModified);

    Note build();
}
