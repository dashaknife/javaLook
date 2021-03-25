package Volos.clothes.service;

import Volos.clothes.model.Look;
import Volos.clothes.model.enums.elements.Brand;
import Volos.clothes.model.enums.elements.Size;
import Volos.clothes.model.enums.type.TypeOfUpperClothes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Volos.repository.LookRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class LookServiceImpl implements LookService {



    private LookRepository lookRepositoryImpl;



    public List<Look> getLooks () {
        return lookRepositoryImpl.findAllLooks();
    }

    public Optional<Look> getLookByName (String name) {
        return lookRepositoryImpl.findLookByName(name);
    }
    public Optional<Look> getLookById (Long id) {
        return lookRepositoryImpl.findLookById(id);
    }

    public void createLook(Look look) {
        lookRepositoryImpl.saveLook(look);
    }
    public void updateLook(Look look) {
        lookRepositoryImpl.updateLook(look);
    }
    public void deleteLookById(Long id) {
        lookRepositoryImpl.deleteLook(id);
    }

    public List<Look> findLooksBySize (Size s) {
        return  lookRepositoryImpl.findAllLooks().stream()
                .filter(sub -> sub.getUpperClothes().getSize().equals(s) || sub.getDownClothes().getSize().equals(s))
                .collect(Collectors.toList());
    }
    public List<Look> findLooksByBrand (Brand b) {
        return  lookRepositoryImpl.findAllLooks().stream()
                .filter(sub -> sub.getUpperClothes().getBrand().equals(b) || sub.getDownClothes().getBrand().equals(b))
                .collect(Collectors.toList());
    }
    public List<Look> findLooksByTypeOfUpperClothes (TypeOfUpperClothes t) {
        return  lookRepositoryImpl.findAllLooks().stream()
                .filter(sub -> sub.getUpperClothes().getTypeOfUpperClothes().equals(t))
                .collect(Collectors.toList());
    }



}
