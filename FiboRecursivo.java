// Guilherme Moreira de Carvalho
// 07/09/21 - Para Laboratório de Algoritmos e Estruturas de Dados II
// Implementa a geração de números da Série de Fibonacci de forma recursiva

import java.io.FileWriter;
import java.io.IOException;

public class FiboRecursivo {
    private long cont;  // contador de chamadas recursivas

    FiboRecursivo () {
        cont = 0;
    }

    public long getCont() {
        return cont;
    }

    public void resetCont() {
        this.cont = 0;
    }

    // Gera recursivamente o n-ésimo número da série de Fibonacci
    public long fibo (int n) {
        if (n <= 2) // cond. de parada - F(1) = 0; F(2) = 1
            return n-1;
        this.cont += 2; // cada posição utiliza as duas anteriores
        return fibo(n-2) + fibo(n-1);
    }

    public static void main (String args[]) {
        String out = "";
        FiboRecursivo fiboRec = new FiboRecursivo();

        // tempo de execução relativamente grande para n > 45
        for (int n = 1; n <= 45; n++) {
            if (n%5 == 0)
                System.out.println(".");
            out += "F(" + n + ") = " + fiboRec.fibo(n) + "\n";
            out += "Chamadas recursivas: " + fiboRec.getCont() + "\n";
            fiboRec.resetCont();
        }

        // tenta escrever a saída do programa em um arquivo "recursivo_out.txt" e
        // a imprime na tela
        try {
            FileWriter fp = new FileWriter("FiboRecursivo_Saida.txt");
            fp.write(out);
            fp.close();
        } catch (IOException e) {
            System.out.println("ERRO: NAO FOI POSSIVEL CRIAR O ARQUIVO");
        }
    }
}
