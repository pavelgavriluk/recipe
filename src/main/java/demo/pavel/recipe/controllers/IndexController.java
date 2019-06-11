package demo.pavel.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.pavel.recipe.services.RecipeService;

@Controller
public class IndexController {

	// fields
	private final RecipeService recipeService;

	// constructors
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"/", "", "index", "index.html"})
	public String getIndexPage(Model model){
		model.addAttribute("recipes", recipeService.findRecipes());
		return "index";
	}
}
