package lt.vytzab.ingredients.controller;

import lt.vytzab.ingredients.dto.IngredientDTO;
import lt.vytzab.ingredients.service.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin
public class IngredientController {
    @Autowired
    IngredientServiceImpl ingredientService;

    @PostMapping("/addIngredient")
    public ResponseEntity<IngredientDTO> addIngredient(@RequestBody IngredientDTO ingredientDTO) {
        IngredientDTO savedIngredientDTO = ingredientService.addIngredient(ingredientDTO);
        return new ResponseEntity<>(savedIngredientDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAllIngredients")
    public ResponseEntity<List<IngredientDTO>> getAllIngredients(){
        List<IngredientDTO> allIngredients = ingredientService.getAllIngredients();
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }

    @GetMapping("/getIngredient/{id}")
    public ResponseEntity<IngredientDTO> getIngredient(@PathVariable Integer id) {
        return ingredientService.getIngredient(id);
    }

    @PutMapping("/updateIngredient")
    public ResponseEntity<IngredientDTO> updateIngredient(@RequestBody IngredientDTO ingredientDTO) {
        IngredientDTO updatedIngredientDTO = ingredientService.updateIngredient(ingredientDTO.getId(), ingredientDTO);
        return new ResponseEntity<>(updatedIngredientDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteIngredient/{id}")
    public ResponseEntity<IngredientDTO> deleteIngredient(@PathVariable Integer id) {
        return ingredientService.deleteIngredient(id);
    }
}
