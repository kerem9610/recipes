package com.example.springboot.api.model;

import java.util.List;

public class RecipiesResponse {
    List<Recipe> recipes;

    public RecipiesResponse(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
