package aplicacao;

import java.io.IOException;
import java.lang.reflect.Field;

import util.Mensagem;
import entidade.Carro;
import entidade.Loja;
import entidade.Motocicleta;
import entidade.Veiculo;

public class Principal
{

	public static void main(String[] args) throws IOException
	{
		Loja loja = new Loja();
		String metodo;
		String valor;
		
		int opcao = Mensagem.geraMenuPrincipal();

		while (opcao != -1)
		{
			if (opcao > 0 && opcao < 10)
			{
				switch (opcao)
				{
					case 1:
						Mensagem.apagarConsole();
						Carro novoCarro = (Carro) Mensagem
								.promptAdicionarVeiculo(Carro.class);
						loja.adicionarCarro(novoCarro);
						System.out.println("Carro adicionado com sucesso !");
						Mensagem.geraMenuProsseguir();
						opcao = Mensagem.geraMenuPrincipal();
						break;
					case 2:
						Mensagem.apagarConsole();
						System.out
								.println("Pesquisar carro por [Chassi, Montadora, Modelo, Tipo, Cor, Motorizacao, Cambio, Preco]: ");
						metodo = Mensagem.prompt("Procura em: ");
						valor = Mensagem.prompt("Com valor: ");
						loja.buscarCarro(metodo, valor);
						Mensagem.geraMenuProsseguir();
						opcao = Mensagem.geraMenuPrincipal();
						break;
					case 3:
						Mensagem.apagarConsole();
						loja.listarEstoqueDeCarros();
						Mensagem.geraMenuProsseguir();
						opcao = Mensagem.geraMenuPrincipal();
						break;
					case 4:
						Mensagem.apagarConsole();
						Motocicleta novaMotocicleta = (Motocicleta) Mensagem
								.promptAdicionarVeiculo(Motocicleta.class);
						loja.adicionarMotocicleta(novaMotocicleta);
						System.out
								.println("Motocicleta adicionada com sucesso !");
						Mensagem.geraMenuProsseguir();
						opcao = Mensagem.geraMenuPrincipal();
						break;
					case 5:
						Mensagem.apagarConsole();
						System.out
								.println("Pesquisar motocicleta por [Chassi, Montadora, Modelo, Tipo, Cor, Motorizacao, Cambio, Preco]: ");
						metodo = Mensagem.prompt("Procura em: ");
						valor = Mensagem.prompt("Com valor: ");
						loja.buscarCarro(metodo, valor);
						Mensagem.geraMenuProsseguir();
						break;
					case 6:
						Mensagem.apagarConsole();
						loja.listarEstoqueDeMotocicletas();
						Mensagem.geraMenuProsseguir();
						opcao = Mensagem.geraMenuPrincipal();
						break;
					case 7:
						Mensagem.apagarConsole();
						loja.salvarEstoque();
						System.out.println("Estoque salvo com sucesso !");
						Mensagem.geraMenuProsseguir();
						opcao = Mensagem.geraMenuPrincipal();
						break;
					case 8:
						Mensagem.apagarConsole();
						loja.recuperarEstoque();
						System.out.println("Estoque recuperado com sucesso !");
						Mensagem.geraMenuProsseguir();
						opcao = Mensagem.geraMenuPrincipal();
						break;
					case 9:
						Mensagem.apagarConsole();
						System.out.println("Adeus !");
						System.exit(0);
						break;
				}
			}
			else
			{
				Mensagem.apagarConsole();
				System.out.println("Opção \"" + opcao + "\" inválida");
				Mensagem.geraMenuPrincipal();
			}
		}

	}
}
