package metodos_projeto;

public class Usuario {

	public String id;
	public String nome;
	private String senha;
	private String email;
	private String status;
	private String perfil;
	private String dtCadastro;
	private String dtAlteracao;
	
	/**
	 * M?todo Construtor para receber o c?digo do Usu?rio.
	 * @param text - vari?vel que armazena o valor recebido do ID.
	 */
	public Usuario(String text) {
		this.id= text;
	}


	/**
	 * M?todo Construtor para receber todos os dados de um Usu?rio.
	 * @param text - vari?vel que armazena o valor recebido do ID.
	 * @param text2 - vari?vel que armazena o valor recebido do NOME.
	 * @param text3 - vari?vel que armazena o valor recebido da SENHA.
	 * @param dtCadastro - vari?vel que armazena o valor recebido da DATA DE CADASTRO.
	 * @param text4 - vari?vel que armazena o valor recebido dO EMAIL.
	 * @param dtAlteracao - vari?vel que armazena o valor recebido da DATA DE ALTERA??O.
	 * @param statusUsuario - vari?vel que armazena o valor recebido do STATUS DO USU?RIO.
	 * @param statusPerfil - vari?vel que armazena o valor recebido do PERFIL.
	 */
	public Usuario(String text, String text2, String text3, String dtCadastro, String text4, String dtAlteracao,
			String statusUsuario, String statusPerfil) {
		this.id= text;
		this.nome=text2;
		this.dtCadastro=dtCadastro;
		this.senha=text3;
		this.email=text4;
		this.dtAlteracao=dtAlteracao;
		this.status=statusUsuario;
		this.perfil=statusPerfil;
	}


	/**
	 * M?todo que recebe a DATA DE CADASTRO.
	 * @return - retorna a DATA DE CADASTRO.
	 */
	public String getDtCadastro() {
		return dtCadastro;
	}

	/**
	 * M?todo que define a DATA DE CADASTRO.
	 * @param dtCadastro - vari?vel que armazena a DATA DE CADASTRO.
	 */
	public void setDtCadastro(String dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	/**
	 * M?todo que recebe a DATA DE ALTERA??O.
	 * @return - retorna a DATA DE ALTERA??O.
	 */
	public String getDtAlteracao() {
		return dtAlteracao;
	}


	/**
	 * M?todo que define a DATA DE ALTERA??O.
	 * @param dtAlteracao - vari?vel que armazena a DATA DE ALTERA??O.
	 */
	public void setDtAlteracao(String dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}


	/**
	 * M?todo que recebe o ID.
	 * @return - retorna o ID.
	 */
	public String getId() {
		return id;
	}


	/**
	 * M?todo que define o ID.
	 * @param text - vari?vel que armazena o ID.
	 */
	public void setId(String text) {
		this.id = text;
	}


	/**
	 * M?todo que recebe o NOME.
	 * @return - retorna o NOME.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M?todo que define o NOME.
	 * @param text2 - vari?vel que armazena o NOME.
	 */
	public void setNome(String text2) {
		this.nome = text2;
	}

	/**
	 * M?todo que recebe a SENHA.
	 * @return - retorna a SENHA.
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * M?todo que define a SENHA.
	 * @param text3 - vari?vel que armazena a SENHA.
	 */
	public void setSenha(String text3) {
		this.senha = text3;
	}


	/**
	 * M?todo que recebe o EMAIL.
	 * @return - retorna o EMAIL.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * M?todo que define o EMAIL.
	 * @param text4 - vari?vel que armazena o EMAIL.
	 */
	public void setEmail(String text4) {
		this.email = text4;
	}

	/**
	 * M?todo que recebe o STATUS.
	 * @return - retorna o STATUS.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * M?todo que define o STATUS.
	 * @param statusUsuario - vari?vel que armazena o STATUS.
	 */
	public void setStatus(String statusUsuario) {
		this.status = statusUsuario;
	}

	/**
	 * M?todo que recebe o PERFIL.
	 * @return - retorna o PERFIL.
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * M?todo que define o PERFIL.
	 * @param statusPerfil - vari?vel que armazena o PERFIL.
	 */
	public void setPerfil(String statusPerfil) {
		this.perfil = statusPerfil;
	}
}
