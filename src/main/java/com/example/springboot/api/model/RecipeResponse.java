package com.example.springboot.api.model;

public class RecipeResponse {
    private final Recipe recipe;

    public RecipeResponse(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }

}
