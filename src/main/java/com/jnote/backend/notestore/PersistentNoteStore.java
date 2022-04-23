package com.jnote.backend.notestore;

import com.functionaltools.functionalutils.Identity;
import com.google.common.collect.ImmutableList;
import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.interfaces.INote;
import com.jnote.backend.model.tranformer.OneToOneTransformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.Validate.notNull;

@Component
public class PersistentNoteStore implements NoteStore{

    private final JpaRepository<NoteEntity, Long> repository;
    private final OneToOneTransformer<INote, NoteEntity> noteLDMToEntity;
    private final OneToOneTransformer<NoteEntity, INote> noteEntityToLDM;

    public PersistentNoteStore(final JpaRepository<NoteEntity, Long> repository,
                               final OneToOneTransformer<INote, NoteEntity> noteLDMToEntity,
                               final OneToOneTransformer<NoteEntity, INote> noteEntityToLDM) {
        this.repository = notNull(repository, "repository must not be null");
        this.noteLDMToEntity = notNull(noteLDMToEntity, "noteLDMToEntity must not be null");
        this.noteEntityToLDM = notNull(noteEntityToLDM, "noteEntityToLDM must not be null");
    }

    public INote saveNote(final INote note) {
        notNull(note, "note must not be null");
        return Identity.of(note)
                .map(noteLDMToEntity::transform)
                .map(repository::save)
                .in(noteEntityToLDM::transform);
    }

    public ImmutableList<INote> getNotes() {
        return repository.findAll().stream()
                .map(noteEntityToLDM::transform)
                .collect(ImmutableList.toImmutableList());
    }
}
