package com.jnote.backend.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "NOTE")
public class NoteEntity {

    @Id
    @GeneratedValue
    private Long id;

    private final String title;
    private final String body;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateLastModified;

    public NoteEntity(final String title, final String body,final LocalDateTime dateCreated, final LocalDateTime dateLastModified) {
        this.title = title;
        this.body = body;
        this.dateCreated = dateCreated;
        this.dateLastModified = dateLastModified;
    }

    public Long getId() {
        return id;
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
}
