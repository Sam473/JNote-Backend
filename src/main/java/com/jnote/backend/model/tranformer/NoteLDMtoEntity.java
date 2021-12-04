package com.jnote.backend.model.tranformer;

import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.interfaces.INote;
import org.springframework.stereotype.Component;

@Component
public class NoteLDMtoEntity implements OneToOneTransformer<INote, NoteEntity> {

    @Override
    public NoteEntity transform(final INote ldm) {
        return new NoteEntity(ldm.getTitle(), ldm.getBody(), ldm.getDateCreated(),ldm.getDateLastModified());
    }
}
