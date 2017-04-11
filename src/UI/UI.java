package UI;

import java.util.Scanner;

import ClassesBD.candidato;
import ClassesBD.partido;

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
	
	public static void menuAdicionarClasse(){
		limparTela();
		
		System.out.println("1 - Adicionar por Arquivo");
		System.out.println("2 - Adicionar por Interface");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		
		if(opcao==1){
			limparTela();
			menuAdicionarClasseArquivo();
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

	private static void menuRemoverClasseInterface(){
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
