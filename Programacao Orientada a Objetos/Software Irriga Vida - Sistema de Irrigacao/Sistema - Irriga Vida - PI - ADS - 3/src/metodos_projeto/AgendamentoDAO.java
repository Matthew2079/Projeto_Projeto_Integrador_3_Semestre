package metodos_projeto;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import metodos.AcessoBD;

public class AgendamentoDAO {

	private AcessoBD bd;
	private String men, sql;
	
	// Esatabelecendo o Construtor para a Classe AgendamentoDAO
	public AgendamentoDAO() {
		bd = new AcessoBD(); // instancia um objeto da Classe BD.
	}
	
	/**
	 * Armazena um Agendamento no banco de dados.
	 * @param Agendamento - O Agendamento a ser gravado.
	 * @return - uma mensagem informando o resultado de uma opera??o.
	 */
	public String incluir(Agendamento agendamento) {
		
		// Verifica??o em console do recebimento das informa??es.
		System.out.println(agendamento.getIdUsuario() + agendamento.getIdEquipamento() + agendamento.getDescricao() +
				agendamento.getTipoAgendamento() + agendamento.getDtAgendamento() + agendamento.getStatusAgendamento());		
		
		//Instru??o a ser executada no Banco de Dados.
		sql = "insert into TB_AGENDAMENTOS (ID_USUARIO, ID_EQUIPAMENTO, DESCRICAO, TIPO_AGEN, DT_MARCADA_AGEND,"
				+ "STATUS_AGEN) values (?,?,?,?,?,?)";
		
		//Acessando o Banco de Dados.
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, agendamento.getIdUsuario());
			bd.st.setString(2, agendamento.getIdEquipamento());
			bd.st.setString(3, agendamento.getDescricao());
			bd.st.setString(4, agendamento.getTipoAgendamento());
			bd.st.setString(5, agendamento.getDtAgendamento());
			bd.st.setString(6, agendamento.getStatusAgendamento());
			bd.st.executeUpdate();
			men = "Agendamento inserido com sucesso!"; // Armazena uma informa??o p?s execu??o.
		}
		
		catch(SQLException erro) {

			/*men = "Falha: " + erro;
			JOptionPane.showMessageDialog(null, men); // Imprimi o erro encontrado.*/

			if(erro.toString().indexOf("CHECK")>=0) {
				men = "Erro de cla?sula CHECK, Favor selecionar uma op??o no STATUS e/ou TIPO DE AGENDAMENTO";
			}

			else {
				men = "Falha: " + erro;
			}
		}
			
		finally {
			bd.close(); // Finaliza o Acesso ao Banco de Dados.
		}
		
		JOptionPane.showMessageDialog(null, men); // Imprimi a mensagem obtida durante a op??o.
		return men;
	}
	
	/**
	 * Altera um Agendamento no banco de dados.
	 * @param Agendamento - O Agendamento a ser gravado.
	 * @return - uma mensagem informando o resultado de uma opera??o.
	 */
	public String alterar(Agendamento agendamento) {
		
		// Verifica??o em console do recebimento das informa??es.
		System.out.println(agendamento.getIdUsuario() + agendamento.getIdEquipamento() + agendamento.getDescricao() +
				agendamento.getTipoAgendamento() + agendamento.getDtAgendamento() + agendamento.getStatusAgendamento());		
				
				// ID_AGENDAMENTO	ID_USUARIO	ID_EQUIPAMENTO	DESCRICAO	TIPO_AGEN	DT_MARCADA_AGEND	STATUS_AGEN
				
		//Instru??o a ser executada no Banco de Dados.
		sql = "update TB_AGENDAMENTOS set ID_USUARIO = ?, ID_EQUIPAMENTO = ?, DESCRICAO = ?,"
				+ " TIPO_AGEN = ?, DT_MARCADA_AGEND = ?, STATUS_AGEN = ? where ID_AGENDAMENTO = ?";
		
		//Acessando o Banco de Dados.
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, agendamento.getIdUsuario());
			bd.st.setString(2, agendamento.getIdEquipamento());
			bd.st.setString(3, agendamento.getDescricao());
			bd.st.setString(4, agendamento.getTipoAgendamento());
			bd.st.setString(5, agendamento.getDtAgendamento());
			bd.st.setString(6, agendamento.getStatusAgendamento());
			bd.st.setString(7, agendamento.getId());
			bd.st.executeUpdate();
			men = "Agendamento Alterado com sucesso!"; // Armazena uma informa??o p?s execu??o.
		}
		
		catch(SQLException erro) {
			/*men = "Falha: " + erro;
			JOptionPane.showMessageDialog(null, men); // Imprimi o erro encontrado.*/

			if(erro.toString().indexOf("CHECK")>=0) {
				men = "Erro de cla?sula CHECK, Favor selecionar uma op??o no STATUS e/ou TIPO DE AGENDAMENTO";
			}

			else {
				men = "Falha: " + erro;
			}
		}
			
		finally {
			bd.close(); // Finaliza o Acesso ao Banco de Dados.
		}
		
		JOptionPane.showMessageDialog(null, men); // Imprimi a mensagem obtida durante a op??o.
		return men;
	}
	
	/**
	 * Exclui um Agendamento a partir de seu ID.
	 * @param Agendamento - o ID do Agendamento.
	 * @return - uma mensagem informando o resultado da opera??o.
	 */
	public String excluir(Agendamento agendamento) {
		
		// Verifica??o em console do recebimento das informa??es.
		System.out.println(agendamento.getId());
		
		//Instru??o a ser executada no Banco de Dados.
		sql = "delete from TB_AGENDAMENTOS where ID_AGENDAMENTO = ?";
		
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, agendamento.getId());
			int n = bd.st.executeUpdate();
			
			if (n==1) {
				men = "Agendamento exclu?do com sucesso!"; // Armazena uma informa??o p?s execu??o.
			}
			else {
				men = "Agendamento n?o encontrado"; // Armazena uma informa??o p?s execu??o.
			}
			
			men = "Agendamento exclu?do com sucesso!"; // Armazena uma informa??o p?s execu??o.
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
