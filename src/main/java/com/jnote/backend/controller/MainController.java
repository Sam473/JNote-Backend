package com.jnote.backend.controller;

import com.jnote.backend.model.Note;
import com.jnote.backend.model.interfaces.INote;
import com.jnote.backend.service.NoteStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

@RestController
@RequestMapping("/api/v1/note")
public class MainController {

    NoteStorageService noteStorageService;

    public MainController(@Autowired final NoteStorageService noteStorageService) {
        this.noteStorageService = notNull(noteStorageService, "noteStorageService must not be null");
    }

    @PostMapping()
    public INote addNote(@RequestBody final Note note) {
        notNull(note, "note must not be null");
        return noteStorageService.saveNote(note);
    }

    @GetMapping()
    public List<INote> getNotes() {
        return noteStorageService.getNotes();
    }

}
