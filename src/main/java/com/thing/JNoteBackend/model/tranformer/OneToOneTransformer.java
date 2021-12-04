package com.thing.JNoteBackend.model.tranformer;

public interface OneToOneTransformer<FROM, TO> {

    TO transform(FROM toTransform);
}
