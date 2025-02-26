package pub;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BarTest {

    private Bar bar;
    private Boisson coffee;
    private Boisson whiskey;
    private Cocktail nonAlcoholicCocktail;
    private Cocktail alcoholicCocktail;

    @BeforeEach
    void setUp() {
        bar = new Bar();
        coffee = new Boisson("Coffee");
        whiskey = new Boisson("Whiskey", 40.0f);
        nonAlcoholicCocktail = new Cocktail("Fruit Punch");
        alcoholicCocktail = new Cocktail("Whiskey Sour");

        nonAlcoholicCocktail.add("Orange Juice", 50.0);
        nonAlcoholicCocktail.add("Pineapple Juice", 50.0);

        alcoholicCocktail.add("Whiskey", 50.0);
        alcoholicCocktail.add("Lemon Juice", 50.0);
    }

    @Test
    void testAddNonAlcoholicDrink() {
        bar.add(coffee);
        assertEquals(1, bar.boissonChaude.size());
        assertEquals("Coffee", bar.boissonChaude.getFirst().nom);
    }

    @Test
    void testAddAlcoholicDrink() {
        bar.add(whiskey);
        assertEquals(1, bar.boissonAlcoolisee.size());
        assertEquals("Whiskey", bar.boissonAlcoolisee.getFirst().nom); // Corrigido
    }

    @Test
    void testAddNonAlcoholicCocktail() {
        bar.add(nonAlcoholicCocktail);
        assertEquals(1, bar.cocktailSansAlcoole.size());
        assertEquals("Fruit Punch", bar.cocktailSansAlcoole.getFirst().nom); // Corrigido
    }

    @Test
    void testAddAlcoholicCocktail() {
        bar.add(alcoholicCocktail);
        assertEquals(1, bar.cocktailAvecAlcoole.size());
        assertEquals("Whiskey Sour", bar.cocktailAvecAlcoole.getFirst().nom); // Corrigido
    }

    @Test
    void testServeDrinkAvailable() {
        bar.add(coffee);
        Boisson servedDrink = (Boisson) bar.serv("Coffee");
        assertNotNull(servedDrink);
        assertEquals("Coffee", servedDrink.nom);
        assertEquals(0, bar.boissonFroide.size());
    }

    @Test
    void testServeDrinkNotAvailable() {
        assertNull(bar.serv("Coca-Cola"));
    }

    @Test
    void testServeCocktailAvailable() {
        bar.add(nonAlcoholicCocktail);
        Cocktail servedCocktail = (Cocktail) bar.serv("Fruit Punch");
        assertNotNull(servedCocktail);
        assertEquals("Fruit Punch", servedCocktail.nom);
        assertEquals(0, bar.cocktailSansAlcoole.size());
    }

    @Test
    void testServeCocktailNotAvailable() {
        assertNull(bar.serv("Mojito"));
    }
}