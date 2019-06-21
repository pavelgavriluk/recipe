package demo.pavel.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.pavel.recipe.commands.RecipeCommand;
import demo.pavel.recipe.services.RecipeService;

@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("recipe/show/{id}")
	public String showById(@PathVariable String id, Model model) {

		model.addAttribute("recipe", recipeService.findRecipeById(Long.valueOf(id)));

		return "recipe/show";
	}

	@RequestMapping("recipe/new")
	public String newRecipe(Model model){
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";
	}

	@PostMapping("recipe")
	public String saveOrUpdate(@ModelAttribute RecipeCommand command){
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

		return "redirect:/recipe/show/" + savedCommand.getId();
	}
}
