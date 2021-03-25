package Volos.clothes.model;


import Volos.clothes.model.enums.type.TypeOfDownClothes;
import Volos.clothes.model.enums.elements.Brand;
import Volos.clothes.model.enums.elements.Color;
import Volos.clothes.model.enums.elements.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DownClothes extends ElementOfClothes {

    private TypeOfDownClothes typeOfDownClothes;

    public DownClothes(TypeOfDownClothes typeOfUpperClothes, Size s, Color c, Brand b) {
        super(s,c,b);
        this.typeOfDownClothes = typeOfUpperClothes;
    }
}
