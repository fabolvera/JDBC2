package net.tecgurus.jdbc2.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;

import net.tecgurus.jdbc2.dao.AlumnoDao;
import net.tecgurus.jdbc2.db.ConnectionFactory;

public class Menu {

	private int opcion;
	
	public void mostrarMenu() {
		System.out.println();
		System.out.println(" * * MENU ALUMNOS* * ");
		System.out.println("1 - Agregar");
		System.out.println("2 - Listar ");
		System.out.println("3 - Actualizar ");
		System.out.println("4 - Eliminar");
		System.out.println("5 - Salir");
		System.out.print("Ingrese una opcion del 1 al 5: ");
	}
	
	public String cleanDato(String teclado) {
		String temp = teclado.trim().toUpperCase();
		return temp;
		
	}
	public int cleanOpcion(String teclado) {
		int opc=0;
		if (teclado.trim().length()>0){
			String temp = teclado.trim().toLowerCase();	
			switch (temp) {
				case "1":				
					opc=1;
					break;
				case "2":				
					opc=2;
					break;
				case "3":				
					opc=3;
					break;
				case "4":				
					opc=4;
					break;
				case "5":				
					opc=5;				
					break;
			}
		}
		else {
			opc=0;
		}
		return opc;
	}
	
	public void setOpcion(String teclado) throws SQLException {				
            int opc = cleanOpcion(teclado);
			switch (opc) {
			case 1:				
				this.opcion=1;
				break;
			case 2:				
				this.opcion=2;
				break;
			case 3:				
				this.opcion=3;
				break;
			case 4:				
				this.opcion=4;
				break;
			case 5:				
				this.opcion=5;			
				break;
			case 0:				
				this.opcion=0;
				break;
			}
	}

	public int getOpcion() {
		return opcion;
	}
	
	public void agregar() throws SQLException, ClassNotFoundException {
		char genero='N';
		String nombre;
		String email;
		int edad;
		//System.out.println("Selecciono Agregar");
		Scanner in = new Scanner(System.in);	
		System.out.println("Ingresar el nombre: ");
		nombre =in.nextLine();			
		System.out.print("Ingresar el correo: ");
		email =in.nextLine();		
		System.out.print("Ingresar la edad: ");
		edad =in.nextInt();
		System.out.print("Ingresar genero M o F: ");
		//genero =sc.nextLine();	
		genero = in.next().charAt(0);			
				//System.out.println("Genero: " + genero);
				//Exception : Ingresar genero M o F: java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		in.close();
		Alumno alumno = new Alumno();
		alumno.setNombre(nombre);
		alumno.setEmail(email);
		alumno.setEdad(edad);
		alumno.setGenero(genero);
		System.out.println(alumno);			
		AlumnoDao alumnoDao = new AlumnoDao();	
		alumnoDao.agregar(alumno);
		
	}
	
	public void listar() throws SQLException, ClassNotFoundException {
		System.out.print("Selecciono Listar");		
		AlumnoDao alumnoDao = new AlumnoDao();
		List <Alumno> listAlummnos = new ArrayList<>();
		listAlummnos =alumnoDao.listar();
		for(Alumno alumno: listAlummnos) {
			System.out.println(alumno);
		}
	}
	
	public void eliminar() throws SQLException, ClassNotFoundException {
		System.out.println("Selecciono Eliminar");
		Scanner in = new Scanner(System.in);	
		System.out.println("Ingresar el ID del alumno a eliminar: ");
		int id =in.nextInt();
		in.close();		
		AlumnoDao alumnoDao = new AlumnoDao();
		alumnoDao.eliminar(id);		
	}
	
	public void actualizar() throws SQLException, ClassNotFoundException {
		//String genero;
				String nombre;
				String email;
				int edad;
				System.out.println("Selecciono Actualizar");
				Scanner in = new Scanner(System.in);	
				System.out.println("Ingresar el ID del alumno a actualizar: ");
				int id =in.nextInt();					
				System.out.println("Ingresar el nombre: ");
				nombre =in.nextLine();				
				System.out.print("Ingresar el correo: ");
				email =in.nextLine();
				System.out.print("Ingresar la edad: ");
				edad =in.nextInt();
				/*System.out.print("Ingresar genero M o F: ");		
					genero = sc.nextLine(); 
					if(genero !=null)
						alumno.setGenero(genero.charAt(0));
					else
						System.out.println("Genero: " + genero);
						Exception : Ingresar genero M o F: java.lang.StringIndexOutOfBoundsException: String index out of range: 0
				*/	
				AlumnoDao alumnoDao = new AlumnoDao();
				Alumno alumno = new Alumno();
				alumno.setId(id);
				alumno.setNombre(nombre);					
				alumno.setEmail(email);
				alumno.setEdad(edad);				
				System.out.println(alumno);		
				alumnoDao.actualizar(alumno);
				in.close();
		
		
	}
	public void salir(){
		System.out.print("  Adios :) ");
	}
}
