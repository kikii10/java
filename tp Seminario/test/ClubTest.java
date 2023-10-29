package test;

import java.time.LocalDate;

import modulo.*;

public class ClubTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Club c1 = new Club("atikob srj");
try {
	c1.getAdm().agregarActividad(1,"futbol" ,"lunes 20hs");// agregamos actividades 
	c1.getAdm().agregarActividad(2,"handball", "martes 18hs");
	c1.getAdm().agregarActividad(3,"basquet", "jueves 20hs");
	c1.getAdm().agregarActividad(4,"voley","viernes 20hs");
	c1.getAdm().cargarArchivos();
	c1.getAdm().leerServicios_salon();
	c1.getAdm().leerServicios_cancha();

//AGREGAMOS PROFES//
c1.getAdm().agregarProfesor(new Profesor(69,"nacho"));
c1.getAdm().agregarProfesor(new Profesor(777,"juampy"));
c1.getAdm().agregarProfesor(new Profesor(666,"facu"));
c1.getAdm().agregarProfesor(new Profesor(999,"wilson"));
c1.getAdm().agregarProfesor(new Profesor(222,"lauti"));
//AGREGAMOS SOCIOS//
c1.getAdm().agregarSocio(new Socio(42,"iki"));
c1.getAdm().agregarSocio(new Socio(73,"mikel"));
c1.getAdm().agregarSocio(new Socio(911,"jorge"));
c1.getAdm().agregarSocio(new Socio(432,"marcos"));
c1.getAdm().agregarSocio(new Socio(86,"mara"));
c1.getAdm().agregarSocio(new Socio(90,"dona"));
// ALTAS DE SOCIOS EN ACTIVIDADES
		//------------ACTIVIDAD 1

	
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(42), c1.getAdm().buscarActividad(1));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(73), c1.getAdm().buscarActividad(1));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(911), c1.getAdm().buscarActividad(1));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(86), c1.getAdm().buscarActividad(1));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(432), c1.getAdm().buscarActividad(1));;
		//------------ACTIVIDAD 2
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(42), c1.getAdm().buscarActividad(2));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(73), c1.getAdm().buscarActividad(2));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(911), c1.getAdm().buscarActividad(2));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(86), c1.getAdm().buscarActividad(2));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(432), c1.getAdm().buscarActividad(2));
		//------------ACTIVIDAD 3
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(42), c1.getAdm().buscarActividad(3));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(911), c1.getAdm().buscarActividad(3));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(86), c1.getAdm().buscarActividad(3));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(432), c1.getAdm().buscarActividad(3));
		//------------ACTIVIDAD 4
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(42), c1.getAdm().buscarActividad(4));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(73), c1.getAdm().buscarActividad(4));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(911), c1.getAdm().buscarActividad(4));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(86), c1.getAdm().buscarActividad(4));
c1.getAdm().agregarSocioActividad(c1.getAdm().buscarSocio(432), c1.getAdm().buscarActividad(4));
//ALTAS DE SOCIOS EN ACTIVIDADES
		//------------ACTIVIDAD 1
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(69),c1.getAdm().buscarActividad(1));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(777),c1.getAdm().buscarActividad(1));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(666),c1.getAdm().buscarActividad(1));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(999),c1.getAdm().buscarActividad(1));


		//------------ACTIVIDAD 2
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(69),c1.getAdm().buscarActividad(2));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(777),c1.getAdm().buscarActividad(2));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(666),c1.getAdm().buscarActividad(2));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(999),c1.getAdm().buscarActividad(2));


		//------------ACTIVIDAD 3
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(69),c1.getAdm().buscarActividad(3));//69;777;666;999;222
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(777),c1.getAdm().buscarActividad(3));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(666),c1.getAdm().buscarActividad(3));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(999),c1.getAdm().buscarActividad(3));

		//------------ACTIVIDAD 4
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(69),c1.getAdm().buscarActividad(4));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(777),c1.getAdm().buscarActividad(4));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(666),c1.getAdm().buscarActividad(4));
c1.getAdm().agregarProfesorActividad(c1.getAdm().buscarProfesor(999),c1.getAdm().buscarActividad(4));


//SERVICIO
c1.getAdm().agregarServicio("alquiler de canchas");
c1.getAdm().agregarServicio("alquiler del salón para evento");
c1.getAdm().buscarServicio(1).agregarHorario(LocalDate.of(2022, 11, 20));
c1.getAdm().buscarServicio(1).agregarHorario(LocalDate.of(2022, 03, 05));
c1.getAdm().buscarServicio(1).agregarHorario(LocalDate.of(2022, 05, 10));
c1.getAdm().buscarServicio(2).agregarHorario(LocalDate.of(2022, 11, 20));
c1.getAdm().buscarServicio(2).agregarHorario(LocalDate.of(2022, 03, 05));
c1.getAdm().buscarServicio(2).agregarHorario(LocalDate.of(2022, 05, 10));
	//Modificar
	//c1.getAdm().modificarSocio(67, "Raul", 73);
//ELIMINACIONES
//c1.getAdm().eliminarSocio(432);
//c1.getAdm().eliminarProfesor(222);
	//c1.getAdm().buscarActividad(1).eliminarSocio(67);
	//c1.getAdm().buscarActividad(1).eliminarProfesor(777);
c1.getAdm().actualizacion();
c1.getAdm().imprimirActividadesTxt();
c1.getAdm().imprimirServicios();

}catch(Exception e) {
	
}
 System.out.println(c1.toString());
	}

}
