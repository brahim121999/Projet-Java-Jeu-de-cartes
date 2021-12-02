package CapaciteSpeciale;

import CodePrincipal.Carte;
import CodePrincipal.Classement;

public class Aucune extends Capacite_speciale {
	
	public Aucune(Carte carte) {
		super(carte);
		this.nom = "Aucune";
		this.description = "Cette capacité spéciale ne fait rien";
	}
	
	public double calculScore(Classement classement) {
		return carte.calculScore(classement);
	}
}
