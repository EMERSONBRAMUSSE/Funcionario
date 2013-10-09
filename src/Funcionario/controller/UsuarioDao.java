package Funcionario.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Funcionario.model.Usuario;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void excluir(Usuario usuario) {
		String sql = "delete from usuario where id_Usuario = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getId_Usuario());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adicionar(Usuario usuario) {
		String sql = "insert into usuario "
				+ "(id_Usuario, nome_Usuario, endereco, bairro, cpf, rg) "
				+ "values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getId_Usuario());
			stmt.setString(2, usuario.getNome_Usuario());
			stmt.setString(3, usuario.getEndereco());
			stmt.setString(4, usuario.getBairro());
			stmt.setString(5, usuario.getCpf());
			stmt.setString(6, usuario.getRg());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getListar() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from usuario");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setId_Usuario(rs.getInt("id_Usuario"));
				usuario.setNome_Usuario(rs.getString("nome_Usuario"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setRg(rs.getString("rg"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
