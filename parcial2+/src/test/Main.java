package test;

import java.time.LocalDateTime;

import models.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Sistema s = new Sistema();
System.out.println("test 1");
try {
	s.agregarArticulo("art1", 100, new DescuentoPorCantidad(true, 3, 1));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	s.agregarArticulo("art2", 150, new DescuentoPorCantidad(true, 5, 2));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	s.agregarArticulo("art3", 200, new DescuentoPorSubTotal(false, 500, 50));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	s.agregarArticulo("art4", 500, new DescuentoPorSubTotal(true, 1000, 50));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

System.out.println(s.getArticulos());


System.out.println("test 2");

try {
	s.agregarArticulo("art1", 100, new DescuentoPorCantidad(true, 3, 1));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

	}
System.out.println("test 3");

	try {
		s.agregarCompra(6, s.traerArticulo("art1"), LocalDateTime.of(2023,10,20, 9,0));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		s.agregarCompra(5, s.traerArticulo("art2"), LocalDateTime.of(2023,10,20, 9,30));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		s.agregarCompra(10, s.traerArticulo("art2"), LocalDateTime.of(2023,10,20, 10,0));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		s.agregarCompra(3, s.traerArticulo("art3"), LocalDateTime.of(2023,10,20, 10,30));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		s.agregarCompra(4, s.traerArticulo("art4"), LocalDateTime.of(2023,10,20, 11,0));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(s.getCompras());
	System.out.println("test 4");
	
	try {
		s.agregarCompra(0, s.traerArticulo("art1"), LocalDateTime.of(2023,10,20, 9,0));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("test 5");
	System.out.println(s.getCompras().get(2).precioTotal());
	System.out.println(s.getCompras().get(3).precioTotal());
	System.out.println(s.getCompras().get(4).precioTotal());
	System.out.println("test 6");
	
	System.out.println(s.traerCompras(LocalDateTime.of(2023,10,20,9,15), LocalDateTime.of(2023,10,20,10,30)));
	
System.out.println("test 7");
	
	System.out.println(s.traerComprasDescuentoPorCantidad(LocalDateTime.of(2023,10,20,9,15), LocalDateTime.of(2023,10,20,10,30)));
	
	System.out.println("test 8");
	System.out.println(s.traerArticulosConDescuento(true));
	
	
}
}
