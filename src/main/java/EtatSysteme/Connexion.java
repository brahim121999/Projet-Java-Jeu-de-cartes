package EtatSysteme;

import java.util.Scanner;

import CodePrincipal.Administrateur;
import CodePrincipal.Jeu;
import CodePrincipal.Player;
import CodePrincipal.Systeme;

public class Connexion extends EtatSysteme {
	
	public void action(Systeme systeme) {
		Jeu jeu = systeme.getJeu();
		
		System.out.println("########## Menu ##########");
		System.out.println("Login : l");
		System.out.println("Register : r");
		System.out.println("##########################");
		
		@SuppressWarnings("resource")
		Scanner saisieUtilisateur = new Scanner(System.in).useDelimiter("|");
		String str = saisieUtilisateur.next();
		
		boolean bool = true;
		while(bool) {
			str = saisieUtilisateur.next();
		
			if(str.equals("l")) {
				System.out.println("Veuillez saisir votre identifiant");
				Integer id = saisieUtilisateur.nextInt();
				System.out.println("Veuillez saisir votre mot de passe");
				String mdp = saisieUtilisateur.next();
				
				Player player = jeu.getUtilisateur(id);
				Administrateur admin = jeu.getAdministrateur(id);
				
				if ((player != null) && (player.getMdp().equals(mdp))) {
					systeme.setUtilisateur_courant(player);
					systeme.setEtat(new ComptePlayer());
					bool = false;
				}
				
				else if ((admin != null) && (admin.getMdp().equals(mdp))) {
					systeme.setUtilisateur_courant(admin);
					systeme.setEtat(new CompteAdministrateur());
					bool = false;
				}
				
				else System.out.println("identifiant ou mot de passe incorrect");
				
			}
		
			else if (str.equals("r")) {
				System.out.println("Veuillez choisir votre pseudo");
				String pseudo = saisieUtilisateur.next();
				System.out.println("Veuillez choisir votre mot de passe");
				String mdp = saisieUtilisateur.next();
				
				Player player = new Player(pseudo, mdp, jeu);
				System.out.println("Enregistrement reussi ! Votre identifiant de connexion est " + player.getId());
				
				systeme.setUtilisateur_courant(player);
				systeme.setEtat(new ComptePlayer());
				bool = false;
			}
		}
	}
}
