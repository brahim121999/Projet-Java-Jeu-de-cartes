package CodePrincipal;

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
	
	private static int nb = 0;
	private Integer id_dataset;
	private Integer semaine;
	private Map<Integer, Data> dataset; //couple id_joueur / Data
	private String RESOURCES_PATH ;
	private String FILE_NAME;
	private final static char SEPARATOR = '\t' ;
	private Jeu jeu;
	
	
	@SuppressWarnings({ "rawtypes", "static-access", "resource" })
	public Dataset(Integer semaine,String path,String file,Jeu jeu) throws IOException {
		this.id_dataset = nb;
		Dataset.nb += 1;
		this.semaine = semaine;
		this.RESOURCES_PATH = "../../../../Data";
		this.FILE_NAME = file;
		this.jeu = jeu;
		this.dataset = new HashMap<Integer, Data>();
		
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
			
			int But2;
			try {
				But2 = Integer.valueOf(But);
			} 
			catch (NumberFormatException e) {
				// si le joueur n'a pas marque aucun but, 0 par defaut
				But2 = 0;
			}
			
			String PassD = info[3];
			int PassD2;
			try {
				PassD2 = Integer.valueOf(PassD);
			} 
			catch (NumberFormatException e) {
				// si le joueur n'a pas fait aucune passe decisive, 0 par defaut
				PassD2 = 0;
			}
			
			String tacle = info[4]; 
			int tacle2;
			try {
				tacle2 = Integer.valueOf(tacle);
			} 
			catch (NumberFormatException e) {
				// si le joueur n'a pas fait aucun tacle, 0 par defaut
				tacle2 = 0;
			}
			
			float PassR5;
			try {
				String PassR = info[5];
				String PassR2[] = PassR.split(" ");
				String PassR3[] = PassR2[1].split("%");
				String PassR4 = PassR3[0].substring(1);

				try {
					 PassR5 = Float.valueOf(PassR4)/100;
				} 
				catch (NumberFormatException e) {
					// si pas de passe reussie, 0 par defaut
					PassR5 = 0;
				}
			}
			catch (ArrayIndexOutOfBoundsException e) {
				PassR5 =  0;
			}
			
			String TotDuelG = info[6];
			String TotDuelG2[] = TotDuelG.split(" ");
			String TotDuelG3 = TotDuelG2[0];
			int TotDuelG4;
			try {
				TotDuelG4 = Integer.valueOf(TotDuelG3);
			} 
			catch (NumberFormatException e) {
				// si le joueur n'a pas gagne aucun duel, 0 par defaut
				TotDuelG4 = (int) 0;
			}

			String DauS = info[7];
			String DauS2[] = DauS.split(" ");
			String DauS3 = DauS2[0];
			int DauS4;
			try {
				  DauS4 = Integer.valueOf(DauS3);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas fait aucun duel au sol, 0 par defaut
				  DauS4 = (int) 0;
			}
			
			String DA = info[8];
			String DA2[] = DA.split(" ");
			String DA3 = DA2[0];
			int DA4;
			try {
				  DA4 = Integer.valueOf(DA3);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas fait aucun duel aerrien, 0 par defaut
				  DA4 = (int) 0;
			}
			
			String TempJ = info[9];
			String TempJ2[] = TempJ.split("'");
			String TempJ3 = TempJ2[0];
			int TempJ4;
			try {
				  TempJ4 = Integer.valueOf(TempJ3);
			} 
			catch (NumberFormatException e) {
				  // si le joueur n'a pas joue, 0 par defaut
				  TempJ4 = (int) 0;
			}

			String Poste = info[10];
			String Note = info[11];
			
			float note2;
			try {
				 note2 = Float.valueOf(Note);
			} 
			catch (NumberFormatException e) {
				// si pas de note 0 par defaut
				note2 = 0;
			}
			
			Data Donnees = new Data(equipe,nom,But2,PassD2,tacle2,PassR5,TotDuelG4,DA4,DauS4,TempJ4,Poste,note2);
			Integer id = 0;
			
			Map<Integer,Equipe> liste_equipe = jeu.getListeEquipe();
			
			// on cherche l'id du joueur dans l'attribut liste_joueur de liste_equipe du systeme, pour eviter le cas ou 2 joueurs dans le jeu ont le meme nom, par contre c'est casi impossible au sein d'une meme equipe
			
			for (Map.Entry mapentry : liste_equipe.entrySet()) {
				
				Equipe e  = (Equipe) mapentry.getValue();
				
				if (e.getNom().equals(equipe)) {	
					for (Integer j : e.getListe_joueur()){
						
						Joueur joueur = this.jeu.getListeJoueur().get(j);
						if (joueur.getNom().equals(nom)) {
							
							id = joueur.getId_joueur();
							break;
						}
					}
				}
			}
			this.dataset.put(id, Donnees);
		}
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	
	public int getId_dataset() {
		return this.id_dataset;
	}
	
	public int getSemaine() {
		return this.semaine;
	}
	
	public String getFIleName() {
		return this.FILE_NAME;
	}
	
	public String getPath() {
		return this.RESOURCES_PATH;
	}
	
	public Map<Integer, Data> getDataset() {
		return this.dataset;
	}
	
	@SuppressWarnings("rawtypes")
	public void afficher() {
		for(Map.Entry mapentry : dataset.entrySet()) {
			System.out.println("=== Joueur n° " + mapentry.getKey() + " ===");
			Data d = (Data) mapentry.getValue();
			d.afficher();
		}
	}
}
