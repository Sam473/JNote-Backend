package com.thing.JNoteBackend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class MainController {

    @GetMapping("/hello")
    public ResponseEntity getHello() {
        return ResponseEntity.of(Optional.of("Hello"));
    }

}
