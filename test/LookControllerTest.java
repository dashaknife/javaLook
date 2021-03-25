import Volos.clothes.controller.LookController;
import Volos.clothes.exception.LookNotFoundException;
import Volos.clothes.exception.WrongInputException;
import Volos.clothes.model.*;
import Volos.clothes.model.enums.elements.*;
import Volos.clothes.model.enums.type.*;
import Volos.context.Application;
import Volos.views.ConsoleView;
import Volos.views.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import Volos.repository.LookRepositoryImpl;
import Volos.clothes.service.LookServiceImpl;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LookControllerTest {

    private ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
    private final LookController lookController = context.getBean(LookController.class);

    private final List<Look> looks = new ArrayList<>();


    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp () {

        looks.add(new Look(
                new UpperClothes(TypeOfUpperClothes.Blouse, Size.S, Color.Wt, Brand.Ch),
                new DownClothes(TypeOfDownClothes.Jeans, Size.M, Color.Bl, Brand.Fe),
                "Look1", 100));
        looks.add(new Look(
                new UpperClothes(TypeOfUpperClothes.Dress, Size.Xs, Color.Pn, Brand.Ch),
                new DownClothes(TypeOfDownClothes.Shorts, Size.S, Color.Or, Brand.GG),
                "Look2", 200));
        looks.add(new Look(
                new UpperClothes(TypeOfUpperClothes.Tshirt, Size.XL, Color.Wt, Brand.Mg),
                new DownClothes(TypeOfDownClothes.Jeans, Size.M, Color.Bk, Brand.Mg),
                "Look3", 300));
        looks.add(new Look(
                new UpperClothes(TypeOfUpperClothes.Tshirt, Size.M, Color.Bl, Brand.Fe),
                new DownClothes(TypeOfDownClothes.Skirt, Size.M, Color.Bl, Brand.Fe),
                "Look4", 400));

        for (Look look : looks) {
            lookController.saveLook(look);
        }
    }
    @Test
    public void allLooks_IsReturnCorrect_True () {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(looks, lookController.allLooks());
    }
    @Test
    public void allLooks_TryGetFromEmptyRepo_EmptyList() {
        //GIVEN
        lookController.deleteLook(1l);
        lookController.deleteLook(2l);
        lookController.deleteLook(3l);
        lookController.deleteLook(4l);
        //WHEN
        assertEquals(0, lookController.allLooks().size());
        //THEN
        assertEquals(Collections.emptyList(),lookController.allLooks());
    }

    @Test
    public void findLookByName_IsReturnCorrect_True() {
        //GIVEN
        Look expected = new Look(
                new UpperClothes(TypeOfUpperClothes.Undershirt, Size.L, Color.Bl, Brand.Fe),
                new DownClothes(TypeOfDownClothes.Skirt, Size.M, Color.Bl, Brand.Fe),
                "Look5", 400);
        //WHEN
        lookController.saveLook(expected);
        //THEN
        assertNotEquals(expected,lookController.findLookByName("Look4"));
        assertEquals(expected,lookController.findLookByName("Look5"));
    }
    @Test
    public void findLookByName_TryEmptyName_Exception() {
        //GIVEN
        expectedEx.expect(LookNotFoundException.class);
        expectedEx.expectMessage("No look with name: " +"" + " found");
        //WHEN
        lookController.findLookByName("");
    }
    @Test
    public void findLookByName_TryNullName_Exception() {
        //GIVEN
        expectedEx.expect(LookNotFoundException.class);
        expectedEx.expectMessage("No look with name: " +"null" + " found");
        //WHEN
        lookController.findLookByName(null);
    }


    @Test
    public void findLookById_IsReturnCorrect_True() {
        //GIVEN
        Look expected = looks.get(0);
        //WHEN
        //THEN
        assertNotEquals(expected,lookController.findLookById(2L));
        assertEquals(expected,lookController.findLookById(1L));
    }
    @Test
    public void findLookById_TryNotFoundId_Exception() {
        //GIVEN
        expectedEx.expect(LookNotFoundException.class);
        expectedEx.expectMessage("No look with " +"100" + " id found");
        //WHEN
        lookController.findLookById(100L);
    }
    @Test
    public void findLookById_TryNullId_Exception() {
        //GIVEN
        expectedEx.expect(LookNotFoundException.class);
        expectedEx.expectMessage("No look with name: " +"null" + " found");
        //WHEN
        lookController.findLookByName(null);
    }


    @Test
    public void findLooksBySize_IsReturnCorrect_True() {
        //GIVEN
        List<Look> expected = new ArrayList<>();
        expected.add(looks.get(0));
        expected.add(looks.get(1));
        //WHEN
        //THEN
        assertEquals(expected,lookController.findLooksBySize(Size.S));
    }
    @Test
    public void findLooksBySize_TryNotFoundSize_Empty() {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(Collections.emptyList(),lookController.findLooksBySize(Size.L));
    }
    @Test
    public void findLooksBySize_TryNullSize_Empty() {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(Collections.emptyList(),lookController.findLooksBySize(null));
    }


    @Test
    public void findLooksByBrand_IsReturnCorrect_True() {
        //GIVEN
        List<Look> expected = new ArrayList<>();
        expected.add(looks.get(0));
        expected.add(looks.get(3));
        //WHEN
        //THEN
        assertEquals(expected,lookController.findLooksByBrand(Brand.Fe));
    }
    @Test
    public void findLooksByBrand_TryNotFoundBrand_Empty() {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(Collections.emptyList(),lookController.findLooksByBrand(Brand.Za));
    }
    @Test
    public void findLooksByBrand_TryNullBrand_Empty() {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(Collections.emptyList(),lookController.findLooksByBrand(null));
    }


    @Test
    public void findLooksByTypeOfUpperClothes_IsReturnCorrect_True() {
        //GIVEN
        List<Look> expected = new ArrayList<>();
        expected.add(looks.get(2));
        expected.add(looks.get(3));
        //WHEN
        //THEN
        assertEquals(expected,lookController.findLooksByTypeOfUpperClothes(TypeOfUpperClothes.Tshirt));
    }
    @Test
    public void findLooksByTypeOfUpperClothes_TryNotFoundType_Empty() {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(Collections.emptyList(),lookController.findLooksByTypeOfUpperClothes(TypeOfUpperClothes.Undershirt));
    }
    @Test
    public void findLooksByTypeOfUpperClothes_TryNullType_Empty() {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(Collections.emptyList(),lookController.findLooksByTypeOfUpperClothes(null));
    }


    @Test
    public void saveLook_IsSaveCorrect_True() {
        //GIVEN
        Look expected = new Look(
                new UpperClothes(TypeOfUpperClothes.Undershirt, Size.L, Color.Bl, Brand.Fe),
                new DownClothes(TypeOfDownClothes.Skirt, Size.M, Color.Bl, Brand.Fe),
                "Look5", 400);
        looks.add(expected);
        //WHEN
        lookController.saveLook(expected);
        //THEN
        assertEquals(looks,lookController.allLooks());
    }
    @Test
    public void saveLook_TryNullLook_Exception() {
        //GIVEN
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage("Can`t save this look");
        //WHEN
        lookController.saveLook(null);
        //THEN
        assertEquals(looks,lookController.allLooks());
    }


    @Test
    public void updateLook_IsUpdateCorrect_True() {
        //GIVEN
        int expectedSize = lookController.allLooks().size();
        Look expected = new Look(3L,
                new UpperClothes(TypeOfUpperClothes.Undershirt, Size.L, Color.Bl, Brand.Fe),
                new DownClothes(TypeOfDownClothes.Skirt, Size.M, Color.Bl, Brand.Fe),
                "Look5", 400);
        //WHEN
        lookController.updateLook(expected);
        //THEN
        assertEquals(expectedSize,lookController.allLooks().size());
        assertEquals(expected,lookController.findLookById(3L));
    }
    @Test
    public void updateLook_TryNotFoundId_Exception() {
        //GIVEN
        expectedEx.expect(LookNotFoundException.class);
        expectedEx.expectMessage("No look with " +"10" + " id found");

        Look expected = new Look(10L,
                new UpperClothes(TypeOfUpperClothes.Undershirt, Size.L, Color.Bl, Brand.Fe),
                new DownClothes(TypeOfDownClothes.Skirt, Size.M, Color.Bl, Brand.Fe),
                "Look5", 400);
        //WHEN
        lookController.updateLook(expected);
        //THEN
    }
    @Test
    public void updateLook_TryNullLook_Exception() {
        //GIVEN
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage("Can`t update this look");
        //WHEN
        lookController.updateLook(null);
        //THEN
    }


    @Test
    public void deleteLookById_IsDeleteCorrect_True() {
        //GIVEN
        List <Look> expected = new ArrayList<>();
        expected = lookController.allLooks();
        expected.remove(0);
        //WHEN
        lookController.deleteLook((1L));
        //THEN
        assertEquals(expected, lookController.allLooks());
    }
    @Test
    public void deleteLookById_TryNotFoundId_DoNothing() {
        //GIVEN
        List <Look> expected = new ArrayList<>();
        expected = lookController.allLooks();
        //WHEN
        lookController.deleteLook((100L));
        //THEN
        assertEquals(expected, lookController.allLooks());
    }
    @Test
    public void deleteLookById_TryNullId_DoNothing() {
        //GIVEN
        List <Look> expected = new ArrayList<>();
        expected = lookController.allLooks();
        //WHEN
        lookController.deleteLook((null));
        //THEN
        assertEquals(expected, lookController.allLooks());
    }
}
