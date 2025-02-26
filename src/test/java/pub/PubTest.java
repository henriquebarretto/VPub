package pub;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PubTest {

    private Pub pub;

    @BeforeEach
    void setUp() {
        pub = new Pub();
        pub.cave.add(new Boisson("Cola"));
        pub.cave.add(new Boisson("Beer", 5.0f));
    }

    @Test
    void testStockBarFromCave() {
        pub.approvisionnerBar("Beer");
        assertEquals(1, pub.bar.boissonAlcoolisee.size());
    }

    @Test
    void testServeDrinkFromBar() {
        pub.approvisionnerBar("Cola");
        Object servedDrink = pub.bar.serv("Cola");
        assertNotNull(servedDrink);
        assertInstanceOf(Boisson.class, servedDrink); // Corrigido
        assertEquals("Cola", ((Boisson) servedDrink).nom);
    }

    @Test
    void testServeUnavailableDrink() {
        assertNull(pub.bar.serv("Water"));
    }
}