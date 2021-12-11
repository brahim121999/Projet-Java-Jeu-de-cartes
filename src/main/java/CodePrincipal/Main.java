package CodePrincipal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import CapaciteSpeciale.Capacite_speciale;
import CapaciteSpeciale.Lunatique;
import enumeration.rarete;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		
		// Creation du jeu
		Jeu jeu = Jeu.getInstance();
		jeu.afficher();
		
		// Creation des comptes
		Administrateur admin = new Administrateur("matteo", "1234", jeu);
		Player player = new Player("brahim", "0000", jeu);
		Player player2 = new Player("picarougne", "0000", jeu);
		
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
		
		// Test achat de cartes
		jeu.afficher();
        System.out.println(player.getBalance());
        System.out.println(jeu.getListeCarte().get(2).getPrix());
        player.acheterCarte(2);

        System.out.println(player.getListeCarte());
        System.out.println(player.getBalance());

        player2.acheterCarte(550);
        player2.ajoutCarteEnVente(550, 1000);

        System.out.println(player.getListeCarte());
        System.out.println(player2.getListeCarte());

        player.acheterCarte(550);
        
        player2.acheterCarte(400);
        System.out.println("/////");
        System.out.println(jeu.getCarte(400).getRarete());
        System.out.println(jeu.getCarte(400).getIdJoueur());
        
        // Test echange de cartes
        player.acheterCarte(1120);
        player.ajoutCarteEchange(1120, rarete.commune, 0);
        
        System.out.println(player.getListeCarte());
        System.out.println(player2.getListeCarte());
        
        player2.echanger(0, 400);
        
        System.out.println(player.getListeCarte());
        System.out.println(player2.getListeCarte());
        
        //String s = "Hello world !";
        //System.out.println(s.substring(1));
        
       // Dataset
        admin.ajouterEquipe(jeu, "FC Nantes");
        ArrayList<Integer> liste_equipe2 = new ArrayList<Integer>();
		liste_equipe2.add(1);
		admin.ajouterJoueur(jeu, "Ludovic Blas", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Andrei Girotto", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Pedro Chirivella", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Nicolas Pallois", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Moses Simon", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Randal Kolo Muani", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Roli Pereira De Sa", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Jean-Charles Castelleto", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Fábio", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Alban Lafont", false, liste_equipe2);
		admin.ajouterJoueur(jeu, "Dennis Appiah", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Sébastien Corchia", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Kalifa Coulibaly", true, liste_equipe2);
		admin.ajouterJoueur(jeu, "Samuel Moutoussamy", true, liste_equipe2);
		
        Dataset data = new Dataset(42, "/home/bob/Bureau/Projet/2021-boursault-braham-java/Données-20211128/2021_42/", "2021_42_Nantes.csv", jeu);
        data.afficher();
	}

}
