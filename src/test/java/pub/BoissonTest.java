package pub;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoissonTest {

    @Test
    void testCreateNonAlcoholicDrink() {
        Boisson water = new Boisson("Water");
        assertEquals("Water", water.nom);
        assertFalse(water.alcoolise);
    }

    @Test
    void testCreateAlcoholicDrink() {
        Boisson beer = new Boisson("Beer", 5.0f);
        assertEquals("Beer", beer.nom);
        assertTrue(beer.alcoolise);
    }

    @Test
    void testToStringNonAlcoholicDrink() {
        Boisson juice = new Boisson("Juice");
        assertEquals("Juice", juice.toString());
    }

    @Test
    void testToStringAlcoholicDrink() {
        Boisson vodka = new Boisson("Vodka", 40.0f);
        assertEquals("Vodka (l'abus d'alcool est dangereux pour la sante)", vodka.toString());
    }
}
