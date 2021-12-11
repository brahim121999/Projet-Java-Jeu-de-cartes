package CapaciteSpeciale;

import CodePrincipal.Carte;
import enumeration.rarete;

public class Force extends Capacite_speciale{

	public Force(Carte carte) {
		super(carte);
		this.nom = "Force";
		this.description = "Donne un bonus fixe de +5/10/20 selon la rareté de la carte";
	}
	
	public Force() {
		this.nom = "Force";
		this.description = "Donne un bonus fixe de +5/10/20 selon la rareté de la carte";
	}
	
	@Override
	public float calculScore() {
		rarete rarete = carte.getRarete();
		switch(rarete) {
			case commune: return carte.calculScore() + 5;
			case peu_commune: return carte.calculScore() + 10;
			case rare: return carte.calculScore() + 20;
		}
		return 0; // on ne rentre jamais dans ce cas là
	}
}
