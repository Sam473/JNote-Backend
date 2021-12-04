package com.thing.JNoteBackend.model.tranformer;

import com.thing.JNoteBackend.jpa.NoteEntity;
import com.thing.JNoteBackend.model.Note;
import com.thing.JNoteBackend.model.interfaces.INote;
import org.springframework.stereotype.Component;

@Component
public class NoteEntityToLDM implements OneToOneTransformer<NoteEntity, INote> {

    @Override
    public INote transform(final NoteEntity entity) {
        return Note.builder()
                .withTitle(entity.getTitle())
                .withBody(entity.getBody())
                .withDateCreated(entity.getDateCreated())
                .withDateLastModified(entity.getDateLastModified())
                .build();
    }
}
