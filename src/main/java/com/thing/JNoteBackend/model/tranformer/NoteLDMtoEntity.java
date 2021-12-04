package com.thing.JNoteBackend.model.tranformer;

import com.thing.JNoteBackend.jpa.NoteEntity;
import com.thing.JNoteBackend.model.interfaces.INote;
import org.springframework.stereotype.Component;

@Component
public class NoteLDMtoEntity implements OneToOneTransformer<INote, NoteEntity> {

    @Override
    public NoteEntity transform(final INote ldm) {
        return new NoteEntity(ldm.getTitle(), ldm.getBody(), ldm.getDateCreated(),ldm.getDateLastModified());
    }
}
