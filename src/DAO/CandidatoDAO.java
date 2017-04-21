package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassesBD.candidato;

public class CandidatoDAO{
	private static Connection conn;

	public static void abrir() throws SQLException, ClassNotFoundException{
		conn = DriverManager.getConnection("jdbc:mysql://localhost/BD", "POO", "12345678");
	}
	
	public static void add(candidato c) throws SQLException{
		String sql = "INSERT INTO tb_candidato (nome, data_nascimento, cpf) VALUES(?, ?, ?)";

		try{

			PreparedStatement stmt = conn.prepareStatement(sql);
	
			stmt.setString(1, c.getNome());
			stmt.setDate(2, c.getDataNascimento());
			stmt.setInt(3, c.getCpf());
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Candidato adicionado com sucesso!");
		} catch(SQLException erro){
			System.out.println("Erro de conexão com o banco!");
		}
	}
	
	public static void rm(candidato c){
		String sql = "DELETE FROM tb_candidato WHERE cpf = ?";
		
		try{

			PreparedStatement stmt = conn.prepareStatement(sql);
	
			stmt.setInt(1, c.getCpf());
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Candidato removido com sucesso!");
		} catch(SQLException erro){
			System.out.println("Erro de conexão com o banco!");
		}
	}
	
	public static candidato bus(candidato c){
		String sql = "SELECT * FROM tb_candidato WHERE cpf = ?";
		
		candidato Candidato = new candidato();

		try{

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, c.getCpf());

			ResultSet result = stmt.executeQuery();
			
			result.next();
			
			Candidato.setCpf(result.getInt("cpf"));
			Candidato.setDataNascimento(result.getDate("data_nascimento"));
			Candidato.setNome(result.getString("nome"));
			
		} catch(SQLException erro){
			System.out.println("Erro de conexão com o banco!");
		}

		return Candidato;
	}
	
	public static void fechar() throws SQLException{
		conn.close();
	}
}
