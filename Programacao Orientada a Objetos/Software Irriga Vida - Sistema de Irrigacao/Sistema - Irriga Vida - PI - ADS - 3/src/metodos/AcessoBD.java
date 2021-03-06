package metodos;

import java.sql.*; // Seleciona todos os imports necess?rios, Cont?m classes e interfaces utilizadas no acesso e manipula??o de dados via JDBC.

public class AcessoBD {

	// Realiza a conex?o ao BD por meio do driver do banco.
	public Connection con = null;
	
	// Realiza a execu??o de instru??es SQL.
	public PreparedStatement st = null;
	
	// Maniupula uma tabela em mem?ria.
	public ResultSet rs = null;
	
	// Pacote.Classe do driver
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // especifica o caminho em que est? o driver. 
	private final String DATABASENAME = "DB_IRRIGA_VIDA"; // nome do banco de dados ques est? sendo acessado.
	private final String URL ="jdbc:sqlserver://localhost:1433;databasename=" + DATABASENAME ; // direciona a porta que ? usado para a conex?o ao BD.
	private final String LOGIN ="sa"; // nome do LOGIN que est? sendo acessado.
	private final String PASSWORD ="Sqlshadow"; // senha do LOGIN que est? sendo acessado.
	
	/***
	 * Realiza a conex?o ao banco de dados
	 * @return - true em caso de sucesso ou false caso contr?rio
	 */
	public boolean getConnection() {
		try {
			Class.forName(DRIVER); // carregando o DRIVER
			//System.out.println("Driver carregado com sucesso !!!"); // retorno de carregamento.
			con = DriverManager.getConnection(URL,LOGIN,PASSWORD); // fornecendo os par?metros de acesso do BD.
			System.out.println("Conectado com sucesso!"); // retorno de conex?o.
			System.out.println("\n");
			return true;
			}
		catch(ClassNotFoundException erro) {
			System.out.println("Driver n?o encontrado !!!"); // retorno do DRIVER ausente.
			return false;
		}
		catch(SQLException erro) {
			System.out.println("Falha na conex?o" + erro); // retorno de falha de conex?o com o BD.
			return false;
		}
	}
	
	/***
	 * Encerra a conex?o ao banco de dados, fechando todos objetos utilizados.
	 */
	public void close() {
		try {
			if(rs!=null) rs.close(); // Encerra o ResultSet na aus?ncia de valores.
			if(st!=null) st.close(); // Encerra o PreparedStatement sen?o houve execu??o de instru??es.
			if(con!=null) {
				con.close(); // encerra a conex?o ao BD.
				System.out.println("\n");
				System.out.println("Conex?o ao Banco de Dados encerrada...");
			}
		}
		catch(SQLException erro){}
	}
	
	public static void main(String[] args) {
		
		AcessoBD bd = new AcessoBD();
		bd.getConnection();
		//executar uma instru??o
		bd.close();
	}
}
