package CapaciteSpeciale;

import CodePrincipal.Carte;
import CodePrincipal.Classement;

public class Lunatique extends Capacite_speciale{
	
	public Lunatique(Carte carte) {
		super(carte);
		this.nom = "Lunatique";
		this.description = "Donne un bonus de 2% les semaines paires et de -2% les semaines impaires";
	}
	
	@Override
	public double calculScore(Classement classement) {
		if(carte.getJeu().getSemaine() % 2 == 0) {
			return carte.calculScore(classement) * 1.02;
		}
		else {
			return carte.calculScore(classement) * 0.98;
		}
	}
}
