package JDL;
import java.util.Hashtable;

public class JeuDeLaVie {
	int [][] tab;
	
	
	public JeuDeLaVie() {
		tab = new int[100][100];
		 for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	            tab[i][j] = 0;
	         }
	      }
		 tab[10][8]=1;
		 tab[9][2]=1;
		 tab[8][7]=1;
		 tab[12][4]=1;
	}
	
	public void affichTab() {
		for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	        	 System.out.print(tab[i][j] + " ");
	         }
	         System.out.println();
	      }
	}
}
