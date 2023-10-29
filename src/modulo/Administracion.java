package modulo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Administracion {
	ArrayList<Actividad> actividades;
	ArrayList<Socio> socios;
	ArrayList<Servicio> servicios;
	ArrayList<Profesor> profesores;

	public boolean agregarSocio(Socio s) {

		
		return this.socios.add(s);
	}

	public boolean agregarServicio(String nombre) {
		Servicio aux = null;

		if (servicios.size() == 0) {
			aux = new Servicio(nombre, 1);
		} else {

			aux = new Servicio(nombre, servicios.get(servicios.size() - 1).getCodigo() + 1);
		}
		return servicios.add(aux);
	}

	public boolean agregarActividad(int codigo, String nombre, String horario) {
		Actividad aux = null;
		aux = new Actividad(nombre, codigo, horario);
		return this.actividades.add(aux);
	}

	public boolean agregarProfesor(Profesor p) {
		return this.profesores.add(p);
	}

	public Administracion() {
		super();
		this.actividades = new ArrayList<Actividad>();
		this.socios = new ArrayList<Socio>();
		this.servicios = new ArrayList<Servicio>();
		this.profesores = new ArrayList<Profesor>();
	}

	@Override
	public String toString() {
		return "###Administracion [#actividades=" + actividades + "\n" + "# socios=" + socios + "\n" + "#servicios="
				+ servicios + "\n" + "# profesores=" + profesores + "]";
	}

	public void actualizarListaSocios() throws Exception {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("socios2.txt");
			br = new BufferedReader(fr);
			String cad = "";

			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");
				double dni = Double.parseDouble(datos[1]);// String tipoDato
				String nombre = datos[0];
				Socio s = new Socio((int) dni, nombre);
				this.socios.add(s);
			}
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Socio buscarSocio(int dni) {
		Socio aux = null;
		for (Socio s : socios) {
			if (s.getDni() == dni) {
				aux = s;
			}

		}
		return aux;
	}

	public Actividad buscarActividad(int codigo) {

		return this.actividades.get(codigo - 1);
	}

	public boolean agregarSocioActividad(Socio s, Actividad a)throws Exception {
		switch (a.getCodigo()) {
		case 1:
			if(a.socios.size() <=20) {
			if (s == null) {
				return false;
			}
			return a.agregarSocio(s);}
			else {
				throw new Exception("cupo alcanzado - futbol");
			}

		case 2:

			if(a.socios.size() <=20) {
				if (s == null) {
					return false;
				}
				return a.agregarSocio(s);}
				else {
					throw new Exception("cupo alcanzado - handball");
				}
		case 3:
			if(a.socios.size() <= 20) {
				if (s == null) {
					return false;
				}
				return a.agregarSocio(s);}
				else {
					throw new Exception("cupo alcanzado - basquet");
				}
		case 4:

			if(a.socios.size() <= 20) {
				if (s == null) {
					return false;
				}
				return a.agregarSocio(s);}
				else {
					throw new Exception("cupo alcanzado - voley");
				}
		}
		if (a.getCodigo() < 0 || a.getCodigo() > 4) {
			System.out.println("el codigo no coincide con el de ninguna actividad");
			return false;
		}
		return false;
	}

	public void actualizarListaProfesores() throws Exception {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("profesores.txt");
			br = new BufferedReader(fr);
			String cad = "";

			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");
				int cuil = Integer.parseInt(datos[1]);
				String nombre = datos[0];
				Profesor p = new Profesor(cuil, nombre);
				this.profesores.add(p);
			}

			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void cargarArchivos() {

		try {
			this.actualizarListaSocios();
			this.actualizarListaProfesores();
			this.leerTxtActividades();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Profesor buscarProfesor(int cuil) {
		Profesor aux = null;
		for (Profesor p : profesores) {
			if (p.getCuil() == cuil) {
				aux = p;
			}

		}
		return aux;
	}

	public boolean agregarProfesorActividad(Profesor p, Actividad a) {
		if (a.getCodigo() == 1) {

			return a.agregarProfe(p);
		}
		if (a.getCodigo() == 2) {

			return a.agregarProfe(p);
		}
		if (a.getCodigo() == 3) {

			return a.agregarProfe(p);
		}
		if (a.getCodigo() == 4) {

			return a.agregarProfe(p);
		} else {
			System.out.println("el codigo no coincide con el de ninguna actividad");
			return false;
		}
	}

	public Servicio buscarServicio(int buscar) {
		return this.servicios.get(buscar - 1);
	}

	public void actualizacion() throws Exception {

		this.vaciarArchivos();

		for (Profesor p : profesores) {// ACTUALIZAR PROFES
			try {

				BufferedWriter out = new BufferedWriter(new FileWriter("profesores.txt", true));
				String cad = p.getNombreCompleto() + ";" + p.getCuil();

				out.write(cad);
				out.newLine();
				out.close();

			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		// ------------ACTUALIZAR SOCIOS
		for (Socio s : socios) {

			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("socios2.txt", true));
				String cad = s.getNombreCompleto() + ";" + s.getDni();

				out.write(cad);
				out.newLine();
				out.close();

			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

	public void eliminarSocio(int buscar) throws Exception {
		for (Actividad a : actividades) {
			for (int i = 0; i < a.getSocios().size(); i++) {
				if (a.getSocios().get(i).getDni() == buscar) {
					a.getSocios().remove(i);
				}
			}
		}

		for (int i = 0; i < socios.size(); i++) {
			if (socios.get(i).getDni() == buscar) {
				socios.remove(i);
			}
		}

		this.actualizacion();
		this.imprimirActividadesTxt();
	}

	public void eliminarProfesor(int buscar) throws Exception {
		for (Actividad a : actividades) {
			for (int i = 0; i < a.getProfes().size(); i++) {
				if (a.getProfes().get(i).getCuil() == buscar) {
					a.getProfes().remove(i);
				}
			}
		}

		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getCuil() == buscar) {
				profesores.remove(i);
			}
		}

		this.actualizacion();
		this.imprimirActividadesTxt();
	}

	public void modificarProfesor(int cuil, String nombre, int buscar) throws Exception {

		// MODIFICACION EN EL PROGRMA
		for (Actividad a : actividades) {
			for (Profesor p : a.getProfes()) {
				if (p.getCuil() == buscar) {
					p.setCuil(cuil);
					p.setNombreCompleto(nombre);
				}
			}
		}

		for (Profesor p : profesores) {
			if (p.getCuil() == buscar) {
				p.setCuil(cuil);
				p.setNombreCompleto(nombre);
			}
		}
		// ----------------------------------------
		// MODIFCACION EN ARCHIVOS

		this.actualizacion();

	}

	public void modificarSocio(int dni, String nombre, int buscar) throws Exception {

		for (Actividad a : actividades) {
			for (Socio p : a.getSocios()) {
				if (p.getDni() == buscar) {
					p.setDni(dni);
					p.setNombreCompleto(nombre);
				}
			}
		}

		for (Socio s : socios) {
			if (s.getDni() == buscar) {
				s.setDni(dni);
				s.setNombreCompleto(nombre);
			}
		}

	

	}

	private void vaciarArchivos() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("basquet.txt"));
			out.write("");
			out.close();
			out = new BufferedWriter(new FileWriter("futbol.txt"));
			out.write("");
			out.close();
			out = new BufferedWriter(new FileWriter("handball.txt"));
			out.write("");
			out.close();
			out = new BufferedWriter(new FileWriter("futbol.txt"));
			out.write("");
			out.close();
			out = new BufferedWriter(new FileWriter("socios2.txt"));
			out.write("");
			out.close();
			out = new BufferedWriter(new FileWriter("profesores.txt"));
			out.write("");
			out.close();
			out = new BufferedWriter(new FileWriter("voley.txt"));
			out.write("");
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void imprimirActividadesTxt() {

		for (Actividad a : this.actividades) {

			switch (a.getCodigo()) {
			case 1:
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter("futbol.txt"));
					for (Socio s : a.socios) {
						String cad = "Socio" + ";" + s.getNombreCompleto() + ";" + s.getDni() + "\n";
						out.write(cad);
					}

					for (Profesor p : a.profes) {
						String cad = "Profesor" + ";" + p.getNombreCompleto() + ";" + p.getCuil() + "\n";
						out.write(cad);
					}

					out.close();
				} catch (IOException e) {

				}

			case 2:
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter("handball.txt"));
					for (Socio s : a.socios) {
						String cad = "Socio" + ";" + s.getNombreCompleto() + ";" + s.getDni() + "\n";
						out.write(cad);
					}

					for (Profesor p : a.profes) {
						String cad = "Profesor" + ";" + p.getNombreCompleto() + ";" + p.getCuil() + "\n";
						out.write(cad);
					}

					out.close();
				} catch (IOException e) {

				}

			case 3:
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter("basquet.txt"));
					for (Socio s : a.socios) {
						String cad = "Socio" + ";" + s.getNombreCompleto() + ";" + s.getDni() + "\n";
						out.write(cad);
					}

					for (Profesor p : a.profes) {
						String cad = "Profesor" + ";" + p.getNombreCompleto() + ";" + p.getCuil() + "\n";
						out.write(cad);
					}

					out.close();
				} catch (IOException e) {

				}

			case 4:
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter("voley.txt"));
					for (Socio s : a.socios) {
						String cad = "Socio" + ";" + s.getNombreCompleto() + ";" + s.getDni() + "\n";
						String cadA = "";
						if (cadA == cad) {
							cadA = cad;
						} else {
							out.write(cad);
						}
						cadA = cad;
					}

					for (Profesor p : a.profes) {
						String cad = "Profesor" + ";" + p.getNombreCompleto() + ";" + p.getCuil() + "\n";
						String cadA = "";
						if (cadA == cad) {
							cadA = cad;
						} else {
							out.write(cad);
							cadA = cad;
						}
					}

					out.close();
				} catch (IOException e) {

				}
			}

		}

	}

	public void leerTxtFutbol() {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("futbol.txt");
			br = new BufferedReader(fr);
			String cad = "";
			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");

				if (datos[0].startsWith("S")) {
					int dni = Integer.parseInt(datos[2]);
					String nombre = datos[1];
					Socio s = null;
					s = new Socio((int) dni, nombre);
					if (this.buscarActividad(1).socios.contains(s) == false) {
						this.buscarActividad(1).getSocios().add(s);
					} else {
						s = null;
					}

				} else {

					int cuil = Integer.parseInt(datos[2]);
					String nombreP = datos[1];
					Profesor p = new Profesor(cuil, nombreP);
					if (this.buscarActividad(1).profes.contains(p) == false) {
						this.buscarActividad(1).getProfes().add(p);
					} else {
						p = null;
					}
				}

			}
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerTxtHandball() {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("handball.txt");
			br = new BufferedReader(fr);
			String cad = "";
			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");

				if (datos[0].startsWith("S")) {
					int dni = Integer.parseInt(datos[2]);
					String nombre = datos[1];
					Socio s = null;
					s = new Socio((int) dni, nombre);
					if (this.buscarActividad(2).socios.contains(s) == false) {
						this.buscarActividad(2).getSocios().add(s);
					} else {
						s = null;
					}

				} else {

					int cuil = Integer.parseInt(datos[2]);
					String nombreP = datos[1];
					Profesor p = new Profesor(cuil, nombreP);
					if (this.buscarActividad(2).profes.contains(p) == false) {
						this.buscarActividad(2).getProfes().add(p);
					} else {
						p = null;
					}
				}

			}
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerTxtBasquet() {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("basquet.txt");
			br = new BufferedReader(fr);
			String cad = "";
			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");

				if (datos[0].startsWith("S")) {
					int dni = Integer.parseInt(datos[2]);
					String nombre = datos[1];
					Socio s = null;
					s = new Socio((int) dni, nombre);
					if (this.buscarActividad(3).socios.contains(s) == false) {
						this.buscarActividad(3).getSocios().add(s);
					} else {
						s = null;
					}

				} else {

					int cuil = Integer.parseInt(datos[2]);
					String nombreP = datos[1];
					Profesor p = new Profesor(cuil, nombreP);
					if (this.buscarActividad(3).profes.contains(p) == false) {
						this.buscarActividad(3).getProfes().add(p);
					} else {
						p = null;
					}
				}

			}
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerTxtVoley() {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("voley.txt");
			br = new BufferedReader(fr);
			String cad = "";
			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");

				if (datos[0].startsWith("S")) {
					int dni = Integer.parseInt(datos[2]);
					String nombre = datos[1];
					Socio s = null;
					s = new Socio((int) dni, nombre);
					if (this.buscarActividad(4).socios.contains(s) == false) {
						this.buscarActividad(4).getSocios().add(s);
					} else {
						s = null;
					}

				} else {

					int cuil = Integer.parseInt(datos[2]);
					String nombreP = datos[1];
					Profesor p = new Profesor(cuil, nombreP);
					if (this.buscarActividad(4).profes.contains(p) == false) {
						this.buscarActividad(4).getProfes().add(p);
					} else {
						p = null;
					}
				}

			}
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerTxtActividades() {
		this.leerTxtFutbol();
		this.leerTxtBasquet();
		this.leerTxtHandball();
		this.leerTxtVoley();
	}

	public void imprimirServicios() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("alquilerSalon.txt"));

			String cad = "Servicio" + ";" + this.buscarServicio(1).getNombre() + ";"
					+ this.buscarServicio(1).getCodigo() + "\n";
			out.write(cad);
			out.write(" reserva : \n");
			for (LocalDate f : this.buscarServicio(1).getFechas()) {
				cad = "f" + ";" + f.getYear() + "-" + f.getMonthValue() + "-" + f.getDayOfMonth() + "\n";
				out.write(cad);
			}
			out.close();
		} catch (IOException e) {

		}
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("alquilerCancha.txt"));

			String cad = "Servicio" + ";" + this.buscarServicio(2).getNombre() + ";"
					+ this.buscarServicio(2).getCodigo() + "\n";
			out.write(cad);
			out.write(" reserva: \n");
			for (LocalDate f : this.servicios.get(1).getFechas()) {
				cad = "f" + ";" + f.getYear() + "-" + f.getMonthValue() + "-" + f.getDayOfMonth() + "\n";
				out.write(cad);
			}
			out.close();
		} catch (IOException e) {

		}
	}

	public void leerServicios_cancha() {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("alquilerCancha.txt");
			br = new BufferedReader(fr);
			String cad = "";
			Servicio s = null;
			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");

				if (datos[0].startsWith("S")) {
					String nombre = datos[1];
					int codigo = Integer.parseInt(datos[2]);
					s = new Servicio(nombre, codigo);
				} else {
					if (datos[0].startsWith("f")) {
						String[] datosF = datos[1].split("-");
						int anio = Integer.parseInt(datosF[0]);
						int mes = Integer.parseInt(datosF[1]);
						int dia = Integer.parseInt(datosF[2]);
						LocalDate p = LocalDate.of(anio, mes, dia);
						s.getReservas().add(p);
						if (servicios.contains(s) == false) {
							this.servicios.add(s);
						} 
					}

				}

			}
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerServicios_salon() {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("alquilerSalon.txt");
			br = new BufferedReader(fr);
			String cad = "";
			Servicio s = null;
			while ((cad = br.readLine()) != null) {

				String[] datos = cad.split(";");

				if (datos[0].startsWith("S")) {
					String nombre = datos[1];
					int codigo = Integer.parseInt(datos[2]);
					s = new Servicio(nombre, codigo);
				} else {
					if (datos[0].startsWith("f")) {
						String[] datosF = datos[1].split("-");
						int anio = Integer.parseInt(datosF[0]);
						int mes = Integer.parseInt(datosF[1]);
						int dia = Integer.parseInt(datosF[2]);
						LocalDate p = LocalDate.of(anio, mes, dia);
						s.getReservas().add(p);
						if (servicios.contains(s) == false) {
							this.servicios.add(s);
						} else {
							s = s;
						}
					}

				}

			}
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
