package CodePrincipal;

import enumeration.rarete;

public abstract class CarteInterface {
	
	public abstract double calculScore(Classement classement);
	
	public abstract void ajouterCarte();
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public abstract Jeu getJeu();
	
	public abstract Integer getIdCarte();
	
	public abstract Integer getIdJoueur();
	
	public abstract boolean getDisponibilite();
	
	public abstract void setDisponibilite(boolean x);
	
	public abstract rarete getRarete();
	
	public abstract Integer getIdUtilisateur();
	
	public abstract void setIdUtilisateur(Integer id_utilisateur);
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
}
