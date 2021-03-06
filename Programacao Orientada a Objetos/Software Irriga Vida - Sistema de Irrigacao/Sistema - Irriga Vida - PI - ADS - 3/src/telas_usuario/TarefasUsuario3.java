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
import metodos_projeto.Agendamento;
import metodos_projeto.AgendamentoDAO;
import metodos_projeto.Tarefa;
import metodos_projeto.TarefaDAO;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TarefasUsuario3 extends JFrame {

	private JPanel contentPane;
	private JTextField textObservacao;
	private JTextField textDescricao;
	private JTextField textCodTarefa;
	public static TarefasUsuario3 tela16;
	public static CadastrosUsuario tela13;
	private JTextField textCodUsuario;
	private JTable table_tarefas;
	private JComboBox ComboBoxStatus;
	private JComboBox ComboBoxTipo;
	private JDateChooser dateChooserDapTarefa;
	private JDateChooser dateChooserExecTarefa;

	/***
	 * Met?do que executa uma pesquisa em toda a tabela de Tarefas. (FILTRO)
	 */
	public void refreshTable() {
		
		AcessoBD bd = new AcessoBD();
		if(bd.getConnection()){ 
			
			String sql ="select * from TB_TAREFAS;"; // instru??o executada no banco de dados.
			try {
				bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
				bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
				table_tarefas.setModel(DbUtils.resultSetToTableModel(bd.rs));	
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
					TarefasUsuario3 frame = new TarefasUsuario3();
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
	public TarefasUsuario3() {
		setTitle("Tarefas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 836, 437);
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
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setForeground(Color.WHITE);
		btSair.setFont(new Font("Arial", Font.BOLD, 12));
		btSair.setBackground(new Color(0, 128, 0));
		btSair.setBounds(626, 363, 89, 23);
		contentPane.add(btSair);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela13 = new CadastrosUsuario();
				tela13.setVisible(true);
				CadastrosUsuario.tela16.setVisible(false);
				
			}
		});
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setFont(new Font("Arial", Font.BOLD, 12));
		btVoltar.setBackground(new Color(0, 128, 0));
		btVoltar.setBounds(725, 363, 89, 23);
		contentPane.add(btVoltar);
		
		JLabel labelDapTarefa = new JLabel("Data da Prevista Tarefa ");
		labelDapTarefa.setForeground(Color.WHITE);
		labelDapTarefa.setFont(new Font("Arial", Font.PLAIN, 12));
		labelDapTarefa.setBounds(386, 284, 132, 14);
		contentPane.add(labelDapTarefa);
		
		textObservacao = new JTextField();
		textObservacao.setDocument( new DocumentoLimitado(150) ); //definindo o tamanho do campo
		textObservacao.setFont(new Font("Arial", Font.PLAIN, 12));
		textObservacao.setColumns(10);
		textObservacao.setBounds(205, 254, 330, 20);
		contentPane.add(textObservacao);
		
		JLabel labelObservacao = new JLabel("Observa\u00E7\u00E3o");
		labelObservacao.setForeground(Color.WHITE);
		labelObservacao.setFont(new Font("Arial", Font.PLAIN, 12));
		labelObservacao.setBounds(203, 231, 152, 14);
		contentPane.add(labelObservacao);
		
		textDescricao = new JTextField();
		textDescricao.setDocument( new DocumentoLimitado(80) ); //definindo o tamanho do campo
		textDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		textDescricao.setColumns(10);
		textDescricao.setBounds(10, 363, 183, 20);
		contentPane.add(textDescricao);
		
		JLabel labelDescricao = new JLabel("Descri\u00E7\u00E3o");
		labelDescricao.setForeground(Color.WHITE);
		labelDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		labelDescricao.setBounds(10, 338, 132, 14);
		contentPane.add(labelDescricao);
		
		textCodTarefa = new JTextField();
		//textCodTarefa.setDocument( new DocumentoLimitado(10) ); //definindo o tamanho do campo
		textCodTarefa.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodTarefa.setColumns(10);
		textCodTarefa.setBounds(10, 256, 183, 20);
		contentPane.add(textCodTarefa);
		
		JLabel labelCodTarefa = new JLabel("C\u00F3digo Tarefa");
		labelCodTarefa.setForeground(Color.WHITE);
		labelCodTarefa.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodTarefa.setBounds(10, 231, 132, 14);
		contentPane.add(labelCodTarefa);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AcessoBD bd = new AcessoBD();
				if(bd.getConnection()){ 

					String sql ="select * from TB_TAREFAS where ID_TAREFA = ? or ID_USUARIO = ? or DESCRICAO = ? or OBS_TAREFA = ? "; // instru??o executada no banco de dados.

					try {
						
						// Recebendo os valores inseridos.
						String  id = textCodTarefa.getText(); // ID_TAREFA
						String  idUsuario = textCodUsuario.getText(); // ID_USUARIO		
						String  descricao =  textDescricao.getText(); // DESCRICAO	
						String  observacao =  textObservacao.getText(); // OBS_TAREFA	

						bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
						bd.st.setString(1, textCodTarefa.getText());
						bd.st.setString(2, textCodUsuario.getText());
						bd.st.setString(3, textDescricao.getText());
						bd.st.setString(4, textObservacao.getText());
						bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
						table_tarefas.setModel(DbUtils.resultSetToTableModel(bd.rs));	
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
		btPesquisar.setBounds(545, 231, 122, 25);
		contentPane.add(btPesquisar);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Limpando dados inseridos nas textboxs.
				textCodTarefa.setText("");
				textCodUsuario.setText("");
				textDescricao.setText("");
				textObservacao.setText("");
				
			}
		});
		btLimpar.setForeground(Color.WHITE);
		btLimpar.setFont(new Font("Arial", Font.BOLD, 12));
		btLimpar.setBackground(new Color(0, 128, 0));
		btLimpar.setBounds(545, 267, 122, 25);
		contentPane.add(btLimpar);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Definindo condicionais para as Datas Prevista Tarefa e Execu??o Tarefa 
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dtPrevista = "0";
				String dtExecucao = "0";
				if(dateChooserDapTarefa.getDate() != null && dateChooserExecTarefa.getDate() !=null) {
					dtPrevista = (df.format(dateChooserDapTarefa.getDate()));    //Formata??o da DT_PREVISTA
					dtExecucao = (df.format(dateChooserExecTarefa.getDate()));  //Formata??o da DT_REAL_TAREFA
				}
				else
					JOptionPane.showMessageDialog(null, "Insira datas v?lidas nos Campos");
				
				//Definindo as variaveis a partir de cada combina??o de sele??o.
				String statusTarefa; // STATUS_TAREFA -- P - PENDENTE | F - FINALIZADA
				String tipoTarefa; // TIPO_TAREFA -- C - COLHEITA | A- AVALIA??O 
				
				if(ComboBoxStatus.getSelectedItem().equals("Pendente")&&ComboBoxTipo.getSelectedItem().equals("Colheita"))
				{
					statusTarefa = "P";
					tipoTarefa = "C";
				}
				
				else if(ComboBoxStatus.getSelectedItem().equals("Pendente")&&ComboBoxTipo.getSelectedItem().equals("Avalia??o"))
				{
					statusTarefa = "P";
					tipoTarefa = "A";
				}
				
				else if(ComboBoxStatus.getSelectedItem().equals("Finalizada")&&ComboBoxTipo.getSelectedItem().equals("Colheita"))
				{
					statusTarefa = "F";
					tipoTarefa = "C";
				}
				
				else if(ComboBoxStatus.getSelectedItem().equals("Finalizada")&&ComboBoxTipo.getSelectedItem().equals("Avalia??o"))
				{
					statusTarefa = "F";
					tipoTarefa = "A";
				}
				
				else
				{
					statusTarefa = "";
					tipoTarefa = "";
				}
						
				Tarefa tarefa = new Tarefa(textCodTarefa.getText(), textCodUsuario.getText(), textDescricao.getText(),
						textObservacao.getText(), dtExecucao, dtPrevista, tipoTarefa, statusTarefa);
				
				TarefaDAO dao = new TarefaDAO();
				dao.alterar(tarefa);
			}
		});
		btAtualizar.setForeground(Color.WHITE);
		btAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btAtualizar.setBackground(new Color(0, 128, 0));
		btAtualizar.setBounds(692, 231, 122, 25);
		contentPane.add(btAtualizar);
		
		JButton btDeletar = new JButton("Deletar ");
		btDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tarefa tarefa = new Tarefa(textCodTarefa.getText());
				
				TarefaDAO dao = new TarefaDAO();
				dao.excluir(tarefa);
			}
		});
		btDeletar.setForeground(Color.WHITE);
		btDeletar.setFont(new Font("Arial", Font.BOLD, 12));
		btDeletar.setBackground(new Color(0, 128, 0));
		btDeletar.setBounds(692, 267, 122, 25);
		contentPane.add(btDeletar);
		
		JButton btNovoCadastro = new JButton("Novo Cadastro");
		btNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Definindo condicionais para as Datas Prevista Tarefa e Execu??o Tarefa 
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dtPrevista = "0";
				String dtExecucao = "0";
				if(dateChooserDapTarefa.getDate() != null && dateChooserExecTarefa.getDate() !=null) {
					dtPrevista = (df.format(dateChooserDapTarefa.getDate()));    //Formata??o da DT_PREVISTA
					dtExecucao = (df.format(dateChooserExecTarefa.getDate()));  //Formata??o da DT_REAL_TAREFA
				}
				else
					JOptionPane.showMessageDialog(null, "Insira datas v?lidas nos Campos");
				
				//Definindo as variaveis a partir de cada combina??o de sele??o.
				String statusTarefa; // STATUS_TAREFA -- P - PENDENTE | F - FINALIZADA
				String tipoTarefa; // TIPO_TAREFA -- C - COLHEITA | A- AVALIA??O 
				
				if(ComboBoxStatus.getSelectedItem().equals("Pendente")&&ComboBoxTipo.getSelectedItem().equals("Colheita"))
				{
					statusTarefa = "P";
					tipoTarefa = "C";
				}
				
				else if(ComboBoxStatus.getSelectedItem().equals("Pendente")&&ComboBoxTipo.getSelectedItem().equals("Avalia??o"))
				{
					statusTarefa = "P";
					tipoTarefa = "A";
				}
				
				else if(ComboBoxStatus.getSelectedItem().equals("Finalizada")&&ComboBoxTipo.getSelectedItem().equals("Colheita"))
				{
					statusTarefa = "F";
					tipoTarefa = "C";
				}
				
				else if(ComboBoxStatus.getSelectedItem().equals("Finalizada")&&ComboBoxTipo.getSelectedItem().equals("Avalia??o"))
				{
					statusTarefa = "F";
					tipoTarefa = "A";
				}
				
				else
				{
					statusTarefa = "";
					tipoTarefa = "";
				}
						
				Tarefa tarefa = new Tarefa(textCodTarefa.getText(), textCodUsuario.getText(), textDescricao.getText(),
						textObservacao.getText(), dtExecucao, dtPrevista, tipoTarefa, statusTarefa);
				
				TarefaDAO dao = new TarefaDAO();
				dao.incluir(tarefa);
				
			}
		});
		btNovoCadastro.setForeground(Color.WHITE);
		btNovoCadastro.setFont(new Font("Arial", Font.BOLD, 12));
		btNovoCadastro.setBackground(new Color(0, 128, 0));
		btNovoCadastro.setBounds(545, 305, 269, 25);
		contentPane.add(btNovoCadastro);
		
		//JDateChooser dateChooserDapTarefa = new JDateChooser();
		dateChooserDapTarefa = new JDateChooser();
		dateChooserDapTarefa.setBounds(383, 309, 152, 20);
		contentPane.add(dateChooserDapTarefa);
		
		JLabel labelExecTarefa = new JLabel("Data da Execu\u00E7\u00E3o Tarefa");
		labelExecTarefa.setForeground(Color.WHITE);
		labelExecTarefa.setFont(new Font("Arial", Font.PLAIN, 12));
		labelExecTarefa.setBounds(386, 338, 152, 14);
		contentPane.add(labelExecTarefa);
		
		//JDateChooser dateChooserExecTarefa = new JDateChooser();
		dateChooserExecTarefa = new JDateChooser();
		dateChooserExecTarefa.setBounds(386, 363, 152, 20);
		contentPane.add(dateChooserExecTarefa);
		
		JLabel labelStatus = new JLabel("Status");
		labelStatus.setForeground(Color.WHITE);
		labelStatus.setFont(new Font("Arial", Font.PLAIN, 12));
		labelStatus.setBounds(208, 310, 61, 14);
		contentPane.add(labelStatus);
		
		//JComboBox ComboBoxStatus = new JComboBox();
		ComboBoxStatus = new JComboBox();
		ComboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"<Selecionar uma op\u00E7\u00E3o>", "Pendente", "Finalizada"}));
		ComboBoxStatus.setBounds(257, 302, 98, 31);
		contentPane.add(ComboBoxStatus);
		
		JLabel labelCodUsuario = new JLabel("C\u00F3digo do Usuario");
		labelCodUsuario.setForeground(Color.WHITE);
		labelCodUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodUsuario.setBounds(10, 284, 132, 14);
		contentPane.add(labelCodUsuario);
		
		textCodUsuario = new JTextField();
		//textCodUsuario.setDocument( new DocumentoLimitado(10) ); //definindo o tamanho do campo
		textCodUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodUsuario.setColumns(10);
		textCodUsuario.setBounds(10, 309, 183, 20);
		contentPane.add(textCodUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 804, 173);
		contentPane.add(scrollPane);
		
		table_tarefas = new JTable();
		scrollPane.setViewportView(table_tarefas);
		
		JLabel labelTipo = new JLabel("Tipo ");
		labelTipo.setForeground(Color.WHITE);
		labelTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		labelTipo.setBounds(205, 366, 61, 14);
		contentPane.add(labelTipo);
		
		//JComboBox ComboBoxTipo = new JComboBox();
		ComboBoxTipo = new JComboBox();
		ComboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Selecionar uma op\u00E7\u00E3o>", "Colheita", "Avalia\u00E7\u00E3o"}));
		ComboBoxTipo.setBounds(257, 358, 98, 31);
		contentPane.add(ComboBoxTipo);
		
		JButton btFiltroTarefas = new JButton("Filtrar Tarefas");
		btFiltroTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				refreshTable();
				
			}
		});
		btFiltroTarefas.setForeground(Color.WHITE);
		btFiltroTarefas.setFont(new Font("Arial", Font.BOLD, 12));
		btFiltroTarefas.setBackground(new Color(0, 128, 0));
		btFiltroTarefas.setBounds(541, 13, 269, 25);
		contentPane.add(btFiltroTarefas);
	}
}
