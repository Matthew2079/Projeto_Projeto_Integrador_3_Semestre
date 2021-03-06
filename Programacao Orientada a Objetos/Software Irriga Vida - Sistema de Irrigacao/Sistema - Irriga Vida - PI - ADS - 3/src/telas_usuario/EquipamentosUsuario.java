package telas_usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import metodos.DocumentoLimitado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquipamentosUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textDescricao;
	private JTextField textCodEquipamento;
	public static EquipamentosUsuario tela18;
	public static CadastrosUsuario tela13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipamentosUsuario frame = new EquipamentosUsuario();
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
	public EquipamentosUsuario() {
		setTitle("Equipamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 762, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(46, 139, 87));
		contentPane_1.setBounds(0, 0, 876, 499);
		contentPane.add(contentPane_1);
		
		JLabel labelSI = new JLabel("Sistema de Irriga\u00E7\u00E3o");
		labelSI.setHorizontalAlignment(SwingConstants.CENTER);
		labelSI.setForeground(Color.WHITE);
		labelSI.setFont(new Font("Arial", Font.BOLD, 14));
		labelSI.setBackground(Color.WHITE);
		labelSI.setBounds(122, 11, 168, 25);
		contentPane_1.add(labelSI);
		
		JEditorPane dtrpnA = new JEditorPane();
		dtrpnA.setBackground(Color.LIGHT_GRAY);
		dtrpnA.setBounds(10, 47, 438, 346);
		contentPane_1.add(dtrpnA);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setForeground(Color.WHITE);
		btSair.setFont(new Font("Arial", Font.BOLD, 12));
		btSair.setBackground(new Color(0, 128, 0));
		btSair.setBounds(10, 404, 89, 23);
		contentPane_1.add(btSair);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela13 = new CadastrosUsuario();
				tela13.setVisible(true);
				CadastrosUsuario.tela18.setVisible(false);
				
			}
		});
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setFont(new Font("Arial", Font.BOLD, 12));
		btVoltar.setBackground(new Color(0, 128, 0));
		btVoltar.setBounds(651, 401, 89, 23);
		contentPane_1.add(btVoltar);
		
		textValor = new JTextField();
		textValor.setDocument( new DocumentoLimitado(10) ); //definindo o tamanho do campo
		textValor.setFont(new Font("Arial", Font.PLAIN, 12));
		textValor.setColumns(10);
		textValor.setBounds(500, 121, 234, 20);
		contentPane_1.add(textValor);
		
		JLabel labelValor = new JLabel("Valor ");
		labelValor.setForeground(Color.WHITE);
		labelValor.setFont(new Font("Arial", Font.PLAIN, 12));
		labelValor.setBounds(458, 124, 132, 14);
		contentPane_1.add(labelValor);
		
		textDescricao = new JTextField();
		textDescricao.setDocument( new DocumentoLimitado(50) ); //definindo o tamanho do campo
		textDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		textDescricao.setColumns(10);
		textDescricao.setBounds(521, 78, 213, 20);
		contentPane_1.add(textDescricao);
		
		JLabel labelDescricao = new JLabel("Descric\u00E3o");
		labelDescricao.setForeground(Color.WHITE);
		labelDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		labelDescricao.setBounds(458, 81, 132, 14);
		contentPane_1.add(labelDescricao);
		
		textCodEquipamento = new JTextField();
		//textCodEquipamento.setDocument( new DocumentoLimitado(1) ); //definindo o tamanho do campo
		textCodEquipamento.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodEquipamento.setColumns(10);
		textCodEquipamento.setBounds(602, 47, 132, 20);
		contentPane_1.add(textCodEquipamento);
		
		JLabel labelCodEquipamento = new JLabel("C\u00F3digo do Equipamento");
		labelCodEquipamento.setForeground(Color.WHITE);
		labelCodEquipamento.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodEquipamento.setBounds(458, 47, 150, 18);
		contentPane_1.add(labelCodEquipamento);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.setForeground(Color.WHITE);
		btPesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		btPesquisar.setBackground(new Color(0, 128, 0));
		btPesquisar.setBounds(473, 237, 122, 25);
		contentPane_1.add(btPesquisar);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Limpando dados inseridos nas textboxs.
				textCodEquipamento.setText("");
				textDescricao.setText("");
				textValor.setText("");
				
			}
		});
		btLimpar.setForeground(Color.WHITE);
		btLimpar.setFont(new Font("Arial", Font.BOLD, 12));
		btLimpar.setBackground(new Color(0, 128, 0));
		btLimpar.setBounds(473, 279, 122, 25);
		contentPane_1.add(btLimpar);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.setForeground(Color.WHITE);
		btAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btAtualizar.setBackground(new Color(0, 128, 0));
		btAtualizar.setBounds(599, 237, 122, 25);
		contentPane_1.add(btAtualizar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setForeground(Color.WHITE);
		btCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		btCancelar.setBackground(new Color(0, 128, 0));
		btCancelar.setBounds(599, 279, 122, 25);
		contentPane_1.add(btCancelar);
		
		JButton btNovoCadastro = new JButton("Novo Cadastro");
		btNovoCadastro.setForeground(Color.WHITE);
		btNovoCadastro.setFont(new Font("Arial", Font.BOLD, 12));
		btNovoCadastro.setBackground(new Color(0, 128, 0));
		btNovoCadastro.setBounds(473, 201, 248, 25);
		contentPane_1.add(btNovoCadastro);
		
		JLabel labelDataum = new JLabel("Data da \u00FAltima manuten\u00E7\u00E3o");
		labelDataum.setForeground(Color.WHITE);
		labelDataum.setFont(new Font("Arial", Font.PLAIN, 12));
		labelDataum.setBounds(458, 152, 158, 20);
		contentPane_1.add(labelDataum);
		
		JDateChooser dateChooserDataum = new JDateChooser();
		dateChooserDataum.setBounds(618, 152, 122, 20);
		contentPane_1.add(dateChooserDataum);
	}
}
