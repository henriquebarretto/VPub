package pub;
import java.util.ArrayList;
import java.util.Iterator;

public class Cave {
	ArrayList<Boisson> rayons;

	public Cave(){
		this.rayons = new ArrayList<>();
	}

	public void add(Boisson b){
		this.rayons.add(b);
	}

	public Boisson take(String nom){
		Iterator<Boisson> iterator = this.rayons.iterator();
		while (iterator.hasNext()) {
			Boisson boisson = iterator.next();
			if (boisson.nom.equalsIgnoreCase(nom)) {
				iterator.remove(); // Safe removal using Iterator
				return boisson;
			}
		}
		return null;
	}
}