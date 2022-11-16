import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InterfaceNovoFilme extends JFrame {
	private JButton bttAdicionar = new JButton("Adicionar");
	private JButton bttCancelar = new JButton("Cancelar");
	private JTextField tfTitulo = new JTextField();
	private JTextField tfSinopse = new JTextField();
	private JTextField tfProdutora = new JTextField();
	private JTextField tfAtorPrincipal = new JTextField();
	private JTextField tfEstilo = new JTextField();
	private JTextField tfDiretorio = new JTextField();
	private JLabel lblTitulo = new JLabel("Título");
	private JLabel lblSinopse = new JLabel("Sinopse");
	private JLabel lblProdutora = new JLabel("Produtora");
	private JLabel lblAtorPrincipal = new JLabel("Ator principal");
	private JLabel lblEstilo = new JLabel("Estilo");
	private JLabel lblDiretorio = new JLabel("Diretorio da imagem");
	private Font fonteLbl = new Font("Arial", Font.BOLD, 12);

	public void InterfaceNovoFilme1(AcoesFilmoteca filmoteca) {
		setLayout(null);

		bttAdicionar.setBounds(10, 310, 290, 40); // Posicao X, Poxicao Y, Largura, Altura
		bttCancelar.setBounds(310, 310, 290, 40);

		tfTitulo.setBounds(90, 10, 500, 30);
		tfSinopse.setBounds(90, 50, 500, 30);
		tfProdutora.setBounds(90, 90, 500, 30);
		tfAtorPrincipal.setBounds(90, 130, 500, 30);
		tfEstilo.setBounds(90, 170, 500, 30);
		tfDiretorio.setBounds(140, 210, 450, 30);

		lblTitulo.setBounds(10, 10, 80, 40);
		lblTitulo.setFont(fonteLbl);
		lblSinopse.setBounds(10, 50, 80, 40);
		lblSinopse.setFont(fonteLbl);
		lblProdutora.setBounds(10, 90, 80, 40);
		lblProdutora.setFont(fonteLbl);
		lblAtorPrincipal.setBounds(10, 130, 80, 40);
		lblAtorPrincipal.setFont(fonteLbl);
		lblEstilo.setBounds(10, 170, 40, 40);
		lblEstilo.setFont(fonteLbl);
		lblDiretorio.setBounds(10, 210, 120, 40);
		lblDiretorio.setFont(fonteLbl);

		bttAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfAtorPrincipal.getText().equals("") || tfEstilo.getText().equals("")
						|| tfTitulo.getText().equals("") || tfProdutora.getText().equals("")
						|| tfSinopse.getText().equals("") || tfDiretorio.getText().equals("")) {
					JOptionPane.showMessageDialog(InterfaceNovoFilme.this, "Todos os campos devem ser preenchidos");

				} else {
					filmoteca.insereFilme(tfTitulo.getText(), tfSinopse.getText(), tfProdutora.getText(),
							tfAtorPrincipal.getText(), tfEstilo.getText(), tfDiretorio.getText());
				}
			}
		});
		
		bttCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfacePrincipal().InterfacePrincipal1(filmoteca);
				
				dispose();				
			}
		});

		add(bttCancelar);
		add(bttAdicionar);
		add(tfTitulo);
		add(tfSinopse);
		add(tfProdutora);
		add(tfAtorPrincipal);
		add(tfEstilo);
		add(tfDiretorio);
		add(lblTitulo);
		add(lblSinopse);
		add(lblProdutora);
		add(lblAtorPrincipal);
		add(lblEstilo);
		add(lblDiretorio);

		setTitle("Sistema Filmoteca - Interface Principal");
		setSize(625, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

}
