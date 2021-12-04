package com.jnote.backend.model.interfaces;

import com.jnote.backend.model.Note;

import java.time.LocalDateTime;

public interface INoteBuilder {

    Note.NoteBuilder withTitle(String title);

    Note.NoteBuilder withBody(String body);

    Note.NoteBuilder withDateCreated(final LocalDateTime dateCreated);

    Note.NoteBuilder withDateLastModified(final LocalDateTime dateLastModified);

    Note build();
}
