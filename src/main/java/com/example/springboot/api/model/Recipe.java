package com.example.springboot.api.model;

import com.example.springboot.types.RecipeId;
import com.example.springboot.types.Title;

public class Recipe {
    RecipeId id;
    Title title;

    public Recipe(RecipeId id, Title title) {
        this.id = id;
        this.title = title;
    }

    public RecipeId getRecipeId() {
        return id;
    }

    public void setRecipeId(RecipeId id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
