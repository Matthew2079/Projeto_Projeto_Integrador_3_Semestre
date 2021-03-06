package telas_usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import metodos.AcessoBD;
import metodos.DocumentoLimitado;
import metodos_projeto.Equipamento;
import metodos_projeto.EquipamentoDAO;
import metodos_projeto.PlantaDAO;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EquipamentosUsuario5 extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textDescricao;
	private JTextField textCodEquipamento;
	public static EquipamentosUsuario5 tela18;
	public static CadastrosUsuario tela13;
	private JTable table_equipamentos;
	private JDateChooser dateChooserDataum;
	
	/***
	 * Met?do que executa uma pesquisa em toda a tabela de Equipamentos. (FILTRO)
	 */
	public void refreshTable() {
		
		AcessoBD bd = new AcessoBD();
		if(bd.getConnection()){ 
			
			String sql ="select * from TB_EQUIPAMENTO"; // instru??o executada no banco de dados.
			try {
				bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
				bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
				table_equipamentos.setModel(DbUtils.resultSetToTableModel(bd.rs));	
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
					EquipamentosUsuario5 frame = new EquipamentosUsuario5();
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
	public EquipamentosUsuario5() {
		setTitle("Equipamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 762, 473);
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
		
		JButton btFiltroEquipamentos = new JButton("Filtrar Equipamentos");
		btFiltroEquipamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshTable();
			}
		});
		btFiltroEquipamentos.setForeground(Color.WHITE);
		btFiltroEquipamentos.setFont(new Font("Arial", Font.BOLD, 12));
		btFiltroEquipamentos.setBackground(new Color(0, 128, 0));
		btFiltroEquipamentos.setBounds(509, 13, 231, 25);
		contentPane.add(btFiltroEquipamentos);
		
		JButton btNovoCadastro = new JButton("Novo Cadastro");
		btNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Definindo condicional para a Data da ?ltima Manuten??o.
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dataUm = "0";
				if(dateChooserDataum.getDate() != null) {
					dataUm = (df.format(dateChooserDataum.getDate()));  //Formata??o da DT_ULTIMA_MAN
				}
				else
					JOptionPane.showMessageDialog(null, "Insira data v?lida no Campo Data");
				
				/*String  id = textCodEquipamento.getText(); // ID_EQUIPAMENTO		
				String  descricao = textDescricao.getText(); // DESCRICAO			
				String  valor =  textValor.getText(); // VALOR_EQUIPAMENTO			
				// DT_ULTIMA_MAN*/
				
				Equipamento equipamento = new Equipamento(textCodEquipamento.getText(), textDescricao.getText(),
						textValor.getText(), dataUm);
				
				EquipamentoDAO dao = new EquipamentoDAO();
				dao.incluir(equipamento);
			}
		});
		btNovoCadastro.setForeground(Color.WHITE);
		btNovoCadastro.setFont(new Font("Arial", Font.BOLD, 12));
		btNovoCadastro.setBackground(new Color(0, 128, 0));
		btNovoCadastro.setBounds(486, 256, 248, 25);
		contentPane.add(btNovoCadastro);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AcessoBD bd = new AcessoBD();
				if(bd.getConnection()){ 
					
					String sql ="select * from TB_EQUIPAMENTO where ID_EQUIPAMENTO = ? or DESCRICAO = ? or VALOR_EQUIPAMENTO = ?"; // instru??o executada no banco de dados.
					try {
						
						// Recebendo os valores inseridos.
						/*String  id = textCodEquipamento.getText(); // ID_EQUIPAMENTO		
						String  descricao = textDescricao.getText(); // DESCRICAO			
						String  valor =  textValor.getText(); // VALOR_EQUIPAMENTO			
						// DT_ULTIMA_MAN*/
						
						
						bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
						bd.st.setString(1, textCodEquipamento.getText());
						bd.st.setString(2, textDescricao.getText());
						bd.st.setString(3, textValor.getText());
						bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
						table_equipamentos.setModel(DbUtils.resultSetToTableModel(bd.rs));	
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
		btPesquisar.setBounds(486, 292, 122, 25);
		contentPane.add(btPesquisar);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Definindo condicional para a Data da ?ltima Manuten??o.
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dataUm = "0";
				if(dateChooserDataum.getDate() != null) {
					dataUm = (df.format(dateChooserDataum.getDate()));  //Formata??o da DT_ULTIMA_MAN
				}
				else
					JOptionPane.showMessageDialog(null, "Insira data v?lida no Campo Data");
				
				/*String  id = textCodEquipamento.getText(); // ID_EQUIPAMENTO		
				String  descricao = textDescricao.getText(); // DESCRICAO			
				String  valor =  textValor.getText(); // VALOR_EQUIPAMENTO			
				// DT_ULTIMA_MAN*/
				
				Equipamento equipamento = new Equipamento(textCodEquipamento.getText(), textDescricao.getText(),
						textValor.getText(), dataUm);
				
				EquipamentoDAO dao = new EquipamentoDAO();
				dao.alterar(equipamento);
				
			}
		});
		btAtualizar.setForeground(Color.WHITE);
		btAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btAtualizar.setBackground(new Color(0, 128, 0));
		btAtualizar.setBounds(612, 292, 122, 25);
		contentPane.add(btAtualizar);
		
		JButton btDeletar = new JButton("Deletar");
		btDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Equipamento equipamento = new Equipamento(textCodEquipamento.getText());
				
				EquipamentoDAO dao = new EquipamentoDAO();
				dao.excluir(equipamento);
			}
		});
		btDeletar.setForeground(Color.WHITE);
		btDeletar.setFont(new Font("Arial", Font.BOLD, 12));
		btDeletar.setBackground(new Color(0, 128, 0));
		btDeletar.setBounds(612, 334, 122, 25);
		contentPane.add(btDeletar);
		
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
		btLimpar.setBounds(486, 334, 122, 25);
		contentPane.add(btLimpar);
		
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
		contentPane.add(btVoltar);
		
		//JDateChooser dateChooserDataum = new JDateChooser();
		dateChooserDataum = new JDateChooser();
		dateChooserDataum.setBounds(290, 351, 168, 20);
		contentPane.add(dateChooserDataum);
		
		textValor = new JTextField();
		textValor.setDocument( new DocumentoLimitado(10) ); //definindo o tamanho do campo
		textValor.setFont(new Font("Arial", Font.PLAIN, 12));
		textValor.setColumns(10);
		textValor.setBounds(52, 320, 406, 20);
		contentPane.add(textValor);
		
		textDescricao = new JTextField();
		textDescricao.setDocument( new DocumentoLimitado(50) ); //definindo o tamanho do campo
		textDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		textDescricao.setColumns(10);
		textDescricao.setBounds(77, 289, 381, 20);
		contentPane.add(textDescricao);
		
		textCodEquipamento = new JTextField();
		//textCodEquipamento.setDocument( new DocumentoLimitado(1) ); //definindo o tamanho do campo
		textCodEquipamento.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodEquipamento.setColumns(10);
		textCodEquipamento.setBounds(154, 258, 304, 20);
		contentPane.add(textCodEquipamento);
		
		JLabel labelCodEquipamento = new JLabel("C\u00F3digo do Equipamento");
		labelCodEquipamento.setForeground(Color.WHITE);
		labelCodEquipamento.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodEquipamento.setBounds(10, 258, 150, 18);
		contentPane.add(labelCodEquipamento);
		
		JLabel labelDescricao = new JLabel("Descric\u00E3o");
		labelDescricao.setForeground(Color.WHITE);
		labelDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		labelDescricao.setBounds(10, 292, 132, 14);
		contentPane.add(labelDescricao);
		
		JLabel labelValor = new JLabel("Valor ");
		labelValor.setForeground(Color.WHITE);
		labelValor.setFont(new Font("Arial", Font.PLAIN, 12));
		labelValor.setBounds(10, 323, 132, 14);
		contentPane.add(labelValor);
		
		JLabel labelDataum = new JLabel("Data da \u00FAltima manuten\u00E7\u00E3o");
		labelDataum.setForeground(Color.WHITE);
		labelDataum.setFont(new Font("Arial", Font.PLAIN, 12));
		labelDataum.setBounds(122, 351, 158, 20);
		contentPane.add(labelDataum);
		
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
		contentPane.add(btSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 51, 713, 177);
		contentPane.add(scrollPane);
		
		table_equipamentos = new JTable();
		scrollPane.setViewportView(table_equipamentos);
	}
}
