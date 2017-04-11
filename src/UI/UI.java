import java.util.Scanner;

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
		System.out.println("1 - Adicionar Classe");
		System.out.println("2 - Remover Classe");
		System.out.println("3 - Buscar Classe");
		System.out.println("4 - Sair");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		
		if(opcao==1){
			menuAdicionarClasse();
		}
		else
			if(opcao==2){
				//menuRemoverClasse();
				System.out.println("2");
			}
			else
				if(opcao==3){
					//menuBuscarClasse();
					System.out.println("3");
				}
				else if(opcao!=4){
					System.out.println("Vc digitou uma opcao errada!");
					menuPrincipal();
				}
	}
	
	public static void menuAdicionarClasse(){
		limparTela();
		System.out.println("1 - Adicionar por Arquivo");
		System.out.println("2 - Adicionar por Interface");
		
		Scanner opcaoSC = new Scanner(System.in);
		
		int opcao = opcaoSC.nextInt();
		
		if(opcao==1){
			//menuAdicionarClasseArquivo();
			System.out.println("1 1");
		}
		else
			if(opcao==2){
				//menuRemoverClasseInterface();
				System.out.println("1 2");
			}
		
		menuPrincipal();
	}
}
