package entidade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Mensagem;

public class Loja
{
	private static final String		arquivoEstoqueCarro			= "carroEstoque.txt";
	private static final String		arquivoEstoqueMotocicleta	= "motocicletaEstoque.txt";

	private String					endereco;
	private String					nome;
	private ArrayList<Carro>		carros;
	private ArrayList<Motocicleta>	motocicletas;

	public Loja()
	{
		carros = new ArrayList<>();
		motocicletas = new ArrayList<>();
	}

	public String getEndereco()
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	private void salvarObjetos(Class<?> tipo, String arquivo)
	{
		try
		{
			FileOutputStream saidaStream = new FileOutputStream(arquivo);
			ObjectOutputStream objectSaida = new ObjectOutputStream(saidaStream);
			objectSaida.writeObject((tipo == Carro.class) ? this.carros
					: this.motocicletas);
			objectSaida.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void recuperarObjetos(Class<?> tipo, String arquivo)
	{
		try
		{
			FileInputStream entradaStream = new FileInputStream(arquivo);
			ObjectInputStream objectEntrada = new ObjectInputStream(
					entradaStream);

			if (tipo == Carro.class)
			{
				this.carros = (ArrayList<Carro>) objectEntrada.readObject();
			}
			else
			{
				this.motocicletas = (ArrayList<Motocicleta>) objectEntrada
						.readObject();
			}

			objectEntrada.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void adicionarCarro(Carro carro)
	{
		this.carros.add(carro);
	}

	public void adicionarMotocicleta(Motocicleta motocicleta)
	{
		this.motocicletas.add(motocicleta);
	}

	private ArrayList<Veiculo> _buscarCarro(String variavel, String valor)
	{
		ArrayList<Veiculo> listaResultado = new ArrayList<>();
		try
		{
			if (Veiculo.class.getDeclaredField(variavel) != null)
			{
				variavel = "get"
						+ variavel.replaceFirst("[a-z]{1}",
								variavel.substring(0, 1).toUpperCase());
				System.out.println("achou metodo: " + variavel);
				Method metodo = Veiculo.class.getMethod(variavel, null);

				for (Veiculo v : this.carros)
				{
					if (metodo.invoke(v, null).toString().equals(valor))
					{
						listaResultado.add(v);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return listaResultado;
	}

	private ArrayList<Veiculo> _buscarMotocicleta(String variavel, String valor)
	{
		ArrayList<Veiculo> listaResultado = new ArrayList<>();
		try
		{
			if (Veiculo.class.getDeclaredField(variavel) != null)
			{
				variavel = "get"
						+ variavel.replaceFirst("[a-z]{1}",
								variavel.substring(0, 1).toUpperCase());
				System.out.println("achou metodo: " + variavel);
				Method metodo = Veiculo.class.getMethod(variavel, null);

				for (Veiculo v : this.motocicletas)
				{
					if (metodo.invoke(v, null).toString().equals(valor))
					{
						listaResultado.add(v);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return listaResultado;
	}

	public void buscarCarro(String variavel, String valor)
	{
		ArrayList<Veiculo> listaResultado = this._buscarCarro(variavel, valor);

		System.out.println("Buscando por " + variavel + " = " + valor);
		Mensagem.imprimeTabelaCabecalho();
		if (listaResultado.size() < 1)
		{
			System.out.format("|%71s%64s|\n", "Nada encontrado para " + valor
					+ " em " + variavel, "");
		}
		else
		{
			for (Veiculo v : listaResultado)
			{
				Mensagem.imprimeTabelaLinha(v);
			}
		}
		Mensagem.imprimeTabelaFim();
	}

	public void buscarMotocicleta(String variavel, String valor)
	{
		ArrayList<Veiculo> listaResultado = this._buscarMotocicleta(variavel,
				valor);

		System.out.println("Buscando por " + variavel + " = " + valor);
		Mensagem.imprimeTabelaCabecalho();
		if (listaResultado.size() < 1)
		{
			System.out.format("|%71s%64s|\n", "Nada encontrado para " + valor
					+ " em " + variavel, "");
		}
		else
		{
			for (Veiculo v : listaResultado)
			{
				Mensagem.imprimeTabelaLinha(v);
			}
		}
		Mensagem.imprimeTabelaFim();
	}

	public void listarEstoqueDeCarros()
	{
		Mensagem.imprimeTabelaCabecalho();
		if (this.carros.size() < 1)
		{
			System.out.format("|%71s%64s|\n", "Nada encontrado para em carros",
					"");
		}
		else
		{
			for (Veiculo v : this.carros)
			{
				Mensagem.imprimeTabelaLinha(v);
			}
		}
		Mensagem.imprimeTabelaFim();
	}

	public void listarEstoqueDeMotocicletas()
	{
		Mensagem.imprimeTabelaCabecalho();
		if (this.motocicletas.size() < 1)
		{
			System.out.format("|%71s%64s|\n",
					"Nada encontrado para em motocicletas", "");
		}
		else
		{
			for (Veiculo v : this.motocicletas)
			{
				Mensagem.imprimeTabelaLinha(v);
			}
		}
		Mensagem.imprimeTabelaFim();
	}

	public void salvarEstoque()
	{
		this.salvarObjetos(Carro.class, arquivoEstoqueCarro);
		this.salvarObjetos(Motocicleta.class, arquivoEstoqueMotocicleta);
	}

	public void recuperarEstoque()
	{
		this.recuperarObjetos(Carro.class, arquivoEstoqueCarro);
		this.recuperarObjetos(Motocicleta.class, arquivoEstoqueMotocicleta);
	}
}
