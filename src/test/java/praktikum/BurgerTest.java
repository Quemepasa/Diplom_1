package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    private Burger burger;
    private Ingredient sauce;
    private Bun bun;
    private Ingredient filling;

    private final static int EMPTY_LIST = 0;
    private final  static int FIRST_ELEMENT_OF_LIST = 0;
    private final static float EXPECTED_PRICE = 2141.3F;

    @Before
    public void setUp() {
        burger = new Burger();
        sauce = new Ingredient(SAUCE, "Соус традиционный галактический", 15);
        filling = new Ingredient(FILLING, "Биокотлета из марсианской Магнолии", (float) 150.3);
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
    }

    @Test
    public void checkAddIngredientMethodAddsIngredientToList() {
        burger.addIngredient(sauce);

        assertEquals(sauce, burger.ingredients.get(FIRST_ELEMENT_OF_LIST));
    }

    @Test
    public void checkRemoveIngredientMethodRemovesIngredientFromList() {
        burger.addIngredient(filling);
        burger.removeIngredient(FIRST_ELEMENT_OF_LIST);

        assertEquals(EMPTY_LIST, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredientMethodMovesIngredientInList() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, FIRST_ELEMENT_OF_LIST);

        assertEquals(filling, burger.ingredients.get(FIRST_ELEMENT_OF_LIST));
    }

    @Test
    public void checkGetPriceReturnsPrice() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float actualResult = burger.getPrice();

        assertEquals(EXPECTED_PRICE, actualResult, 0);
    }

    @Test
    public void checkGetReceiptReturnsReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String expectedResult = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(),
                        sauce.getName()) +
                String.format("= %s %s =%n", filling.getType().toString().toLowerCase(),
                        filling.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        String actualResult = burger.getReceipt();

        assertEquals(expectedResult, actualResult);
    }
}