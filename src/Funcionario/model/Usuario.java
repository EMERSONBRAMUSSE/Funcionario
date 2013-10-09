package Funcionario.model;

import com.mysql.jdbc.Connection;

public class Usuario {

	int id_Usuario;
	String nome_Usuario;
	String endereco;
	String bairro;
	String cpf;
	String rg;

	public Usuario() {

	};

	public Usuario(String id_Usuario, String nome_Usuario, String endereco,
			String bairro, String cpf, String rg) {
		this.id_Usuario = new Integer(id_Usuario);
		this.nome_Usuario = nome_Usuario;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cpf = cpf;
		this.rg = rg;

	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getNome_Usuario() {
		return nome_Usuario;
	}

	public void setNome_Usuario(String nome_Usuario) {
		this.nome_Usuario = nome_Usuario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Connection getConexao() {
		// TODO Auto-generated method stub
		return null;
	}

}
