package data;
import java.util.Random;

import test.QuickSortTest;

public class QuickSortThread extends Thread {
	 private final int[] array;
     private final int minimo;
     private final int maximo;
     private static final int UMBRAL = 10000;
     private static final int MAX_HILOS = Runtime.getRuntime().availableProcessors(); // esta funcion busca cuanto es el maximo d ehilos que puede aguantar mi procesador
     private static int hilosActivos = 0;
     public QuickSortThread(int[] array, int minimo, int maximo) {
         this.array = array;
         this.minimo = minimo;
         this.maximo = maximo;
     }

     @Override
     public void run() {
         if (minimo >= maximo) return;

         int punteroDer = particion(array, minimo, maximo);

         boolean puedeCrearHilos = false;

         synchronized (QuickSortThread.class) {
        	 if (hilosActivos + 2 <= MAX_HILOS && (maximo - minimo) > UMBRAL) {
                 hilosActivos += 2;
                 puedeCrearHilos = true;
             }
         }

         if (puedeCrearHilos) {
             Thread hiloIzq = new QuickSortThread(array, minimo, punteroDer - 1);
             Thread hiloDer = new QuickSortThread(array, punteroDer + 1, maximo);

             hiloIzq.start();
             hiloDer.start();

             try {
                 hiloIzq.join();
                 hiloDer.join();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

             synchronized (QuickSortThread.class) {
                 hilosActivos -= 2;
             }

         } else {
             quickSort(array, minimo, punteroDer - 1);
             quickSort(array, punteroDer + 1, maximo);
         }
     }

     private void quickSort(int[] array, int minimo, int maximo) {
         if (minimo >= maximo) return;

         int particion = particion(array, minimo, maximo);
         quickSort(array, minimo, particion - 1);
         quickSort(array, particion + 1, maximo);
     }

     private int particion(int[] array, int minimo, int maximo) {
    	    int pivotIndex = new Random().nextInt(maximo - minimo + 1) + minimo;
    	    swap(array, pivotIndex, maximo);
    	    int pivot = array[maximo];  // pivot es el elemento que ahora está en maximo
    	    int punteroIzq = minimo;
    	    int punteroDer = maximo - 1;  // punteroDer inicia un lugar antes del pivote

    	    while (punteroIzq <= punteroDer) {
    	        while (punteroIzq <= punteroDer && array[punteroIzq] <= pivot) punteroIzq++;
    	        while (punteroDer >= punteroIzq && array[punteroDer] >= pivot) punteroDer--;
    	        if (punteroIzq < punteroDer) {
    	            swap(array, punteroIzq, punteroDer);
    	        }
    	    }
    	    swap(array, punteroIzq, maximo);
    	    return punteroIzq;
    	}
     
     private void swap(int[] array, int index1, int index2) {
         int temp = array[index1];
         array[index1] = array[index2];
         array[index2] = temp;
     }
 }
