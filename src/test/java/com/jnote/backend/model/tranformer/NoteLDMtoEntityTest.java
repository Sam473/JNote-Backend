package com.jnote.backend.model.tranformer;

import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.interfaces.INote;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class NoteLDMtoEntityTest {

    public static final LocalDateTime DATE_LAST_MODIFIED = LocalDateTime.of(2021, 2, 2, 2, 2, 3);
    public static final LocalDateTime DATE_CREATED = LocalDateTime.of(2020, 2, 2, 2, 2, 2);
    public static final String TITLE = "title";
    public static final String BODY = "body";

    @Test
    void ldmMustNotBeNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> new NoteLDMtoEntity().transform(null))
                .withMessage("ldm must not be null");
    }

    @Test
    void willReturnEntityWithCorrectProperties() {
        final NoteLDMtoEntity noteLDMtoEntity = new NoteLDMtoEntity();
        final INote note = INote.builder()
                .withTitle(TITLE)
                .withBody(BODY)
                .withDateCreated(DATE_CREATED)
                .withDateLastModified(DATE_LAST_MODIFIED)
                .build();
        final NoteEntity expected = new NoteEntity(TITLE, BODY, DATE_CREATED, DATE_LAST_MODIFIED);

        assertThat(noteLDMtoEntity.transform(note)).usingRecursiveComparison().isEqualTo(expected);
    }

}