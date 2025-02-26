package pub;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pub {
	private static final Logger LOGGER = Logger.getLogger(Pub.class.getName());
	private static final String BIERE = "Biere"; // Defined constant

	Bar bar;
	Cave cave;

	public Pub(){
		this.bar = new Bar();
		this.cave = new Cave();
	}

	public void approvisionnerBar(String nom){
		Boisson boisson = this.cave.take(nom);
		if (boisson != null) {
			this.bar.add(boisson);
		}
	}

	public static void main(String[] args) {
		Pub pub = new Pub();

		pub.cave.add(new Boisson("Coca"));
		pub.cave.add(new Boisson("Eau"));
		pub.cave.add(new Boisson("Whisky", 40));
		pub.cave.add(new Boisson(BIERE, 8));

		pub.approvisionnerBar(BIERE);
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("Eau");

		Cocktail maz = new Cocktail("Mazout");
		maz.add(BIERE, 50);
		maz.add("Coca", 50);
		pub.bar.add(maz);

		pub.bar.boissonChaude.add(new Boisson("Cafe"));

		// Log message only if logging at INFO level is enabled
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.log(Level.INFO, "Drink served: {0}", pub.bar.serv("Cafe"));
		}
	}
}