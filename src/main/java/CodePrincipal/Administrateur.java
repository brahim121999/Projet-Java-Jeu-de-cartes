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
	
	
	// pour ajouter une carte dans le jeu on doit vérifier si le nombre de cartes permises par joueur en fonction de sa
	// rareté n'est pas atteint
	public void ajouterCarte(Carte carte) {
		
		  
			Integer nbr=0;
			for (Carte c : this.jeu.getListe_carte()) {
				if (carte.getIdJoueur() == c.getIdJoueur()) {
					nbr++;
				}
			}
			
			if ((carte.getRarete() == rarete.commune) && (nbr<1000) ) {
				
				this.jeu.getListe_carte().add(carte);
			}
			else {
				
				System.out.println("Le nombre de cartes permises pour ce joueur avec cette rareté est atteint");
			}
			
			if ((carte.getRarete() == rarete.peu_commune) && (nbr<100) ) {
				
				this.jeu.getListe_carte().add(carte);
			}
			else {
				
				System.out.println("Le nombre de cartes permises pour ce joueur avec cette rareté est atteint");
			}
			
			if ((carte.getRarete() == rarete.rare) && (nbr<10) ) {
				
				this.jeu.getListe_carte().add(carte);
			}
			else {
				
				System.out.println("Le nombre de cartes permises pour ce joueur avec cette rareté est atteint");
			}
	}
	
	// pour ajouter un joueur dans le jeu on doit vérifier qu'il n'existe pas dans la liste des joueurs du jeu 
	public void ajouterJoueur(Joueur joueur) {
		
		Integer nbr=0;
		for (Joueur j : this.jeu.getListe_Joueur()) {
			
			if (j.getId_joueur() == joueur.getId_joueur()) {
				
				nbr++;
			}
		}
		
		if (nbr ==0) {
			this.jeu.getListe_Joueur().add(joueur);
		}
		else {
			System.out.println("Joueur déjà existant");
		}
		
	}
	
	// pour ajouter une équipe dans le jeu on doit vérifier qu'elle n'existe pas dans la liste des équipes du jeu 
		public void ajouterEquipe(Equipe equipe) {
			
			Integer nbr=0;
			for (Equipe e : this.jeu.getListe_equipe()) {
				
				if (e.getId_equipe() == equipe.getId_equipe()) {
					
					nbr++;
				}
			}
			
			if (nbr ==0) {
				this.jeu.getListe_equipe().add(equipe);
			}
			else {
				System.out.println("Equipe déjà existante");
			}
			
		}
	
	
	

}
