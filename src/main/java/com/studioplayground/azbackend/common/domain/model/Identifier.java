package com.studioplayground.azbackend.common.domain.model;

import java.util.Objects;

public interface Identifier<T> {
    T id();
    default boolean isNull() {
        return Objects.isNull(id());
    }

}
