package CodePrincipal;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import CapaciteSpeciale.Capacite_speciale;
import enumeration.rarete;

public class Administrateur extends Utilisateur {
	
	private Jeu jeu;
	
	public Administrateur(String pseudo, String mdp, Jeu jeu) {
		super(pseudo, mdp);
		this.jeu=jeu;
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public String getPseudo() {
		
		return pseudo;
	}
	
	public void setPseudo(String nom) {
		this.pseudo=nom;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String password) {
		this.mdp=password;
	}
	
	public Integer getId() {
		
		return id_utilisateur;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public void ajouterCarte(Integer id_joueur) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		int nb_capacite_spe = jeu.getListeCapaciteSpeciale().size();
		
		//creation des cartes communes
		for(int i=0; i<1000; i++) {
			double alea1 = Math.random();
			//2 chance sur 10 d'avoir une capacite speciale
			if(alea1 >= 0.8) {
				Integer alea2 = (int)(Math.random() * nb_capacite_spe);
				rarete rarete = enumeration.rarete.commune;
				Carte carte = new Carte(id_joueur, rarete,this.jeu);
				Capacite_speciale capacite = jeu.getListeCapaciteSpeciale().get(alea2).getClass().getDeclaredConstructor().newInstance(carte);
				capacite.ajouterCarte();
			}
			else {
				rarete rarete = enumeration.rarete.commune;
				Carte carte = new Carte(id_joueur, rarete, this.jeu);
				carte.ajouterCarte();
			}
		}
		//creation des cartes peu communes
		for(int i=0; i<100; i++) {
			double alea1 = Math.random();
			//2 chance sur 10 d'avoir une capacite speciale
			if(alea1 >= 0.8) {
				Integer alea2 = (int)(Math.random() * nb_capacite_spe) + 1;
				rarete rarete = enumeration.rarete.peu_commune;
				Carte carte = new Carte(id_joueur, rarete, this.jeu);
				Capacite_speciale capacite = jeu.getListeCapaciteSpeciale().get(alea2).getClass().getDeclaredConstructor().newInstance(carte);
				capacite.ajouterCarte();
			}
			else {
				rarete rarete = enumeration.rarete.peu_commune;
				Carte carte = new Carte(id_joueur, rarete, this.jeu);
				carte.ajouterCarte();
			}
		}
		//creation des cartes rares
		for(int i=0; i<10; i++) {
			double alea1 = Math.random();
			//2 chance sur 10 d'avoir une capacite speciale
			if(alea1 >= 0.8) {
				Integer alea2 = (int)(Math.random() * nb_capacite_spe) + 1;
				rarete rarete = enumeration.rarete.rare;
				Carte carte = new Carte(id_joueur, rarete, this.jeu);
				Capacite_speciale capacite = jeu.getListeCapaciteSpeciale().get(alea2).getClass().getDeclaredConstructor().newInstance(carte);
				capacite.ajouterCarte();
			}
			else {
				rarete rarete = enumeration.rarete.rare;
				Carte carte = new Carte(id_joueur, rarete, this.jeu);
				carte.ajouterCarte();
			}
		}
	}
	
	// pour ajouter un joueur dans le jeu
	public void ajouterJoueur(Jeu jeu, String nom, String prenom, boolean poste, List<Integer> liste_equipe, List<Integer> liste_score) {
		Joueur joueur = new Joueur(jeu, nom, prenom, poste, liste_equipe, liste_score);
		
		//On ajoute le joueur a la liste des joueurs du jeu
		jeu.getListeJoueur().put(joueur.getId_joueur(), joueur);
				
		//On ajoute le joueur a la liste des joueurs de ses equipes
		for (int i=0; i<liste_equipe.size();i++) {
			Equipe equipe = jeu.getListeEquipe().get(liste_equipe.get(i));
			if (!equipe.getListe_joueur().contains(joueur.getId_joueur())) {
				equipe.addPlayer(joueur.getId_joueur());
			}
		}
	}
	
	// pour ajouter une equipe dans le jeu
	public void ajouterEquipe(Jeu jeu, String nom, List<Integer> liste_joueur) {
		Equipe equipe = new Equipe(jeu, nom, liste_joueur);
		jeu.getListeEquipe().put(equipe.getId_equipe(), equipe);
	}
}
