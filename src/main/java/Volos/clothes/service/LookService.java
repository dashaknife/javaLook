package Volos.clothes.service;

import Volos.clothes.model.Look;
import Volos.clothes.model.enums.elements.Brand;
import Volos.clothes.model.enums.elements.Size;
import Volos.clothes.model.enums.type.TypeOfUpperClothes;

import java.util.List;
import java.util.Optional;

public interface LookService {
    List<Look> getLooks();
    Optional<Look> getLookByName(String name);
    Optional<Look> getLookById(Long id);

    void createLook(Look look);
    void updateLook(Look look);
    void deleteLookById(Long id);

    List<Look> findLooksBySize (Size s);
    List<Look> findLooksByBrand (Brand b);
    List<Look> findLooksByTypeOfUpperClothes (TypeOfUpperClothes t);
}
