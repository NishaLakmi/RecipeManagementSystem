package com.Employee.Directory.Individual;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.stereotype.Component;


@Entity
@Table(name="recipetable")
@Builder
@Component
public class RecipeTable {
    @Id
    @Column
    @SequenceGenerator(name="recipeTable_sequence", sequenceName = "recipeTable_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "recipeTable_sequence")
    private Long id;

//    @Column(name="EmployeeID")
//    private String employeeID;

    @Column(name = "title")
    private String title;

    @Column(name = "categorizeType")  // Changed property name to match database column
    private String categorizeType;

    @Column(name = "vegitarian_Non")  // Changed property name to match database column
    private String vegitarian_Non;


    @Column(name = "description")  // Changed property name to match database column
    private String description;


    @Column(name = "instructions")  // Changed property name to match database column
    private String instructions;


    @Column(name = "ingredients")  // Changed property name to match database column
    private String ingredients;


    @Column(name = "nutritions ")  // Changed property name to match database column
    private String nutritions;

    @Column(name = "calories")  // Changed property name to match database column
    private String calories;

    @Column(name = "NumberOfPeople")  // Changed property name to match database column
    private String numberOfPeple;

    public RecipeTable() {
    }

    public RecipeTable(Long id, String title, String categorizeType, String vegitarian_Non, String description, String instructions, String ingredients, String nutritions, String calories, String numberOfPeple) {
        this.id = id;
        this.title = title;
        this.categorizeType = categorizeType;
        this.vegitarian_Non = vegitarian_Non;
        this.description = description;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.nutritions = nutritions;
        this.calories = calories;
        this.numberOfPeple = numberOfPeple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategorizeType() {
        return categorizeType;
    }

    public void setCategorizeType(String categorizeType) {
        this.categorizeType = categorizeType;
    }

    public String getVegitarian_Non() {
        return vegitarian_Non;
    }

    public void setVegitarian_Non(String vegitarian_Non) {
        this.vegitarian_Non = vegitarian_Non;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getNutritions() {
        return nutritions;
    }

    public void setNutritions(String nutritions) {
        this.nutritions = nutritions;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getNumberOfPeple() {
        return numberOfPeple;
    }

    public void setNumberOfPeple(String numberOfPeple) {
        this.numberOfPeple = numberOfPeple;
    }

    @Override
    public String toString() {
        return "RecipeTable{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categorizeType='" + categorizeType + '\'' +
                ", Vegitarian_Non='" + vegitarian_Non + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", nutritions='" + nutritions + '\'' +
                ", calories=" + calories +
                ", numberOfPeple=" + numberOfPeple +
                '}';
    }

    //    @Column(name = "startDate")  // Changed property name to match database column
//    private String startDate;
//
//    @Column(name = "endDate")  // Changed property name to match database column
//    private String endDate;

//    public RecipeTable(Long id, String fName, String lName, String email, String pNumber, String locationName, String teamName, String accountName, String position, String employeeType, String startDate, String endDate) {
//        this.id= id;
////        this.employeeID = employeeID;
//        this.title = fName;
//        this.categorizeType = lName;
//        this.Vegitarian_Non = email;
//        this.description = pNumber;
//        this.instructions = locationName;
//        this.ingredients = teamName;
//        this.nutritions = accountName;
//        this.position = position;
//        this.numberOfPeple = employeeType;
//        this.startDate = startDate;
//        this.endDate = endDate;
//    }
//
//    public RecipeTable() {
//    }
//
//    public Long getid() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id= id;
//    }
//
////    public String getEmployeeID() {
////        return employeeID;
////    }
//
////    public void setEmployeeID(String employeeID) {
////        this.employeeID = employeeID;
////    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCategorizeType() {
//        return categorizeType;
//    }
//
//    public void setCategorizeType(String categorizeType) {
//        this.categorizeType = categorizeType;
//    }
//
//    public String getVegitarian_Non() {
//        return Vegitarian_Non;
//    }
//
//    public void setVegitarian_Non(String vegitarian_Non) {
//        this.Vegitarian_Non = vegitarian_Non;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getInstructions() {
//        return instructions;
//    }
//
//    public void setInstructions(String instructions) {
//        this.instructions = instructions;
//    }
//
//    public String getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(String ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public String getNutritions() {
//        return nutritions;
//    }
//
//    public void setNutritions(String nutritions) {
//        this.nutritions = nutritions;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public String getNumberOfPeple() {
//        return numberOfPeple;
//    }
//
//    public void setNumberOfPeple(String numberOfPeple) {
//        this.numberOfPeple = numberOfPeple;
//    }
//
//    public String getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//
//    public String getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(String endDate) {
//        this.endDate = endDate;
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeeTable{" +
//                "employeeid=" + id +
////                ", employeeID='" + employeeID + '\'' +
//                ", fName='" + title + '\'' +
//                ", lName='" + categorizeType + '\'' +
//                ", email='" + Vegitarian_Non + '\'' +
//                ", pNumber='" + description + '\'' +
//                ", location='" + instructions + '\'' +
//                ", teamName='" + ingredients + '\'' +
//                ", accountName='" + nutritions + '\'' +
//                ", position='" + position + '\'' +
//                ", employeeType='" + numberOfPeple + '\'' +
//                ", startDate=" + startDate +
//                ", endDate=" + endDate +
//                '}';
//    }
}
