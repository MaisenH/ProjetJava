import java.util.Hashtable;
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
	        		 tab[i][j] = 0;
	      }
		}
		//tab[10][8]=1;
		//tab[9][2]=1;
		 //tab[8][7]=1;
		 //tab[12][4]=1;
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
}

