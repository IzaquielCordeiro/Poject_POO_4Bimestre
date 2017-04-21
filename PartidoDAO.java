	package DAO;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import ClassesBD.partido;

	public class PartidoDAO{
			private static Connection conn;

			PartidoDAO() throws SQLException{
				conn = DriverManager.getConnection("jdbc:mysql://localhost/BD", "root", "");
			}
			
			public static void add(partido c) throws SQLException{
				String sql = "INSERT INTO tb_partido (nome, data_nascimento, cpf) VALUES(?, ?, ?)";
		
				try{
		
					PreparedStatement stmt = conn.prepareStatement(sql);
			
					stmt.setLong(1, c.getCnpj());
			
					stmt.setString(2, c.getNome());
					
					stmt.execute();
			
					stmt.close();
		
				} catch(SQLException erro){
					System.out.println("Erro de conexão com o banco!");
				}
			}
			
			public static void rm(partido c){
				String sql = "DELETE FROM tb_partido WHERE cpf = ?";
				
				try{
		
					PreparedStatement stmt = conn.prepareStatement(sql);
			
					stmt.setInt(1, c.getCnpj());
					
					stmt.execute();
			
					stmt.close();
		
				} catch(SQLException erro){
					System.out.println("Erro de conexão com o banco!");
				}
			}
			
			public static partido bus(partido c){
				String sql = "SELECT * FROM tb_partido WHERE cpf = ?";
				
				partido partido = new partido();

				try{

					PreparedStatement stmt = conn.prepareStatement(sql);

					stmt.setInt(1, c.getCnpj());

					ResultSet result = stmt.executeQuery();

					partido.setNome(result.getString(1));
					partido.setCnpj(result.getInt(1));
					
				} catch(SQLException erro){
					System.out.println("Erro de conexão com o banco!");
				}

				return partido;
			}
			
			public static void fecharCon() throws SQLException{
				conn.close();
			}
}


