package Volos.clothes.model;

import Volos.clothes.model.enums.elements.Brand;
import Volos.clothes.model.enums.elements.Color;
import Volos.clothes.model.enums.elements.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import Volos.clothes.model.enums.type.TypeOfUpperClothes;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpperClothes extends ElementOfClothes {
    private TypeOfUpperClothes typeOfUpperClothes;

    public  UpperClothes(TypeOfUpperClothes typeOfUpperClothes, Size s, Color c, Brand b) {
        super(s,c,b);
        this.typeOfUpperClothes = typeOfUpperClothes;
    }
}
