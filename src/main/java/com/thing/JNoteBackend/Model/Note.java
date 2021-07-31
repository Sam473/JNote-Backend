package com.thing.JNoteBackend.Model;

import com.thing.JNoteBackend.Model.Interfaces.INote;
import com.thing.JNoteBackend.Model.Interfaces.INoteBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;

public class Note implements INote {
    private final String title;
    private final String body;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateLastModified;


    private Note(NoteBuilder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.dateCreated = builder.dateCreated;
        this.dateLastModified = builder.dateLastModified;
    }

    @Override
    public JSONObject getDetails() {
        //TODO: Sort this shit
        JSONObject postDetails = new JSONObject();
        try {
            postDetails.put("title", title);
            postDetails.put("body", body);
            postDetails.put("cdate", dateCreated);
            postDetails.put("mdate", dateLastModified);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return postDetails;
    }

    public static class NoteBuilder implements INoteBuilder {
        private String title;
        private String body;
        private LocalDateTime dateCreated;
        private LocalDateTime dateLastModified;

        public NoteBuilder() {

        }

        @Override
        public void withBody(String body) {
            this.body = body;
        }

        @Override
        public void withDateCreated(LocalDateTime created) {
            this.dateCreated = created;
        }

        @Override
        public void withDateLastModified(LocalDateTime modified) {
            this.dateLastModified=modified;
        }

        @Override
        public void withTitle(String title) {
            this.title = title;
        }

        @Override
        public Note build() {
            Note note = new Note(this);
            return note;
        }

    }

}
