package entidade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public void listarEstoqueDeCarros(){
		for(Carro c : this.carros){
			System.out.println(c.getChassi());
		}
	}

	public void adicionarMotocicleta(Motocicleta motocicleta)
	{
		this.motocicletas.add(motocicleta);
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
