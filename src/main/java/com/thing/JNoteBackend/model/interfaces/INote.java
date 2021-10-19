package com.thing.JNoteBackend.model.interfaces;

import java.time.LocalDateTime;

public interface INote {

    String getTitle();

    String getBody();

    LocalDateTime getDateCreated();

    LocalDateTime getDateLastModified();

}
