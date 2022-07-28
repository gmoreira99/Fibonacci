// Guilherme Moreira de Carvalho
// 07/09/21 - Para Laboratório de Algoritmos e Estruturas de Dados II
// Implementa a geração de números da Série de Fibonacci por meio da programação dinâmica

import java.io.FileWriter;
import java.io.IOException;

public class FiboDinamico {
    private long cont;  // contador de chamadas recursivas

    FiboDinamico () {
        cont = 0;
    }

    public long getCont() {
        return cont;
    }

    public void resetCont() {
        this.cont = 0;
    }

    // Gera o n-ésimo número da série de Fibonacci dinamicamente
    public int fibo (int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        // vetor de valores já calculados para a série
        int[] f = new int[n + 1];   // posições 1 - n
        f[1] = 0; f[2] = 1;
     
        for (int i = 3; i <= n; i++) {
            this.cont += 2; // cada posição utiliza as duas anteriores
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    public static void main (String args[]) {
        String out = "";
        FiboDinamico fiboDyn = new FiboDinamico();
        for (int n = 1; n <= 45; n++) {
            if (n%5 == 0)
                System.out.println(".");
            out += "F(" + n + ") = " + fiboDyn.fibo(n) + "\n";
            out += "Chamadas recursivas: " + fiboDyn.getCont() + "\n";
            fiboDyn.resetCont();
        }

        // tenta escrever a saída do programa em um arquivo "dinamico_out.txt" e
        // a imprime na tela
        try {
            FileWriter fp = new FileWriter("FiboDinamico_Saida.txt");
            fp.write(out);
            fp.close();
        } catch (IOException e) {
            System.out.println("ERRO: NAO FOI POSSIVEL CRIAR O ARQUIVO");
        }
    }
}
