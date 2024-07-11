package com.Employee.Directory.Individual;
//import com.Employee.Directory.Individual.model.EmployeeTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RecipeRepository extends JpaRepository<RecipeTable, Long> {


    @Query(value = "SELECT * FROM RecipeTable WHERE categorize_type = :categorize_type AND vegitarian_Non = :vegitarian_Non", nativeQuery = true)
    List<RecipeTable> findByCategorizeTypeAndvegitarian_Non(String categorize_type, String vegitarian_Non);


    @Query(value = "SELECT * FROM RecipeTable WHERE title = :title", nativeQuery = true)
    Optional<RecipeTable> findrecipeByTitle(String title);




}
