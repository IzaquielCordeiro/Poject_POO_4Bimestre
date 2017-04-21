package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassesBD.partido;

public class PartidoDAO{
	private static Connection conn;

	public static void abrir() throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://localhost/BD", "POO", "12345678");
	}
		
	public static void add(partido c) throws SQLException{
		String sql = "INSERT INTO tb_partido (nome, cnpj) VALUES(?, ?)";
	
		try{
	
			PreparedStatement stmt = conn.prepareStatement(sql);
		
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getCnpj());
				
			stmt.execute();
			stmt.close();
	
		} catch(SQLException erro){
				System.out.println("Erro de conex�o com o banco!");
		}
	}
		
	public static void rm(partido c){
		String sql = "DELETE FROM tb_partido WHERE cnpj = ?";
			
		try{
	
			PreparedStatement stmt = conn.prepareStatement(sql);
		
			stmt.setInt(1, c.getCnpj());
				
			stmt.execute();
			stmt.close();
	
		} catch(SQLException erro){
			System.out.println("Erro de conex�o com o banco!");
		}
	}
		
	public static partido bus(partido c){
		String sql = "SELECT * FROM tb_partido WHERE cnpj = ?";
			
		partido partido = new partido();

		try{

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, c.getCnpj());

			ResultSet result = stmt.executeQuery();
			
			result.next();
			
			partido.setNome(result.getString("nome"));
			partido.setCnpj(result.getInt("cnpj"));
				
		} catch(SQLException erro){
			System.out.println("Erro de conex�o com o banco!");
		}

		return partido;
	}
		
	public static void fechar() throws SQLException{
		conn.close();
	}
}


