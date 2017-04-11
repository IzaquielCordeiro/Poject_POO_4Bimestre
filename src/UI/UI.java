package UI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import ClassesBD.candidato;
import ClassesBD.partido;
import DAO.CandidatoDAO;

public class UI {
	
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	public static void limparTela(){
		for(int i=0;i<100;i++)
			System.out.println();
	}
	
	public static void menuPrincipal(){
		limparTela();
		
		while(true){
			System.out.println("1 - Adicionar Classe");
			System.out.println("2 - Remover Classe");
			System.out.println("3 - Buscar Classe");
			System.out.println("4 - Sair");
			
			Scanner opcaoSC = new Scanner(System.in);
			
			int opcao = opcaoSC.nextInt();
			
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
		
		if(opcao==1){
			limparTela();
			try {
				menuBuscarClasseArquivo();
			} catch (IOException e) {
				System.out.println("Erro inesperado no arquivo");
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
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o caminho do arquivo:");
			String caminhoArquivo = opcaoSC.nextLine();
			
			InputStream is = new FileInputStream(caminhoArquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			Candidato.setCpf(Integer.parseInt(br.readLine()));
			
			br.close();
			
			CandidatoDAO.bus(Candidato);
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
				
				Partido.setCnpj(Integer.parseInt(br.readLine()));
				
				br.close();
				
				PartidoDAO.bus(Partido);
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
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o cpf:");
			Candidato.setCpf(opcaoSC.nextInt());
			
			CandidatoDAO.bus(Candidato);
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o cnpj:");
				Partido.setCnpj(opcaoSC.nextInt());
				
				PartidoDAO.bus(Partido);
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
		
		if(opcao==1){
			limparTela();
			try {
				menuRemoverClasseArquivo();
			} catch (IOException e) {
				System.out.println("Erro inesperado no arquivo");
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
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o caminho do arquivo:");
			String caminhoArquivo = opcaoSC.nextLine();
			
			InputStream is = new FileInputStream(caminhoArquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			Candidato.setCpf(Integer.parseInt(br.readLine()));
			
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
				
				Partido.setCnpj(Integer.parseInt(br.readLine()));
				
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
			Candidato.setCpf(opcaoSC.nextInt());
			
			CandidatoDAO.rm(Candidato);
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o cnpj:");
				Partido.setCnpj(opcaoSC.nextInt());
				
				PartidoDAO.rm(Partido);
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	public static void menuAdicionarClasse(){
		limparTela();
		
		System.out.println("1 - Adicionar por Arquivo");
		System.out.println("2 - Adicionar por Interface");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		
		if(opcao==1){
			limparTela();
			try {
				menuAdicionarClasseArquivo();
			} catch (IOException e) {
				System.out.println("Erro inesperado no arquivo");
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

	private static void menuAdicionarClasseArquivo() throws IOException{
		limparTela();
		
		System.out.println("1 - Adicionar Candidato");
		System.out.println("2 - Adicionar Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o caminho do arquivo:");
			String caminhoArquivo = opcaoSC.nextLine();
			
			InputStream is = new FileInputStream(caminhoArquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			Candidato.setNome(br.readLine());
			
			Candidato.setCpf(Integer.parseInt(br.readLine()));
			
			Candidato.setDataNascimento(Integer.parseInt(br.readLine()));
			
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
				
				Partido.setCnpj(Integer.parseInt(br.readLine()));
				
				br.close();
				
				PartidoDAO.add(Partido);
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}

	private static void menuAdiconarClasseInterface(){
		limparTela();
		
		System.out.println("1 - Adicionar Candidato");
		System.out.println("2 - Adicionar Partido");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		
		if(opcao==1){
			limparTela();
			
			candidato Candidato = new candidato();
			
			System.out.println("Digite o nome:");
			Candidato.setNome(opcaoSC.nextLine());
			
			System.out.println("Digite o cpf:");
			Candidato.setCpf(opcaoSC.nextInt());
			
			System.out.println("Digite a data de nascimento:");
			Candidato.setDataNascimento(opcaoSC.nextInt());
			
			CandidatoDAO.add(Candidato);
		}
		else
			if(opcao==2){
				limparTela();
				
				partido Partido = new partido();
				
				System.out.println("Digite o nome:");
				Partido.setNome(opcaoSC.nextLine());
				
				System.out.println("Digite o cnpj:");
				Partido.setCnpj(opcaoSC.nextInt());
				
				PartidoDAO.add(Partido);
			}
			else{
				limparTela();
				System.out.println("Vc digitou uma opcao errada!");
			}
	}
}
