package CodePrincipal;

public class Data {
	//represente la performance d'un joueur sur un match donne
	
	private String club;
	private String nom;
	private int but;
	private int passe_decisive;
	private int tacle;
	private double passe_reussie;	//en pourcentage
	private int duel_gagne;
	private int duel_aerien;
	private int duel_sol ;
	private int temps_de_jeu;		//en minute
	private String poste;
	private double note;
	
	public Data(String club, String nom,int but, int passe_decisive, int tacle, double passe_reussie, int duel_gagne, int duel_aerien, int duel_sol ,int temps_de_jeu, String poste, double note) {
		this.club = club;
		this.nom = nom;
		this.but = but;
		this.passe_decisive = passe_decisive;
		this.tacle = tacle;
		this.passe_reussie = passe_reussie;
		this.duel_gagne = duel_gagne;
		this.duel_aerien = duel_aerien;
		this.temps_de_jeu = temps_de_jeu;
		this.poste = poste;
		this.note = note;
		this.duel_sol = duel_sol;
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public int getBut() {
		return this.but;
	}
	
	public int getPasse_decisive() {
		return this.passe_decisive;
	}
	
	public int getTacle() {
		return this.tacle;
	}
	
	public double getPasse_reussie() {
		return this.passe_reussie;
	}
	
	public int getDuel_gagne() {
		return this.duel_gagne;
	}
	
	public int getDuel_aerien() {
		return this.duel_aerien;
	}
	
	public int getTemps_de_jeu() {
		return this.temps_de_jeu;
	}
	
	public String getPoste() {
		return this.poste;
	}
	
	public double getNote() {
		return this.note;
	}
	
	public int getDuel_sol() {
		return this.duel_sol;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public void afficher() {
		System.out.println("Nom du joueur : " + nom );
		System.out.println("Club : " + club );
		System.out.println("Nombre de buts marques : " + but);
		System.out.println("Nombre de passes decisives : " + passe_decisive);
		System.out.println("Nombre de tacles : " + tacle);
		System.out.println("Nombre de passes reussies : " + passe_reussie);
		System.out.println("Nombre de duels gagnes : " + duel_gagne);
		System.out.println("Nombre de duels aeriens : " + duel_aerien);
		System.out.println("Nombre de duels au sol : " + duel_sol);
		System.out.println("Nombre de tacles : " + tacle);
		System.out.println("Temps de jeu : " + temps_de_jeu);
		System.out.println("Poste : " + poste);
		System.out.println("Note : " + note);
		
	}
}
