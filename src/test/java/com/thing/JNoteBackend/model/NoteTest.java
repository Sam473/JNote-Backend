package com.thing.JNoteBackend.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.thing.JNoteBackend.model.Note.NoteBuilder;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@ExtendWith(MockitoExtension.class)
public class NoteTest {

    @Nested
    class BuilderPreconditions {
        @Test
        void titleMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new NoteBuilder().withTitle(null))
            .withMessage("title must not be null");
        }

        @Test
        void bodyMustNotBeNull() {
        assertThatNullPointerException()
            .isThrownBy(() -> new NoteBuilder().withBody(null))
            .withMessage("body must not be null");
        }
    }
}
