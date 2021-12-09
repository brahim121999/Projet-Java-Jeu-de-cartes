package CodePrincipal;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	private Jeu jeu;
	private static int nb = 0;
	private Integer id_equipe;
	private String nom;
	private List<Integer> liste_joueur;
	
	public Equipe(Jeu jeu, String nom) {
		this.jeu = jeu;
		this.nom = nom;
		this.liste_joueur = new ArrayList<Integer>();
		this.id_equipe = nb;
		Equipe.nb += 1;
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public int getNb() {
		return nb;
	}
	
	public int getId_equipe() {
		return this.id_equipe;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public List<Integer> getListe_joueur() {
		return this.liste_joueur;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public void addPlayer(int id_joueur) {
		liste_joueur.add(id_joueur);
	}
	
	public void afficher() {
		System.out.println("=== equipe n° : " + id_equipe + " ===");
		System.out.println("nom : " + nom);
		System.out.println("liste_joueur : ");
		for(Integer j : liste_joueur) {
			System.out.println(jeu.getJoueur(j).getNom());
		}
	}
}
