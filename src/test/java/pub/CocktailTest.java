package pub;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CocktailTest {

    private Cocktail nonAlcoholicCocktail;
    private Cocktail alcoholicCocktail;

    @BeforeEach
    void setUp() {
        nonAlcoholicCocktail = new Cocktail("Tropical Mix");
        alcoholicCocktail = new Cocktail("Rum Punch");

        nonAlcoholicCocktail.add("Mango Juice", 50.0);
        nonAlcoholicCocktail.add("Orange Juice", 50.0);

        alcoholicCocktail.add("Rum", 50.0);
        alcoholicCocktail.add("Pineapple Juice", 50.0);
    }

    @Test
    void testCreateCocktail() {
        assertEquals("Tropical Mix", nonAlcoholicCocktail.nom);
        assertFalse(nonAlcoholicCocktail.alcoolFree());
    }

    @Test
    void testAddIngredient() {
        Cocktail cocktail = new Cocktail("Mojito");
        cocktail.add("Mint", 10.0);
        assertEquals(1, cocktail.ingrediants.size());
    }

    @Test
    void testAlcoholFree() {
        assertFalse(nonAlcoholicCocktail.alcoolFree());
        assertFalse(alcoholicCocktail.alcoolFree());
    }

    @Test
    void testToString() {
        String expected = "Mango Juice 50.0%\tOrange Juice 50.0%\t";
        assertEquals(expected, nonAlcoholicCocktail.toString());
    }
}
