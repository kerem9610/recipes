package com.example.springboot.api.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeDbModel, String> {

    RecipeDbModel findByTitle(String title);
}
