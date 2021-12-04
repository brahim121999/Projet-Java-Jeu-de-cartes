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
			
			String PassD = info[3];
			int PassD2 = Integer.parseInt(PassD);
			
			String tacle = info[4]; 
			int tacle2 = Integer.parseInt(tacle);
			
			String PassR = info[5];
			String PassR2 = PassR.substring(7,8);
			double PassR3 = Double.parseDouble(PassR2)/100;
			
			String TotDuelG = info[6];
			String TotDuelG2 = TotDuelG.substring(0);
			int TotDuelG3 = Integer.parseInt(TotDuelG2);
			
			String DauS = info[7];
			String DauS2 = DauS.substring(0);
			int DauS3 = Integer.parseInt(DauS2);
			
			String DA = info[8];
			String DA2 = DA.substring(0);
			int DA3 = Integer.parseInt(DA2);
			
			String TempJ = info[9];
			String TempJ2 = TempJ.substring(0,1);
			int TempJ3 = Integer.parseInt(TempJ2);
			
			String Poste = info[10];
			
			String Note = info[11];
			double Note2 = Double.parseDouble(Note);
			
			Data Donnees = new Data(equipe,nom,But2,PassD2,tacle2,PassR3,TotDuelG3,DA3,DauS3,TempJ3,Poste,Note2);
			
			Map<Integer,Joueur> liste_joueur = new HashMap();
			liste_joueur= jeu.getListeJoueur();
			
			Integer id=0;
			
			for (Map.Entry mapentry : liste_joueur.entrySet()) {
				
				Joueur j  = (Joueur) mapentry.getValue();
				
				if (j.getNom() == nom) {
					
					id = (Integer) mapentry.getKey();
					
				}
			}
	
			this.dataset.put(id, Donnees);
		}
	}
}
