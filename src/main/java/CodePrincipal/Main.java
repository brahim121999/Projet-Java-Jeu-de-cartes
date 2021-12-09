package CodePrincipal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import CapaciteSpeciale.Capacite_speciale;
import CapaciteSpeciale.Lunatique;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		// Creation du jeu
		Jeu jeu = Jeu.getInstance();
		jeu.afficher();
		
		// Creation des comptes
		Administrateur admin = new Administrateur("matteo", "1234", jeu);
		Utilisateur player = new Player("brahim", "0000", jeu);
		
		// Ajout des capacites speciales
		Capacite_speciale lunatique = new Lunatique();
		Capacite_speciale force = new Lunatique();
		
		HashMap<Integer, Capacite_speciale> liste_capacite_speciale = new HashMap<Integer, Capacite_speciale>();
		liste_capacite_speciale.put(0, lunatique);
		liste_capacite_speciale.put(1, force);
		jeu.setListeCapaciteSpeciale(liste_capacite_speciale);
		
		// Creation des equipes et des joueurs
		admin.ajouterEquipe(jeu, "FCChantrerie");
		ArrayList<Integer> liste_equipe = new ArrayList<Integer>();
		liste_equipe.add(0);
		
		admin.ajouterJoueur(jeu, "Brahim", true, liste_equipe);
		admin.ajouterJoueur(jeu, "Matt", true, liste_equipe);
		admin.ajouterJoueur(jeu, "Peter", false, liste_equipe);
		
		jeu.afficher();
		// Creation des cartes
		for(int i=0; i<jeu.getListeJoueur().size();i++) {
			admin.ajouterCarte(i);
		}
		
		// Affichage
		jeu.afficher();
	}

}
