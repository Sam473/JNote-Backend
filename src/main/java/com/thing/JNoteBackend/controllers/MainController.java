package com.thing.JNoteBackend.controllers;

import com.thing.JNoteBackend.model.Note;
import com.thing.JNoteBackend.service.NoteStorageService;
import io.micrometer.core.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/note")
public class MainController {

    @NonNull
    NoteStorageService noteStorageService;

    public MainController(@Autowired final NoteStorageService noteStorageService) {
        this.noteStorageService = noteStorageService;
    }

    @GetMapping("/hello")
    public ResponseEntity getHello() {
        return ResponseEntity.of(Optional.of("Hello"));
    }

    @PostMapping()
    public ResponseEntity addNote(@RequestBody final Note note) {
        noteStorageService.saveNote(note);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public @ResponseBody Set<Note> getNotes() {
        //get all the notes and return them
        return noteStorageService.getNotes();
    }

}
