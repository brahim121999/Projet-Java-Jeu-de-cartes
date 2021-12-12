package CodePrincipal;

public class Data {
	//represente la performance d'un joueur sur un match donne
	
	private float but;
	private float passe_decisive;
	private float tacle;
	private float passe_reussie;	//en pourcentage
	private float duel_gagne;
	private float duel_aerien;
	private float duel_sol ;
	private float temps_de_jeu;		//en minute
	private float note;
	
	public Data(float but, float passe_decisive, float tacle, float passe_reussie, float duel_gagne, float duel_aerien, float duel_sol ,float temps_de_jeu, float note) {
		this.but = but;
		this.passe_decisive = passe_decisive;
		this.tacle = tacle;
		this.passe_reussie = passe_reussie;
		this.duel_gagne = duel_gagne;
		this.duel_aerien = duel_aerien;
		this.duel_sol = duel_sol;
		this.temps_de_jeu = temps_de_jeu;
		this.note = note;
	}
	
	public Data() {
		//pour les joueurs n'ayant joué aucun match de la semaine
		this.but = 0;
		this.passe_decisive = 0;
		this.tacle = 0;
		this.passe_reussie = 0;
		this.duel_gagne = 0;
		this.duel_aerien = 0;
		this.duel_sol = 0;
		this.temps_de_jeu = 0;
		this.note = 0;
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public float getBut() {
		return this.but;
	}
	
	public float getPasse_decisive() {
		return this.passe_decisive;
	}
	
	public float getTacle() {
		return this.tacle;
	}
	
	public float getPasse_reussie() {
		return this.passe_reussie;
	}
	
	public float getDuel_gagne() {
		return this.duel_gagne;
	}
	
	public float getDuel_aerien() {
		return this.duel_aerien;
	}
	
	public float getTemps_de_jeu() {
		return this.temps_de_jeu;
	}
	
	public float getNote() {
		return this.note;
	}
	
	public float getDuel_sol() {
		return this.duel_sol;
	}
	
	public float getNb_data() {
		return this.duel_sol;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public void afficher() {
		System.out.println("Nombre de buts marques : " + but);
		System.out.println("Nombre de passes decisives : " + passe_decisive);
		System.out.println("Nombre de tacles : " + tacle);
		System.out.println("Nombre de passes reussies : " + passe_reussie);
		System.out.println("Nombre de duels gagnes : " + duel_gagne);
		System.out.println("Nombre de duels aeriens : " + duel_aerien);
		System.out.println("Nombre de duels au sol : " + duel_sol);
		System.out.println("Nombre de tacles : " + tacle);
		System.out.println("Temps de jeu : " + temps_de_jeu);
		System.out.println("Note : " + note);
	}
	
	public void addData(Data data) {
		this.but += data.getBut();
		this.passe_decisive += data.getPasse_decisive();
		this.tacle += data.getTacle();
		this.passe_reussie += data.getPasse_reussie();
		this.duel_gagne += data.getDuel_gagne();
		this.duel_aerien += data.getDuel_gagne();
		this.duel_sol += data.getDuel_sol();
		this.temps_de_jeu += data.getTemps_de_jeu();
		this.note += data.getNote();
	}
	
	public void meanData(int nb) {
		this.but /= nb;
		this.passe_decisive /= nb;
		this.tacle /= nb;
		this.passe_reussie /= nb;
		this.duel_gagne /= nb;
		this.duel_aerien /= nb;
		this.duel_sol /= nb;
		this.temps_de_jeu /= nb;
		this.note /= nb;
	}
}
