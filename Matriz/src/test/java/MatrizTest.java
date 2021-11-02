import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MatrizTest {

    private final static String matrizSimples ="2 2 1 2 3 4"; // 1 2
                                                              // 3 4

    private final static String matrizSimplesNegativa ="2 2 -1 -2 -3 -4"; // -1 -2
                                                                         //  -3 -4

    private final static String matrizSimplesMulti ="2 2 5 10 15 20"; // 5 10
                                                                      // 15 20

    private final static String matrizSimplesSoma ="2 2 6 12 18 24"; // 6 12
                                                                     // 18 24

    private final static String matrizVetor= "1 5 9 8 7 6 5 4"; // A B C D E

    private final static String matrizTres= "2 3 1 2 3 4 5 6"; // 1 2 3
                                                                //4 5 6
    @Test
    void getLin() {
        Matriz m = new Matriz(new Scanner(matrizSimples));
        assertEquals(2,m.getLin(),"numero de linhas incorreto");
    }

    @Test
    void getColun() {
        Matriz m = new Matriz(new Scanner(matrizSimples));
        assertEquals(2,m.getColun(),"numero de colunas incorreto");
    }

    @Test
    void getElemento() {
        Matriz m=new Matriz(new Scanner(matrizVetor));
        assertEquals(8,m.getElemento(1,2),"getElemento() retorna o valor incorreto");
    }

    @Test
    void setElemento() {
        Matriz m=new Matriz(new Scanner(matrizVetor));
        m.setElemento(1,2,10);
        assertEquals(10,m.getElemento(1,2),"setElemento() setou valor incorretamente");
    }

    @Test
    void comparaIgual() {
        Matriz a=new Matriz(new Scanner(matrizSimples));
        Matriz b=new Matriz(new Scanner(matrizSimples));
        assertEquals(true,a.comparaIgual(b),"matrizes diferentes");
    }

    @Test
    void negar() {
        Matriz a=new Matriz(new Scanner(matrizSimples));
        Matriz b=new Matriz(new Scanner(matrizSimplesNegativa));
        a.negar();
        assertEquals(true,b.comparaIgual(a),"negate did not have the correct result");
    }

    @Test
    void multiplicar() {
        Matriz m = new Matriz(new Scanner(matrizSimples));
        Matriz res = new Matriz(2, 2);
        Matriz mmulti = new Matriz(new Scanner(matrizSimplesMulti));
        assertEquals(true, mmulti.comparaIgual(m.multiplicar(5, res)), "Multiplicação está incorreta");

    }

    @Test
        void add() {
            Matriz a=new Matriz(new Scanner(matrizSimples));
            Matriz b=new Matriz(new Scanner(matrizSimplesMulti));
            Matriz res=new Matriz(2, 2);
            Matriz c = new Matriz(new Scanner(matrizSimplesSoma));
            Matriz d = b.somar(a,res);
            assertEquals(true,c.comparaIgual(d),"soma incorreta");
        }
}