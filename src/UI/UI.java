package UI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ClassesBD.candidato;
import ClassesBD.partido;
import DAO.CandidatoDAO;
import DAO.PartidoDAO;

public class UI {
	
	public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException {
		try{
			CandidatoDAO.abrir();
			PartidoDAO.abrir();
			
			menuPrincipal();
			
			try{
				CandidatoDAO.fechar();
				PartidoDAO.fechar();
			}catch(Exception e){
				System.out.println("Erro ao fechar conexão com o banco");
			}
		}catch(Exception e){
			System.out.println("Erro ao abrir conexão com o banco");
		}
	}
	

	public static void limparTela(){
		for(int i=0;i<100;i++)
			System.out.println();
	}
	
	public static void menuPrincipal() throws SQLException, ParseException{
		limparTela();
		
		while(true){
			System.out.println("1 - Adicionar Classe");
			System.out.println("2 - Remover Classe");
			System.out.println("3 - Buscar Classe");
			System.out.println("4 - Sair");
			
			Scanner opcaoSC = new Scanner(System.in);
			
			int opcao = opcaoSC.nextInt();
			opcaoSC.nextLine();
			
			if(opcao==1){
				limparTela();
				menuAdicionarClasse();
			}
			else
				if(opcao==2){
					limparTela();
					menuRemoverClasse();
				}
				else
					if(opcao==3){
						limparTela();
						menuBuscarClasse();
					}
					else
						if(opcao==4){
							limparTela();
							break;
						}
						else{
							limparTela();
							System.out.println("Vc digitou uma opcao errada!");
						}
		}
	}
	
