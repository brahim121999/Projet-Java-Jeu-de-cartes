package CodePrincipal;
import java.util.*;

import enumeration.rarete;

public class Administrateur extends Utilisateur {
	
	private Jeu jeu;
	private static Integer nb=0;
	
	
	public Administrateur(String nom, String password,Jeu jeu) {
		
		this.pseudo=nom;
		this.mdp=password;
		this.id_utilisateur=nb;
		Administrateur.nb+=1;
		this.jeu=jeu;
		
		
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
	
	public void ajouterCarte(Integer id_joueur) {
		// ajouter des cartes d'un joueur dans le système
		// à completer
		
	}
	
	public void ajouterJoueur() {
		
	}
	
	
	

}
