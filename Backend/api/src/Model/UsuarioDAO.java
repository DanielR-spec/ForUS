package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Conection.BD;

public class UsuarioDAO {
	
	Connection connection = null;
	BD conexion = null;
	PreparedStatement preStatement = null;
	
	private String conectar() {
		conexion = new BD();
		String resultado = conexion.conectar();
		if (resultado.equals("conectado")) {
			connection = conexion.getConnection();
			
		}else {
			JOptionPane.showMessageDialog(null, resultado,"Error",JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}
	
	public String registrarUsuario(Usuario usuario) throws SQLException {
		String resultado = "";
		if (!conectar().equals("conectado")) {
			return "error";
		}
		
		String consulta = "INSERT INTO usuario (idusuario, nombres, apellidos, username, password)"
				+ "  VALUES (2,aa,bb,cc,dd)";
		try {
			
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, usuario.getId());
			preStatement.setString(2, usuario.getName());
			preStatement.setString(3,usuario.getEmail());
			preStatement.setString(4,usuario.getPassword());
			preStatement.setString(5,usuario.getPhone());
			preStatement.execute();
			
			resultado = "El usuario se registro exitosamente";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo registrar el estudiante, verifique que el documento no exista: " + e.getMessage());
			resultado = "error";
		}
		finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		
		
		return resultado;
		
	}
	
	public Usuario buscarUsuario(int id) throws SQLException {
		Usuario usuarioPedido = null;
		if (!conectar().equals("conectado")) {
			return usuarioPedido;
		}
		
		ResultSet result = null;	
		String consulta = "SELECT idusuario, nombres, apellidos, username"
		+ " FROM usuario WHERE idusuario = ?";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setInt(1, id);
			result = preStatement.executeQuery();
			
			if(result.next()){
				usuarioPedido = new Usuario();
				usuarioPedido.setId(result.getInt("idusuario"));
				usuarioPedido.setName(result.getString("nombres"));
				usuarioPedido.setEmail(result.getString("apellidos"));
				//usuarioPedido.setPassword(result.getString("username"));
				//usuarioPedido.setPhone(result.getString("phone"));
				
			}	
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		finally {
			
			result.close();
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		return usuarioPedido;
		
		
	}
	
	
	/*public String actualizarUsuario(Usuario usuario) throws SQLException {
		String resultado = "";
		if (!conectar().equals("conectado")) {
			return "error";
		}
		
		
		String consulta="UPDATE users "
				+ "SET id = ? , "
				+ "name = ? , "
				+ "email = ? , "
				+ "password = ? , "
				+ "phone = ?  "
				+ "WHERE email = ?;";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, usuario.getId());
			preStatement.setString(2, usuario.getName());
			preStatement.setString(3,usuario.getEmail());
			preStatement.setString(4,usuario.getPassword());
			preStatement.setString(5,usuario.getPhone());
			preStatement.execute();
			resultado = "ok me actualice";
		} 
		catch (SQLException e) {
			System.out.println("Ocurrió una excepcion de SQL "
            		+ "al momento de actualizar: "+e);
			resultado = "error";
		}
		finally {
			
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		
		return resultado;
	}*/
	
	public String eliminarUsuario(String correo) throws SQLException {
		String resultado = "";
		if (!conectar().equals("conectado")) {
			return "error";
		}
		
		String consulta = "DELETE FROM usuario WHERE email = c ";
		
		PreparedStatement statement;
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, correo);
			preStatement.executeUpdate();
			resultado = "Se elimino el usuario";
		} catch (SQLException e) {
			System.out.println("Ocurrió una excepcion de SQL "
            		+ "al momento de eliminar "+e);
			resultado="error";
		}
		finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		
		return "Usuario eliminado";
	}

}
