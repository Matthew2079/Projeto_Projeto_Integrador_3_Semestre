package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import metodos.AcessoBD;
import metodos.DocumentoLimitado;
import metodos_projeto.Plantio;
import metodos_projeto.PlantioDAO;
import metodos_projeto.Tarefa;
import metodos_projeto.TarefaDAO;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Plantios extends JFrame {

	private JPanel contentPane;
	private JTextField textQuantidadeDeSementes;
	private JTextField textTempoMedio;
	private JTextField textCodFertilizantes;
	private JTextField textCodPlantio;
	private JTextField textCodPlanta;
	private JTextField textTipoDeAdubo;
	private JTextField textMetragem;
	public static Cadastros tela3;
	public static Plantios tela6;
	private JTable table_plantios;
	private JDateChooser dateChooserInicioColheita;
	private JDateChooser dateChooserFimColheita;
	private JDateChooser dateChooserInicioPlantio;
	private JDateChooser dateChooserFimPlantio;
	private JComboBox ComboBoxTipoPlantio;
	
	/***
	 * Met?do que executa uma pesquisa em toda a tabela de Plantios. (FILTRO)
	 */
	public void refreshTable() {
		
		AcessoBD bd = new AcessoBD();
		if(bd.getConnection()){ 
			
			String sql ="select * from TB_PLANTIO;"; // instru??o executada no banco de dados.
			try {
				bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
				bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
				table_plantios.setModel(DbUtils.resultSetToTableModel(bd.rs));	
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
					Plantios frame = new Plantios();
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
	public Plantios() {
		setTitle("Plantios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 895, 493);
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
		btSair.setBounds(10, 424, 89, 23);
		contentPane.add(btSair);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela3 = new Cadastros();
				tela3.setVisible(true);
				Cadastros.tela6.setVisible(false);
				
			}
		});
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setFont(new Font("Arial", Font.BOLD, 12));
		btVoltar.setBackground(new Color(0, 128, 0));
		btVoltar.setBounds(778, 424, 89, 23);
		contentPane.add(btVoltar);
		
		textQuantidadeDeSementes = new JTextField();
		textQuantidadeDeSementes.setDocument( new DocumentoLimitado(8) ); //definindo o tamanho do campo
		textQuantidadeDeSementes.setFont(new Font("Arial", Font.PLAIN, 12));
		textQuantidadeDeSementes.setColumns(10);
		textQuantidadeDeSementes.setBounds(300, 383, 132, 20);
		contentPane.add(textQuantidadeDeSementes);
		
		JLabel labelQuantidadeDeSementes = new JLabel("Quantidade de Sementes");
		labelQuantidadeDeSementes.setForeground(Color.WHITE);
		labelQuantidadeDeSementes.setFont(new Font("Arial", Font.PLAIN, 12));
		labelQuantidadeDeSementes.setBounds(300, 354, 150, 14);
		contentPane.add(labelQuantidadeDeSementes);
		
		textTempoMedio = new JTextField();
		textTempoMedio.setDocument( new DocumentoLimitado(10) ); //definindo o tamanho do campo
		textTempoMedio.setFont(new Font("Arial", Font.PLAIN, 12));
		textTempoMedio.setColumns(10);
		textTempoMedio.setBounds(158, 321, 132, 20);
		contentPane.add(textTempoMedio);
		
		JLabel labelTempoMedio = new JLabel("Tempo M\u00E9dio Irriga\u00E7\u00E3o");
		labelTempoMedio.setForeground(Color.WHITE);
		labelTempoMedio.setFont(new Font("Arial", Font.PLAIN, 12));
		labelTempoMedio.setBounds(158, 295, 132, 14);
		contentPane.add(labelTempoMedio);
		
		textCodFertilizantes = new JTextField();
		//textCodFertilizantes.setDocument( new DocumentoLimitado(8) ); //definindo o tamanho do campo
		textCodFertilizantes.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodFertilizantes.setColumns(10);
		textCodFertilizantes.setBounds(10, 383, 132, 20);
		contentPane.add(textCodFertilizantes);
		
		JLabel labelCodFertilizantes = new JLabel("C\u00F3digo Fertilizantes");
		labelCodFertilizantes.setForeground(Color.WHITE);
		labelCodFertilizantes.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodFertilizantes.setBounds(10, 354, 132, 14);
		contentPane.add(labelCodFertilizantes);
		
		textCodPlantio = new JTextField();
		//textCodPlantio.setDocument( new DocumentoLimitado(8) ); //definindo o tamanho do campo
		textCodPlantio.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodPlantio.setColumns(10);
		textCodPlantio.setBounds(10, 269, 132, 20);
		contentPane.add(textCodPlantio);
		
		JLabel labelCodPlantio = new JLabel("C\u00F3digo do Plantio");
		labelCodPlantio.setForeground(Color.WHITE);
		labelCodPlantio.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodPlantio.setBounds(10, 240, 132, 14);
		contentPane.add(labelCodPlantio);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AcessoBD bd = new AcessoBD();
				if(bd.getConnection()){ 

					String sql ="select * from TB_PLANTIO where ID_PLANTIO = ? or ID_PLANTA = ? or ID_FERTILIZANTE = ? or TIPO_ADUBO = ? "
							+ "or TEMPO_MED_IRRIGA = ? or METRAGEM = ? or QTD_SEMENTE = ?"; // instru??o executada no banco de dados.

					try {
						
						// Recebendo os valores inseridos.
						/*String  id = textCodPlantio.getText(); // ID_PLANTIO
						String  idPlanta = textCodPlanta.getText(); // ID_PLANTA	
						String  idFertilizante =  textCodFertilizantes.getText(); // ID_FERTILIZANTE	
						String  tipoAdubo =  textTipoDeAdubo.getText(); // TIPO_ADUBO	
						String  tempoMedio =  textTempoMedio.getText(); // TEMPO_MED_IRRIGA
						String  metragem =  textMetragem.getText(); // METRAGEM
						String  qtdeSementes =  textQuantidadeDeSementes.getText(); // QTD_SEMENTE*/

						
						bd.st = bd.con.prepareStatement(sql); // preparar a instru??o para ser executada.
						bd.st.setString(1, textCodPlantio.getText());
						bd.st.setString(2, textCodPlanta.getText());
						bd.st.setString(3, textCodFertilizantes.getText());
						bd.st.setString(4, textTipoDeAdubo.getText());
						bd.st.setString(5, textTipoDeAdubo.getText());
						bd.st.setString(6, textTipoDeAdubo.getText());
						bd.st.setString(7, textQuantidadeDeSementes.getText());
						bd.rs = bd.st.executeQuery(); // Obt?m a posicao BOF da tabela e executa a Consulta.
						table_plantios.setModel(DbUtils.resultSetToTableModel(bd.rs));	
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
		btPesquisar.setBounds(613, 245, 122, 25);
		contentPane.add(btPesquisar);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Limpando dados inseridos nas textboxs.
				textCodPlantio.setText("");
				textCodPlanta.setText("");
				textCodFertilizantes.setText("");
				textTipoDeAdubo.setText("");
				textTempoMedio.setText("");
				textMetragem.setText("");
				textQuantidadeDeSementes.setText("");
				
			}
		});
		btLimpar.setForeground(Color.WHITE);
		btLimpar.setFont(new Font("Arial", Font.BOLD, 12));
		btLimpar.setBackground(new Color(0, 128, 0));
		btLimpar.setBounds(613, 290, 122, 25);
		contentPane.add(btLimpar);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ID_PLANTIO	ID_PLANTA	ID_FERTILIZANTE	TIPO_ADUBO	TEMPO_MED_IRRIGA	METRAGEM	QTD_SEMENTE	TIPO_PLANTIO								
				//Definindo condicionais para as Datas Inicio/Fim Plantio e Inicio/Fim Colheita
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dtInicioP = "0";
				String dtFimP = "0";
				String dtInicioC = "0";
				String dtFimC = "0";
				if(dateChooserInicioPlantio.getDate() != null && dateChooserFimPlantio.getDate() !=null
						&& dateChooserInicioColheita.getDate() != null && dateChooserFimColheita.getDate() != null) {
					
					dtInicioP = (df.format(dateChooserInicioPlantio.getDate())); //Formata??o da DT_INI_PLANTIO
					dtFimP = (df.format(dateChooserFimPlantio.getDate()));  //Formata??o da DT_FIM_PLANTIO
					
					dtInicioC = (df.format(dateChooserInicioColheita.getDate())); //Formata??o da DT_INI_COLHEITA
					dtFimC = (df.format(dateChooserFimColheita.getDate()));  //Formata??o da DT_FIM_COLHEITA
				}
				else
					JOptionPane.showMessageDialog(null, "Insira datas v?lidas nos Campos");
				
				
				//Definindo a variavel a partir de cada combina??o de sele??o.
				String tipoPlantio; // -- H - Hortali?as | F - Frutas | L - Legumes
				
				if(ComboBoxTipoPlantio.getSelectedItem().equals("Hortali?as"))
				{
					tipoPlantio = "H";
				}
				
				else if(ComboBoxTipoPlantio.getSelectedItem().equals("Frutas"))
				{
					tipoPlantio = "F";
				}
				
				else if(ComboBoxTipoPlantio.getSelectedItem().equals("Legumes"))
				{
					tipoPlantio = "L";
				}
				
				else
				{
					tipoPlantio = "";
				}
				
				Plantio plantio = new Plantio(textCodPlantio.getText(), textCodPlanta.getText(), textCodFertilizantes.getText(),
						textTipoDeAdubo.getText(), textTempoMedio.getText(), textMetragem.getText(), textQuantidadeDeSementes.getText(),
						tipoPlantio, dtInicioP, dtFimP, dtInicioC, dtFimC);
				
				PlantioDAO dao = new PlantioDAO();
				dao.alterar(plantio);
			}
		});
		btAtualizar.setForeground(Color.WHITE);
		btAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btAtualizar.setBackground(new Color(0, 128, 0));
		btAtualizar.setBounds(745, 245, 122, 25);
		contentPane.add(btAtualizar);
		
		JButton btDeletar = new JButton("Deletar");
		btDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Plantio plantio = new Plantio(textCodPlantio.getText());
				
				PlantioDAO dao = new PlantioDAO();
				dao.excluir(plantio);
			}
		});
		btDeletar.setForeground(Color.WHITE);
		btDeletar.setFont(new Font("Arial", Font.BOLD, 12));
		btDeletar.setBackground(new Color(0, 128, 0));
		btDeletar.setBounds(745, 290, 122, 25);
		contentPane.add(btDeletar);
		
		JButton btNovoCadastro = new JButton("Novo Cadastro");
		btNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ID_PLANTIO	ID_PLANTA	ID_FERTILIZANTE	TIPO_ADUBO	TEMPO_MED_IRRIGA	METRAGEM	QTD_SEMENTE	TIPO_PLANTIO								
				//Definindo condicionais para as Datas Inicio/Fim Plantio e Inicio/Fim Colheita
				//DateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
				DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
				
				String dtInicioP = "0";
				String dtFimP = "0";
				String dtInicioC = "0";
				String dtFimC = "0";
				if(dateChooserInicioPlantio.getDate() != null && dateChooserFimPlantio.getDate() !=null
						&& dateChooserInicioColheita.getDate() != null && dateChooserFimColheita.getDate() != null) {
					
					dtInicioP = (df.format(dateChooserInicioPlantio.getDate())); //Formata??o da DT_INI_PLANTIO
					dtFimP = (df.format(dateChooserFimPlantio.getDate()));  //Formata??o da DT_FIM_PLANTIO
					
					dtInicioC = (df.format(dateChooserInicioColheita.getDate())); //Formata??o da DT_INI_COLHEITA
					dtFimC = (df.format(dateChooserFimColheita.getDate()));  //Formata??o da DT_FIM_COLHEITA
				}
				else
					JOptionPane.showMessageDialog(null, "Insira datas v?lidas nos Campos");
				
				
				//Definindo a variavel a partir de cada combina??o de sele??o.
				String tipoPlantio; // -- H - Hortali?as | F - Frutas | L - Legumes
				
				if(ComboBoxTipoPlantio.getSelectedItem().equals("Hortali?as"))
				{
					tipoPlantio = "H";
				}
				
				else if(ComboBoxTipoPlantio.getSelectedItem().equals("Frutas"))
				{
					tipoPlantio = "F";
				}
				
				else if(ComboBoxTipoPlantio.getSelectedItem().equals("Legumes"))
				{
					tipoPlantio = "L";
				}
				
				else
				{
					tipoPlantio = "";
				}
				
				Plantio plantio = new Plantio(textCodPlantio.getText(), textCodPlanta.getText(), textCodFertilizantes.getText(),
						textTipoDeAdubo.getText(), textTempoMedio.getText(), textMetragem.getText(), textQuantidadeDeSementes.getText(),
						tipoPlantio, dtInicioP, dtFimP, dtInicioC, dtFimC);
				
				PlantioDAO dao = new PlantioDAO();
				dao.incluir(plantio);
				
			}
		});
		btNovoCadastro.setForeground(Color.WHITE);
		btNovoCadastro.setFont(new Font("Arial", Font.BOLD, 12));
		btNovoCadastro.setBackground(new Color(0, 128, 0));
		btNovoCadastro.setBounds(613, 321, 254, 25);
		contentPane.add(btNovoCadastro);
		
		JLabel labelCodPlanta = new JLabel("C\u00F3digo da Planta");
		labelCodPlanta.setForeground(Color.WHITE);
		labelCodPlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		labelCodPlanta.setBounds(10, 294, 132, 14);
		contentPane.add(labelCodPlanta);
		
		textCodPlanta = new JTextField();
		//textCodPlanta.setDocument( new DocumentoLimitado(8) ); //definindo o tamanho do campo
		textCodPlanta.setFont(new Font("Arial", Font.PLAIN, 12));
		textCodPlanta.setColumns(10);
		textCodPlanta.setBounds(10, 323, 132, 20);
		contentPane.add(textCodPlanta);
		
		textTipoDeAdubo = new JTextField();
		textTipoDeAdubo.setDocument( new DocumentoLimitado(20) ); //definindo o tamanho do campo
		textTipoDeAdubo.setFont(new Font("Arial", Font.PLAIN, 12));
		textTipoDeAdubo.setColumns(10);
		textTipoDeAdubo.setBounds(158, 269, 132, 20);
		contentPane.add(textTipoDeAdubo);
		
		JLabel labelTipoDeAdubo = new JLabel("Tipo de Adubo");
		labelTipoDeAdubo.setForeground(Color.WHITE);
		labelTipoDeAdubo.setFont(new Font("Arial", Font.PLAIN, 12));
		labelTipoDeAdubo.setBounds(158, 240, 132, 14);
		contentPane.add(labelTipoDeAdubo);
		
		textMetragem = new JTextField();
		textMetragem.setDocument( new DocumentoLimitado(4) ); //definindo o tamanho do campo
		textMetragem.setFont(new Font("Arial", Font.PLAIN, 12));
		textMetragem.setColumns(10);
		textMetragem.setBounds(158, 383, 132, 20);
		contentPane.add(textMetragem);
		
		JLabel labelMetragem = new JLabel("Metragem (m\u00B2)");
		labelMetragem.setForeground(Color.WHITE);
		labelMetragem.setFont(new Font("Arial", Font.PLAIN, 12));
		labelMetragem.setBounds(158, 352, 132, 14);
		contentPane.add(labelMetragem);
		
		JLabel labelInicioPlantio = new JLabel("Inicio do Plantio");
		labelInicioPlantio.setForeground(Color.WHITE);
		labelInicioPlantio.setFont(new Font("Arial", Font.PLAIN, 12));
		labelInicioPlantio.setBounds(304, 240, 150, 14);
		contentPane.add(labelInicioPlantio);
		
		JLabel labelFimPlantio = new JLabel("Fim do Plantio");
		labelFimPlantio.setForeground(Color.WHITE);
		labelFimPlantio.setFont(new Font("Arial", Font.PLAIN, 12));
		labelFimPlantio.setBounds(304, 295, 150, 14);
		contentPane.add(labelFimPlantio);
		
		JLabel labelInicioColheita = new JLabel("Inicio da Colheita");
		labelInicioColheita.setForeground(Color.WHITE);
		labelInicioColheita.setFont(new Font("Arial", Font.PLAIN, 12));
		labelInicioColheita.setBounds(464, 240, 150, 14);
		contentPane.add(labelInicioColheita);
		
		JLabel labelFimColheita = new JLabel("Fim da Colheita");
		labelFimColheita.setForeground(Color.WHITE);
		labelFimColheita.setFont(new Font("Arial", Font.PLAIN, 12));
		labelFimColheita.setBounds(464, 295, 150, 14);
		contentPane.add(labelFimColheita);
		
		//JDateChooser dateChooserInicioPlantio = new JDateChooser();
		dateChooserInicioPlantio = new JDateChooser();
		dateChooserInicioPlantio.setBounds(300, 265, 136, 20);
		contentPane.add(dateChooserInicioPlantio);
		
		//JDateChooser dateChooserFimPlantio = new JDateChooser();
		dateChooserFimPlantio = new JDateChooser();
		dateChooserFimPlantio.setBounds(300, 324, 136, 20);
		contentPane.add(dateChooserFimPlantio);
		
		//JDateChooser dateChooserInicioColheita = new JDateChooser();
		dateChooserInicioColheita = new JDateChooser();
		dateChooserInicioColheita.setBounds(460, 265, 136, 20);
		contentPane.add(dateChooserInicioColheita);
		
		//JDateChooser dateChooserFimColheita = new JDateChooser();
		dateChooserFimColheita = new JDateChooser();
		dateChooserFimColheita = new JDateChooser();
		dateChooserFimColheita.setBounds(460, 324, 136, 20);
		contentPane.add(dateChooserFimColheita);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 857, 182);
		contentPane.add(scrollPane);
		
		table_plantios = new JTable();
		scrollPane.setViewportView(table_plantios);
		
		JButton btFiltroPlantios = new JButton("Filtrar Plantios");
		btFiltroPlantios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshTable();
			}
		});
		btFiltroPlantios.setForeground(Color.WHITE);
		btFiltroPlantios.setFont(new Font("Arial", Font.BOLD, 12));
		btFiltroPlantios.setBackground(new Color(0, 128, 0));
		btFiltroPlantios.setBounds(613, 13, 254, 25);
		contentPane.add(btFiltroPlantios);
		
		JLabel labelTipoPlantio = new JLabel("Tipo Plantio ");
		labelTipoPlantio.setForeground(Color.WHITE);
		labelTipoPlantio.setFont(new Font("Arial", Font.PLAIN, 12));
		labelTipoPlantio.setBounds(460, 378, 74, 14);
		contentPane.add(labelTipoPlantio);
		
		//JComboBox ComboBoxTipoPlantio = new JComboBox();
		ComboBoxTipoPlantio = new JComboBox();
		ComboBoxTipoPlantio.setModel(new DefaultComboBoxModel(new String[] {"<Selecionar uma op\u00E7\u00E3o>", "Hortali\u00E7as", "Frutas", "Legumes"}));
		ComboBoxTipoPlantio.setBounds(544, 370, 98, 31);
		contentPane.add(ComboBoxTipoPlantio);
	}
}
