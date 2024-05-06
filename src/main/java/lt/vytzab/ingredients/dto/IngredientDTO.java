package lt.vytzab.ingredients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {
    private int id;
    private String name;
    private int protein;
    private int carbs;
    private int fat;
    private int kcal;
}
