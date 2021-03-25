package Volos.clothes.controller;

import Volos.clothes.exception.LookNotFoundException;
import Volos.clothes.exception.WrongInputException;
import Volos.clothes.model.Look;
import Volos.clothes.model.enums.elements.Brand;
import Volos.clothes.model.enums.elements.Size;
import Volos.clothes.model.enums.type.TypeOfUpperClothes;
import lombok.AllArgsConstructor;
import Volos.clothes.model.*;
import Volos.clothes.service.LookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@AllArgsConstructor
@RequestMapping("look")
public class LookController {


    private LookService lookService;
    @Autowired
    public LookController(LookService lookService) {
        this.lookService = lookService;
    }

    @GetMapping("/")
    public List<Look> allLooks() {
        return lookService.getLooks();
    }

    @GetMapping("name/{name}")
    public Look findLookByName (@PathVariable String name) throws LookNotFoundException {
            return lookService.getLookByName(name).orElseThrow(() -> new LookNotFoundException(name));
    }

    @GetMapping("{id}")
    public Look findLookById (@PathVariable Long id) {
        return lookService.getLookById(id).orElseThrow(() -> new LookNotFoundException(id));
    }

    @GetMapping("size/{s}")
    public List<Look> findLooksBySize (@PathVariable Size s) {
        return lookService.findLooksBySize(s);
    }

    @GetMapping("brand/{b}")
    public List<Look> findLooksByBrand (@PathVariable Brand b) {
        return lookService.findLooksByBrand(b);
    }

    @GetMapping("type/{t}")
    public List<Look> findLooksByTypeOfUpperClothes (@PathVariable TypeOfUpperClothes t) {
        return lookService.findLooksByTypeOfUpperClothes(t);
    }

    @PostMapping
    public void saveLook(@RequestBody Look look) {
        try {
            lookService.createLook(look);
        }
        catch (NullPointerException ex) {
            throw new WrongInputException("Can`t save this look");
        }
    }

    @PutMapping("{id}")
    public void updateLook(Look look) {
        try {
            lookService.updateLook(look);
        }
        catch (NullPointerException ex) {
            throw new WrongInputException("Can`t update this look");
        }
    }

    @DeleteMapping("{id}")
    public void deleteLook(@PathVariable Long id) {
        lookService.deleteLookById(id);
    }
}
