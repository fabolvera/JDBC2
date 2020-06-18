package net.tecgurus.jdbc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.tecgurus.jdbc2.db.ConnectionFactory;
import net.tecgurus.jdbc2.model.Alumno;


public class AlumnoDao {
private final ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public List<Alumno> listar() throws SQLException, ClassNotFoundException{
		Connection connection = connectionFactory.conectar(); 
		List<Alumno> listAlumnos = new ArrayList<>(); 
		if(connection != null) {
			String query = "SELECT * FROM alumnos;";
			PreparedStatement select = connection.prepareStatement(query);
			ResultSet rs = select.executeQuery();
			if(rs!=null) {
				while (rs.next()) {
					Alumno alumno = new Alumno();
					alumno.setId(rs.getInt("id"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setEmail(rs.getString("email"));
					alumno.setEdad(rs.getInt("edad"));
					String genero = rs.getString("genero");
					if(genero!=null) {
						alumno.setGenero(genero.charAt(0));
					}
					listAlumnos.add(alumno);					
				}rs.close();
			}
			select.close();
			connection.close();							
		}		
		return listAlumnos;
	}
	
	public Alumno traerPorId(int id) throws SQLException, ClassNotFoundException{
		Connection connection = connectionFactory.conectar(); 
		Alumno alumno = new Alumno(); // - DUDA - si li declaro aqui afuera y no se encuentra el id en la base devuelve un objeto null
		if(connection != null) {
			String query = "SELECT * FROM alumnos where id =?;";
			PreparedStatement select = connection.prepareStatement(query);
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			if(rs!=null) {
				while (rs.next()) {
					//Alumno alumno = new Alumno();
					alumno.setId(rs.getInt("id"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setEmail(rs.getString("email"));
					alumno.setEdad(rs.getInt("edad"));
					String genero = rs.getString("genero");
					if(genero!=null) {
						alumno.setGenero(genero.charAt(0));
					}									
				}
				rs.close();
			}
			select.close();
			//connection.close();	
		}
		return alumno;
	}
	
	public void agregar(Alumno alumno) throws SQLException, ClassNotFoundException {
		Connection connection = connectionFactory.conectar(); 		
		if(connection != null) {
			String query ="INSERT INTO alumnos (nombre,email,edad,genero) VALUES(?,?,?,?);";
			 PreparedStatement insert = connection.prepareStatement(query);
			 insert.setString(1, alumno.getNombre());
			 insert.setString(2, alumno.getEmail());
			 insert.setInt(3, alumno.getEdad());
			 String genero = String.valueOf(alumno.getGenero()); 
			 insert.setString(4, genero);			 
			 insert.executeUpdate(); //se usa para insert, update,delete			 
			 insert.close();
			 //connection.close();
		}		
	}
	
	public void eliminar (int id) throws ClassNotFoundException, SQLException {
		Connection connection = connectionFactory.conectar(); 		
		if(connection != null) {
			 String query ="DELETE FROM alumnos where id = ? ";
			 PreparedStatement delete = connection.prepareStatement(query);
			 delete.setInt(1, id);
			 delete.executeUpdate(); //se usa para insert, update,delete
			 delete.close();
			 //connection.close();
		}
	}
	
	public void actualizar (Alumno alumno) throws ClassNotFoundException, SQLException {
		Connection connection = connectionFactory.conectar(); 		
		if(connection != null) {
			 String query ="UPDATE alumnos SET nombre = ?, email = ?, edad = ?, genero=? where id = ? ";
			 PreparedStatement update = connection.prepareStatement(query);
			 update.setString(1, alumno.getNombre());
			 update.setString(2, alumno.getEmail());
			 update.setInt(3, alumno.getEdad());
			 String genero = String.valueOf(alumno.getGenero()); 
			 update.setString(4, genero);
			 update.setInt(5, alumno.getId());
			 update.executeUpdate(); //se usa para insert, update,delete
			 update.close();
			 //connection.close();
		}
		
	}
}
