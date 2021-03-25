package Volos.clothes.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Look {
    private Long id;
    private UpperClothes upperClothes;
    private DownClothes downClothes;
    private String name;
    private double price;


    public Look(UpperClothes uc, DownClothes dc, String name, double price) {
        this.upperClothes = uc;
        this.downClothes = dc;
        this.name = name;
        this.price = price;
    }


    public boolean isExpensive () { return price > 200; }
}
