package CapaciteSpeciale;

import java.util.List;

import CodePrincipal.Data;
import CodePrincipal.Jeu;

public class Aucune extends Capacite_speciale {
	
	public Aucune(Jeu jeu) {
		this.nom = "Aucune";
		this.description = "Cette capacité spéciale ne fait rien";
		this.jeu = jeu;
	}
	
	@Override
	public double calculCapaciteSpeciale(double score, List<Data> data) {
		return score;
	}

}
