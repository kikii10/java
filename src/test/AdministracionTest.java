package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import modulo.*;

public class AdministracionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Administracion adm = new Administracion();
		
		try {	
			adm.agregarActividad(1,"futbol" ,"lunes 20hs");// agregamos actividades 
			adm.agregarActividad(2,"handball", "martes 18hs");
			adm.agregarActividad(3,"basquet", "jueves 20hs");
			adm.agregarActividad(4,"voley","viernes 20hs");
			adm.cargarArchivos();// carga de los Socios y Profesores txt
			//adm.agregarServicio("alquiler de canchas");
			//adm.agregarServicio("alquiler del salón para evento");
			/*adm.buscarServicio(1).agregarHorario(LocalDate.of(2022, 11, 20));
			adm.buscarServicio(1).agregarHorario(LocalDate.of(2022, 03, 05));
			adm.buscarServicio(1).agregarHorario(LocalDate.of(2022, 05, 10));
			dm.buscarServicio(2).agregarHorario(LocalDate.of(2022, 11, 20));
		    adm.buscarServicio(2).agregarHorario(LocalDate.of(2022, 03, 05));
			adm.buscarServicio(2).agregarHorario(LocalDate.of(2022, 05, 10));*/
			/*adm.agregarSocio(new Socio(8, "osvaldo"));
		    adm.agregarSocioActividad(adm.buscarSocio(8), adm.buscarActividad(1));
		    adm.agregarSocioActividad(adm.buscarSocio(8), adm.buscarActividad(2));
		    adm.agregarSocioActividad(adm.buscarSocio(8), adm.buscarActividad(3));*/
			//System.out.println(adm.toString());
		    //System.out.println("-------------------------------------------------------------------------------------------");
			//adm.agregarSocio(new Socio(4, "jose"));
			//adm.agregarSocio(new Socio(5, "pablo"));
			
			//adm.agregarProfesor(new Profesor(333,"juanjo"));
			/*adm.agregarProfesor(new Profesor(45,"peep"));*/
			//adm.agregarProfesorActividad(adm.buscarProfesor(333),adm.buscarActividad(3));
			//adm.agregarProfesorActividad(adm.buscarProfesor(333),adm.buscarActividad(2));
			//adm.agregarProfesorActividad(adm.buscarProfesor(333),adm.buscarActividad(4));
			//adm.agregarProfesorActividad(adm.buscarProfesor(333),adm.buscarActividad(4));
			//adm.agregarSocioActividad(adm.buscarSocio(10), adm.buscarActividad(4));
			//adm.agregarSocioActividad(adm.buscarSocio(4), adm.buscarActividad(4));
			//adm.agregarSocioActividad(adm.buscarSocio(5), adm.buscarActividad(4));
			//adm.agregarSocioActividad(adm.buscarSocio(6), adm.buscarActividad(4));
			//adm.agregarSocioActividad(adm.buscarSocio(5), adm.buscarActividad(4));
			/*adm.agregarSocioActividad(adm.buscarSocio(6), adm.buscarActividad(4));
		adm.agregarSocioActividad(adm.buscarSocio(4), adm.buscarActividad(3));
			adm.agregarSocioActividad(adm.buscarSocio(5), adm.buscarActividad(3));
			adm.agregarSocioActividad(adm.buscarSocio(6), adm.buscarActividad(3));
			adm.agregarSocioActividad(adm.buscarSocio(4), adm.buscarActividad(2));
			adm.agregarSocioActividad(adm.buscarSocio(5), adm.buscarActividad(2));
			adm.agregarSocioActividad(adm.buscarSocio(6), adm.buscarActividad(2));
		adm.agregarSocioActividad(adm.buscarSocio(4), adm.buscarActividad(2));
			adm.agregarSocioActividad(adm.buscarSocio(5), adm.buscarActividad(2));
			adm.agregarSocioActividad(adm.buscarSocio(6), adm.buscarActividad(2));*/
			//adm.actualizarTxtActividades();   // cargamos los txt de las actividades al programa
			//adm.modificarProfesor(75,"manuel",333);// modifica un profesor
			//adm.modificarSocio(69,"Mauro" , 4);
			//adm.agregarSocio(new Socio(99,"lucas"));
			//adm.agregarProfesor(new Profesor(44,"pedro"));
			//adm.agregarProfesorActividad(adm.buscarProfesor(44),adm.buscarActividad(1));
			//adm.agregarProfesorActividad(adm.buscarProfesor(44),adm.buscarActividad(2));
			//adm.agregarProfesorActividad(adm.buscarProfesor(44),adm.buscarActividad(3));
			
			//adm.actualizacion();//carga los profes y socios de las actividades desde los txt
			//adm.imprimirActividadesTxt();
			//adm.leerServicios_salon();
			//adm.leerServicios_cancha();
			//adm.imprimirServicios();
			//adm.eliminarProfesor(44);
			//adm.eliminarSocio(8);
			
			
			
			
			//adm.modificarProfesor(46, "juanjito", 45);
			//adm.agregarServicio("basquet");
			//adm.buscarServicio("basquet").agregarHorario(LocalDate.now());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		//System.out.println(adm.toString());
		System.out.print(adm.toString());
		}
	

}

