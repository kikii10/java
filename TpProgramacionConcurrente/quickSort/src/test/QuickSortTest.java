package test;

import java.util.Random;

public class QuickSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Random rand = new Random();
        
         int[] numeros = new int[1000000000];
         
         for(int i= 0; i < numeros.length; i++) {
        	 
        	 numeros[i] = rand.nextInt(1000000000);
         }
         long inicio = System.currentTimeMillis();
        
         quickSort( numeros);
         
         long fin = System.currentTimeMillis();
         System.out.println("Tiempo sin hilos: " + (fin - inicio) + " ms");        
       
         
	}
	private static void quickSort(int[] array ) {
		
		quickSort(array, 0,array.length - 1);
		
	}
	private static void quickSort(int[] array, int minimo, int maximo) {
		if  (minimo >= maximo) {
			
			return;
		}
		int punteroDer = particion(array, minimo, maximo);
		quickSort(array, minimo,punteroDer-1);
		quickSort(array, punteroDer+1,maximo);
		
	}
	private static int particion(int[] array, int minimo, int maximo) {
		 int pivotIndex =new Random().nextInt(maximo - minimo) + minimo;
		 
		int pivot = array[pivotIndex];
		int punteroIzq = minimo;
		int punteroDer = maximo;
		swap (array,pivotIndex,maximo);
		
		
		
		while (punteroIzq< punteroDer){
			
			while  (array[punteroIzq]<= pivot &&  punteroIzq< punteroDer) {
				
				punteroIzq++;
			}
        while  (array[punteroDer] >= pivot &&  punteroIzq< punteroDer) {
				
				punteroDer--;
			}
        swap(array,punteroIzq,punteroDer);
		}
		swap(array,punteroDer,maximo);
		return punteroDer;
	}
	private static void swap (int[] array, int index1, int index2) {
		
		int temp = array[index1];
		array[index1]= array[index2];
		array[index2]= temp;
		
		
	}
 



}


