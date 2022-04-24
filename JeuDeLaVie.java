package Projet1;
import java.lang.Thread;
import java.lang.reflect.Array;
import java.util.Random;

public class JeuDeLaVie {
	String [][] tab; // Le tableau qui representera nos cellules
	int nb_tours; // nombre de tour correspond au nombre de fois ou le programme va tourner
	int delai; // optionelle, on indique le delai entre chaque tour
	String vivant; // Ce sera le caractère qui va representer les cellules vivantes
	String mort; // pareil mais pour les cellules mortes
	
	//Les constructeurs (on en a deux differents)
	public JeuDeLaVie() { 
	/*initialise un tableau de dimension 100*100 aléatoirement en 
	representant les cellules mortes par 0 et les cellules vivantes par 1*/
		vivant="1";
		mort="0";
		tab = new String[100][100];
		for (int i = 0;i < tab.length; i++) {
	        	for (int j = 0;j < tab.length;j++) {
	        		int min_val = 10;
	            		int max_val = 100;
	            		Random ran = new Random();
	            		int x = ran.nextInt(max_val) + min_val;
	            		if(x%2==0) {
	             			tab[i][j] = vivant;
	            		}
	            		else {
	             			tab[i][j] = mort;
	            		}
	        	}
		}
	}
	
	public JeuDeLaVie(String viv,String mor, int k) {
	/*initialise un tableau de dimension 100*100 aléatoirement en 
	représentant les cellules vivantes et mortes par un caractère que l'utilsateur peut choisir
	Il y a 10 etats initiaux possibles que l'utilisateur peut choisir avec la valeur k*/
		vivant=viv;
		mort=mor;
		tab = new String[100][100];
		if(k==1) {
			for (int i = 0;i < tab.length; i++) {
		        	for (int j = 0;j < tab[i].length;j++) {
		        		int min_val = 10;
		            		int max_val = 100;
		            		Random ran = new Random();
		            		int x = ran.nextInt(max_val) + min_val; //x est un nombre aléatoire compris entre 10 et 100
		            		if(x%2==0) {
		             			tab[i][j] = vivant;
		            		}
		           		else {
		             			tab[i][j] = mort;
		            		}
		        	}
			}
		}
		if(k==2) {
			for (int i = 0;i < tab.length; i++) {
		        	for (int j = 0;j < tab[i].length;j++) {
		        	 	if(j>i) {
		             			tab[i][j] = vivant;
		        	 	}
					else {
		        	 		tab[i][j] = mort;
		        	 	}
		       		}
			}
		}
		if(k==3) {
			for (int i = 0;i < tab.length; i++) {
		        	for (int j = 0;j < tab[i].length;j++) {
		        		tab[i][j]=mort;
		        	}
		        }
			tab[49][49]=vivant;
			tab[49][50]=vivant;
			tab[50][49]=vivant;
			tab[51][49]=vivant;
		}
		if(k==4) {
			for (int i = 0;i < tab.length; i++) {
		        	for (int j = 0;j < tab[i].length;j++) {
		        		int h=i+j;
		        		if(h%2==0) {
		        	 		tab[i][j]=vivant;
		        		}
		        	 	else {
		        			tab[i][j]=mort;
		        		}
		        	}
			}
		}
		if(k==5) {
			for (int i = 0;i < tab.length; i++) {
		        	for (int j = 0;j < tab[i].length;j++) {
		        		int h=i+j;
		        	 	if(i<20 || i>80) {
			        		if(h%2==0) {
			        	 		tab[i][j]=vivant;
			        	    	}
			        		else {
			        			tab[i][j]=mort;
			        		}
		        	 	}
					else {
		        	 		tab[i][j]=mort;
		        	 	}
		         	}
			}
		}
		if(k==7) {
           		for (int i = 0;i < tab.length; i++) {
                		for (int j = 0;j < tab[i].length;j++) {
					int h=i+j;
				    	if(j<20 || j>80) {
						if(h%2==0) {
                            				tab[i][j]=vivant;
                        			}
                       				else {
                            				tab[i][j]=mort;
                        			}
                    			}
					else {
                        			tab[i][j]=vivant;
                    			}
                		}
            		}
        	}

		if(k==6) {
			for (int i = 0;i < tab.length; i++) {
				for (int j = 0;j < tab[i].length;j++) {
			    		int h=i+j;
			    		if(i<20 || i>80) {
						if(h%2==0) {
				    			tab[i][j]=mort;
						}
						else {
				    			tab[i][j]=vivant;
						}
			   		}
					else {
						tab[i][j]=vivant;
			    		}
				}
		    	}
		}
		if(k==8) {
			for (int i = 0;i < tab.length; i++) {
				for (int j = 0;j < tab[i].length;j++) {
			    		int p=i*j;
			    		if(i<10 || i>90)
						if(p%2==0) {
				    			tab[i][j]=vivant;
						}
						else {
				    			tab[i][j]=mort;
						}
			    		else {
						tab[i][j]=vivant;
			    		}
				}
		    	}
		}

		if(k==9){
			for(int i = 0; i< tab.length; i++){
				for(int j = 0; j<tab[i].length; j++){
			    		int h = i+j;
			    		if(i<30 || i>98){
				    		if(h%2==0){
							tab[i][j]=vivant;
				    		}
				    		else{
							tab[i][j]=mort;
				    		}
			    		}
					else {
						tab[i][j]=mort;
			    		}
				}
		    	}
		}
	}


	
	public void affichTab() {
	/*Permet d'fficher le tableau tab*/
		for (int i = 0;i < tab.length; i++) { // On parcourt le tableau ligne et colonne
	        	for (int j = 0;j < tab[i].length;j++) {
	        		System.out.print(tab[i][j] + " "); //On met un espace pour que l'affichage soit correct
	        	}
	        System.out.println();
	    	}
	}
		
	
	public int valeur_case(int i, int j) {
	/*Retourne la valeur (l'état de la cellule) de la case d'indice i,j*/
		if(tab[i][j]==vivant) {
			return 1;
		}
		return 0;
	}
	
