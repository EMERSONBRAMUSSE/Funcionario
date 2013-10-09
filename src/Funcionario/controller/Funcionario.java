package Funcionario.controller;

import java.util.List;

import Funcionario.model.Usuario;
import Funcionario.view.FuncionarioTela;

public class Funcionario {

	public List<Usuario> usuarios;
	int crivo;
	static UsuarioDao usuarioDao;
	static FuncionarioTela tela;
	boolean aux = true;

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		usuarioDao = new UsuarioDao();
		funcionario.usuarios = usuarioDao.getListar();
		funcionario.crivo = 0;
		tela = new FuncionarioTela("CADASTRO DE FUNCIONARIO", funcionario);

	}

	public Usuario gravar(Usuario u) {
		for (Usuario usuario : usuarios) {
			if (usuario.getId_Usuario() == u.getId_Usuario()) {
				usuario.setNome_Usuario(u.getNome_Usuario());
				usuario.setEndereco(u.getEndereco());
				usuario.setBairro(u.getBairro());
				usuario.setCpf(u.getCpf());
				usuario.setRg(u.getRg());
				return usuario;
			}
		}
		usuarioDao.adicionar(u);
		usuarios.add(u);
		crivo = usuarios.size();
		return new Usuario();

	}

	public Usuario proximo() {

		if ((crivo == 0 && aux == true)) {

			crivo = -1;
			crivo++;
			if (usuarios.isEmpty()) {
				crivo = 1;
				return new Usuario();
			}
			if (crivo >= usuarios.size())
				crivo = usuarios.size() - 1;
			aux = false;

			return usuarios.get(crivo);

		} else {

			crivo++;
			if (usuarios.isEmpty()) {
				crivo = 1;
				return new Usuario();
			}
			if (crivo >= usuarios.size())
				crivo = usuarios.size() - 1;
			return usuarios.get(crivo);
		}

	}

	public Usuario anterior() {

		crivo--;
		if (usuarios.isEmpty()) {
			crivo = 0;
			return new Usuario();
		}
		if (crivo <= 0)
			crivo = 0;
		return usuarios.get(crivo);

	}

	public Usuario apagar() {
		if (!usuarios.isEmpty()) {
			usuarioDao.excluir(usuarios.get(crivo));
			usuarios.remove(crivo);
		}
		return anterior();
	}

	public Usuario novo() {

		crivo = 0;
		aux = true;

		Usuario u = new Usuario("" + (maiorUsuario() + 1), "", "", "", "", "");

		return u;

	}

	private int maiorUsuario() {
		if (usuarios.isEmpty())
			return 0;
		return usuarios.get(usuarios.size() - 1).getId_Usuario();
	}

}
