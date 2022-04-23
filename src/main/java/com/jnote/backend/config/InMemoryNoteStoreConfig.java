package com.jnote.backend.config;

import com.jnote.backend.model.interfaces.INote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("inmemory")
public class InMemoryNoteStoreConfig {

    @Bean
    public List<INote> notes() {
        return new ArrayList<>();
    }

}
