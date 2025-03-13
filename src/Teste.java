public class Teste {

    public static void main(String[] args) {

        int[] vetor = new int[10];

        preencherVetor(vetor);

        imprimir(vetor);

    }

    public static void preencherVetor(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {

            vetor[i] = i+1;

        }

    }

    public static void imprimir(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {

            System.out.println(vetor[i]);

        }

        for(int i : vetor) {



        }

    }

}