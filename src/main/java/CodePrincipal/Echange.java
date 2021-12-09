package CodePrincipal;
import enumeration.rarete;

public class Echange {
	private static Integer nb=0;
	Integer id_echange;
	Integer proprietaire;
	Integer carte_a_echange;
	rarete rarete_attendue;
	Integer joueur_attendu;
	
	public Echange(Integer proprietaire, Integer carte_a_echange, rarete rarete_attendue, Integer joueur_attendu) {
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
}
