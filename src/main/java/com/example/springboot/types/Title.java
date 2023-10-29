package com.example.springboot.types;

import com.fasterxml.jackson.annotation.JsonCreator;

public record Title(
    @RecordJsonValue
    String value
) {

    @JsonCreator
    public static Title title(String value) {
        return new Title(value);
    }
}
