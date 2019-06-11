package demo.pavel.recipe.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import demo.pavel.recipe.model.Recipe;
import demo.pavel.recipe.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	// fields
	private final RecipeRepository recipeRepository;

	// constructor
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> findRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet :: add);
		return recipeSet;
	}
}
