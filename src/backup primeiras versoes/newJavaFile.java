import java.util.Scanner;

public class newJavaFile {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[][] matriz = new String[3][3];
        GeraMatriz(matriz);
        ImprimeMatriz(matriz);
        int turno = 1;
        while(turno <= 10){
            if (turno == 10){
                System.out.println(" Deu velha ");
                break;
            }else{
                int movimento_1=jogada_x();
                int movimento_2=jogada_y();
                ExecutaJogada(turno, matriz, movimento_1, movimento_2);
                ImprimeMatriz(matriz);
                if(VerificaFim(matriz) == 1){
                    System.out.println(" X ganhou ");
                    break;
                }else if(VerificaFim(matriz) == 2){
                    System.out.println(" O ganhou ");
                    break;
                }
                turno++;
            }
            
        }
    }
    public static Class<Void> GeraMatriz(String matriz[][]){
        int i; int j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                matriz[i][j] = "-";
            }
        }
        return void.class;
    }
    public static Class<Void> ImprimeMatriz(String matriz[][]){
        int i; int j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if( j == 0){
                    System.out.printf("| %s ", matriz[i][j]);
                }
                else if(j == 2){
                    System.out.printf(" %s |", matriz[i][j]);
                }
                else{
                    System.out.printf(" %s ", matriz[i][j]);
                }
            }
            System.out.println();
        }
        return void.class;
    }
    public static int jogada_x(){
        Scanner jogadaScanner = new Scanner(System.in);
        System.out.println("digite entre 1 e 3 onde deseja jogar");
        int x = jogadaScanner.nextInt();
        while ( x < 1 || x > 3 ){
            System.out.println("coordenada invalida, escolha um local dentro do tabuleiro: ");
            x = jogadaScanner.nextInt();
            jogadaScanner.close();
        }
        return x-1;
    }
    public static int jogada_y(){
        Scanner jogadaScanner = new Scanner(System.in);
        System.out.println("digite entre 1 e 3 onde deseja jogar");
        int y = jogadaScanner.nextInt();
        while ( y < 1 || y > 3 ){
            System.out.println("coordenada invalida, escolha um local dentro do tabuleiro: ");
            y = jogadaScanner.nextInt();
            jogadaScanner.close();
        }
        return y-1;
    }
    public static void ExecutaJogada(int turno,String matriz[][],int i,int j){
        Scanner jogadaScanner = new Scanner(System.in);
        if (turno %2 != 0){
            if(matriz[i][j] == "-"){
                matriz[i][j] = "X";
            }
            else{
                System.out.println("coordenada invalida, escolha uma posição que nao foi tomada:");
                i = jogadaScanner.nextInt();
                j = jogadaScanner.nextInt();
                jogadaScanner.close();
                ExecutaJogada(turno, matriz, i, j);
            }
        }
        else if (turno %2 == 0){
            if(matriz[i][j] == "-"){
                matriz[i][j] = "O";
            }
            else{
                System.out.println("coordenada invalida, escolha uma posição que nao foi tomada:");
                i = jogadaScanner.nextInt();
                j = jogadaScanner.nextInt();
                ExecutaJogada(turno, matriz, i, j);
            }
        }
    }
    public static int VerificaFim(String matriz[][]){
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(matriz[i][0].equals("X") && matriz[i][1].equals("X")  && matriz[i][2].equals("X")){
                    return 1;
                }else if(matriz[i][0].equals("O") && matriz[i][1].equals("O")  && matriz[i][2].equals("O")){
                    return 2;
                }
            }
        }for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(matriz[0][i].equals("X") && matriz[1][i].equals("X")  && matriz[2][i].equals("X")){
                    return 1;
                }else if(matriz[0][i].equals("O") && matriz[1][i].equals("O")  && matriz[2][i].equals("O")){
                    return 2;
                }
            }
        }
        if ( matriz[0][0].equals("X") && matriz[1][1].equals("X")  && matriz[2][2].equals("X") ){
            return 1;
        }else if ( matriz[0][0].equals("O") && matriz[1][1].equals("O")  && matriz[2][2].equals("O") ){
            return 2;
        }else if(matriz[0][2].equals("X") && matriz[1][1].equals("X")  && matriz[2][0].equals("X")){
            return 1;
        }else if(matriz[0][2].equals("O") && matriz[1][1].equals("O")  && matriz[2][0].equals("O")){
            return 2;
        }else{
            return 0;
        } 
    }    
}

