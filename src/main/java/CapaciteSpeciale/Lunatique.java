package CapaciteSpeciale;

import java.util.List;

import CodePrincipal.Data;
import CodePrincipal.Jeu;

public class Lunatique extends Capacite_speciale{
	
	public Lunatique(Jeu jeu) {
		this.nom = "Lunatique";
		this.description = "Donne un bonus de 2% les semaines paires et de -2% les semaines impaires";
		this.jeu = jeu;
	}
	
	@Override
	public double calculCapaciteSpeciale(double score, List<Data> data) {
		if(jeu.getSemaine() % 2 == 0) {
			return score * 1.02;
		}
		else {
			return score * 0.98;
		}
	}
}
