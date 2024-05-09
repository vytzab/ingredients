package lt.vytzab.ingredients.service;

import lt.vytzab.ingredients.dto.IngredientDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IngredientService {
    IngredientDTO addIngredient(IngredientDTO ingredientDTO);

    List<IngredientDTO> getAllIngredients();

    ResponseEntity<IngredientDTO> getIngredient(Integer id);

    IngredientDTO updateIngredient(Integer id, IngredientDTO ingredientDTO);

    ResponseEntity<IngredientDTO> deleteIngredient(Integer id);
}
