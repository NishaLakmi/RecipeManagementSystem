package com.Employee.Directory.Individual;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeManagementService {
    @Autowired
    private final RecipeRepository recipeRepository;

  public RecipeManagementService(RecipeRepository edRepository) {
    this.recipeRepository = edRepository;
  }


  @Transactional
    public boolean addNewRecipe(RecipeTable recipeTable){

    recipeRepository.save(recipeTable);
      return true;

    }
  public List<RecipeTable> getAllUrlInfo() {
    return recipeRepository.findAll();    // returns all database info from the repository class.
  }


  public List<RecipeTable> findRecord(String categorizeType, String vegitarian_Non){
    List<RecipeTable> results = recipeRepository.findByCategorizeTypeAndvegitarian_Non(categorizeType,  vegitarian_Non);
    return results;


  }

  public boolean deleteRecipe(String title){

//    boolean results;

//    var entity = recipeRepository.findById(id);
    var record = recipeRepository.findrecipeByTitle(title);

    Long id = record.get().getId();

    if(id != null){
      recipeRepository.deleteById(id);
      return true;
    }
    else{
      return false;
    }
//return results;
  }

  public boolean saveTable(String title, String categorizeType, String vegitarian_Non, String description, String instructions, String ingredients, String nutritions, String calories, String numberOfPeple) {

    RecipeTable newRecord = new RecipeTable();
    newRecord.setTitle(title);
    newRecord.setCategorizeType(categorizeType);
    newRecord.setVegitarian_Non(vegitarian_Non);
    newRecord.setDescription(description);
    newRecord.setInstructions(instructions);
    newRecord.setIngredients(ingredients);
    newRecord.setNutritions(nutritions);
    newRecord.setCalories(calories);
    newRecord.setNumberOfPeple(numberOfPeple);
    RecipeTable saveRecord = recipeRepository.save(newRecord);

    if(saveRecord.getId() != null){
      return true;
    }
    else{
      return false;
    }


  }

  public boolean updateRecipe(String title, String ingredients, String numberOfPeple) {
    var record = recipeRepository.findrecipeByTitle(title);

    Long id = record.get().getId();
    if(record.isPresent()){


//      RecipeTable update = new RecipeTable();
      record.get().setIngredients(ingredients);

      record.get().setNumberOfPeple(numberOfPeple);
      recipeRepository.save(record.get());

//      update.setIngredients(ingredients);
//      update.setNumberOfPeple(numberOfPeple);
//      RecipeTable saveUpdateRecord = recipeRepository.save(update);
      return true;

    }
    return false;
  }


}

