package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.DocumentoLimitado;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Relatorios extends JFrame {

	private JPanel contentPane;
	private JTextField textTaxaUmidade;
	public static TelaInicial tela2;
	public static Relatorios tela10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios frame = new Relatorios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Relatorios() {
		setTitle("Relat\u00F3rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelSI = new JLabel("Sistema de Irriga\u00E7\u00E3o");
		labelSI.setHorizontalAlignment(SwingConstants.CENTER);
		labelSI.setForeground(Color.WHITE);
		labelSI.setFont(new Font("Arial", Font.BOLD, 14));
		labelSI.setBackground(Color.WHITE);
		labelSI.setBounds(122, 11, 168, 25);
		contentPane.add(labelSI);
		
		JEditorPane dtrpnA = new JEditorPane();
		dtrpnA.setBackground(Color.LIGHT_GRAY);
		dtrpnA.setBounds(10, 47, 514, 316);
		contentPane.add(dtrpnA);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setForeground(Color.WHITE);
		btSair.setFont(new Font("Arial", Font.BOLD, 12));
		btSair.setBackground(new Color(0, 128, 0));
		btSair.setBounds(10, 388, 89, 23);
		contentPane.add(btSair);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela2 = new TelaInicial();
				tela2.setVisible(true);
				TelaInicial.tela10.setVisible(false);
				
			}
		});
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setFont(new Font("Arial", Font.BOLD, 12));
		btVoltar.setBackground(new Color(0, 128, 0));
		btVoltar.setBounds(630, 388, 89, 23);
		contentPane.add(btVoltar);
		
		JLabel labelStatusUmidade = new JLabel("Status Umidade");
		labelStatusUmidade.setForeground(Color.WHITE);
		labelStatusUmidade.setFont(new Font("Arial", Font.PLAIN, 12));
		labelStatusUmidade.setBounds(534, 128, 132, 14);
		contentPane.add(labelStatusUmidade);
		
		textTaxaUmidade = new JTextField();
		textTaxaUmidade.setDocument( new DocumentoLimitado(6) ); //definindo o tamanho do campo
		textTaxaUmidade.setFont(new Font("Arial", Font.PLAIN, 12));
		textTaxaUmidade.setColumns(10);
		textTaxaUmidade.setBounds(534, 84, 152, 20);
		contentPane.add(textTaxaUmidade);
		
		JLabel labelTaxaUmidade = new JLabel("Taxa de Umidade");
		labelTaxaUmidade.setForeground(Color.WHITE);
		labelTaxaUmidade.setFont(new Font("Arial", Font.PLAIN, 12));
		labelTaxaUmidade.setBounds(534, 55, 132, 14);
		contentPane.add(labelTaxaUmidade);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.setForeground(Color.WHITE);
		btPesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		btPesquisar.setBackground(new Color(0, 128, 0));
		btPesquisar.setBounds(555, 207, 122, 25);
		contentPane.add(btPesquisar);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Limpando dados inseridos nas textboxs.
				textTaxaUmidade.setText("");
			}
		});
		btLimpar.setForeground(Color.WHITE);
		btLimpar.setFont(new Font("Arial", Font.BOLD, 12));
		btLimpar.setBackground(new Color(0, 128, 0));
		btLimpar.setBounds(555, 254, 122, 25);
		contentPane.add(btLimpar);
		
		JComboBox ComboBoxStatusUmidade = new JComboBox();
		ComboBoxStatusUmidade.setModel(new DefaultComboBoxModel(new String[] {"Baixo", "Alto"}));
		ComboBoxStatusUmidade.setToolTipText("");
		ComboBoxStatusUmidade.setBounds(534, 148, 152, 31);
		contentPane.add(ComboBoxStatusUmidade);
	}
}
