package test;

import java.util.Random;

import data.QuickSortThread;

public class QuickSortTest {

	public static void main(String[] args) {
        int[] numeros = new int[1000000000]; // 
        Random rand = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(1000000000); // Números aleatorios
        }

        long inicio = System.currentTimeMillis();

        // Llamamos a la clase que extiende de Thread
        QuickSortThread sortThread = new QuickSortThread(numeros, 0, numeros.length - 1);
        sortThread.start();

        try {
            sortThread.join(); // Espera a que termine el hilo principal
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo con hilos: " + (fin - inicio) + " ms");
        
        /*for(int i= 0 ; i<numeros.length; i++) {
        	
        	System.out.print(numeros[i] + "--");
        }*/
        

}
}
