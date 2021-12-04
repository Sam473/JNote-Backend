package com.jnote.backend.jpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "NOTE")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;
    private LocalDateTime dateCreated;
    private LocalDateTime dateLastModified;

    public NoteEntity(final String title, final String body,final LocalDateTime dateCreated, final LocalDateTime dateLastModified) {
        this.title = title;
        this.body = body;
        this.dateCreated = dateCreated;
        this.dateLastModified = dateLastModified;
    }

    //TODO: Does this need to be protected?
    protected NoteEntity() {}

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
