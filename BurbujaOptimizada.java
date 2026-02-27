import java.util.Random;

public class BurbujaOptimizada {

    public static void burbujaOptimizada(int[] arr) {

        int n = arr.length;
        int ultimoIntercambio;

        do {
            ultimoIntercambio = 0;

            for (int i = 1; i < n; i++) {

                if (arr[i - 1] > arr[i]) {

                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    ultimoIntercambio = i;
                }
            }

            n = ultimoIntercambio;

        } while (ultimoIntercambio != 0);
    }

    public static int[] generarArreglo(int size) {

        Random r = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(100000);
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] tamanios = {100, 1000, 2000, 5000, 10000};

        for (int size : tamanios) {

            int[] arreglo = generarArreglo(size);

            long inicio = System.nanoTime();

            burbujaOptimizada(arreglo);

            long fin = System.nanoTime();

            long tiempo = fin - inicio;

            System.out.println("Tamaño: " + size +
                    " | Tiempo: " + tiempo + " ns");
        }
    }
}