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
import net.tecgurus.jdbc2.model.Curso;

class ConnectionFactoryCursoTest {

	/* Con este metodo voy a probar mi funcion de conactar y Curso
	 * Seleccionar el nombre del metodo y Clic derecho, Run As JUnit Test
	 * 
	 */
	
	@Test  //Indica que es para prueba y lo pueda ejecutar con JUnit*/
	public void conectar() throws SQLException {
		//System.out.println("Hola Test JUnit Curso");
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
			 String query ="INSERT INTO cursos (nombre) "
			 		+ "VALUES(?);";
			 PreparedStatement insert = connection.prepareStatement(query);
			 insert.setString(1, "PHYTON");
			 insert.executeUpdate(); //se usa para insert, update,delete			 
			 insert.close();			 
		 }
		 else {
			 System.out.println("Error al conectarme :c");
		 }
	}
	
	@Test
	public void select() throws SQLException{
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf. conectar();
		List<Curso> listCursos = new ArrayList<>();
		if(connection != null) {
			String query = "SELECT * FROM cursos;";
			PreparedStatement select = connection.prepareStatement(query);
			ResultSet rs = select.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Curso curso=new Curso();
					curso.setId(rs.getInt("id"));
					curso.setNombre(rs.getString("nombre"));
					listCursos.add(curso);					
				}
				System.out.println(listCursos);
			}
		}
	}
	
	@Test
	public void delete() throws SQLException{
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		if(connection != null) {
			String query = "DELETE FROM cursos where id = ?";
			PreparedStatement delete = connection.prepareStatement(query);
			delete.setInt(1, 5);
			delete.executeUpdate();
			delete.close();
		}
		else {
			System.out.println("Error al conectarme :c ");
		}
	}
	
	@Test
	public void update() throws SQLException{
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		if(connection !=null) {
			String query = "UPDATE cursos SET nombre = ? where id = ? ";
			PreparedStatement update = connection.prepareStatement(query);
			update.setString(1, "JAVASCRIPT");
			update.setInt(2, 3);
			update.executeUpdate();
			update.close();
		}
	}

}
