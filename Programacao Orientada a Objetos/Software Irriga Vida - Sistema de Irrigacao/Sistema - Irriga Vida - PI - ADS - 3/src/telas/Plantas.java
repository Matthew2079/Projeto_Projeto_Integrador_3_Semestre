package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.AcessoBD;
import metodos.DocumentoLimitado;
import metodos_projeto.Planta;
import metodos_projeto.PlantaDAO;
import metodos_projeto.Usuario;
import metodos_projeto.UsuarioDAO;
import net.proteanit.sql.DbUtils;
import telas_usuario.CadastrosUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

public class Plantas extends JFrame {

	private JPanel contentPane;
	private JTextField textCodPlanta;
	private JTextField textNomePlanta;
	private JTextField textNomeCientifico;
	private JTextField textOrigem;
	private JTextField textFamilia;
	public static Cadastros tela3;
	public static Plantas tela5;
	private JTextField textTipoDaPlanta;
	private JTextField textClima;
	private JTextField textObservacoes;
	private JTable table_planta;
	private JDateChooser dateChooserDtCadastro;
	
	/***
	 * Met?do que executa uma pesquisa em toda a tabela de Planta. (FILTRO)
	 */
	public void refreshTable() {
		
		AcessoBD bd = new AcessoBD();
		if(bd.getConnection()){ 
			
			String sql ="select * from TB_PLANTA"; // instru??o executada no banco de dados.
			try {
				bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
				bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
				table_planta.setModel(DbUtils.resultSetToTableModel(bd.rs));	
				}	
			
			catch(SQLException erro) { 
				System.out.println(erro); // mostra o erro encontrado quando tentou a conex?o.
			}
			finally {
				bd.close(); // encerra a conex?o ao BD.
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plantas frame = new Plantas();
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
	public Plantas() {
		setTitle("Plantas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 826, 470);
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
		
		JLabel labelCodPlanta = new JLabel("C\u00F3digo da Planta");
		labelCodPlanta.setForeground(Color.WHITE);
		labelCodPlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodPlanta.setBounds(21, 255, 132, 14);
		contentPane.add(labelCodPlanta);
		
		textCodPlanta = new JTextField();
		//textPlanta.setDocument( new DocumentoLimitado(30) ); //definindo o tamanho do campo
		textCodPlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodPlanta.setColumns(10);
		textCodPlanta.setBounds(21, 284, 152, 20);
		contentPane.add(textCodPlanta);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AcessoBD bd = new AcessoBD();
				if(bd.getConnection()){ 
					
					String sql ="select * from TB_PLANTA where ID_PLANTA = ? or NOME_POPULAR = ? "
							+ "or OBSERVACOES = ? or TIPO_PLANTA = ? or ORIGEM = ? or NOME_CIENT = ? "
							+ "or FAMILIA = ?  or CLIMA = ?"; // instru??o executada no banco de dados.
					try {
						
						// Recebendo os valores inseridos.
						/*String  id = textCodPlanta.getText(); // ID_PLANTA							
						String nome = textNomePlanta.getText(); // NOME_POPULAR
						String obs = textObservacoes.getText(); // OBSERVACOES
						String tipo = textTipoDaPlanta.getText(); // TIPO_PLANTA
						String origem = textOrigem.getText(); // ORIGEM
						String nomect = textNomeCientifico.getText(); // NOME_CIENT
						String familia = textFamilia.getText(); // FAMILIA
						String clima = textClima.getText(); // CLIMA*/
						
						
						bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
						bd.st.setString(1, textCodPlanta.getText());
						bd.st.setString(2, textNomePlanta.getText());
						bd.st.setString(3, textObservacoes.getText());
						bd.st.setString(4, textTipoDaPlanta.getText());
						bd.st.setString(5, textOrigem.getText());
						bd.st.setString(6, textNomeCientifico.getText());
						bd.st.setString(7, textFamilia.getText());
						bd.st.setString(8, textClima.getText());
						bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
						table_planta.setModel(DbUtils.resultSetToTableModel(bd.rs));	
						}	
					
					catch(SQLException erro) { 
						System.out.println(erro); // mostra o erro encontrado quando tentou a conex?o.
					}
					catch(NumberFormatException erro) { 
						System.out.println("Insira um dado para busca !"); // erro na leitura em caso de valor em branco.
					}
					finally {
						bd.close(); // encerra a conex?o ao BD.
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Falha na conex?o com o BD!"); // retorna a mensagem de falha de conex?o ao BD.
				}
			}
		});
		btPesquisar.setForeground(Color.WHITE);
		btPesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		btPesquisar.setBackground(new Color(0, 128, 0));
		btPesquisar.setBounds(21, 189, 122, 25);
		contentPane.add(btPesquisar);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Limpando dados inseridos nas textboxs.
				textCodPlanta.setText("");
				textNomePlanta.setText("");
				textNomeCientifico.setText("");
				textOrigem.setText("");
				textFamilia.setText("");
				textTipoDaPlanta.setText("");
				textClima.setText("");
				textObservacoes.setText("");
			}
		});
		btLimpar.setForeground(Color.WHITE);
		btLimpar.setFont(new Font("Arial", Font.BOLD, 12));
		btLimpar.setBackground(new Color(0, 128, 0));
		btLimpar.setBounds(599, 189, 122, 25);
		contentPane.add(btLimpar);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Definindo condicional para a Data Cadastro
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dtCadastro = "0";
				if(dateChooserDtCadastro.getDate() != null) {
					dtCadastro = (df.format(dateChooserDtCadastro.getDate()));  //Formata??o da DT_CADASTRO
				}
				else
					JOptionPane.showMessageDialog(null, "Insira data v?lida no Campo Data");
				
