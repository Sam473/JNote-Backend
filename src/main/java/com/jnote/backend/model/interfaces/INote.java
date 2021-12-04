package com.jnote.backend.model.interfaces;

import com.jnote.backend.model.Note;

import java.time.LocalDateTime;

public interface INote {

    String getTitle();

    String getBody();

    LocalDateTime getDateCreated();

    LocalDateTime getDateLastModified();

    static INoteBuilder builder() {
        return new Note.NoteBuilder();
    }

}
