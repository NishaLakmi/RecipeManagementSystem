package com.Employee.Directory.Individual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SaveRecipe {


    @Autowired
    private RecipeRepository recipeRepository;


    @Test
    public void SaveNewRecipe(){

        // Arrange
        RecipeTable newRecord = new RecipeTable();

        newRecord.setTitle("Pasta");
        newRecord.setCategorizeType("lunch");
        newRecord.setVegitarian_Non("vegetarian");
        newRecord.setDescription("A tasty pasta dish with tomato sauce");
        newRecord.setInstructions("1. Boil the pasta.\\n2. Cook the sauce.\\n3. Mix the pasta with the sauce.");
        newRecord.setIngredients("Pasta, tomatoes, garlic, basil");
        newRecord.setNutritions("Calories: 300, Protein: 10g, Fat: 5g, Carbs: 50g");
        newRecord.setCalories("200");
        newRecord.setNumberOfPeple("4");


        // Act
        RecipeTable saveRecord = recipeRepository.save(newRecord);


        //Assert
        assertNotNull(saveRecord.getId());
        Assertions.assertEquals("Pasta", saveRecord.getTitle());
        Assertions.assertEquals("lunch", saveRecord.getCategorizeType());
        Assertions.assertEquals("vegetarian", saveRecord.getVegitarian_Non());
        Assertions.assertEquals("A tasty pasta dish with tomato sauce", saveRecord.getDescription());
        Assertions.assertEquals("1. Boil the pasta.\\n2. Cook the sauce.\\n3. Mix the pasta with the sauce.", saveRecord.getInstructions());
        Assertions.assertEquals("Pasta, tomatoes, garlic, basil", saveRecord.getIngredients());
        Assertions.assertEquals("Calories: 300, Protein: 10g, Fat: 5g, Carbs: 50g", saveRecord.getNutritions());
        Assertions.assertEquals("200", saveRecord.getCalories());
        Assertions.assertEquals("4", saveRecord.getNumberOfPeple());
    }
}
