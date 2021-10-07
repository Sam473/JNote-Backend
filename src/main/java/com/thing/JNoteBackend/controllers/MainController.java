package com.thing.JNoteBackend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thing.JNoteBackend.model.Note;
import com.thing.JNoteBackend.service.NoteStorageService;
import io.micrometer.core.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/note")
public class MainController {

    @NonNull
    NoteStorageService noteStorageService;

    public MainController(@Autowired final NoteStorageService noteStorageService) {
        this.noteStorageService = noteStorageService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.of(Optional.of("Hello"));
    }

    @PostMapping()
    public ResponseEntity addNote(@RequestBody final Note note) {
        noteStorageService.saveNote(note);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Note>> getNotes() throws JsonProcessingException {
        //get all the notes and return them
        return ResponseEntity.of(Optional.of(noteStorageService.getNotes()));
    }

}
