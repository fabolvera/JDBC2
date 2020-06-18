package net.tecgurus.jdbc2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import net.tecgurus.jdbc2.model.Alumno;
import net.tecgurus.jdbc2.model.Curso;

public class ConnectionFactory {
	//Objeto global Connection
	private Connection connection;
	
	public Connection conectar() throws SQLException {
		//Paso 1 : Asignar los parametros de conexion
		//Para version mysqlserver 5
		String url = "jdbc:mysql://localhost:3306/SchoolManager";
		//Ejemplo para vesion mysql 8
		//String url = "jdbc:mysql://localhost:3306/SchoolManager?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "12345678";  // esto no se hace en produccion
	
		//PASO 2: CREAR LA CONEXION
		connection = DriverManager.getConnection(url,user,password);
		return connection;
	}
	/*
	public static void insert () throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		 if(connection != null) {
			 String query ="INSERT INTO cursos (nombre) "
			 		+ "VALUES(?);";
			 PreparedStatement insert = connection.prepareStatement(query);
			 insert.setString(1, "PYTHON");			 
			 int resp = insert.executeUpdate(); //se usa para insert, update,delete
		     if (resp > 0) {
		        System.out.println("Registro insertado");
		     }
		     else {
			    	System.out.println("No se pudo agregar");
			    }
			 insert.close();			 
		 }
		 else {
			 System.out.println("Error al conectarme :c");
		 }
	}
	

	public static void select() throws SQLException{
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
				//System.out.println(listCursos);
				for (Curso curso:listCursos) {
					System.out.println(curso);
				}
			}
		}
	}

	public static void delete() throws SQLException{
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		if(connection != null) {
			String query = "DELETE FROM cursos where id = ?";
			PreparedStatement delete = connection.prepareStatement(query);
			delete.setInt(1, 9);
			int resp = delete.executeUpdate(); //se usa para insert, update,delete
		    if (resp > 0) {
		        System.out.println("Registro eliminado");
		     }
		    else {
		    	System.out.println("No se pudo eliminar");
		    }
			delete.close();
		}
		else {
			System.out.println("Error al conectarme :c ");
		}
	}

	public static void update() throws SQLException{
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.conectar();
		if(connection !=null) {
			String query = "UPDATE cursos SET nombre = ? where id = ? ";
			PreparedStatement update = connection.prepareStatement(query);
			update.setString(1, "PHYTON");
			update.setInt(2, 6);
			int resp = update.executeUpdate(); //se usa para insert, update,delete
		    if (resp > 0) {
		        System.out.println("Registro actualizado");
		    }
			update.close();
		}
	}*/
}