	public int total_voisins(int i,int j) {
	/*Calcule pour une cellule d'indice i et j, la somme totale des valeurs des cellules voisines 
	Cette méthode sera utile pour savoir si la cellule reste vivante ou meurt*/
		int somme=0;
		//Pour tous les cas de i (ligne)
		if(i==0){
			if(j==0) {//En haut à gauche
				somme=valeur_case(i,j+1)+valeur_case(i+1,j+1)+valeur_case(i+1,j);
			}
			else if(j==tab.length-1) {//En haut à droite
				somme=valeur_case(i,j-1)+valeur_case(i+1,j-1)+valeur_case(i+1,j);
			}
			else {//Le long de la première ligne
				somme=valeur_case(i,j+1)+valeur_case(i+1,j+1)+valeur_case(i+1,j)+valeur_case(i,j-1)+valeur_case(i+1,j-1);
			}
		}
		else if(i==tab.length-1) {
			if(j==0) {//En bas à gauche
				somme=valeur_case(i-1,j)+valeur_case(i,j+1)+valeur_case(i-1,j+1);
			}
			else if(j==tab.length-1) {//En bas à droite
				somme=valeur_case(i-1,j-1)+valeur_case(i-1,j)+valeur_case(i,j-1);
			}
			else {//Le long de la dernière ligne
				somme=valeur_case(i,j-1)+valeur_case(i-1,j-1)+valeur_case(i-1,j)+valeur_case(i-1,j+1)+valeur_case(i,j+1);
			}
		}
		//Pour chaque cas de j (colonne)
		else if(j==0 && i!=0 && i!=tab.length-1) {//Le long de la première colonne
			somme=valeur_case(i-1,j)+valeur_case(i-1,j+1)+valeur_case(i,j+1)+valeur_case(i+1,j+1)+valeur_case(i+1,j);
		}
		else if(j==tab.length-1 && i!=0 && i!=tab.length-1) {//Le long de la dernière colonne
			somme=valeur_case(i-1,j-1)+valeur_case(i-1,j)+valeur_case(i+1,j)+valeur_case(i+1,j-1)+valeur_case(i,j-1);
		}
		else {//Le corps de la matrice
			somme=valeur_case(i-1,j-1)+valeur_case(i-1,j)+valeur_case(i-1,j+1)+valeur_case(i,j+1)+valeur_case(i+1,j+1)+valeur_case(i+1,j)+valeur_case(i+1,j-1)+valeur_case(i,j-1);
		}
		return somme;
	}
	
	
	public String resultat(int i, int j) {
	/* Méthode qui renvoie le nouvel état de la cellule d'indice i,j.
	Si une cellule vivante a plus de 3 cellules vivantes autour d'elles, elle reste vivante (return 1 sinon return 0)
	Si une cellule morte est entouré par plus de 3 cellules vivantes elle devient vivante*/
		if( total_voisins(i,j)>=3) {  
			return vivant;
		}
		return mort; // dans le cas ou on a pas plus de 3 voisins vivants
	}
	
