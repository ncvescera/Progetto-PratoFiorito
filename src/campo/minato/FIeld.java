package campo.minato;

import java.util.Random;

public class FIeld {
    private int matrice[][];
    private final int  Y;
    private final int X;
    private final int BOMB = -7;
    
    public FIeld(int x, int y){
        this.X = x;
        this.Y = y;
        
        this.matrice = new int[Y][X];
    }
    
    public void init(int iter){
        int i,j;
   
        for(i=0;i<iter;i++){
            int[] YX = this.spawnCell();
            
            this.matrice[YX[0]][YX[1]] = BOMB;
        }
        
        for(i=0;i<Y;i++){
            for(j=0;j<X;j++){
                if(matrice[i][j]!= BOMB)
                    matrice[i][j] = 0;
            }
        }
        
    }
    
    // ritorna le coordinate Y X di dove andrà piazzata la bomba
    private int[] spawnCell(){
        Random rand = new Random();
        int[] array = new int[2];
        
        array[0] = rand.nextInt(this.Y);
        array[1] = rand.nextInt(this.X);
        
        return array;
    }
    
    //stampa la matrice
    public void print(){
        int i,j;
        
        for(i=0;i<Y;i++){
            for(j=0;j<X;j++){
                System.out.print(matrice[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }
}
