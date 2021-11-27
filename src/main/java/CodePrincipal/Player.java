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
	
	
	
	
	public void setBalance(Integer m) {
		this.balance+=m;
	}
	
	public double getBalance() {
		
		return this.balance;
	}
	
	public ArrayList<Integer> getListeCarte(){
		
		return this.liste_carte;
	}
	
	public void setListeCarte(Integer x) {
		
		this.liste_carte.add(x);
	}
	
	public ArrayList<Integer> getCarteSemaineSuivante() {
		
		return this.carte_semaine_suivante;
	}
	
	public void setCarteSemaineSuivante(ArrayList<Integer> suivante ) {
		
		for (int i=0;i<suivante.size() ;i++) {
			this.carte_semaine_suivante.add(suivante.get(i));
		}
		
	}
	
	public ArrayList<Integer> getCarteEnVente() {
		
		return this.carte_en_vente;
	}
	
	public void setCarteEnVente(ArrayList<Integer> vente) {
		
		for (int i=0;i<vente.size() ;i++) {
			this.carte_en_vente.add(vente.get(i));
		}
		
	}
	

	public ArrayList<Integer> getCarteEchange() {
		
		return this.carte_echange;
	}
	
	public void setCarteEchange(ArrayList<Integer> echange) {
		
		for (int i=0;i<echange.size() ;i++) {
			this.carte_echange.add(echange.get(i));
		}
		
	}
	
	public void calculScoreHebdo() {
		
		// à completer
		// this.score_player=x ...
	}
	
	public Integer getScore() {
		
		return this.score_player;
	}
	
	public ArrayList<Integer> getListeScore(){
		
		return this.liste_score;
	}
	
	public void setListeScore(Integer score) {
		
		this.liste_score.add(score);
	}
	

	
	
	
	
	
	
	
	
	

}
