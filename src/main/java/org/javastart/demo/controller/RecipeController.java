package org.javastart.demo.controller;

import org.javastart.demo.model.Category;
import org.javastart.demo.model.CategoryName;
import org.javastart.demo.model.Recipe;
import org.javastart.demo.repository.CategoryRepository;
import org.javastart.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class RecipeController {
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        Category desert = new Category(CategoryName.DESERT);
        Category firstD = new Category(CategoryName.FIRST);
        Category secondD = new Category(CategoryName.SECOND);
        Category mainC = new Category(CategoryName.MAIN);
        Category drink = new Category(CategoryName.DRINK);
        Category salad = new Category(CategoryName.SALAD);
        categoryRepository.save(desert);
        categoryRepository.save(firstD);
        categoryRepository.save(secondD);
        categoryRepository.save(mainC);
        categoryRepository.save(drink);
        categoryRepository.save(salad);
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "success";
    }

    @GetMapping("/add")
    public String saveRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "save";
    }

    @GetMapping("/recipes")
    public String allRecipes(Model model) {
        model.addAttribute("recipes", new ArrayList<>(recipeRepository.findAll()));
        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    public String getRecipe(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("recipe", recipeRepository.getOne(id));
        return "recipe";
    }

//    @GetMapping("/{category}")
//    public String getCategories(@PathVariable(name = "category") Category category, Model model) {
//        model.addAttribute("recipe", new Recipe());
//        return "category";
//    }
}
