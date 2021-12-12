package CodePrincipal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import CapaciteSpeciale.Capacite_speciale;
import CapaciteSpeciale.Lunatique;
import enumeration.rarete;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		
		// Creation du jeu
		Jeu jeu = Jeu.getInstance();
		
		// Creation des comptes
		Administrateur admin = new Administrateur("admin", "0000", jeu);
		Player player = new Player("joueur1", "0000", jeu);
		Player player2 = new Player("joueur2", "0000", jeu);
		
		// Ajout des capacites speciales
		Capacite_speciale lunatique = new Lunatique();
		Capacite_speciale force = new Lunatique();
		
		HashMap<Integer, Capacite_speciale> liste_capacite_speciale = new HashMap<Integer, Capacite_speciale>();
		liste_capacite_speciale.put(0, lunatique);
		liste_capacite_speciale.put(1, force);
		jeu.setListeCapaciteSpeciale(liste_capacite_speciale);
		
		// Creation des equipes et des joueurs
		admin.ajouterEquipe(jeu, "FC Nantes");
        ArrayList<Integer> nantes = new ArrayList<Integer>();
        nantes.add(0);
		admin.ajouterJoueur(jeu, "Ludovic Blas", true, nantes);
		admin.ajouterJoueur(jeu, "Andrei Girotto", true, nantes);
		admin.ajouterJoueur(jeu, "Pedro Chirivella", true, nantes);
		admin.ajouterJoueur(jeu, "Nicolas Pallois", true, nantes);
		admin.ajouterJoueur(jeu, "Moses Simon", true, nantes);
		admin.ajouterJoueur(jeu, "Randal Kolo Muani", true, nantes);
		admin.ajouterJoueur(jeu, "Roli Pereira De Sa", true, nantes);
		admin.ajouterJoueur(jeu, "Jean-Charles Castelleto", true, nantes);
		admin.ajouterJoueur(jeu, "Fábio", true, nantes);
		admin.ajouterJoueur(jeu, "Alban Lafont", false, nantes);
		admin.ajouterJoueur(jeu, "Dennis Appiah", true, nantes);
		admin.ajouterJoueur(jeu, "Sébastien Corchia", true, nantes);
		admin.ajouterJoueur(jeu, "Kalifa Coulibaly", true, nantes);
		admin.ajouterJoueur(jeu, "Samuel Moutoussamy", true, nantes);
		
		admin.ajouterJoueur(jeu, "Quentin Merlin", true, nantes);
		admin.ajouterJoueur(jeu, "Marcus Coco", true, nantes);
		admin.ajouterJoueur(jeu, "Willem Geubbels", true, nantes);
		admin.ajouterJoueur(jeu, "Wylan Cyprien", true, nantes);
		admin.ajouterJoueur(jeu, "Jean-Charles Castelletto", true, nantes);
		admin.ajouterJoueur(jeu, "Osman Bukari", true, nantes);
		
		admin.ajouterEquipe(jeu, "France");
        ArrayList<Integer> france = new ArrayList<Integer>();
		france.add(1);
		admin.ajouterJoueur(jeu, "Kylian Mbappé", true, france);
		admin.ajouterJoueur(jeu, "Dayot Upamecano", true, france);
		admin.ajouterJoueur(jeu, "Kurt Zouma", true, france);
		admin.ajouterJoueur(jeu, "Aurélien Tchouaméni", true, france);
		admin.ajouterJoueur(jeu, "Karim Benzema", true, france);
		admin.ajouterJoueur(jeu, "Hugo Lloris", true, france);
		admin.ajouterJoueur(jeu, "Lucas Digne", true, france);
		admin.ajouterJoueur(jeu, "Antoine Griezmann", true, france);
		admin.ajouterJoueur(jeu, "Léo Dubois", true, france);
		admin.ajouterJoueur(jeu, "Jules Koundé", false, france);
		admin.ajouterJoueur(jeu, "Benjamin Pavard", true, france);
		admin.ajouterJoueur(jeu, "Kingsley Coman", true, france);
		admin.ajouterJoueur(jeu, "Moussa Diaby", true, france);
		admin.ajouterJoueur(jeu, "Adrien Rabiot", true, france);
		admin.ajouterJoueur(jeu, "Mattéo Guendouzi", true, france);
		admin.ajouterJoueur(jeu, "Jordan Veretout", true, france);
		
		// Creation des cartes
		for(int i=0; i<jeu.getListeJoueur().size();i++) {
			admin.ajouterCarte(i);
		}
		
		// Test achat/echange de cartes
		player.acheterCarte(0);
		player.acheterCarte(1110);
		player.acheterCarte(2220);
		player.acheterCarte(3330);
		player.acheterCarte(4440);
		
		player2.acheterCarte(5550);
		player2.acheterCarte(6660);
		player2.acheterCarte(7770);
		
		player.ajoutCarteEnVente(4440, 1000);
		player2.acheterCarte(4440);
		
		player.ajoutCarteEchange(0, rarete.commune, 5);
		player2.echanger(0, 5550);
		
		//player.afficherDetail();
		//player2.afficherDetail();
		
		// Test d'une semaine
		ArrayList<Integer> equipe_player = new ArrayList<Integer>();
		equipe_player.add(5550);
		equipe_player.add(1110);
		equipe_player.add(2220);
		equipe_player.add(3330);
		player.setCarteSemaineSuivante(equipe_player);
		
		ArrayList<Integer> equipe_player2 = new ArrayList<Integer>();
		equipe_player2.add(0);
		equipe_player2.add(6660);
		equipe_player2.add(7770);
		equipe_player2.add(4440);
		player2.setCarteSemaineSuivante(equipe_player2);
		
		System.out.println(player2.getCarteSemaineSuivante());
		
        admin.miseAjourHebdo();
        jeu.afficherClassementPlayer();
	}

}
