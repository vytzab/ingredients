package lt.vytzab.ingredients.service;

import jakarta.ws.rs.NotFoundException;
import lt.vytzab.ingredients.dto.IngredientDTO;
import lt.vytzab.ingredients.entity.Ingredient;
import lt.vytzab.ingredients.mapper.IngredientMapper;
import lt.vytzab.ingredients.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService{
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public IngredientDTO addIngredient(IngredientDTO ingredientDTO) {
        Ingredient savedIngredient = ingredientRepository.save(IngredientMapper.INSTANCE.mapIngredientDTOToIngredient(ingredientDTO));
        return IngredientMapper.INSTANCE.mapIngredientToIngredientDTO(savedIngredient);
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream().map(IngredientMapper.INSTANCE::mapIngredientToIngredientDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<IngredientDTO> getIngredient(Integer id) {
        Optional<Ingredient> ingredientOptional  = ingredientRepository.findById(id);
        return ingredientOptional.map(ingredient -> new ResponseEntity<>(IngredientMapper.INSTANCE.mapIngredientToIngredientDTO(ingredient), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public IngredientDTO updateIngredient(Integer id, IngredientDTO ingredientDTO) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        if (optionalIngredient.isEmpty()) {
            throw new NotFoundException("Ingredient not found with id: " + id);
        }
        Ingredient ingredient = ingredientRepository.save(IngredientMapper.INSTANCE.mapIngredientDTOToIngredient(ingredientDTO));
        return IngredientMapper.INSTANCE.mapIngredientToIngredientDTO(ingredient);
    }

    @Override
    public ResponseEntity<IngredientDTO> deleteIngredient(Integer id) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        if (optionalIngredient.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ingredientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}