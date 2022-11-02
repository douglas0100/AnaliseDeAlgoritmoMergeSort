public class MergeSort {

    public static void main(String[] args) {
        int vetor[] = {10, 5, 8, 7, 4, 19, 9, 6, 1, 15, 18, 0};
        imprimeVetor(vetor);
        mergesort_i(vetor, vetor.length);
        imprimeVetor(vetor);
    }


    public static void mergesort_i (int vetor[], int tam) {
        
        //Tamanho do subvetor
        int sub = 1;

        while (sub < tam) {

            //posicao inicial do subvetor
            int inicio = 0;

            while (inicio + sub < tam) {

                int fim = inicio + 2*sub;
                
                if (fim > tam){
                    fim = tam;
                } 

                merge (vetor, inicio, inicio + sub, fim);

                inicio = inicio + 2*sub; 
            }

            sub = 2*sub;

        }

    }


    public static void merge(int vetor[], int inicio, int meio, int fim) {

        int prim = inicio;
        int seg = meio;
        int [] aux = new int[fim - inicio];
        int i = 0;

        // enquanto tiver elementos nos dois conjuntos
        while ((prim < meio) && (seg < fim)) {

            // insere elemento do primeiro
            if (vetor[prim] <= vetor[seg]) {
                aux[i] = vetor[prim];
                prim++;
            } 

            // insere elemento do segundo
            else { 
                aux[i] = vetor[seg];
                seg++;
            }
            i++;
        }

        // sobrou elementos do segundo
        if (prim >= meio) {
            while (seg < fim) {
                aux[i] = vetor[seg];
                seg++;
                i++;
            }
        }
            
        // sobrou elementos do primeiro
        else {
            while (prim < meio) {
                aux[i] = vetor[prim];
                prim++;
                i++;  
            }
        }

        // copia o vetor auxiliar no vetor principal
        int i_aux = 0;
        for (i = inicio; i < fim; i++) {
            vetor[i] = aux[i_aux];
            i_aux++;
        }
        
    }


    public static void imprimeVetor(int[] vetor){

        System.out.println();
        
        for (int i = 0; i < vetor.length; i++) {

            if(i == 0) System.out.format("[%d, ", vetor[i]);

            if(i > 0 && i < vetor.length - 1) System.out.format("%d, ", vetor[i]);

            if(i == vetor.length - 1) System.out.format("%d]", vetor[i]);
        }

        System.out.println();
    }


}