				String  id = textCodPlanta.getText(); // ID_PLANTA		
				String nome = textNomePlanta.getText(); // NOME_POPULAR
				String obs = textObservacoes.getText(); // OBSERVACOES
				String tipo = textTipoDaPlanta.getText(); // TIPO_PLANTA
				String origem = textOrigem.getText(); // ORIGEM
				String nomect = textNomeCientifico.getText(); // NOME_CIENT
				String familia = textFamilia.getText(); // FAMILIA
				String clima = textClima.getText(); // CLIMA*/
				
				Planta planta = new Planta(textCodPlanta.getText(),textNomePlanta.getText(),dtCadastro,textObservacoes.getText(),
						textTipoDaPlanta.getText(), textOrigem.getText(),textNomeCientifico.getText(),textFamilia.getText(),
						textClima.getText());
				
				PlantaDAO dao = new PlantaDAO();
				dao.alterar(planta);
			}
		});
		btAtualizar.setForeground(Color.WHITE);
		btAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btAtualizar.setBackground(new Color(0, 128, 0));
		btAtualizar.setBounds(321, 189, 122, 25);
		contentPane.add(btAtualizar);
		
		textNomePlanta = new JTextField();
		textNomePlanta.setDocument( new DocumentoLimitado(30) ); //definindo o tamanho do campo
		textNomePlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		textNomePlanta.setColumns(10);
		textNomePlanta.setBounds(21, 344, 152, 20);
		contentPane.add(textNomePlanta);
		
		JButton btDeletar = new JButton("Deletar");
		btDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Planta planta = new Planta(textCodPlanta.getText());
				
				PlantaDAO dao = new PlantaDAO();
				dao.excluir(planta);
			}
		});
		btDeletar.setForeground(Color.WHITE);
		btDeletar.setFont(new Font("Arial", Font.BOLD, 12));
		btDeletar.setBackground(new Color(0, 128, 0));
		btDeletar.setBounds(460, 189, 122, 25);
		contentPane.add(btDeletar);
		
		JButton btNovoCadastro = new JButton("Novo Cadastro");
		btNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Definindo condicional para a Data Cadastro
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dtCadastro = "0";
				if(dateChooserDtCadastro.getDate() != null) {
					dtCadastro = (df.format(dateChooserDtCadastro.getDate()));  //Formata??o da DT_CADASTRO
				}
				else
					JOptionPane.showMessageDialog(null, "Insira data v?lida no Campo Data");
				
				/*String  id = textCodPlanta.getText(); // ID_PLANTA		
				String nome = textNomePlanta.getText(); // NOME_POPULAR
				String obs = textObservacoes.getText(); // OBSERVACOES
				String tipo = textTipoDaPlanta.getText(); // TIPO_PLANTA
				String origem = textOrigem.getText(); // ORIGEM
				String nomect = textNomeCientifico.getText(); // NOME_CIENT
				String familia = textFamilia.getText(); // FAMILIA
				String clima = textClima.getText(); // CLIMA*/
				
				Planta planta = new Planta(textCodPlanta.getText(),textNomePlanta.getText(),dtCadastro,textObservacoes.getText(),
						textTipoDaPlanta.getText(), textOrigem.getText(),textNomeCientifico.getText(),textFamilia.getText(),
						textClima.getText());
				
				PlantaDAO dao = new PlantaDAO();
				dao.incluir(planta);
			}
		});
		btNovoCadastro.setForeground(Color.WHITE);
		btNovoCadastro.setFont(new Font("Arial", Font.BOLD, 12));
		btNovoCadastro.setBackground(new Color(0, 128, 0));
		btNovoCadastro.setBounds(174, 189, 122, 25);
		contentPane.add(btNovoCadastro);
		
		textNomeCientifico = new JTextField();
		textNomeCientifico.setDocument( new DocumentoLimitado(50) ); //definindo o tamanho do campo
		textNomeCientifico.setFont(new Font("Arial", Font.PLAIN, 12));
		textNomeCientifico.setColumns(10);
		textNomeCientifico.setBounds(208, 284, 152, 20);
		contentPane.add(textNomeCientifico);
		
		textOrigem = new JTextField();
		textOrigem.setDocument( new DocumentoLimitado(20) ); //definindo o tamanho do campo
		textOrigem.setFont(new Font("Arial", Font.PLAIN, 12));
		textOrigem.setColumns(10);
		textOrigem.setBounds(210, 338, 152, 20);
		contentPane.add(textOrigem);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setForeground(Color.WHITE);
		btSair.setFont(new Font("Arial", Font.BOLD, 12));
		btSair.setBackground(new Color(0, 128, 0));
		btSair.setBounds(10, 402, 89, 23);
		contentPane.add(btSair);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					tela3 = new Cadastros();
					tela3.setVisible(true);
					Cadastros.tela5.setVisible(false);
					
			}
		});
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setFont(new Font("Arial", Font.BOLD, 12));
		btVoltar.setBackground(new Color(0, 128, 0));
		btVoltar.setBounds(122, 402, 89, 23);
		contentPane.add(btVoltar);
		
		JLabel labelNomePlanta = new JLabel("Nome da Planta");
		labelNomePlanta.setForeground(Color.WHITE);
		labelNomePlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		labelNomePlanta.setBounds(21, 315, 132, 14);
		contentPane.add(labelNomePlanta);
		
		JLabel labelNomeCientifico = new JLabel("Nome Cientifico");
		labelNomeCientifico.setForeground(Color.WHITE);
		labelNomeCientifico.setFont(new Font("Arial", Font.PLAIN, 12));
		labelNomeCientifico.setBounds(208, 261, 132, 14);
		contentPane.add(labelNomeCientifico);
		
		JLabel labelOrigem = new JLabel("Origem");
		labelOrigem.setForeground(Color.WHITE);
		labelOrigem.setFont(new Font("Arial", Font.PLAIN, 12));
		labelOrigem.setBounds(208, 315, 132, 14);
		contentPane.add(labelOrigem);
		
		JLabel labelFamlia = new JLabel("Fam\u00EDlia");
		labelFamlia.setForeground(Color.WHITE);
		labelFamlia.setFont(new Font("Arial", Font.PLAIN, 12));
		labelFamlia.setBounds(394, 261, 132, 14);
		contentPane.add(labelFamlia);
		
		textFamilia = new JTextField();
		textFamilia.setDocument( new DocumentoLimitado(30) ); //definindo o tamanho do campo
		textFamilia.setFont(new Font("Arial", Font.PLAIN, 12));
		textFamilia.setColumns(10);
		textFamilia.setBounds(394, 284, 152, 20);
		contentPane.add(textFamilia);
		
		JLabel labelTipoDaPlanta = new JLabel("Tipo da Planta");
		labelTipoDaPlanta.setForeground(Color.WHITE);
		labelTipoDaPlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		labelTipoDaPlanta.setBounds(394, 315, 132, 14);
		contentPane.add(labelTipoDaPlanta);
		
		textTipoDaPlanta = new JTextField();
		textTipoDaPlanta.setDocument( new DocumentoLimitado(10) ); //definindo o tamanho do campo
		textTipoDaPlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		textTipoDaPlanta.setColumns(10);
		textTipoDaPlanta.setBounds(394, 338, 152, 20);
		contentPane.add(textTipoDaPlanta);
		
		JLabel labelClima = new JLabel("Clima");
		labelClima.setForeground(Color.WHITE);
		labelClima.setFont(new Font("Arial", Font.PLAIN, 12));
		labelClima.setBounds(394, 382, 132, 14);
		contentPane.add(labelClima);
		
		textClima = new JTextField();
		textClima.setDocument( new DocumentoLimitado(20) ); //definindo o tamanho do campo
		textClima.setFont(new Font("Arial", Font.PLAIN, 12));
		textClima.setColumns(10);
		textClima.setBounds(394, 405, 152, 20);
		contentPane.add(textClima);
		
		JLabel labelObservacoes = new JLabel("Observa\u00E7\u00F5es");
		labelObservacoes.setForeground(Color.WHITE);
		labelObservacoes.setFont(new Font("Arial", Font.PLAIN, 12));
		labelObservacoes.setBounds(571, 255, 132, 14);
		contentPane.add(labelObservacoes);
		
		textObservacoes = new JTextField();
		textObservacoes.setHorizontalAlignment(SwingConstants.LEFT);
		textObservacoes.setDocument( new DocumentoLimitado(120) ); //definindo o tamanho do campo
		textObservacoes.setFont(new Font("Arial", Font.PLAIN, 12));
		textObservacoes.setColumns(10);
		textObservacoes.setBounds(571, 284, 229, 80);
		contentPane.add(textObservacoes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 794, 131);
		contentPane.add(scrollPane);
		
		table_planta = new JTable();
		scrollPane.setViewportView(table_planta);
		
		JLabel labelDtCadastro = new JLabel("Data Cadastro");
		labelDtCadastro.setForeground(Color.WHITE);
		labelDtCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		labelDtCadastro.setBounds(571, 380, 150, 14);
		contentPane.add(labelDtCadastro);
		
		// JDateChooser dateChooserDtCadastro = new JDateChooser();
		dateChooserDtCadastro = new JDateChooser();
		dateChooserDtCadastro.setBounds(571, 405, 136, 20);
		contentPane.add(dateChooserDtCadastro);
		
		JButton btFiltroPlanta = new JButton("Filtrar Plantas");
		btFiltroPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshTable();
			}
		});
		btFiltroPlanta.setForeground(Color.WHITE);
		btFiltroPlanta.setFont(new Font("Arial", Font.BOLD, 12));
		btFiltroPlanta.setBackground(new Color(0, 128, 0));
		btFiltroPlanta.setBounds(569, 13, 231, 25);
		contentPane.add(btFiltroPlanta);
	}
}
