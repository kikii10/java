package tests;

import java.time.LocalDateTime;
import java.util.List;

import modules.SistemaSube;
import modules.Viaje;

public class test {

	public static void main(String[] args) {
		SistemaSube sistema = new SistemaSube();
		
		
		System.out.println("------------------test 1---------------------------");
		try {
			sistema.agregarUsuario(44444444, "nombre1", "apellido1", false);
			sistema.agregarUsuario(55555555, "nombre2", "apellido2", false);
			sistema.agregarUsuario(66666666, "nombre3", "apellido3", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
          System.out.println(sistema.getUsuarios().toString());
          
          System.out.println("------------------test 2---------------------------");
          try {
			sistema.agregarUsuario(55555555, "nombre2", "apellido2", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
          System.out.println("------------------test 3---------------------------");
          
          try {
			sistema.agregarTarjeta("1234567890", sistema.traerUsuario(44444444));		
          sistema.agregarTarjeta("1234567891", sistema.traerUsuario(55555555));
           sistema.agregarTarjeta("1234567892", sistema.traerUsuario(66666666));           
	}catch (Exception e) {			
			e.printStackTrace();
		}
          System.out.println(sistema.getTarjetas().toString());
          
          System.out.println("------------------test 4---------------------------");
          try {
			sistema.agregarTarjeta("1234", sistema.traerUsuario(55555555));
		} catch (Exception e) {	
			e.printStackTrace();
		}
          System.out.println("------------------test 5---------------------------");
          sistema.agregarViaje(sistema.traerTarjeta("1234567890"), "linea 1", "medio 1", LocalDateTime.of(2023, 9,1, 10, 00), 50.0);
          sistema.agregarViaje(sistema.traerTarjeta("1234567890"), "linea 2", "medio 2", LocalDateTime.of(2023, 9,1, 10, 30), 50.0);
          sistema.agregarViaje(sistema.traerTarjeta("1234567890"), "linea 3", "medio 3", LocalDateTime.of(2023, 9,2, 9, 00), 100.0);
          
          sistema.agregarViaje(sistema.traerTarjeta("1234567891"), "linea 1", "medio 1", LocalDateTime.of(2023, 9,1, 10, 00), 60.0);
          sistema.agregarViaje(sistema.traerTarjeta("1234567891"), "linea 2", "medio 2", LocalDateTime.of(2023, 9,2, 15, 00), 60.0);
          sistema.agregarViaje(sistema.traerTarjeta("1234567891"), "linea 3", "medio 3", LocalDateTime.of(2023, 9,3, 22, 00), 60.0);
          
          sistema.agregarViaje(sistema.traerTarjeta("1234567892"), "linea 1", "medio 1", LocalDateTime.of(2023, 9,1, 10, 00), 100.0);
          sistema.agregarViaje(sistema.traerTarjeta("1234567892"), "linea 2", "medio 2", LocalDateTime.of(2023, 9,2, 10, 30), 100.0);
          sistema.agregarViaje(sistema.traerTarjeta("1234567892"), "linea 3", "medio 3", LocalDateTime.of(2023, 9,3, 10, 00), 100.0);
          System.out.println(sistema.getViajes().toString());
          System.out.println("------------------test 6---------------------------");
          List<Viaje> v = sistema.traerViaje(LocalDateTime.of(2023, 9,2, 10, 30), LocalDateTime.of(2023, 9,3, 10, 00));
          for(int i = 0; i<v.size(); i++) {       	  
        	  System.out.println(v.get(i).toString());  
          }
          System.out.println("------------------test 7---------------------------");
          System.out.println("total =" + sistema.calcularTotalFacturadoEntreFechas(LocalDateTime.of(2023, 9,2, 10, 30), LocalDateTime.of(2023, 9,3, 10, 00)));
}
}