	private static void menuBuscarClasse(){
		limparTela();
		
		System.out.println("1 - Buscar por Arquivo");
		System.out.println("2 - Buscar por Interface");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			try {
				menuBuscarClasseArquivo();
			} catch (IOException e) {
				System.out.println("Erro na leitura do arquivo");
			}
		}
		else
			if(opcao==2){
				limparTela();
				menuBuscarClasseInterface();
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuBuscarClasseArquivo() throws IOException{
		limparTela();
		
		System.out.println("1 - Buscar Candidato");
		System.out.println("2 - Buscar Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o caminho do arquivo:");
			String caminhoArquivo = opcaoSC.nextLine();
			
			InputStream is = new FileInputStream(caminhoArquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			try{
				Candidato.setCpf(Integer.parseInt(br.readLine()));
			}  catch(Exception e){
				System.out.println("Erro no formato do cpf!");
				br.close();
				
				return;
			}
			
			br.close();
			
			candidato CandidatoS = CandidatoDAO.bus(Candidato);
			
			if(CandidatoS!=null){
				System.out.println("Nome: " + CandidatoS.getNome());
				System.out.println("CPF: " + CandidatoS.getCpf());
				
				try{
					System.out.println("Data Nascimento: " + CandidatoS.getDataNascimento().toString());
				} catch(Exception e){
					System.out.println("Data Nascimento: null");
				}
			} else{
				System.out.println("Candidato não encontrado!");
			}
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o caminho do arquivo:");
				String caminhoArquivo = opcaoSC.nextLine();
				
				InputStream is = new FileInputStream(caminhoArquivo);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				try{
					Partido.setCnpj(Integer.parseInt(br.readLine()));
				}  catch(Exception e){
					System.out.println("Erro no formato do cnpj!");
					br.close();
					
					return;
				}
				
				br.close();
				
				partido PartidoS = PartidoDAO.bus(Partido);
				
				if(PartidoS!=null){
					System.out.println("Nome: " + PartidoS.getNome());
					System.out.println("CNPJ: " + PartidoS.getCnpj());
				} else{
					System.out.println("Partido não encontrado!");
				}
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuBuscarClasseInterface(){
		System.out.println("1 - Buscar Candidato");
		System.out.println("2 - Buscar Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o cpf:");
			try{
				Candidato.setCpf(opcaoSC.nextInt());
				opcaoSC.nextLine();
			}  catch(Exception e){
				System.out.println("Erro no formato do cpf!");
				
				return;
			}
			
			candidato CandidatoS = CandidatoDAO.bus(Candidato);
			
			if(CandidatoS!=null){
				System.out.println("Nome: " + CandidatoS.getNome());
				System.out.println("CPF: " + CandidatoS.getCpf());
				
				try{
					System.out.println("Data Nascimento: " + CandidatoS.getDataNascimento().toString());
				} catch(Exception e){
					System.out.println("Data Nascimento: null");
				}
			} else{
				System.out.println("Candidato não encontrado!");
			}
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o cnpj:");
				
				try{
					Partido.setCnpj(opcaoSC.nextInt());
					opcaoSC.nextLine();
				}  catch(Exception e){
					System.out.println("Erro no formato do cnpj!");
					
					return;
				}
				
				partido PartidoS = PartidoDAO.bus(Partido);
				
				if(PartidoS!=null){
					System.out.println("Nome: " + PartidoS.getNome());
					System.out.println("CNPJ: " + PartidoS.getCnpj());
				} else{
					System.out.println("Partido não encontrado!");
				}
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuRemoverClasse(){
		limparTela();
		
		System.out.println("1 - Remover por Arquivo");
		System.out.println("2 - Remover por Interface");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			
			try {
				menuRemoverClasseArquivo();
			} catch (IOException e) {
				System.out.println("Erro na leitura do arquivo");
			}
		}
		else
			if(opcao==2){
				limparTela();
				menuRemoverClasseInterface();
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuRemoverClasseArquivo() throws IOException{
		limparTela();
		
		System.out.println("1 - Remover Candidato");
		System.out.println("2 - Remover Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o caminho do arquivo:");
			String caminhoArquivo = opcaoSC.nextLine();
			
			InputStream is = new FileInputStream(caminhoArquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			try{
				Candidato.setCpf(Integer.parseInt(br.readLine()));
			}  catch(Exception e){
				System.out.println("Erro no formato do cpf!");
				br.close();
				
				return;
			}
			br.close();
			
			CandidatoDAO.rm(Candidato);
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o caminho do arquivo:");
				String caminhoArquivo = opcaoSC.nextLine();
				
				InputStream is = new FileInputStream(caminhoArquivo);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				try{
					Partido.setCnpj(Integer.parseInt(br.readLine()));
				} catch(Exception e){
					System.out.println("Erro no formato do cnpj!");
					br.close();
					
					return;
				}
				
				br.close();
				
				PartidoDAO.rm(Partido);
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuRemoverClasseInterface(){
		limparTela();
		
		System.out.println("1 - Remover Candidato");
		System.out.println("2 - Remover Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o cpf:");
			try{
				Candidato.setCpf(opcaoSC.nextInt());
				opcaoSC.nextLine();
			} catch(Exception e){
				System.out.println("Erro no formato do cpf!");

				return;
			}
			
			CandidatoDAO.rm(Candidato);
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o cnpj:");
				
				try{
					Partido.setCnpj(opcaoSC.nextInt());
					opcaoSC.nextLine();
				} catch(Exception e){
					System.out.println("Erro no formato do cnpj!");

					return;
				}
				
				PartidoDAO.rm(Partido);
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	public static void menuAdicionarClasse() throws SQLException, ParseException{
		limparTela();
		
		System.out.println("1 - Adicionar por Arquivo");
		System.out.println("2 - Adicionar por Interface");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			
			try {
				menuAdicionarClasseArquivo();
			} catch (IOException e) {
				System.out.println("Erro na leitura do arquivo");
			}
		}
		else
			if(opcao==2){
				limparTela();
				menuAdiconarClasseInterface();
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuAdicionarClasseArquivo() throws IOException, SQLException, ParseException{
		limparTela();
		
		System.out.println("1 - Adicionar Candidato");
		System.out.println("2 - Adicionar Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o caminho do arquivo:");
			String caminhoArquivo = opcaoSC.nextLine();
			
			InputStream is = new FileInputStream(caminhoArquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			Candidato.setNome(br.readLine());
			
			try{
				Candidato.setCpf(Integer.parseInt(br.readLine()));
			} catch(Exception e){
				System.out.println("Erro no formato do cpf!");
				return;
			}
			
			try{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date myDate = formatter.parse(br.readLine());
				java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
				
				Candidato.setDataNascimento(sqlDate);
			} catch(Exception e){
				System.out.println("Erro no formato da data!");
				Candidato.setDataNascimento(null);
			}
			
			br.close();
			
			CandidatoDAO.add(Candidato);
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o caminho do arquivo:");
				String caminhoArquivo = opcaoSC.nextLine();
				
				InputStream is = new FileInputStream(caminhoArquivo);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				Partido.setNome(br.readLine());
				
				try{
					Partido.setCnpj(Integer.parseInt(br.readLine()));
				} catch(Exception e){
					System.out.println("Erro no formato do cnpj!");

					return;
				}
				
				br.close();
				
				PartidoDAO.add(Partido);
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuAdiconarClasseInterface() throws SQLException, ParseException{
		limparTela();
		
		System.out.println("1 - Adicionar Candidato");
		System.out.println("2 - Adicionar Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		opcaoSC.nextLine();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o nome:");
			Candidato.setNome(opcaoSC.nextLine());
			
			try{
				System.out.println("Digite o cpf:");
				Candidato.setCpf(opcaoSC.nextInt());
				opcaoSC.nextLine();
			} catch(Exception e){
				System.out.println("Erro no formato do cpf!");

				return;
			}
			
			try{
				System.out.println("Digite a data de nascimento (yyyy-MM-dd):");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date myDate = formatter.parse(opcaoSC.nextLine());
				java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
				
				Candidato.setDataNascimento(sqlDate);
			} catch(Exception e){
				System.out.println("Erro no formato da data!");

				Candidato.setDataNascimento(null);
			}
			
			CandidatoDAO.add(Candidato);
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o nome:");
				Partido.setNome(opcaoSC.nextLine());
				
				System.out.println("Digite o cnpj:");
				
				try{
					Partido.setCnpj(opcaoSC.nextInt());
				} catch(Exception e){
					System.out.println("Erro no formato do cnpj!");

					return;
				}
				
				PartidoDAO.add(Partido);
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}
}
