import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class InterfacePrincipal extends JFrame {
	private JButton bttAnterior = new JButton("Anterior");
	private JButton bttProximo = new JButton("Próximo");
	private JButton bttExcluir = new JButton("Exlusão");
	private JButton bttAdicionar = new JButton("Novo");
	private JTextField tfTitulo = new JTextField();
	private JTextField tfSinopse = new JTextField();
	private JTextField tfProdutora = new JTextField();
	private JTextField tfAtorPrincipal = new JTextField();
	private JTextField tfEstilo = new JTextField();
	private JLabel lblTitulo = new JLabel("Título");
	private JLabel lblSinopse = new JLabel("Sinopse");
	private JLabel lblProdutora = new JLabel("Produtora");
	private JLabel lblAtorPrincipal = new JLabel("Ator principal");
	private JLabel lblEstilo = new JLabel("Estilo");
	private JLabel lblTipoNavegacao = new JLabel("Navegação");
	private JLabel lblCapa;
	private JRadioButton rbnTitulo = new JRadioButton("Por título", true);
	private JRadioButton rbnAtorPrincipal = new JRadioButton("Por ator principal", false);
	private JRadioButton rbnEstilo = new JRadioButton("Por estilo", false);
	private ButtonGroup bgTipoOrdem = new ButtonGroup();
	private JScrollPane scrollSinopse = new JScrollPane(tfSinopse);
	private ImageIcon capa = new ImageIcon();
	private Font fonteLbl = new Font("Arial", Font.BOLD, 12);
	private Filme filme = new Filme();
	private AcoesFilmoteca addFilme;

	public void InterfacePrincipal1(AcoesFilmoteca filmoteca) {

		setLayout(null);

		this.addFilme = filmoteca;

		bttAnterior.setBounds(10, 310, 140, 40); // Posicao X, Poxicao Y, Largura, Altura
		bttExcluir.setBounds(160, 310, 140, 40);
		bttAdicionar.setBounds(310, 310, 140, 40);
		bttProximo.setBounds(460, 310, 140, 40);

		tfTitulo.setBounds(310, 10, 290, 30);
		tfTitulo.setEditable(false);
		tfSinopse.setBounds(310, 60, 290, 30);
		tfSinopse.setEditable(false);
		tfProdutora.setBounds(310, 110, 290, 30);
		tfProdutora.setEditable(false);
		tfAtorPrincipal.setBounds(310, 150, 290, 30);
		tfAtorPrincipal.setEditable(false);
		tfEstilo.setBounds(310, 190, 290, 30);
		tfEstilo.setEditable(false);
		
		scrollSinopse.setPreferredSize(new Dimension(50,50));
		scrollSinopse.setBounds(310,50,290,50);

		lblTitulo.setBounds(270, 10, 80, 40);
		lblTitulo.setFont(fonteLbl);
		lblSinopse.setBounds(255, 60, 80, 40);
		lblSinopse.setFont(fonteLbl);
		lblProdutora.setBounds(245, 110, 80, 40);
		lblProdutora.setFont(fonteLbl);
		lblAtorPrincipal.setBounds(225, 150, 80, 40);
		lblAtorPrincipal.setFont(fonteLbl);
		lblEstilo.setBounds(270, 190, 40, 40);
		lblEstilo.setFont(fonteLbl);
		lblTipoNavegacao.setBounds(240, 240, 80, 40);
		lblTipoNavegacao.setFont(fonteLbl);

		lblCapa = new JLabel();
		lblCapa.setBounds(10, 10, 200, 250);

		rbnTitulo.setBounds(310, 235, 80, 20);
		rbnAtorPrincipal.setBounds(395, 235, 130, 20);
		rbnEstilo.setBounds(310, 255, 100, 40);

		bgTipoOrdem.add(rbnTitulo);
		bgTipoOrdem.add(rbnAtorPrincipal);
		bgTipoOrdem.add(rbnEstilo);

		add(bttAnterior);
		add(bttProximo);
		add(bttExcluir);
		add(bttAdicionar);
		add(tfTitulo);
		add(tfProdutora);
		add(tfAtorPrincipal);
		add(tfEstilo);
		add(scrollSinopse);
		add(lblTitulo);
		add(lblSinopse);
		add(lblProdutora);
		add(lblAtorPrincipal);
		add(lblEstilo);
		add(lblTipoNavegacao);
		add(lblCapa);
		add(rbnTitulo);
		add(rbnAtorPrincipal);
		add(rbnEstilo);

		setTitle("Sistema Filmoteca - Interface Principal");
		setSize(625, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		this.pegaPrimeiroFilme();

		bttProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(rbnTitulo.isSelected()) {
					if(filme.getProxTitulo() == null) {
						JOptionPane.showMessageDialog(null, "Vai com calme! Esse é o último filme da lista.");
					
					}else {
						filme = filme.getProxTitulo();

						tfTitulo.setText(filme.getNome());
						tfSinopse.setText(filme.getSinopse());
						tfAtorPrincipal.setText(filme.getAtorPrincipal());
						tfEstilo.setText(filme.getEstilo());
						tfProdutora.setText(filme.getProdutora());

						capa = new ImageIcon(this.getClass().getResource(filme.getDirCapa()));
						lblCapa.setIcon(capa);
					}
					
				}
				
				if(rbnAtorPrincipal.isSelected()) {
					if(filme.getProxAtorPrincipal() == null) {
						JOptionPane.showMessageDialog(null, "Vai com calme! Esse é o último filme da lista.");
					
					}else {
						filme = filme.getProxAtorPrincipal();

						tfTitulo.setText(filme.getNome());
						tfSinopse.setText(filme.getSinopse());
						tfAtorPrincipal.setText(filme.getAtorPrincipal());
						tfEstilo.setText(filme.getEstilo());
						tfProdutora.setText(filme.getProdutora());

						capa = new ImageIcon(this.getClass().getResource(filme.getDirCapa()));
						lblCapa.setIcon(capa);
					}
					
				}
				
				if(rbnEstilo.isSelected()) {
					if(filme.getProxEstilo() == null) {
						JOptionPane.showMessageDialog(null, "Vai com calme! Esse é o último filme da lista.");
					
					}else {
						filme = filme.getProxEstilo();

						tfTitulo.setText(filme.getNome());
						tfSinopse.setText(filme.getSinopse());
						tfAtorPrincipal.setText(filme.getAtorPrincipal());
						tfEstilo.setText(filme.getEstilo());
						tfProdutora.setText(filme.getProdutora());

						capa = new ImageIcon(this.getClass().getResource(filme.getDirCapa()));
						lblCapa.setIcon(capa);
					}
					
				}
			}
		});

		bttAnterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(rbnTitulo.isSelected()) {
					if(filme.getAntTitulo() == null) {
						JOptionPane.showMessageDialog(null, "Vai com calma! Esse é o primeiro filme da lista.");
					
					}else {
						filme = filme.getAntTitulo();

						tfTitulo.setText(filme.getNome());
						tfSinopse.setText(filme.getSinopse());
						tfAtorPrincipal.setText(filme.getAtorPrincipal());
						tfEstilo.setText(filme.getEstilo());
						tfProdutora.setText(filme.getProdutora());

						capa = new ImageIcon(this.getClass().getResource(filme.getDirCapa()));
						lblCapa.setIcon(capa);
					}
					
				}
				
				if(rbnAtorPrincipal.isSelected()) {
					if(filme.getAntAtorPrincipal() == null) {
						JOptionPane.showMessageDialog(null, "Vai com calme! Esse é o primeiro filme da lista.");
					
					}else {
						filme = filme.getAntAtorPrincipal();

						tfTitulo.setText(filme.getNome());
						tfSinopse.setText(filme.getSinopse());
						tfAtorPrincipal.setText(filme.getAtorPrincipal());
						tfEstilo.setText(filme.getEstilo());
						tfProdutora.setText(filme.getProdutora());

						capa = new ImageIcon(this.getClass().getResource(filme.getDirCapa()));
						lblCapa.setIcon(capa);
					}
					
				}
				
				if(rbnEstilo.isSelected()) {
					if(filme.getAntEstilo() == null) {
						JOptionPane.showMessageDialog(null, "Vai com calme! Esse é o primeiro filme da lista.");
					
					}else {
						filme = filme.getAntEstilo();

						tfTitulo.setText(filme.getNome());
						tfSinopse.setText(filme.getSinopse());
						tfAtorPrincipal.setText(filme.getAtorPrincipal());
						tfEstilo.setText(filme.getEstilo());
						tfProdutora.setText(filme.getProdutora());

						capa = new ImageIcon(this.getClass().getResource(filme.getDirCapa()));
						lblCapa.setIcon(capa);
					}
					
				}
			}
		});

		bttAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceNovoFilme inf = new InterfaceNovoFilme();
				inf.InterfaceNovoFilme1(addFilme);

				dispose();

			}
		});

		bttExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(filmoteca.excluiFilme(tfTitulo.getText())){
					JOptionPane.showMessageDialog(null, "Ok até aqui!");
				}else {
					JOptionPane.showMessageDialog(null, "Erro(ver classe de exclusão)!");
				}
			}
		});

	}
	
	public void pegaPrimeiroFilme() {
		Filme primeiroF = this.addFilme.retornaPrimeiro();

		if (primeiroF != null) {
			filme = primeiroF;

			this.tfTitulo.setText(primeiroF.getNome());
			this.tfSinopse.setText(primeiroF.getSinopse());
			this.tfAtorPrincipal.setText(primeiroF.getAtorPrincipal());
			this.tfEstilo.setText(primeiroF.getEstilo());
			this.tfProdutora.setText(primeiroF.getProdutora());
			this.capa = new ImageIcon(this.getClass().getResource(primeiroF.getDirCapa()));
			this.lblCapa.setIcon(capa);

		}
	}
}