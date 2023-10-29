package com.example.springboot.service;

import com.example.springboot.api.model.Recipe;
import com.example.springboot.api.model.RecipeRepository;
import com.example.springboot.types.RecipeId;
import com.example.springboot.types.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final List<Recipe> recipeList;
    RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(List<Recipe> recipeList, RecipeRepository recipeRepository) {
        this.recipeList = recipeList;
        this.recipeRepository = recipeRepository;
    }


    public RecipeService() {
        var firstRecipe = new Recipe(RecipeId.recipeId("123"), new Title("first recipe title"));
        var secondRecipe = new Recipe(RecipeId.recipeId("456"), new Title("second recipe title"));

        this.recipeList = List.of(firstRecipe, secondRecipe);
    }

    public Optional<Recipe> getRecipe(RecipeId recipeId) {
        return recipeList.stream().filter(recipe -> recipe.getRecipeId().equals(recipeId)).findAny();
    }

    public List<Recipe> getRecipes() {
        var firstDbRecipe = recipeRepository.findByTitle("first Title");
        System.out.println(firstDbRecipe.getTitle());
        System.out.println("aaaaaaaa");
        return recipeList;
    }


}
