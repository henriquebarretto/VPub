package pub;

public class Boisson {
	String nom;
	boolean alcoolise;
	float degre;

	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = false;
	}

	public Boisson(String nom, float degre){
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = true;
	}

	public String toString(){
		return this.alcoolise ? this.nom + " (l'abus d'alcool est dangereux pour la sante)" : this.nom;
	}
}