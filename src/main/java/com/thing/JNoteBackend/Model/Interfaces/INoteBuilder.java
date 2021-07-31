package com.thing.JNoteBackend.Model.Interfaces;

import com.thing.JNoteBackend.Model.Note;

import java.time.LocalDateTime;

public interface INoteBuilder {

    void withTitle(String title);

    void withBody(String body);

    void withDateCreated(LocalDateTime created);

    void withDateLastModified(LocalDateTime modified);

    Note build();
}
