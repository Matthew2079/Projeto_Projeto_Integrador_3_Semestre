package metodos_projeto;

public class Agendamentos {
	
	public int id;
	private String descricao;
	private char tipo;
	private char status;
	private String dtAgendamento;
	public int idUsuario;
	public int idEquipamento;
	
	/***
	 *  M?todo que ir? realizar as opera??es do sistema ? respeito aos Agendamentos (Cadastrar, Editar, Excluir, Consultar) 
	 */
	private void manterAgendamento() {
		
		// L?gica ainda a ser implementada
	}
	
	/***
	 * M?todo que ir? receber o id de um equipamento e buscar na classe Equipamento
	 * @param idEquipamento - id de um determinado equipamento
	 * @return - retorna o equipamento correspondente
	 */
	private Equipamento buscarEquipamento(int idEquipamento) {
		return null;
		
		// L?gica ainda a ser implementada
	}
	
	/***
	 * M?todo que ir? receber o id de um usu?rio e buscar na classe Usu?rio
	 * @param idUsuario - id de um determinado usu?rio
	 * @return - retorna o usu?rio correspondente
	 */
	private Usuario buscarUsuario(int idUsuario) {
		return null;
		
		// L?gica ainda a ser implementada
	}
	
	/***
	 * M?todo que valida se a data agendada est? dispon?vel
	 * @param dtAgendamento - data armazenada durante inser??o
	 * @return - retorna uma mensagem de valida??o
	 */
	private String validarDataAgendamento(String dtAgendamento) {
		String mensagem = null;
		return mensagem;
	}
}
