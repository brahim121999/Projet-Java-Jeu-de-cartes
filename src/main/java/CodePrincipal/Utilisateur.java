package CodePrincipal;

public abstract class Utilisateur {
	
	protected static Integer nb = 1; //id 0 reserve au systeme
	protected String pseudo;
	protected String mdp;
	protected Integer id_utilisateur;
	
	public Utilisateur(String pseudo, String mdp) {
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.id_utilisateur = nb;
		Utilisateur.nb += 1;
	}
}
