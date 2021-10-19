package com.thing.JNoteBackend.model;

import com.thing.JNoteBackend.model.interfaces.INote;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.thing.JNoteBackend.model.Note.NoteBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@ExtendWith(MockitoExtension.class)
public class NoteTest {

    public static final String TITLE = "title";
    public static final String BODY = "body";

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

    @Nested
    class Builder {

        @Test
        //TODO: This doesn't work due to clock mocking
        void builderCreatesCorrectObject() {
            final INote testNote = new NoteBuilder()
                    .withTitle(TITLE)
                    .withBody(BODY)
                    .build();

            assertThat(testNote.getTitle()).isEqualTo(TITLE);
            assertThat(testNote.getBody()).isEqualTo(BODY);
        }
    }

}
