package pub;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaveTest {

    private Cave cave;
    private Boisson wine;
    private Boisson soda;

    @BeforeEach
    void setUp() {
        cave = new Cave();
        wine = new Boisson("Wine", 12.0f);
        soda = new Boisson("Soda");
    }

    @Test
    void testAddDrinkToCave() {
        cave.add(wine);
        assertEquals(1, cave.rayons.size());
        assertEquals("Wine", cave.rayons.getFirst().nom); // Corrigido
    }

    @Test
    void testTakeExistingDrink() {
        cave.add(soda);
        Boisson takenDrink = cave.take("Soda");
        assertNotNull(takenDrink);
        assertEquals("Soda", takenDrink.nom);
        assertEquals(0, cave.rayons.size());
    }

    @Test
    void testTakeNonExistingDrink() {
        assertNull(cave.take("Whiskey"));
    }
}