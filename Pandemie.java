public class Pendemie {
    int [][] tab;
    //Le constructeur monde infini
    public Population() {
        boolean vaccine;
        boolean contamine;
        // mettre un coefficient dans le cas du port du masque ou nom //boolean masque;
        // mettre un coefficient à la prise ou nom de chlorochine et autre médicament // boolean traitement 
        /*Scanner sc = new Scanner(System.in);
        int lenghti = sc.nextInt();
        Scanner sc = new Scanner(System.in);
        int lenghtj = sc.nextInt();*/
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
// mise en place du monde infinie //
    public int total_voisins(int i,int j) {
        int somme=0;

        //Pour tous les cas de i
        if(i==0){
            if(j==0) {//En haut à gauche
                somme=tab[i][j+1]+tab[i+1][j+1]+tab[i+1][j]+tab[tab.length-1][j]+tab[i][tab.length-1]+tab[i+1][tab.length-1]+tab[tab.length-1][j+1]+tab[tab.length][tab.length]
            }
            else if(j==tab.length-1) {//En haut à droite
                somme=tab[i][j-1]+tab[i+1][j-1]+tab[i+1][j]+tab[tab.length-1][tab.length-1]+tab[tab.length-1][tab.length-2]+tab[0][0]+tab[1][0]+tab[tab.length][0];
            }
            else {//Le long de la première ligne
                somme=tab[i][j+1]+tab[i+1][j+1]+tab[i+1][j]+tab[i][j-1]+tab[i+1][j-1]+tab[tab.length-1][j-1]+tab[tab.length-2][j-1]+tab[tab.length-2][j]+tab[tab.length-2][j+1]+tab[tab.length-1][j+1];
            }
        }
        else if(i==tab.length-1) {
            if(j==0) {//En bas à gauche
                somme=tab[i-1][j]+tab[i][j+1]+tab[i-1][j+1]+tab[0][0]+tab[0][1]+tab[i][tab.length-1]+tab[i-1][tab.length-1]+tab[0][tab.length-1];
            }
            else if(j==tab.length-1) {//En bas à droite
                somme=tab[i-1][j-1]+tab[i-1][j]+tab[i][j-1]+tab[i][0]+tab[i][1]+tab[i][0]+tab[0][J]+tab[0][j-1]+tab[0][0];
            }
            else {//Le long de la dernière ligne
                somme=tab[i][j-1]+tab[i-1][j-1]+tab[i-1][j]+tab[i-1][j+1]+tab[0][j+1]+tab[0][j+1]+tab[1][j+1]+tab[1][j]+tab[0][j-1]+tab[1][j-1]
            }
        }
        //Pour chaque cas de j
        else if(j==0 && i!=0 && i!=tab.length-1) {//Le long de la première colonne
            somme=tab[i-1][j]+tab[i-1][j+1]+tab[i][j+1]+tab[i+1][j+1]+tab[i+1][j]+tab[i-1][tab.length]+tab[i][tab.length]+tab[i+1][tab.length];
        }
        else if(j==tab.length-1 && i!=0 && i!=tab.length-1) {//Le long de la dernière colonne
            somme=tab[i-1][j-1]+tab[i-1][j]+tab[i+1][j]+tab[i+1][j-1]+tab[i][j-1]+tab[i-1][j]+tab[i][j]+tab[i+1][j];
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
