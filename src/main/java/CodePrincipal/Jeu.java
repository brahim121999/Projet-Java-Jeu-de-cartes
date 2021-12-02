package CodePrincipal;

import java.util.HashMap;
import java.util.Map;

import CapaciteSpeciale.Capacite_speciale;

public class Jeu {
	private int semaine;
	private Map<Integer, Utilisateur> liste_utilisateur;	//Couple id / objet
	private Map<Integer, Equipe> liste_equipe;
	private Map<Integer, Joueur> liste_joueur;
	private Map<Integer, Carte> liste_carte;			//Liste des cartes impl�ment�es dans le jeu
	private Map<Integer, Carte> liste_en_vente;			//Liste des cartes en ventes
	private Map<Integer, Carte> liste_carte_echange;	//Liste des cartes propos�es en �change
	private Map<Integer, Carte> liste_carte_systeme;	//Liste des cartes n'appartenant � aucun joueur
	private Map<Integer, Classement_Player> liste_classement_utilisateur;	
	private Map<Integer, Classement_Joueur> liste_classement_joueur;
	private Map<Integer, Dataset> liste_dataset;
	private Map<Integer, Capacite_speciale> liste_capacite_speciale;
	private static Jeu uniqueInstance = new Jeu();
	
	private Jeu() {
		this.semaine = 0;
		this.liste_utilisateur = new HashMap<Integer, Utilisateur>();
		this.liste_equipe = new HashMap<Integer, Equipe>();
		this.liste_joueur = new HashMap<Integer, Joueur>();
		this.liste_carte = new HashMap<Integer, Carte>();
		this.liste_en_vente = new HashMap<Integer, Carte>();
		this.liste_carte_echange = new HashMap<Integer, Carte>();
		this.liste_carte_systeme = new HashMap<Integer, Carte>();
		this.liste_classement_utilisateur = new HashMap<Integer, Classement_Player>();
		this.liste_classement_joueur = new HashMap<Integer, Classement_Joueur>();
		this.liste_dataset = new HashMap<Integer, Dataset>();
		this.liste_capacite_speciale = new HashMap<Integer, Capacite_speciale>();
	}
	
	public static Jeu getInstance() {
		return Jeu.uniqueInstance;
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
	
	public Map<Integer, Utilisateur> getListeUtilisateur() {
		return this.liste_utilisateur;
	}
	
	public void setListeUtilisateur(Map<Integer, Utilisateur> liste_utilisateur) {
		this.liste_utilisateur = liste_utilisateur;
	}
	
	public Map<Integer, Equipe> getListeEquipe() {
		return this.liste_equipe;
	}
	
	public void setListeEquipe(Map<Integer, Equipe> liste_equipe) {
		this.liste_equipe = liste_equipe;
	}
	
	public Map<Integer, Joueur> getListeJoueur() {
		return this.liste_joueur;
	}
	
	public void setListeJoueur(Map<Integer, Joueur> liste_joueur) {
		this.liste_joueur = liste_joueur;
	}
	
	public Map<Integer, Carte> getListeCarte() {
		return this.liste_carte;
	}
	
	public void setListeCarte(Map<Integer, Carte> liste_carte) {
		this.liste_carte = liste_carte;
	}
	
	public Map<Integer, Carte> getListeEnVente() {
		return this.liste_en_vente;
	}
	
	public void setListeEnVente(Map<Integer, Carte> liste_en_vente) {
		this.liste_en_vente = liste_en_vente;
	}
	
	public Map<Integer, Carte> getListeCarteEchange() {
		return this.liste_carte_echange;
	}
	
	public void setListeCarteEchange(Map<Integer, Carte> liste_carte_echange) {
		this.liste_carte_echange = liste_carte_echange;
	}
	
	public Map<Integer, Carte> getListeCarteSysteme() {
		return this.liste_carte_systeme;
	}
	
	public void setListeCarteSysteme(Map<Integer, Carte> liste_carte_systeme) {
		this.liste_carte_systeme = liste_carte_systeme;
	}
	
	public Map<Integer, Classement_Player> getListeClassementUtilisateur() {
		return this.liste_classement_utilisateur;
	}
	
	public Map<Integer, Classement_Joueur> getListeClassementJoueur() {
		return this.liste_classement_joueur;
	}
	
	public Map<Integer, Dataset> getListeDataset() {
		return this.liste_dataset;
	}
	
	public Map<Integer, Capacite_speciale> getListeCapaciteSpeciale() {
		return this.liste_capacite_speciale;
	}
	
	public void setListeCapaciteSpeciale(Map<Integer, Capacite_speciale> liste_capacite_speciale) {
		this.liste_capacite_speciale = liste_capacite_speciale;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public void mettreEnVente(Carte carte) {
		liste_en_vente.put(carte.getIdCarte(), carte);
	}
	
	public void mettreEnEchange(Carte carte) {
		liste_carte_echange.put(carte.getIdCarte(), carte);
	}
	
	public void supprimerDeLaVente(int id_carte) {
		liste_en_vente.remove(id_carte);
	}
	
	public void supprimerDeEchange(int id_carte) {
		liste_carte_echange.remove(id_carte);
	}
	
	void afficherClassementJoueur() {
		//affiche le dernier classement des joueurs en date
	}
	
	void afficherClassementJoueur(int semaine) {
		//affiche le classement des joueurs de la semaine plac�e en param�tre
	}
	
	void afficherClassementPlayer() {
		//affiche le dernier classement des utilisateurs en date
	}
	
	void afficherClassementPlayer(int semaine) {
		//affiche le classement des utilisateurs de la semaine plac�e en param�tre
	}
}
