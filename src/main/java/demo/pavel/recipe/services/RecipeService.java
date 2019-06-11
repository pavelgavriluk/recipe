package demo.pavel.recipe.services;

import java.util.Set;

import demo.pavel.recipe.model.Recipe;

public interface RecipeService {

	Set<Recipe> findRecipes();
}
