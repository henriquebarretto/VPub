package pub;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Bar {
	List<Boisson> boissonChaude;
	List<Boisson> boissonFroide;
	List<Cocktail> cocktailSansAlcoole;
	List<Boisson> boissonAlcoolisee;
	List<Cocktail> cocktailAvecAlcoole;

	public Bar(){
		this.boissonChaude = new ArrayList<>();
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();
		this.cocktailAvecAlcoole = new ArrayList<>();
		this.cocktailSansAlcoole = new ArrayList<>();
	}

	public void add(Boisson boisson){
		if (boisson.alcoolise) {
			this.boissonAlcoolisee.add(boisson);
		} else {
			if (boisson.nom.equalsIgnoreCase("coffee") || boisson.nom.equalsIgnoreCase("tea")) {
				this.boissonChaude.add(boisson);
			} else {
				this.boissonFroide.add(boisson);
			}
		}
	}

	public void add(Cocktail cocktail){
		if (cocktail.alcoolFree()) {
			this.cocktailSansAlcoole.add(cocktail);
		} else {
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}

	public Object serv(String command){
		Iterator<Boisson> itB;
		Iterator<Cocktail> itC;

		itB = this.boissonFroide.iterator();
		while (itB.hasNext()) {
			Boisson b = itB.next();
			if (b.nom.equalsIgnoreCase(command)) {
				itB.remove();
				return b;
			}
		}

		itB = this.boissonAlcoolisee.iterator();
		while (itB.hasNext()) {
			Boisson b = itB.next();
			if (b.nom.equalsIgnoreCase(command)) {
				itB.remove();
				return b;
			}
		}

		itB = this.boissonChaude.iterator();
		while (itB.hasNext()) {
			Boisson b = itB.next();
			if (b.nom.equalsIgnoreCase(command)) {
				itB.remove();
				return b;
			}
		}

		itC = this.cocktailSansAlcoole.iterator();
		while (itC.hasNext()) {
			Cocktail c = itC.next();
			if (c.nom.equalsIgnoreCase(command)) {
				itC.remove();
				return c;
			}
		}

		itC = this.cocktailAvecAlcoole.iterator();
		while (itC.hasNext()) {
			Cocktail c = itC.next();
			if (c.nom.equalsIgnoreCase(command)) {
				itC.remove();
				return c;
			}
		}

		return null;
	}
}