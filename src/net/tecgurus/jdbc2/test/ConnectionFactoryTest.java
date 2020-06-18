package net.tecgurus.jdbc2.test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import net.tecgurus.jdbc2.db.ConnectionFactory;
import net.tecgurus.jdbc2.model.Alumno;

class ConnectionFactoryTest {
	/* Con este metodo voy a probar mi funcion de conactar
	 * Clic derecho, Run As JUnit Test
	 * 
	 */
	
	@Test  //Indica que es para prueba y lo pueda ejecutar con JUnit*/
	public void conectar() throws SQLException {
		//System.out.println("Hola Test JUnit");
		ConnectionFactory conecctionFactory = new ConnectionFactory();
			 Connection connection = conecctionFactory.conectar();
			 if(connection != null) {
				 System.out.println("Conexion establecida!");
			 }
			 /*
			 else {
				 System.out.println("Error al conectarme :c");
			 }*/		
	}
	@Test
	public void insert () throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		 if(connection != null) {
			 String query ="INSERT INTO alumnos (nombre,email,edad,genero) "
			 		+ "VALUES(?,?,?,?);";
			 PreparedStatement insert = connection.prepareStatement(query);
			 insert.setString(1, "Paty");
			 insert.setString(2, "paty@gmail.com");
			 insert.setInt(3, 30);
			 insert.setString(4, "F");
			 insert.executeUpdate(); //se usa para insert, update,delete
			 
			 insert.close();
			 //connection.close();
			 
		 }
		 else {
			 System.out.println("Error al conectarme :c");
		 }
	}
	
	@Test
	public void select() throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		List<Alumno> listAlumnos = new ArrayList<>();
		if(connection != null) {
			String query = "SELECT * FROM alumnos;";
			PreparedStatement select = connection.prepareStatement(query);
			ResultSet rs = select.executeQuery();  //regresa un objeto de resulset
			if(rs != null) {
				while(rs.next()) {
					//lo que se recibe hay que almacenarlo en un listado
					Alumno alumno= new Alumno();
					alumno.setId(rs.getInt("id"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setEmail(rs.getString("email"));
					alumno.setEdad(rs.getInt("edad"));
					alumno.setGenero(rs.getString("genero").charAt(0));
					
					listAlumnos.add(alumno);
				}
				
				System.out.println(listAlumnos);
				
				for (Alumno alumno:listAlumnos) {
					System.out.println(alumno);
				}
			}
			
		}
	}
	
	@Test
	public void delete () throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		 if(connection != null) {
			 String query ="DELETE FROM alumnos where id = ? ";
			 PreparedStatement delete = connection.prepareStatement(query);
			 delete.setInt(1, 8);
			 delete.executeUpdate(); //se usa para insert, update,delete
			 delete.close();
			 //connection.close();			 
		 }
		 else {
			 System.out.println("Error al conectarme :c");
		 }
	}

	@Test
	public void update () throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		 if(connection != null) {
			 String query ="UPDATE alumnos SET nombre = ?, email = ?, edad = ?, genero=? where id = ? ";
			 PreparedStatement update = connection.prepareStatement(query);
			 update.setString(1, "Patricia");
			 update.setString(2, "patricia@gmail.com");
			 update.setInt(3, 38);
			 update.setString(4, "F");
			 update.setInt(5, 9);
			 update.executeUpdate(); //se usa para insert, update,delete
			 update.close();
			 //connection.close();			 
		 }
		 else {
			 System.out.println("Error al conectarme :c");
		 }
	}
	
	//hacer el metodo test para update y delete
	//tabla cursos id (primary key) y nombre texto 50
	//operaciones CRUD cursos
	//que es una llave foranea
	
	//Tarea 2 
	//Como obtener informacion del usuario por consola   Scanner
}
