package CapaciteSpeciale;

import java.util.List;

import CodePrincipal.Data;
import CodePrincipal.Jeu;

public abstract class Capacite_speciale {
	protected Jeu jeu;
	protected String nom;
	protected String description;
	
	public abstract double calculCapaciteSpeciale(double score, List<Data> data);
}
