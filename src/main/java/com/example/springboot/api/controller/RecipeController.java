package com.example.springboot.api.controller;

import com.example.springboot.api.controller.model.RecipeBody;
import com.example.springboot.api.model.RecipeDbModel;
import com.example.springboot.api.model.RecipeRepository;
import com.example.springboot.api.model.RecipiesResponse;
import com.example.springboot.service.RecipeService;
import com.example.springboot.types.RecipeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.api.model.RecipeResponse;

@RestController
@RequestMapping(path = "/api/recipes")
public class RecipeController {
	private final RecipeService recipeService;
	private final RecipeRepository recipeRepository;

	@Autowired
	public RecipeController(RecipeService recipeService, RecipeRepository recipeRepository) {
		this.recipeService = recipeService;
		this.recipeRepository = recipeRepository;
	}

	@GetMapping("")
	public ResponseEntity<RecipiesResponse> getRecipies() {
		return ResponseEntity.ok(new RecipiesResponse(recipeService.getRecipes()));
	}

	@GetMapping(value = "/{recipeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecipeResponse> getRecipe(@PathVariable RecipeId recipeId) {
		return recipeService.getRecipe(recipeId)
				.map(RecipeResponse::new)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postRecipe(@RequestBody RecipeBody recipeBody) {
		var recipeDbModel = new RecipeDbModel();
		recipeDbModel.setTitle(recipeBody.getTitle());
		recipeRepository.save(recipeDbModel);

		return ResponseEntity.ok().build();
	}
}
