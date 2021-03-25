package Volos.clothes.model;
import Volos.clothes.model.enums.elements.Brand;
import Volos.clothes.model.enums.elements.Color;
import Volos.clothes.model.enums.elements.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ElementOfClothes {
    private Size size;
    private Color color;
    private Brand brand;
}
