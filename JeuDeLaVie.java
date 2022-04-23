package JDL;
import java.lang.Thread;
import java.util.Random;

public class JeuDeLaVie {
	String [][] tab;
	int nb_tours;
	int delai;
	String vivant;
	String mort;
	
	//Le constructeurs 
	public JeuDeLaVie() {
		vivant="1";
		mort="0";
		tab = new String[100][100];
		 for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
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
		vivant=viv;
		mort=mor;
		tab = new String[100][100];
		if(k==1) {
			 for (int i = 0;i < tab.length; i++) {
		         for (int j = 0;j < tab[i].length;j++) {
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
		if(k==2) {
			for (int i = 0;i < tab.length; i++) {
		         for (int j = 0;j < tab[i].length;j++) {
		        	 	if(j>i) {
		             		tab[i][j] = vivant;
		        	 	}else {
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
		        	 	}else {
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
                    }else {
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
                    }else {
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
                    }else {
                    	tab[i][j]=mort;
                    }
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
		
	//Retourne la valeur
	public int valeur_case(int i, int j) {
		if(tab[i][j]==vivant) {
			return 1;
		}
		return 0;
	}
	
	public int total_voisins(int i,int j) {
		int somme=0;
		
		//Pour tous les cas de i
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
		//Pour chaque cas de j
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
		if( total_voisins(i,j)>=3) {
			return vivant;
		}
		return mort;
	}
	public String[][] tour() {
		String[][] tabb=new String[100][100];
		for (int i = 0;i < tab.length; i++) {
	         for (int j = 0;j < tab[i].length;j++) {
	        		 tabb[i][j] = resultat(i,j);
	      }
		}
		return tabb;
	}
	
	//Get nombre de vivants
	public int getNbVivants() {
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
	
	//Get nombre de morts
		public int getNbmorts() {
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
		for(int i=0;i<nb_tours;i++) {
			int bb=getNbmorts();
			
			tab=tour();
			affichTab();
			int a=getNbVivants();
			int b=getNbmorts();
			int c=i+1;
			System.out.println("Tour "+c);
			System.out.println("Le nombre de vivants : "+a);
			System.out.println("Le nombre de morts : "+b);
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Arrêt lorsqu'aucun changement n'est détecté.
			if(b==bb || b==0) {
				break;
			}
		}
		System.out.println("Fin");
	}
	
}

