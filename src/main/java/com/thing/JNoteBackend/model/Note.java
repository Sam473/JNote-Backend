package com.thing.JNoteBackend.model;

import com.thing.JNoteBackend.model.interfaces.INote;
import com.thing.JNoteBackend.model.interfaces.INoteBuilder;

import java.time.LocalDateTime;

public class Note implements INote {
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

    private Note(final String title, final String body, final LocalDateTime dateCreated, final LocalDateTime dateLastModified) {
        this.title = title;
        this.body = body;
        this.dateCreated = dateCreated;
        this.dateLastModified = dateLastModified;
    }

    public static class NoteBuilder implements INoteBuilder {
        private String title;
        private String body;
        private LocalDateTime dateCreated;
        private LocalDateTime dateLastModified;

        @Override
        public NoteBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        @Override
        public NoteBuilder withDateCreated(LocalDateTime created) {
            this.dateCreated = created;
            return this;
        }

        @Override
        public NoteBuilder withDateLastModified(LocalDateTime modified) {
            this.dateLastModified = modified;
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
