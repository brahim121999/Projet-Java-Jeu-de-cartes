package CodePrincipal;
import enumeration.rarete;

public class Echange {
	private static int nb=0;
	private Jeu jeu;
	private Integer id_echange;
	private Integer proprietaire;
	private Integer carte_a_echange;
	private rarete rarete_attendue;
	private Integer joueur_attendu;
	
	public Echange(Jeu jeu, Integer proprietaire, Integer carte_a_echange, rarete rarete_attendue, Integer joueur_attendu) {
		this.jeu = jeu;
		this.id_echange=nb;
		Echange.nb+=1;
		this.proprietaire = proprietaire;
		this.carte_a_echange = carte_a_echange;
		this.rarete_attendue = rarete_attendue;
		this.joueur_attendu = joueur_attendu;
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public Integer getIdEchange() {
		return this.id_echange;
	}
	
	public Integer getProprietaire() {
		return this.proprietaire;
	}
	
	public Integer getCarteAEchange() {
		return this.carte_a_echange;
	}
	
	public rarete getRarete() {
		return this.rarete_attendue;
	}
	
	public Integer getJoueurAttendu() {
		return this.joueur_attendu;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public void afficher() {
		System.out.println("=== echange numero : " + id_echange + " ===");
		System.out.println("proprietaire : " + proprietaire);
		System.out.println("carte proposee : ");
		jeu.getCarte(this.carte_a_echange).afficher();
		System.out.println("id_joueur attendu : " + joueur_attendu);
		System.out.println("joueur attendu : " + jeu.getJoueur(joueur_attendu).getNom());
		System.out.println("rarete : " + rarete_attendue);
	}
}
