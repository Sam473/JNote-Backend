package com.jnote.backend.model;

import com.jnote.backend.model.interfaces.INote;
import com.jnote.backend.model.interfaces.INoteBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

import static org.apache.commons.lang3.Validate.notNull;

public class Note implements INote, Serializable {
    private final String title;
    private final String body;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateLastModified;

    private Note(final NoteBuilder builder) {
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

    public static NoteBuilder builder(){
        return new NoteBuilder();
    }

    public static class NoteBuilder implements INoteBuilder {
        private String title;
        private String body;
        private LocalDateTime dateCreated;
        private LocalDateTime dateLastModified;

        public NoteBuilder() {
            this.dateCreated = LocalDateTime.now();
            this.dateLastModified = LocalDateTime.now();
        }

        @Override
        public NoteBuilder withBody(final String body) {
            notNull(body, "body must not be null");
            this.body = body;
            return this;
        }

        @Override
        public NoteBuilder withTitle(final String title) {
            notNull(title, "title must not be null");
            this.title = title;
            return this;
        }

        @Override
        public NoteBuilder withDateCreated(final LocalDateTime dateCreated) {
            notNull(dateCreated, "dateCreated must not be null");
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public NoteBuilder withDateLastModified(final LocalDateTime dateLastModified) {
            notNull(dateLastModified, "dateLastModified must not be null");
            this.dateLastModified = dateLastModified;
            return this;
        }

        @Override
        public Note build() {
            return new Note(this);
        }
    }
}
