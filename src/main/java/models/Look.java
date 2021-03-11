package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Look {
    private UpperClothes upperClothes;
    private DownClothes downClothes;
    private String name;
    private Float price;

    public boolean isExpensive () { return price > 200; }
}
