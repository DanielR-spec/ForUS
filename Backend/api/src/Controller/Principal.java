package Controller;

import java.sql.SQLException;

import Conection.BD;
import Model.Usuario;
import Model.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BD miConexion = new BD();
		String respuesta = miConexion.conectar();
		System. out. println(respuesta);
		
		Usuario usuarioPrueba = new Usuario();
		usuarioPrueba.setId(3);
		usuarioPrueba.setName("juan");
		usuarioPrueba.setEmail("jrsandovalb@hotmailcom");
		usuarioPrueba.setPassword("juanito67");
		//usuarioPrueba.setPhone("3163122315");
		
		UsuarioDAO dao = new UsuarioDAO();
		/*try {
			String rta = dao.registrarUsuario(usuarioPrueba);
			System. out. println(rta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}*/
		/*
		int idSearch = 1;
		try {
			Usuario resultado = dao.buscarUsuario(idSearch);
			System. out. println(resultado.getId() + resultado.getName() + resultado.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String correoEliminar = "b";
		try {
			dao.eliminarUsuario(correoEliminar);
			System. out. println("Eliminado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario usuarioActualizar = new Usuario();
		usuarioActualizar.setId(1);
		usuarioActualizar.setName("alejandra");
		usuarioActualizar.setEmail("malejasl062014@gmail.com");
		usuarioActualizar.setPassword("mimundo");
		usuarioActualizar.setPhone("3168670976");
		
		/*try {
			dao.actualizarUsuario(usuarioActualizar);
			System. out. println("Actualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
