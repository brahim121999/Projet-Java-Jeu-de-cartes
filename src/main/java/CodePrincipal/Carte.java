package CodePrincipal;
import java.util.*;

import enumeration.rarete;


public class Carte {
	
	private static Integer nb=0;
	private Integer id_carte;
	private Jeu jeu;
	private Integer id_joueur;
	private boolean disponibilite;
	private Integer id_capacite;
	private rarete Rarete;
	
	public Carte(Integer id_joueur,rarete Rarete, Integer id_capacite, Jeu jeu ) {
		
		this.id_carte=nb;
		Carte.nb+=1;
		this.disponibilite=true;
		this.id_joueur=id_joueur;
		this.Rarete=Rarete;
		this.id_capacite=id_capacite;
		this.jeu=jeu;
		jeu.getListe_carte().add(this);
		jeu.getListe_carte_systeme().add(this);
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	
	public Integer getIdCarte() {
		return this.id_carte;
	}
	
	public Integer getIdJoueur() {
		return this.id_joueur;
	}
	
	public boolean getDisponibilite() {
		return this.disponibilite;
	}
	
	public void setDisponibilite(boolean x) {
		this.disponibilite=x;
	}
	
	public rarete getRarete() {
		return this.Rarete;
	}
	
	public Integer getCapacite() {
		return this.id_capacite;
	}
	
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
}


