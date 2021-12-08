package CodePrincipal;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class Dataset {
	//represente toutes les donnees sur les joueurs pour une semaine
	
	private int semaine;
	private Map<Integer, Data> dataset; //couple id_joueur / Data
	private String RESOURCES_PATH ;
	private String FILE_NAME;
	private final static char SEPARATOR = '\t' ;
	private Jeu jeu;
	
	
	public Dataset(int semaine,String path,String file,Jeu jeu) throws IOException {
		this.semaine = semaine;
		this.RESOURCES_PATH = path;
		this.FILE_NAME = file;
		this.jeu = jeu;
		
		
	    final ArrayList<String[] > data = new ArrayList<String[] >();

	    try {
	            final File fichier = new File(this.RESOURCES_PATH + this.FILE_NAME);
	            final FileReader fr = new FileReader(fichier);

	            final CSVReader csvReader = new CSVReader(fr, this.SEPARATOR);

	            String[] nextLine = null;
	            while ((nextLine = csvReader.readNext()) != null) {
	                final int size = nextLine.length;

	                // ligne vide
	                if (size == 0) {
	                    continue;
	                }
	                final String debut = nextLine[0].trim();
	                if (debut.length() == 0 && size == 1) {
	                    continue;
	                }

	                // ligne de commentaire
	                if (debut.startsWith("#")) {
	                    continue;
	                }
	                data.add(nextLine);
	            }
	    } 
	    catch (FileNotFoundException e) {
	            e.printStackTrace();
	    } 
	    catch (IOException e) {
	            e.printStackTrace();
	    }

	        
		
		for (String[] info : data) {
			
			String equipe = info[0];
			
			String nom = info[1];
			
			String But = info[2];
			int But2 = Integer.parseInt(But);
			try {
				But2 = Integer.valueOf(But);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas marqué aucun but, 0 par defaut
				But2 = (int) 0;
			}
			
			String PassD = info[3];
			int PassD2;
			try {
				PassD2 = Integer.valueOf(PassD);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas fait aucune passe décisive, 0 par defaut
				PassD2 = (int) 0;
			}
			
			String tacle = info[4]; 
			int tacle2 = Integer.parseInt(tacle);
			try {
				tacle2 = Integer.valueOf(tacle);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas fait aucun tacle, 0 par defaut
				tacle2 = (int) 0;
			}
			
			String PassR = info[5];
			String PassR2 = PassR.substring(7,8);
			double PassR3;
			try {
				 PassR3 = Float.valueOf(PassR2)/100;
			} 
			catch (NumberFormatException e) {
				// si pas de passe réussie, 0 par defaut
				PassR3 = (float) 0.0;
			}
			
			String TotDuelG = info[6];
			String TotDuelG2 = TotDuelG.substring(0);
			int TotDuelG3;
			try {
				TotDuelG3 = Integer.valueOf(TotDuelG2);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas gagné aucun duel, 0 par defaut
				TotDuelG3 = (int) 0;
			}
			
			String DauS = info[7];
			String DauS2 = DauS.substring(0);
			int DauS3;
			try {
				  DauS3 = Integer.valueOf(DauS2);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas fait aucun duel au sol, 0 par defaut
				  DauS3 = (int) 0;
			}
			
			String DA = info[8];
			String DA2 = DA.substring(0);
			int DA3;
			try {
				  DA3 = Integer.valueOf(DA2);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas fait aucun duel aerrien, 0 par defaut
				  DA3 = (int) 0;
			}
			
			String TempJ = info[9];
			String TempJ2 = TempJ.substring(0,1);
			int TempJ3;
			try {
				  TempJ3 = Integer.valueOf(TempJ2);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas joué, 0 par defaut
				  TempJ3 = (int) 0;
			}
			
			String Poste = info[10];
			
			String Note = info[11];
			double note2;
			try {
				 note2 = Float.valueOf(Note);
			} 
			catch (NumberFormatException e) {
				// si pas de note 0 par defaut
				note2 = (float) 0.0;
			}
			
			
			
			Data Donnees = new Data(equipe,nom,But2,PassD2,tacle2,PassR3,TotDuelG3,DA3,DauS3,TempJ3,Poste,note2);
			
			
			
			Integer id=0;
			
			Map<Integer,Equipe> liste_equipe = new HashMap();
			liste_equipe= jeu.getListeEquipe();
			
			// on cherche l'id du joueur dans l'attribut liste_joeur de liste_equipe du système, pour éviter le cas où 2 joueurs dans le jeu ont le même nom , par contre c'est casi impossible au sein d'une même équipe
			
			for (Map.Entry mapentry : liste_equipe.entrySet()) {
				
				Equipe e  = (Equipe) mapentry.getValue();
				
				if (e.getNom() == equipe) {
					
					
						
					for (int j : e.getListe_joueur()){
						
						Joueur joueur = this.jeu.getListeJoueur().get(j);
						
						if (joueur.getNom() == nom) {
							
							id = joueur.getId_joueur();
							break;
						}
					};
				};
				
				
			}
			
			this.dataset.put(id, Donnees);
		}
	
		
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	
	public int getSemaine() {
		return this.semaine;
	}
	
	public String getFIleName() {
		return this.FILE_NAME;
	}
	
	public String getPath() {
		return this.RESOURCES_PATH;
	}
	
}
