package CapaciteSpeciale;

import CodePrincipal.Carte;
import CodePrincipal.Classement;
import enumeration.rarete;

public class Lunatique extends Capacite_speciale{
	
	public Lunatique(Carte carte) {
		super(carte);
		this.nom = "Lunatique";
		this.description = "Donne un bonus de 2-4-6% les semaines paires et un malus les semaines impaires selon la rareté de la carte";
	}
	
	@Override
	public double calculScore(Classement classement) {
		rarete rarete = carte.getRarete();
		if(carte.getJeu().getSemaine()%2 == 0) {
			switch(rarete) {
			case commune: return carte.calculScore(classement) * 1.02;
			case peu_commune: return carte.calculScore(classement) * 1.04;
			case rare: return carte.calculScore(classement) * 1.06;
			}
		}
		else {
			switch(rarete) {
			case commune: return carte.calculScore(classement) * 0.98;
			case peu_commune: return carte.calculScore(classement) * 0.96;
			case rare: return carte.calculScore(classement) * 0.94;
			}
		}
		return 0; // on ne rentre jamais dans ce cas là
	}
}

