package mvc.project.reciepeproject.controllers;

import lombok.extern.slf4j.Slf4j;
import mvc.project.reciepeproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientsController {

    private final RecipeService recipeService;

    public IngredientsController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngrdients(@PathVariable String recipeId, Model model){
        log.debug("Getting ingredient list for recipe id : "+ recipeId);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }
}
