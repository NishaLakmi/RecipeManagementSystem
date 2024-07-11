package com.Employee.Directory.Individual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    private RecipeManagementService recipeManagementService;

    @Autowired
    private RecipeRepository recipeRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //SignUp Page
    @GetMapping("/registerPage")
    public String getRegister() {
        return "register_page";
    }


    @GetMapping("/loginPage")
    public String getLoginPage() {

        return "login_page";
    }

    @GetMapping("/recipePage")
    public String getUpdatePage() {

        return "recipe_page";
    }
    @GetMapping("/recipeViewPage")
    public String viewRecipe() {

        return "recipesView_Page";
    }
    @GetMapping("/recipeDeletePage")
    public String deleteRecipe() {

        return "recipes_Delete";
    }
    @GetMapping("/recipeUpdatePage")
    public String updateRecipe() {

        return "recipes_Update";
    }
    @GetMapping("/optionPage")
    public String optionPage() {

    return "option_page";
}

    @PostMapping("/register")
    public String getRegisterPage(@RequestParam String username, @RequestParam String email, @RequestParam String user_password, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("user_password", user_password);

        int minLength = 8;
        int maxLength = 15;

        if(isPasswordValid(user_password, minLength, maxLength)){

            boolean results = userService.registerUser(username, email, user_password);
            if (results) {

                model.addAttribute("message", "Your Registration is success!!!!");
                return "register_page";
            } else {
                model.addAttribute("errorMessage", "Your Email Address already existing.. Please try again.");
                return "register_page";
            }

        }
        else{
            model.addAttribute("errorMessage", "Password is invalid. It must be between " + minLength + " and " + maxLength + " characters long.");
            return "register_page";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String user_password, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("user_password", user_password);


        boolean user = userService.verifyUser(username, user_password);
        if (user) {
            return "redirect:/optionPage";
        } else {
                model.addAttribute("errorMessage", "Your Password or Username is wrong!.. Please try again.");
                return "login_page";
            }



    }



    @GetMapping("/viewAll")
    public List<RecipeTable> getAllEmployeeInfo() {
        return recipeManagementService.getAllUrlInfo();
    }

    @PostMapping("/addNew")
    public String getAddNewRecipe(@RequestParam String title, @RequestParam String categorizeType, @RequestParam String vegitarian_Non, @RequestParam String description, @RequestParam String instructions,
                                    @RequestParam String ingredients, @RequestParam String nutritions, @RequestParam String calories,@RequestParam String numberOfPeple , Model model) {
//

        title = title.trim().toLowerCase();
//        categorizeType = categorizeType.trim().toLowerCase();
//        vegitarian_Non = vegitarian_Non.trim().toLowerCase();
        description = description.trim().toLowerCase();
        instructions = instructions.trim().toLowerCase();
        ingredients = ingredients.trim().toLowerCase();
        nutritions = nutritions.trim().toLowerCase();
//        calories = calories.trim().toLowerCase();
//        numberOfPeople = numberOfPeople.trim().toLowerCase();

        model.addAttribute("title", title.toLowerCase());
        model.addAttribute("categorizeType", categorizeType);
        model.addAttribute("vegitarian_Non" ,vegitarian_Non);
        model.addAttribute("description", description);
        model.addAttribute("instructions", instructions);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("nutritions", nutritions);
        model.addAttribute("calories", calories);
        model.addAttribute("numberOfPeple", numberOfPeple);

        boolean results = recipeManagementService.saveTable(title, categorizeType, vegitarian_Non, description, instructions, ingredients, nutritions, calories, numberOfPeple);

        if(results){
            model.addAttribute("results", "Your Recipe has been added." );
            return "recipe_page";
        }
        else{
            model.addAttribute("errorMessage", "Something Wrong!!!" );
            return "recipe_page";
        }

    }
    @PostMapping("/viewRecipes")
    public String getRecipeRecord(@RequestParam String categorizeType, @RequestParam String vegitarian_Non, Model model){


        model.addAttribute("categorizeType", categorizeType);
        model.addAttribute("vegitarian_Non" ,vegitarian_Non);

        List<RecipeTable> record = recipeManagementService.findRecord(categorizeType, vegitarian_Non);
        if(record != null){
            System.out.println("Number of recipes found: " + record.size());
            model.addAttribute("recipe", record );
            return  "recipesView_page";
        }
        else{
            model.addAttribute("recipe", "No recipes found!! May not here" );
            return  "recipesView_page";
        }


    }

    @PostMapping("/deleteRecipes")

    public String deleteRecipeRecord(@RequestParam String title, Model model ){

        title = title.trim().toLowerCase();
        boolean results = recipeManagementService.deleteRecipe(title);

        if (!results) {
            System.out.println(false);
            model.addAttribute("message2", "Error !!! Please check your Input value" );
            return  "recipes_Delete";

        } else {
            model.addAttribute("message", "Success your Delete!!!!!" );
            return  "recipes_Delete";
        }


    }
    @PostMapping("/updateRecipe")
    public String updateRecipe(@RequestParam String title, @RequestParam String ingredients,@RequestParam String numberOfPeple , Model model) {
//
        title = title.trim().toLowerCase();
        ingredients = ingredients.trim().toLowerCase();


        model.addAttribute("title", title);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("numberOfPeple", numberOfPeple);

        boolean results = recipeManagementService.updateRecipe(title,ingredients, numberOfPeple);

        if(results){
            model.addAttribute("results", "Your Recipe has been update." );
            return "recipes_Update";
        }
        else{
            model.addAttribute("errorMessage", "Something Wrong!!!" );
            return "recipes_Update";
        }

    }
    public static boolean isPasswordValid(String password, int minLength, int maxLength) {
        int passwordLength = password.length();
        return passwordLength >= minLength && passwordLength <= maxLength;
    }








}
