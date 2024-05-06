package lt.vytzab.ingredients.mapper;

import lt.vytzab.ingredients.dto.IngredientDTO;
import lt.vytzab.ingredients.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);
    Ingredient mapIngredientDTOToIngredient(IngredientDTO ingredientDTO);
    IngredientDTO mapIngredientToIngredientDTO(Ingredient ingredient);
}