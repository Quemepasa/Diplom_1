package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}")
    public static Object[][] getSumData() {
        return new Object[][] {
                { SAUCE, "Соус традиционный галактический", 15 },
                { FILLING, "Биокотлета из марсианской Магнолии", (float) 150.3 },
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void checkGetNameReturnName() {
        String actualResult = ingredient.getName();
        assertEquals("Неправильный имя ингредиента", name, actualResult);
    }

    @Test
    public void checkGetPriceReturnPrice() {
        float actualResult = ingredient.getPrice();
        assertEquals("Неправильный цена ингредиента", price, actualResult, 0);
    }

    @Test
    public void checkGetTypeReturnIngredientType() {
        IngredientType actualResult = ingredient.getType();
        assertEquals("Неправильный тип ингредиента", ingredientType, actualResult);
    }
}