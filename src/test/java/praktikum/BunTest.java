package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Флюоресцентная булка R2-D3", 988 },
                { "Краторная булка N-200i", (float) 1250.75 },
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void checkGetNameReturnsName() {
        String actualResult = bun.getName();

        assertEquals("Неправильное имя булочки", name, actualResult);
    }

    @Test
    public void checkGetPriceReturnsPrice() {
        float actualResult = bun.getPrice();

        assertEquals("Неправильная цена булочки", price, actualResult, 0);
    }
}