package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassesBD.candidato;

public class CandidatoDAO{
		private static Connection conn;

		CandidatoDAO() throws SQLException{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/BD", "root", "");
		}
		
		public static void add(candidato c) throws SQLException{
			String sql = "INSERT INTO tb_candidato (nome, data_nascimento, cpf) VALUES(?, ?, ?)";
	
			try{
	
				PreparedStatement stmt = conn.prepareStatement(sql);
		
				stmt.setString(1, c.getNome());
		
				stmt.setInt(2, c.getDataNascimento());
				stmt.setInt(3, c.getCpf());
				
				stmt.execute();
		
				stmt.close();
	
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

				Candidato.setCpf(result.getInt(1));
				Candidato.setDataNascimento(result.getInt(1));
				Candidato.setNome(result.getString(1));
				
			} catch(SQLException erro){
				System.out.println("Erro de conexão com o banco!");
			}

			return Candidato;
		}
		
		public static void fecharCon() throws SQLException{
			conn.close();
		}
}
