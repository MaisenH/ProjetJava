package JDL;
import java.lang.Thread;
import java.util.Random;

public class JeuDeLaVie {
	int [][] tab;
	int nb_tours;
	int delai;
	
	//Le constructeur
	public JeuDeLaVie() {
		tab = new int[100][100];
		 for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	        	 int min_val = 10;
	             int max_val = 100;
	             Random ran = new Random();
	             int x = ran.nextInt(max_val) + min_val;
	             	if(x%2==0) {
	             		tab[i][j] = 1;
	             	}
	             	else {
	             		tab[i][j] = 0;
	             	}
	         }
		 }
	}
	
	//Affiche le tableau
	public void affichTab() {
		for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	        	 System.out.print(tab[i][j] + " ");
	         }
	         System.out.println();
	      }
	}
	
	public void affichTab2(String a, String b) {
		String[][] tabb = new String[100][100];
		 for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	        	 if(tab[i][j]==1) {
	        		 tabb[i][j]=a;
	        		 System.out.print(tabb[i][j] + " ");
	        	 }else {
	        		 tabb[i][j]=b;
	        		 System.out.print(tabb[i][j] + " ");
	        	 }
	         }
	         System.out.println();
		 }
		
	}
	//Retourne la valeur
	public int valeur_case(int i, int j) {
		return tab[i][j];
	}
	
	public int total_voisins(int i,int j) {
		int somme=0;
		
		//Pour tous les cas de i
		if(i==0){
			if(j==0) {//En haut à gauche
				somme=tab[i][j+1]+tab[i+1][j+1]+tab[i+1][j];
			}
			else if(j==tab.length-1) {//En haut à droite
				somme=tab[i][j-1]+tab[i+1][j-1]+tab[i+1][j];
			}
			else {//Le long de la première ligne
				somme=tab[i][j+1]+tab[i+1][j+1]+tab[i+1][j]+tab[i][j-1]+tab[i+1][j-1];
			}
		}
		else if(i==tab.length-1) {
			if(j==0) {//En bas à gauche
				somme=tab[i-1][j]+tab[i][j+1]+tab[i-1][j+1];
			}
			else if(j==tab.length-1) {//En bas à droite
				somme=tab[i-1][j-1]+tab[i-1][j]+tab[i][j-1];
			}
			else {//Le long de la dernière ligne
				somme=tab[i][j-1]+tab[i-1][j-1]+tab[i-1][j]+tab[i-1][j+1]+tab[i][j+1];
			}
		}
		//Pour chaque cas de j
		else if(j==0 && i!=0 && i!=tab.length-1) {//Le long de la première colonne
			somme=tab[i-1][j]+tab[i-1][j+1]+tab[i][j+1]+tab[i+1][j+1]+tab[i+1][j];
		}
		else if(j==tab.length-1 && i!=0 && i!=tab.length-1) {//Le long de la dernière colonne
			somme=tab[i-1][j-1]+tab[i-1][j]+tab[i+1][j]+tab[i+1][j-1]+tab[i][j-1];
		}
		else {//Le corps de la matrice
			somme=tab[i-1][j-1]+tab[i-1][j]+tab[i-1][j+1]+tab[i][j+1]+tab[i+1][j+1]+tab[i+1][j]+tab[i+1][j-1]+tab[i][j-1];
		}
		return somme;
	}
	public int resultat(int i, int j) {
		if( total_voisins(i,j)>=3) {
			return 1;
		}else {
			return 0;
		}
	}
	public void tour() {
		for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	        		 tab[i][j] = resultat(i,j);
	      }
		}
	}
	public void run(int nb_tours,int delai){
		for(int i=0;i<nb_tours;i++) {
			int [][] tabi=tab;
				tour();
				try {
					Thread.sleep(delai);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				affichTab();
				//Arrêt lorsqu'aucun changement n'est détecté.
				if(tabi==tab) {
					break;
				}
			}
	}
}

