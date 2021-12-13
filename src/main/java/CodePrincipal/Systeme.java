package CodePrincipal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import EtatSysteme.*;

public class Systeme {
	Jeu jeu;
	EtatSysteme etat;
	Utilisateur utilisateur_courant;
	
	public Systeme(Jeu jeu) {
		this.jeu = jeu;
		this.etat = new Connexion();
	}
	
	public void action() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		boolean bool = true;
		while(bool) {
			etat.action(this);
		}
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public EtatSysteme getEtat() {
		return etat;
	}

	public void setEtat(EtatSysteme etat) {
		this.etat = etat;
	}

	public Utilisateur getUtilisateur_courant() {
		return utilisateur_courant;
	}

	public void setUtilisateur_courant(Utilisateur utilisateur_courant) {
		this.utilisateur_courant = utilisateur_courant;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
}
