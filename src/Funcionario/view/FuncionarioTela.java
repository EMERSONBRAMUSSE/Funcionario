package Funcionario.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Funcionario.controller.Funcionario;
import Funcionario.model.Usuario;

public class FuncionarioTela extends JFrame implements ActionListener {

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	Usuario u = new Usuario();

	Funcionario controller;

	JLabel id_UsuarioLb;
	public JTextField id_UsuarioTf;

	JLabel nome_UsuarioLb;
	public JTextField nome_UsuarioTf;

	JLabel enderecoLb;
	public JTextField enderecoTf;

	JLabel bairroLb;
	public JTextField bairroTf;

	JLabel cpfLb;
	public JTextField cpfTf;

	JLabel rgLb;
	public JTextField rgTf;

	JButton gravarBt;
	JButton apagarBt;
	JButton proximoBt;
	JButton anteriorBt;
	JButton novoBt;

	public FuncionarioTela(String titulo, Funcionario controller) {
		super(titulo);
		this.controller = controller;
		id_UsuarioLb = new JLabel("ID: ");
		id_UsuarioTf = new JTextField();
		id_UsuarioTf.setEnabled(false);
		id_UsuarioTf.setText("");

		nome_UsuarioLb = new JLabel("NOME: ");
		nome_UsuarioLb.setToolTipText("DIGITE O NOME!");
		nome_UsuarioTf = new JTextField();
		nome_UsuarioTf.addActionListener(this);

		enderecoLb = new JLabel("ENDERECO: ");
		enderecoLb.setToolTipText("DIGITE O ENDEREÇO!");
		enderecoTf = new JTextField();
		enderecoTf.addActionListener(this);

		bairroLb = new JLabel("BAIRRO: ");
		bairroLb.setToolTipText("DIGITE O BAIRRO!");
		bairroTf = new JTextField();
		bairroTf.addActionListener(this);

		cpfLb = new JLabel("CPF: ");
		cpfLb.setToolTipText("DIGITE O CPF!");
		cpfTf = new JTextField();
		cpfTf.addActionListener(this);

		rgLb = new JLabel("RG: ");
		rgLb.setToolTipText("DIGITE O RG!");
		rgTf = new JTextField();
		rgTf.addActionListener(this);

		gravarBt = new JButton("SALVAR");
		gravarBt.addActionListener(this);

		apagarBt = new JButton("EXCLUIR");
		apagarBt.addActionListener(this);

		anteriorBt = new JButton("<");
		anteriorBt.addActionListener(this);

		proximoBt = new JButton(">");
		proximoBt.addActionListener(this);

		novoBt = new JButton("NOVO");
		novoBt.addActionListener(this);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(8, 2, 5, 5));

		c2.add(id_UsuarioLb);
		c2.add(id_UsuarioTf);
		c2.add(nome_UsuarioLb);
		c2.add(nome_UsuarioTf);
		c2.add(enderecoLb);
		c2.add(enderecoTf);
		c2.add(bairroLb);
		c2.add(bairroTf);
		c2.add(cpfLb);
		c2.add(cpfTf);
		c2.add(rgLb);
		c2.add(rgTf);

		c2.add(anteriorBt);
		c2.add(proximoBt);
		c2.add(gravarBt);
		c2.add(apagarBt);

		c.add(BorderLayout.SOUTH, (novoBt));
		c.add(BorderLayout.CENTER, c2);

		setResizable(false);
		setLocation(400, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);// resolução do programa;
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(anteriorBt)) {
			anterior();
		} else if (e.getSource().equals(proximoBt)) {
			proximo();
		} else if (e.getSource().equals(gravarBt)) {
			gravar();
		} else if (e.getSource().equals(apagarBt)) {
			apagar();
		} else if (e.getSource().equals(novoBt)) {
			novo();
		}

	}

	private void novo() {

		desenhar(controller.novo());

	}

	private void apagar() {

		if (nome_UsuarioTf.getText().trim().isEmpty()) {

		} else {

			desenhar(controller.apagar());

			id_UsuarioTf.setText("");
			nome_UsuarioTf.setText("");
			enderecoTf.setText("");
			bairroTf.setText("");
			cpfTf.setText("");
			rgTf.setText("");

		}

	}

	private void gravar() {

		if ((nome_UsuarioTf.getText().trim().isEmpty())) {

		} else if ((enderecoTf.getText().trim().isEmpty())) {

		} else if ((bairroTf.getText().trim().isEmpty())) {

		} else if ((cpfTf.getText().trim().isEmpty())) {

		} else if ((rgTf.getText().trim().isEmpty())) {

		} else {

			Usuario u = new Usuario(id_UsuarioTf.getText(),
					nome_UsuarioTf.getText(), enderecoTf.getText(),
					bairroTf.getText(), cpfTf.getText(), rgTf.getText());
			desenhar(controller.gravar(u));

			id_UsuarioTf.setText("");
			nome_UsuarioTf.setText("");
			enderecoTf.setText("");
			bairroTf.setText("");
			cpfTf.setText("");
			rgTf.setText("");

		}

	}

	private void proximo() {

		if (controller.usuarios.size() == 0) {

		} else {

			desenhar(controller.proximo());
		}
	}

	private void anterior() {

		if (nome_UsuarioTf.getText().trim().isEmpty()) {

		} else {

			desenhar(controller.anterior());
		}
	}

	public void desenhar(Usuario u) {
		id_UsuarioTf.setText("" + u.getId_Usuario());
		nome_UsuarioTf.setText(u.getNome_Usuario());
		enderecoTf.setText(u.getEndereco());
		bairroTf.setText(u.getBairro());
		cpfTf.setText("" + u.getCpf());
		rgTf.setText("" + u.getRg());

	}

}
