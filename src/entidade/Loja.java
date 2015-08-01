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
	private static final String		arquivoDadosLoja	= "data.txt";

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

	public ArrayList<Carro> getCarros()
	{
		return carros;
	}

	public ArrayList<Motocicleta> getMotocicletas()
	{
		return motocicletas;
	}

	public void salvarCarros()
	{
		try
		{
			FileOutputStream saidaStream = new FileOutputStream(arquivoDadosLoja);
			ObjectOutputStream objectSaida = new ObjectOutputStream(saidaStream);
			objectSaida.writeObject(this.carros);
			objectSaida.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void carregarCarros()
	{
		try{
			FileInputStream entradaStream = new FileInputStream(arquivoDadosLoja);
			ObjectInputStream objectEntrada = new ObjectInputStream (entradaStream);
			this.carros = (ArrayList<Carro>) objectEntrada.readObject();
			objectEntrada.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
