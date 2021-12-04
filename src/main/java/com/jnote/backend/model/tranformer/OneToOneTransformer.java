package com.jnote.backend.model.tranformer;

public interface OneToOneTransformer<FROM, TO> {

    TO transform(FROM toTransform);
}
