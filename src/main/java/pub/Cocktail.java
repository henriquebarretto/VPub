package pub;
import java.util.ArrayList;

public class Cocktail {
	private static class Ingrediant {
		String name;
		double quantite;

		public Ingrediant(String name, double quantite){
			this.name = name;
			this.quantite = quantite;
		}
	}

	String nom;
	ArrayList<Ingrediant> ingrediants;
	boolean alcoolise;

	public Cocktail(String nom){
		this.nom = nom;
		this.ingrediants = new ArrayList<>();
		this.alcoolise = false;
	}

	public void add(String ingrediant, double quantite){
		if (ingrediant.equalsIgnoreCase("whiskey") || ingrediant.equalsIgnoreCase("rum") ||
				ingrediant.equalsIgnoreCase("vodka") || ingrediant.equalsIgnoreCase("tequila")) {
			this.alcoolise = true;
		}
		this.ingrediants.add(new Ingrediant(ingrediant, quantite));
	}

	public boolean alcoolFree(){
		return !this.alcoolise;
	}

	public String toString(){
		StringBuilder result = new StringBuilder();
		for (Ingrediant current : ingrediants) {  // Substituição de Enumeration por for-each
			result.append(current.name).append(" ").append(current.quantite).append("%\t");
		}
		return result.toString();
	}
}