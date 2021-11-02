import java.util.Scanner;


public class Matriz {

    private double [][] matriz;  // Array 2D guarda matriz de tamanho lin x colun
    int lin;                     // quantidade de linhas da matriz
    int colun;                   // quantidade de colunas matriz

    /**
     * @description: Construtor cria uma matriz vazia de tamanho m x n.
     * @param  m: linha da matriz
     * @param  n: coluna da matriz
     */
    public Matriz(int m, int n) {
        matriz = new double[m][n];
        lin = m;
        colun = n;
    }

    /**
     * @description Construtor recebe a matriz através de um objeto da classe Scanner
     * @param   s: Objeto da classe Scanner com valores para preencher a matriz
     */
    public Matriz(Scanner s) {
        lin = s.nextInt();
        colun = s.nextInt();
        matriz = new double[lin][colun];

        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < colun; j++) {
                matriz[i][j] = s.nextDouble();
            }
        }
    }

    /**
     * @description Construtor clona a matriz passada
     * @param   mtz: matriz para ser clonada
     */
    public Matriz(Matriz mtz) {
        lin = mtz.getLin();
        colun = mtz.getColun();
        matriz = new double[lin][colun];

        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < colun; j++) {
                matriz[i][j] = mtz.matriz[i][j];
            }
        }
    }

    /**
     * @return a quatidade de linhas matriz.
     */
    public int getLin() {

        return lin;
    }

    /**
     * @return a quantidade de colunas da matriz.
     */
    public int getColun() {

        return colun;
    }

    /**
     * @description Retornar elementos da matriz.
     * @param   i: posição da linha
     * @param   j: posição da coluna
     * @return element E[i,j]
     */
    public double getElemento(int i, int j) {

        return matriz[i - 1][j - 1];
    }

    /**
     * @description Retornar elementos da matriz.
     * @param   i: posição da linha
     * @param   j: posição da coluna
     * @param   v: novo valor setado
     */
    public void setElemento(int i, int j, double v) {

        matriz[i - 1][j - 1] = v;
    }

    /**
     * @description Negar todos os elementos da matriz
     */
    public void negar() {
        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < colun; j++) {
                matriz[i][j] = -matriz[i][j];
            }
        }
    }

    /**
     * @description Multiplicar todos os elementos da matriz pelo mesmo valor.
     * @param   num:   valor que vai multiplicar a matriz
     * @param   res: resultado da nova matriz multiplicada
     * @return returna resultado .
     */
    public Matriz multiplicar(double num, Matriz res) {
        if (res != null) {
            //checa que as matrizes tem o mesmo tamanho, a do resultado e a da multipliacação
            if ((res.getLin() != lin) || (res.getColun() != colun)) {
                return null;
            }

            // multiplicação
            for (int i = 0; i < lin; i++) {
                for (int j = 0; j < colun; j++) {
                    res.matriz[i][j] = num * matriz[i][j];
                }
            }
        }

        return res;
    }

    /**
     * @description Returna true se uma matriz for identica a outra.
     * @param   a:   matriz a ser comparada com a matriz atual
     * @return returna true se as matrizes forem identicas
     */
    public boolean comparaIgual(Matriz a) {
        if ((a == null) || (a.getLin() != lin) || (a.getColun() != colun) ) {
            return false;
        }

        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < colun; j++) {
                if (matriz[i][j] != a.matriz[i][j]) {
                    // pelo menos um elemento não está identico entre as matrizes
                    return false;
                };
            }
        }

        return true;
    }

    /**
     * @description somar uma matriz b" a uma matriz já existente "this", se duas matrizes não tiverem o mesmo tamanho retorne null
     * @param   b:   matriz para ser adicionada na matriz atual
     * @param   res: matriz auxiliar que vai guardar o resultado.
     * @return  retorna res como resultado.
     */
    public Matriz somar(Matriz b, Matriz res) {
        if ((res == null) || (b == null) ||
                (b.getLin() != lin) || (b.getColun() != colun) ||
                (res.getLin() != lin) || (res.getColun() != colun)) {
            return res;
        }

        // Soma
        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < colun; j++) {
                res.matriz[i][j] = matriz[i][j] + b.matriz[i][j];
            }
        }
        return res;
    }


}
