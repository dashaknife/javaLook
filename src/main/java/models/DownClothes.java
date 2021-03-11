package models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import models.elements.*;
import models.type.TypeOfDownClothes;

@EqualsAndHashCode(callSuper = true)
@Data
public class DownClothes extends ElementOfClothes {

    private TypeOfDownClothes typeOfDownClothes;

    public DownClothes(Size size1, Color color1, Brand brand1, TypeOfDownClothes typeOfDownClothes1){
        super(size1, color1, brand1);
        this.typeOfDownClothes = typeOfDownClothes1;
    }
}
