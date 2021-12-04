//import java.util.*;
public class JogoDaVelhaFim {
    public static void main(String args []){
        String[][] matriz = new String[3][3];
        Comandos.GeraMatriz(matriz);
        Comandos.ImprimeMatriz(matriz);
        int turno = 1;
        while(turno <= 10){
            if (turno == 10){
                System.out.println(" Deu velha ");
                break;
            }else{
                int movimento_1=Comandos.jogada_x();
                int movimento_2=Comandos.jogada_x();
                Comandos.ExecutaJogada(turno, matriz, movimento_1, movimento_2);
                Comandos.ImprimeMatriz(matriz);
                if(Comandos.VerificaFim(matriz) == 1){
                    System.out.println(" X ganhou ");
                    break;
                }else if(Comandos.VerificaFim(matriz) == 2){
                    System.out.println(" O ganhou ");
                    break;
                }
                turno++;
            }   
        }
    }
}
