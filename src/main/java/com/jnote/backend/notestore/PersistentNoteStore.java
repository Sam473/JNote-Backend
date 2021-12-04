package com.jnote.backend.notestore;

import com.jnote.backend.jpa.NoteEntity;
import com.jnote.backend.model.interfaces.INote;
import com.jnote.backend.model.tranformer.OneToOneTransformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    //TODO: fix this optional get, really should be the identity monad, might need to ask if I can use it
    public INote saveNote(final INote note) {
        notNull(note, "note must not be null");
        return Optional.of(note)
                .map(noteLDMToEntity::transform)
                .map(repository::save)
                .map(noteEntityToLDM::transform)
                .get();
    }

    public List<INote> getNotes() {
        return repository.findAll().stream()
                .map(noteEntityToLDM::transform)
                .collect(Collectors.toList());
    }
}
