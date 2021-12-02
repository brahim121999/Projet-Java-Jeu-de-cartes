package CapaciteSpeciale;

import CodePrincipal.Carte;
import CodePrincipal.CarteInterface;
import CodePrincipal.Classement;
import CodePrincipal.Jeu;
import enumeration.rarete;

public abstract class Capacite_speciale extends CarteInterface{
	protected Carte carte;
	protected String nom;
	protected String description;
	
	public Capacite_speciale(Carte carte) {
		this.carte = carte;
	}
	
	public void ajouterCarte() {
		carte.ajouterCarte();	
	}
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public Jeu getJeu() {
		return carte.getJeu();
	}
	
	public Integer getIdCarte() {
		return carte.getIdCarte();
	}
	
	public Integer getIdJoueur() {
		return carte.getIdCarte();
	}
	
	public boolean getDisponibilite() {
		return carte.getDisponibilite();
	}
	
	public void setDisponibilite(boolean x) {
		carte.setDisponibilite(x);
	}
	
	public rarete getRarete() {
		return carte.getRarete();
	}
	
	public Integer getCapacite() {
		return carte.getCapacite();
	}
	
	public Integer getIdUtilisateur() {
		return carte.getIdUtilisateur();
	}
	
	public void setIdUtilisateur(Integer id_utilisateur) {
		carte.setIdUtilisateur(id_utilisateur);
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public abstract double calculScore(Classement classement);
}
