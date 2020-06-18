package net.tecgurus.jdbc2.model;

public class Alumno {
	private int id;
    private String nombre;
    private String email;
    private int edad;
    private char genero;
    
    public Alumno() {
	}
	
    public Alumno(int id, String nombre, String email, int edad, char genero) {

		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.genero = genero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", email=" + email + ", edad=" + edad + ", genero=" + genero
				+ "]";
	}
    
	
    

}
