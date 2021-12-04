package com.jnote.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"test", "h2"})
class JNoteBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
