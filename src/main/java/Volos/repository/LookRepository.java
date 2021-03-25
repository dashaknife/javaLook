package Volos.repository;

import Volos.clothes.model.Look;

import java.util.List;
import java.util.Optional;

public interface LookRepository {

    Optional<Look> findLookById (Long id);
    Optional<Look> findLookByName (String name);
    List<Look> findAllLooks ();

    void saveLook (Look look);
    void updateLook (Look look);
    void deleteLook (Long id);


}
