package com.jnote.backend.model.tranformer;

import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.Note;
import com.jnote.backend.model.interfaces.INote;
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
