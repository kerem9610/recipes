package com.example.springboot.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Value;

public record RecipeId(
    @RecordJsonValue
    String value
) {

    @JsonCreator
    public static RecipeId recipeId(String value) {
        return new RecipeId(value);
    }
}
