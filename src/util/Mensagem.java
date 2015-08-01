package util;

import java.util.Scanner;

import entidade.Carro;
import entidade.Motocicleta;
import entidade.Veiculo;

public class Mensagem
{
	public final static void apagarConsole()
	{
		for (int clear = 0; clear < 1000; clear++)
		{
			System.out.println("\b");
		}
	}

	public static String prompt(String mensagem)
	{
		System.out.print(mensagem);
		return new Scanner(System.in).next();
	}

	public static Veiculo promptAdicionarVeiculo(Class<?> tipoVeiculo)
	{
		System.out.println("-> ADICIONAR "
				+ ((tipoVeiculo == Carro.class) ? "Carro" : "Motocileta")
				+ "\n-------------------");
		System.out.println("Insira os dados do veiculo:");
		String chassi = Mensagem.prompt("chassi: ");
		String montadora = Mensagem.prompt("montadora");
		String modelo = Mensagem.prompt("modelo: ");
		String tipo = Mensagem.prompt("tipo: ");
		String cor = Mensagem.prompt("cor: ");
		String motorizacao = Mensagem.prompt("motorizacao: ");
		String cambio = Mensagem.prompt("cambio: ");
		String preco = Mensagem.prompt("preco: ");

		if (tipoVeiculo == Motocicleta.class)
		{
			return new Motocicleta(chassi, montadora, modelo, tipo, cor,
					motorizacao, cambio, Float.parseFloat(preco));
		}

		return new Carro(chassi, montadora, modelo, tipo, cor, motorizacao,
				cambio, Float.parseFloat(preco));
	}

	public static boolean geraMenuProsseguir()
	{
		String resultado = Mensagem
				.prompt("Deseja voltar para o menu principal? [sim] [nao]");

		if (resultado.equals("sim"))
		{
			return true;
		}

		return false;
	}

	public static int geraMenuPrincipal()
	{
		StringBuilder tmp = new StringBuilder();
		tmp.append("Menu\n");
		tmp.append("------------------------------\n");
		tmp.append("1 - Adicionar Carro\n");
		tmp.append("2 - Pesquisar Carro\n");
		tmp.append("3 - Listar Carros\n");
		tmp.append("4 - Adicionar Motocicleta\n");
		tmp.append("5 - Pesquisar Motocicleta\n");
		tmp.append("6 - Listar Motocicleta\n");
		tmp.append("7 - Salvar Estoque\n");
		tmp.append("8 - Recuperar Estoque\n");
		tmp.append("------------------------------\n");

		System.out.println(tmp);

		int opcao = Integer.parseInt(Mensagem.prompt("Insira uma opção: "));

		return opcao;
	}
}
