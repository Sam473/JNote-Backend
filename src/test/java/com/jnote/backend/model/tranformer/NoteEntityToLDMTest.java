package com.jnote.backend.model.tranformer;

import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.interfaces.INote;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class NoteEntityToLDMTest {

    private static final LocalDateTime DATE_LAST_MODIFIED = LocalDateTime.of(2021, 2, 2, 2, 2, 3);
    private static final LocalDateTime DATE_CREATED = LocalDateTime.of(2020, 2, 2, 2, 2, 2);
    private static final String TITLE = "title";
    private static final String BODY = "body";

    @Test
    void entityMustNotBeNull() {
    assertThatNullPointerException()
        .isThrownBy(() -> new NoteEntityToLDM().transform(null))
        .withMessage("entity must not be null");
    }

    @Test
    void willReturnLDMWithCorrectProperties() {
        final NoteEntityToLDM noteEntityToLDM = new NoteEntityToLDM();
        final NoteEntity noteEntity = new NoteEntity(TITLE, BODY, DATE_CREATED, DATE_LAST_MODIFIED);
        final INote expected = INote.builder()
                .withTitle(TITLE)
                .withBody(BODY)
                .withDateCreated(DATE_CREATED)
                .withDateLastModified(DATE_LAST_MODIFIED)
                .build();

        assertThat(noteEntityToLDM.transform(noteEntity)).usingRecursiveComparison().isEqualTo(expected);
    }
}