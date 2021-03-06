package metodos_projeto;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import metodos.AcessoBD;

public class EquipamentoDAO {

	private AcessoBD bd;
	private String men, sql;
	
	// Esatabelecendo o Construtor para a Classe EquipamentoDAO
	public EquipamentoDAO() {
		bd = new AcessoBD(); // instancia um objeto da Classe BD.
	}
	
	/**
	 * Armazena um Equipamento no banco de dados.
	 * @param Equipamento - O Equipamento a ser gravado.
	 * @return - uma mensagem informando o resultado de uma opera??o.
	 */
	public String incluir(Equipamento equipamento) {
		
		// Verifica??o em console do recebimento das informa??es.
		System.out.println(equipamento.getId() + equipamento.getDescricao() + equipamento.getValor() + equipamento.getDtUltManutencao());
		
		/*String  id = textCodEquipamento.getText(); // ID_EQUIPAMENTO		
		String  descricao = textDescricao.getText(); // DESCRICAO			
		String  valor =  textValor.getText(); // VALOR_EQUIPAMENTO			
		// DT_ULTIMA_MAN*/
		
		//Instru??o a ser executada no Banco de Dados.
		sql = "insert into TB_EQUIPAMENTO (DESCRICAO, VALOR_EQUIPAMENTO, DT_ULTIMA_MAN) values (?,?,?)";
		
		//Acessando o Banco de Dados.
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, equipamento.getDescricao());
			bd.st.setString(2, equipamento.getValor());
			bd.st.setString(3, equipamento.getDtUltManutencao());
			bd.st.executeUpdate();
			men = "Equipamento inserido com sucesso!"; // Armazena uma informa??o p?s execu??o.
		}
		
		catch(SQLException erro) {
			men = "Falha: " + erro;
		}
			
		finally {
			bd.close(); // Finaliza o Acesso ao Banco de Dados.
		}
		
		JOptionPane.showMessageDialog(null, men); // Imprimi a mensagem obtida durante a op??o.
		return men;
	}
	
	/**
	 * Altera um Equipamento no banco de dados.
	 * @param Equipamento - O Equipamento a ser gravado.
	 * @return - uma mensagem informando o resultado de uma opera??o.
	 */
	public String alterar(Equipamento equipamento) {
		
		// Verifica??o em console do recebimento das informa??es.
		System.out.println(equipamento.getId() + equipamento.getDescricao() + equipamento.getValor() + equipamento.getDtUltManutencao());
		
		//Instru??o a ser executada no Banco de Dados.
		sql = "update TB_EQUIPAMENTO set DESCRICAO = ?, VALOR_EQUIPAMENTO = ?, DT_ULTIMA_MAN = ? where ID_EQUIPAMENTO = ?";
		
		//Acessando o Banco de Dados.
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, equipamento.getDescricao());
			bd.st.setString(2, equipamento.getValor());
			bd.st.setString(3, equipamento.getDtUltManutencao());
			bd.st.setString(4, equipamento.getId());
			bd.st.executeUpdate();
			men = "Equipamento Alterado com sucesso!"; // Armazena uma informa??o p?s execu??o.
		}
		
		catch(SQLException erro) {
				men = "Falha: " + erro;
		}
			
		finally {
			bd.close(); // Finaliza o Acesso ao Banco de Dados.
		}
		
		JOptionPane.showMessageDialog(null, men); // Imprimi a mensagem obtida durante a op??o.
		return men;
	}
	
	/**
	 * Exclui um Equipamento a partir de seu ID.
	 * @param Equipamento - o ID do Equipamento.
	 * @return - uma mensagem informando o resultado da opera??o.
	 */
	public String excluir(Equipamento equipamento) {
		
		// Verifica??o em console do recebimento das informa??es.
		System.out.println(equipamento.getId());
		
		//Instru??o a ser executada no Banco de Dados.
		sql = "delete from TB_EQUIPAMENTO where ID_EQUIPAMENTO = ?";
		
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, equipamento.getId());
			int n = bd.st.executeUpdate();
			
			if (n==1) {
				men = "Equipamento exclu?do com sucesso!"; // Armazena uma informa??o p?s execu??o.
			}
			else {
				men = "Equipamento n?o encontrado"; // Armazena uma informa??o p?s execu??o.
			}
			
			men = "Equipamento exclu?do com sucesso!"; // Armazena uma informa??o p?s execu??o.
		}
		
		catch(SQLException erro) {
			
			men = "Erro: " + erro; // Imprimi o erro encontrado.
			
			}
		
		finally {
			bd.close();  // Finaliza o Acesso ao Banco de Dados.
		}
		
		JOptionPane.showMessageDialog(null, men); // Imprimi a mensagem obtida durante a op??o.
		return men;
	}
}
