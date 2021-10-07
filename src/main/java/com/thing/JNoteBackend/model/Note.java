package com.thing.JNoteBackend.model;

import com.thing.JNoteBackend.model.interfaces.INote;
import com.thing.JNoteBackend.model.interfaces.INoteBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements INote, Serializable {
    private final String title;
    private final String body;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateLastModified;

    private Note(NoteBuilder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.dateCreated = builder.dateCreated;
        this.dateLastModified = builder.dateLastModified;
    }

    private Note(final String title, final String body) {
        this.title = title;
        this.body = body;
        this.dateCreated = LocalDateTime.now();
        this.dateLastModified = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateLastModified() {
        return dateLastModified;
    }

    public static class NoteBuilder implements INoteBuilder {
        private String title;
        private String body;
        private final LocalDateTime dateCreated;
        private final LocalDateTime dateLastModified;

        public NoteBuilder() {
            this.dateCreated = LocalDateTime.now();
            this.dateLastModified = LocalDateTime.now();
        }

        @Override
        public NoteBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        @Override
        public NoteBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        @Override
        public Note build() {
            Note note = new Note(this);
            return note;
        }

    }

}
