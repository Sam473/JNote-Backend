package com.jnote.backend.model.tranformer;

import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.interfaces.INote;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.Validate.notNull;

@Component
public class NoteLDMtoEntity implements OneToOneTransformer<INote, NoteEntity> {

    @Override
    public NoteEntity transform(final INote ldm) {
        notNull(ldm, "ldm must not be null");
        return new NoteEntity(ldm.getTitle(), ldm.getBody(), ldm.getDateCreated(), ldm.getDateLastModified());
    }
}
