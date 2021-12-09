package CodePrincipal;

import java.util.*;

import enumeration.rarete;

public class Player extends Utilisateur{
	
	private double balance;
	private ArrayList<Integer> liste_carte;
	private ArrayList<Integer> carte_semaine_suivante;
	public ArrayList<Integer> carte_en_vente;
	public ArrayList<Integer> echange;
	public Integer score_player;
	public ArrayList<Integer> liste_score;
	private Jeu jeu;
	
	
	public Player(String pseudo, String mdp, Jeu jeu) {
		super(pseudo, mdp);
		this.balance = 10000;
		this.liste_carte= new ArrayList<Integer>();
		this.carte_semaine_suivante = new ArrayList<Integer>(4);
		this.carte_en_vente = new ArrayList<Integer>();
		this.echange = new ArrayList<Integer>();
		this.score_player = 0;
		this.liste_score = new ArrayList<Integer>();
		this.jeu = jeu;
		jeu.getListeUtilisateur().put(this.id_utilisateur, this);
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
	
	public double getBalance() {
		return this.balance;
	}
	
	public ArrayList<Integer> getListeCarte(){
		return this.liste_carte;
	}
	
	public ArrayList<Integer> getCarteSemaineSuivante() {
		return this.carte_semaine_suivante;
	}
	
	public void setCarteSemaineSuivante(ArrayList<Integer> suivante ) {
		this.carte_semaine_suivante = suivante;
	}
	
	public ArrayList<Integer> getCarteEnVente() {
		return this.carte_en_vente;
	}

	public ArrayList<Integer> getCarteEchange() {
		return this.echange;
	}
	
	public Integer getScore() {
		return this.score_player;
	}
	
	public void setScore(Integer score) {
		this.score_player = score;
	}
	
	public ArrayList<Integer> getListeScore(){
		return this.liste_score;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	// deposer de l'argent
	public void augmenterBalance(double m) {
		this.balance += m;
	}
	
	// retirer de l'argent
	public void diminuerBalance(double m) {
		this.balance -= m  ;
	}
	
	// sauvegarde des performances hebdomadaires
	public void ajoutListeScore(Integer score) {
		this.liste_score.add(score);
	}
	
	// on ajoute la carte dans la liste des cartes en vente du joueur et dans la liste des cartes en vente du jeu
	public void ajoutCarteEnVente(Integer id_carte, Integer prix) {
		Carte carte = jeu.getCarte(id_carte);
		carte.setPrix(prix);
		
		if(!this.liste_carte.contains(id_carte)) {
			System.out.println("Vous ne poss�dez pas la carte");
		}
		else if(!carte.getDisponibilite()) {
			System.out.println("La carte a d�j� �t� mise en vente ou propos� en �change");
		}
		else {
			carte.setDisponibilite(false);
			jeu.mettreEnVente(carte);
			this.carte_en_vente.add(id_carte);
			System.out.println("La carte a �t� mise en vente avec succ�s");
		}
	}
	
	// on ajoute la carte dans la liste des cartes a echanger du joueur et dans la liste des cartes a�echanger du jeu
	public void ajoutCarteEchange(Integer id_carte, rarete rarete_attendue, Integer joueur_attendu) {
		Carte carte = jeu.getCarte(id_carte);
		
		if(!this.liste_carte.contains(id_carte)) {
			System.out.println("Vous ne poss�dez pas la carte");
		}
		else if(!carte.getDisponibilite()) {
			System.out.println("La carte a d�j� �t� mise en vente ou propos� en �change");
		}
		else {
			carte.setDisponibilite(false);
			Echange echange = new Echange(id_utilisateur, id_carte, rarete_attendue, joueur_attendu);
			jeu.mettreEnEchange(echange);
			this.echange.add(echange.getIdEchange());
			System.out.println("La carte a �t� propos� en �change avec succ�s");
		}
	}
	
	// on supprime la carte de la liste des cartes en vente du joueur et de la liste des cartes en vente du jeu
	public void supprimeCarteEnVente(Integer id_carte) {
		Carte carte = jeu.getCarte(id_carte);
		
		if(!this.carte_en_vente.contains(id_carte)) {
			System.out.println("La carte n'est actuellement pas en vente");
		}
		else {
			carte.setDisponibilite(true);
			jeu.supprimerDeLaVente(id_carte);
			this.carte_en_vente.remove(id_carte);
			System.out.println("Suppression r�ussie");
		}
	}
	
	// on supprime la carte de la liste des cartes a echanger du joueur et de la liste des cartes a echanger du jeu
	public void supprimeCarteEchange(Integer id_echange) {
		Echange echange = jeu.getEchange(id_echange);
		
		if(!this.echange.contains(id_echange)) {
			System.out.println("La carte n'est actuellement pas propos� en �change");
		}
		else {
			echange.carte.setDisponibilite(true);
			jeu.supprimerDeEchange(id_carte);
			this.echange.remove(id_carte);
			System.out.println("Suppression r�ussie");
		}
	}
	
	public void calculScoreHebdo() {
		
		//a completer
		
	}

	
	
	
	
	
	
	
	
	

}
