package CodePrincipal;

import java.util.*;

public class Player extends Utilisateur{
	
	private static Integer nb=0;
	private double balance;
	private ArrayList<Integer> liste_carte;
	private ArrayList<Integer> carte_semaine_suivante;
	public ArrayList<Integer> carte_en_vente;
	public ArrayList<Integer> carte_echange;
	public Integer score_player;
	public ArrayList<Integer> liste_score;
	private Jeu Jeu;
	
	
	public Player(String nom, String password,Jeu jeu) {
		
		this.pseudo=nom;
		this.mdp=password;
		this.id_utilisateur=nb;
		this.balance=10000;
		this.liste_carte= new ArrayList<Integer>();
		this.carte_semaine_suivante=new ArrayList<Integer>(4);
		this.carte_en_vente= new ArrayList<Integer>();
		this.carte_echange= new ArrayList<Integer>();
		this.score_player=0;
		this.liste_score= new ArrayList<Integer>();
		this.Jeu=jeu;
		jeu.getListe_utilisateur().add(this);
		Player.nb+=1;
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
		
		return this.carte_echange;
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
	
	public void augmenterBalance(double m) {
		this.balance += m;
	}
	
	public void diminuerBalance(Integer m) {
		this.balance += m;
	}
	
	public void calculScoreHebdo() {
		
		// ра completer
		// this.score_player=x ...
	}

	
	
	
	
	
	
	
	
	

}
