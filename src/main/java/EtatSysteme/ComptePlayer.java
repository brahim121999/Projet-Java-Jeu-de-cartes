package EtatSysteme;

import CodePrincipal.Jeu;
import CodePrincipal.Systeme;

public class ComptePlayer extends EtatSysteme{

	@Override
	public void action(Systeme systeme) {
		Jeu jeu = systeme.getJeu();
		
		System.out.println("########## Menu ##########");
		System.out.println("Afficher mes infos : a");
		System.out.println("Afficher le classement des joueurs : c");
		System.out.println("Afficher les cartes en vente : v");
		System.out.println("Afficher les echanges proposés : e");
		System.out.println("Mettre une carte en vente : mv");
		System.out.println("proposer un echange : pe");
		System.out.println("##########################");
		
	}

}
