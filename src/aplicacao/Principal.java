package aplicacao;

import javax.rmi.CORBA.Util;

import util.Mensagem;
import entidade.Carro;
import entidade.Loja;
import entidade.Motocicleta;

public class Principal
{

	public static void main(String[] args)
	{
		Loja loja = new Loja();

		int opcao = Mensagem.geraMenuPrincipal();

		while (opcao != -1)
		{
			if (opcao > 0 && opcao < 9)
			{
				switch (opcao)
				{
					case 1:
						Carro novoCarro = (Carro) Mensagem
								.promptAdicionarVeiculo(Carro.class);
						loja.adicionarCarro(novoCarro);
						System.out.println("Carro adicionado com sucesso !");
						Mensagem.apagarConsole();
						Mensagem.geraMenuPrincipal();
						break;
					case 2:
						break;
					case 3:
						loja.listarEstoqueDeCarros();

						if (Mensagem.geraMenuProsseguir() == true)
						{
							opcao = Mensagem.geraMenuPrincipal();
						}
						else
						{
							Mensagem.geraMenuProsseguir();
						}

						break;
					case 4:
						Motocicleta novaMotocicleta = (Motocicleta) Mensagem
								.promptAdicionarVeiculo(Motocicleta.class);
						loja.adicionarMotocicleta(novaMotocicleta);
						System.out
								.println("Motocicleta adicionada com sucesso !");
						Mensagem.apagarConsole();
						Mensagem.geraMenuPrincipal();
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						loja.salvarEstoque();
						System.out.println("Estoque salvo com sucesso !");
						Mensagem.geraMenuPrincipal();
						break;
					case 8:
						loja.recuperarEstoque();
						System.out.println("Estoque recuperado com sucesso !");
						opcao = Mensagem.geraMenuPrincipal();
						break;
				}
			}
			else
			{
				Mensagem.apagarConsole();
				System.out.println("Opcao \"" + opcao + "\" inválida");
				try
				{
					Thread.sleep(4);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				Mensagem.geraMenuPrincipal();
			}
		}

	}

}
