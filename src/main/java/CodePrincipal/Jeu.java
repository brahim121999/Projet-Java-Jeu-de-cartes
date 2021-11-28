package CodePrincipal;

import java.util.ArrayList;
import java.util.List;

import CapaciteSpeciale.Capacite_speciale;

public class Jeu {
	private int semaine;
	private List<Utilisateur> liste_utilisateur;
	private List<Equipe> liste_equipe;
	private List<Joueur> liste_joueur;
	private List<Carte> liste_carte;			//Liste des cartes implémentées dans le jeu
	private List<Carte> liste_en_vente;			//Liste des cartes en ventes
	private List<Carte> liste_carte_echange;	//Liste des cartes proposées en échange
	private List<Carte> liste_carte_systeme;	//Liste des cartes n'appartenant à aucun joueur
	private List<Classement_Player> liste_classement_utilisateur;	
	private List<Classement_Joueur> liste_classement_joueur;
	private List<Dataset> liste_dataset;
	private List<Capacite_speciale> liste_capacite_speciale;
	
	public Jeu() {
		this.semaine = 0;
		this.liste_utilisateur = new ArrayList<Utilisateur>();
		this.liste_equipe = new ArrayList<Equipe>();
		this.liste_joueur = new ArrayList<Joueur>();
		this.liste_carte = new ArrayList<Carte>();
		this.liste_en_vente = new ArrayList<Carte>();
		this.liste_carte_echange = new ArrayList<Carte>();
		this.liste_carte_systeme = new ArrayList<Carte>();
		this.liste_classement_utilisateur = new ArrayList<Classement_Player>();
		this.liste_classement_joueur = new ArrayList<Classement_Joueur>();
		this.liste_dataset = new ArrayList<Dataset>();
		this.liste_capacite_speciale = new ArrayList<Capacite_speciale>();
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	
	public int getSemaine() {
		return this.semaine;
	}
	
	public void setSemaine(int semaine) {
		this.semaine = semaine;
	}
	
	public List<Utilisateur> getListe_utilisateur() {
		return this.liste_utilisateur;
	}
	
	public void setListe_utilisateur(List<Utilisateur> liste_utilisateur) {
		this.liste_utilisateur = liste_utilisateur;
	}
	
	public List<Equipe> getListe_equipe() {
		return this.liste_equipe;
	}
	
	public void setListe_equipe(List<Equipe> liste_equipe) {
		this.liste_equipe = liste_equipe;
	}
	
	public List<Joueur> getListe_Joueur() {
		return this.liste_joueur;
	}
	
	public void setListe_joueur(List<Joueur> liste_joueur) {
		this.liste_joueur = liste_joueur;
	}
	
	public List<Carte> getListe_carte() {
		return this.liste_carte;
	}
	
	public void setListe_carte(List<Carte> liste_carte) {
		this.liste_carte = liste_carte;
	}
	
	public List<Carte> getListe_en_vente() {
		return this.liste_en_vente;
	}
	
	public void setListe_en_vente(List<Carte> liste_en_vente) {
		this.liste_en_vente = liste_en_vente;
	}
	
	public List<Carte> getListe_carte_echange() {
		return this.liste_carte_echange;
	}
	
	public void setListe_carte_echange(List<Carte> liste_carte_echange) {
		this.liste_carte_echange = liste_carte_echange;
	}
	
	public List<Carte> getListe_carte_systeme() {
		return this.liste_carte_systeme;
	}
	
	public void setListe_carte_systeme(List<Carte> liste_carte_systeme) {
		this.liste_carte_systeme = liste_carte_systeme;
	}
	
	public List<Classement_Player> getListe_classement_utilisateur() {
		return this.liste_classement_utilisateur;
	}
	
	public List<Classement_Joueur> getListe_classement_joueur() {
		return this.liste_classement_joueur;
	}
	
	public List<Dataset> getListe_dataset() {
		return this.liste_dataset;
	}
	
	public List<Capacite_speciale> getListe_capacite_speciale() {
		return this.liste_capacite_speciale;
	}
	
	public void setListe_capacite_speciale(List<Capacite_speciale> liste_capacite_speciale) {
		this.liste_capacite_speciale = liste_capacite_speciale;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	void afficherClassementJoueur() {
		//affiche le dernier classement des joueurs en date
	}
	
	void afficherClassementJoueur(int semaine) {
		//affiche le classement des joueurs de la semaine placée en paramètre
	}
	
	void afficherClassementPlayer() {
		//affiche le dernier classement des utilisateurs en date
	}
	
	void afficherClassementPlayer(int semaine) {
		//affiche le classement des utilisateurs de la semaine placée en paramètre
	}
}
