package net.tecgurus.jdbc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.tecgurus.jdbc2.db.ConnectionFactory;
import net.tecgurus.jdbc2.model.Curso;

public class CursoDao {
	private final ConnectionFactory connectionFactory = new ConnectionFactory();

	public List<Curso> listar() throws SQLException, ClassNotFoundException {
		Connection connection = connectionFactory.conectar();
		List<Curso> listCursos = new ArrayList<>();
		if (connection != null) {
			String query = "SELECT * FROM cursos;";
			PreparedStatement select = connection.prepareStatement(query);
			ResultSet rs = select.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Curso curso = new Curso();
					curso.setId(rs.getInt("id"));
					curso.setNombre(rs.getString("nombre"));
					listCursos.add(curso);
				}
				rs.close();
			}
			select.close();
			// connection.close();
		}
		return listCursos;
	}

	public Curso traerPorId(int id) throws SQLException, ClassNotFoundException {
		Connection connection = connectionFactory.conectar();
		Curso curso = new Curso(); // - DUDA - si li declaro aqui afuera y no se encuentra el id en la base
									// devuelve un objeto null
		if (connection != null) {
			String query = "SELECT * FROM cursos where id =?;";
			PreparedStatement select = connection.prepareStatement(query);
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					curso.setId(rs.getInt("id"));
					curso.setNombre(rs.getString("nombre"));
				}
				rs.close();
			}
			select.close();
			// connection.close();
		}
		return curso;
	}

	public void agregar(Curso curso) throws SQLException, ClassNotFoundException {
		Connection connection = connectionFactory.conectar();

		if (connection != null) {
			String query = "INSERT INTO cursos (nombre) VALUES(?);";
			PreparedStatement insert = connection.prepareStatement(query);
			insert.setString(1, curso.getNombre());
			insert.executeUpdate(); // se usa para insert, update,delete
			insert.close();
			// connection.close();
		}
	}

	public void eliminar(int id) throws ClassNotFoundException, SQLException {
		Connection connection = connectionFactory.conectar();
		if (connection != null) {
			String query = "DELETE FROM cursos where id = ? ";
			PreparedStatement delete = connection.prepareStatement(query);
			delete.setInt(1, id);
			delete.executeUpdate(); // se usa para insert, update,delete
			delete.close();
			// connection.close();
		}
	}

	public void actualizar(Curso curso) throws ClassNotFoundException, SQLException {
		Connection connection = connectionFactory.conectar();
		if (connection != null) {
			// System.out.println(curso);
			String query = "UPDATE cursos SET nombre = ? WHERE id = ? ";
			PreparedStatement update = connection.prepareStatement(query);
			update.setString(1, curso.getNombre());
			update.setInt(2, curso.getId());
			update.executeUpdate(); // se usa para insert, update,delete
			update.close();
			// connection.close();
		}

	}
}