	public String[][] tour() {
	/*Méthode qui permet d'effectuer un tour pour tous les éléments du tableau (on applique
	la méthode résultat a chaque cellule). Renvoie le nouveau tableau avec le nouvel etat des cellules */
		String[][] tabb=new String[100][100]; // on crée un nouveau tableau qui remplacera l'ancien
		for (int i = 0;i < tab.length; i++) {
	        	for (int j = 0;j < tab[i].length;j++) {
	        		 tabb[i][j] = resultat(i,j);
	      		}
		}
		return tabb;
	}
	
	
	public int getNbVivants() {
	/*Renvoie le nombre total de cellule vivante dans le tableau*/
		int count=0;
		for (int i = 0;i < tab.length; i++) {
	        	for (int j = 0;j < tab[i].length;j++) {
	        		if(valeur_case(i,j)==1) {
	        			count+=1;
	        		}
	        	}
		}
		return count;
	}
	
	
	public int getNbmorts() {
	/*Renvoie le nombre total de cellule vivante dans le tableau*/
		int count=0;
		for (int i = 0;i < tab.length; i++) {
		    for (int j = 0;j < tab[i].length;j++) {
		    	if(valeur_case(i,j)==0) {
		        	count+=1;
		        }
		    }
		}
		return count;
	}
		
	
	public void run(int nb_tours,int delai){
	/*Méthode qui fait tourner le jeu. Elle prend en entrée un nombre de tour ainsi que le delai
	choisi entre chaque tour et renvoie l'etat final du tableau.
	Renvoie aussi un tableau récapitulatif (nombre de mort, vivant, nombre de tour effectué)
	Arret losrqu'aucun changement n'est détecté entre deux tours*/
		
		for(int i=0;i<nb_tours;i++) {// boucle qui va jusqu'au nombre de tour indiqué par l'utilisateur
			int nb_mort_ini=getNbmorts(); // nombre de mort dans le tableau initiale
			tab=tour(); // On recupere le tableau apres un tour dans tab
			affichTab(); // On l'affiche
			int nb_viv=getNbVivants();
			int nb_mort=getNbmorts();
			int n_tour=i+1;
			System.out.println("Tour "+n_tour); 
			System.out.println("Le nombre de vivants : "+nb_viv); 
			System.out.println("Le nombre de morts : "+nb_mort);
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Arrêt lorsqu'aucun changement n'est détecté entre deux tours.
			if(nb_mort==nb_mort_ini || nb_mort==0) {
				break;
			}
		}
		System.out.println("Fin");
	}
}

