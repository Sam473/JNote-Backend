package com.thing.JNoteBackend.config;

import com.thing.JNoteBackend.model.interfaces.INote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class NoteStoreConfig {

    @Bean
    public List<INote> notes() {
        return new ArrayList<INote>();
    }

}
