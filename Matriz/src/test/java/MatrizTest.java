import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MatrizTest {

    private static String matrizPreDefinida = "2 2 1 2 3 4";
    private static String matrizPreDefinidaNegativa = "2 2 -1 -2 -3 -4";
    private static String matrizPreDefinidaMultiplicadoPor2 = "2 2 2 4 6 8";
    private static String matrizPreDefinida2 = "2 2 0 8 8 7";
    private static String matrizPreDefinidasSomadas = "2 2 1 10 11 11";

    @Test
    void getLin() {
        Matriz matriz = new Matriz(new Scanner(matrizPreDefinida));
        assertEquals(matriz.getLin(), 2, "wrong line's number");
    }

    @Test
    void getColun() {
        Matriz matriz = new Matriz(new Scanner(matrizPreDefinida));
        assertEquals(matriz.getColun(), 2, "wrong column's number");
    }

    @Test
    void getElemento() {
        Matriz matriz = new Matriz(new Scanner(matrizPreDefinida));
        assertEquals(matriz.getElemento(1,1), 1);
    }

    @Test
    void setElemento() {
        Matriz matriz = new Matriz(1,1);
        matriz.setElemento(1,1,87);
        assertEquals(matriz.getElemento(1,1), 87);
    }

    @Test
    void negar() {
        Matriz matriz = new Matriz(new Scanner(matrizPreDefinida));
        Matriz matrizNegativa = new Matriz(new Scanner(matrizPreDefinidaNegativa));
        matriz.negar();
        for (int i = 1; i <= matriz.getLin(); i++) {
            for (int j = 1; j <= matriz.getColun(); j++) {
                assertEquals(matriz.getElemento(i, j), matrizNegativa.getElemento(i, j));
            }
        }
    }

    @Test
    void multiplicar() {
        Matriz matriz = new Matriz(new Scanner(matrizPreDefinida));
        Matriz matrizMultiplicadaPor2 = new Matriz(new Scanner(matrizPreDefinidaMultiplicadoPor2));
        int multiplicador = 2;
        matriz.multiplicar(multiplicador, matrizMultiplicadaPor2);
        for (int i = 1; i <= matriz.getLin(); i++) {
            for (int j = 1; j <= matriz.getColun(); j++) {
                assertEquals(matriz.getElemento(i, j) * multiplicador, matrizMultiplicadaPor2.getElemento(i, j));
            }
        }
    }

    @Test
    void comparaIgual() {
        Matriz matriz1 = new Matriz(new Scanner(matrizPreDefinida));
        Matriz matriz2 = new Matriz(new Matriz(matriz1));
        assertTrue(matriz1.comparaIgual(matriz2));
    }

    @Test
    void somar() {
        Matriz matriz = new Matriz(new Scanner(matrizPreDefinida));
        Matriz matriz2 = new Matriz(new Scanner(matrizPreDefinida2));
        Matriz matrizSomadas = new Matriz(new Scanner(matrizPreDefinidasSomadas));
        matriz.somar(matriz2, matrizSomadas);
        for (int i = 1; i <= matriz.getLin(); i++) {
            for (int j = 1; j <= matriz.getColun(); j++) {
                assertEquals(matriz.getElemento(i, j) + matriz2.getElemento(i, j), matrizSomadas.getElemento(i, j));
            }
        }
    }
}