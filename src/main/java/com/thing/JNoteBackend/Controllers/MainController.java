package com.thing.JNoteBackend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MainController {

    @GetMapping("/hello")
    public ResponseEntity getHello() {
        return ResponseEntity.of(Optional.of("Hello"));
    }

    @PostMapping("/addnote")
    public ResponseEntity addNote() {
        //add the note
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getnotedetails")
    public ResponseEntity getNoteDetails() {
        //get all the notes and return them
        return ResponseEntity.of(Optional.of("NoteDetail"));
    }

    @GetMapping("/getnotes")
    public ResponseEntity getNotes() {
        //get all the notes and return them
        return ResponseEntity.of(Optional.of("Notes"));
    }

}
