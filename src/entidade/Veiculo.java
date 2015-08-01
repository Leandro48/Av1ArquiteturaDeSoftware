package entidade;

import java.io.Serializable;

public abstract class Veiculo implements Serializable
{
	private String	chassi;
	private String	montadora;
	private String	modelo;
	private String	tipo;
	private String	cor;
	private String	motorizacao;
	private String	cambio;
	private float	preco;

	public Veiculo()
	{
	}

	public Veiculo(String chassi, String montadora, String modelo, String tipo,
			String cor, String motorizacao, String cambio, float preco)
	{
		super();
		this.chassi = chassi;
		this.montadora = montadora;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cor = cor;
		this.motorizacao = motorizacao;
		this.cambio = cambio;
		this.preco = preco;
	}

	public String getChassi()
	{
		return chassi;
	}

	public void setChassi(String chassi)
	{
		this.chassi = chassi;
	}

	public String getMontadora()
	{
		return montadora;
	}

	public void setMontadora(String montadora)
	{
		this.montadora = montadora;
	}

	public String getModelo()
	{
		return modelo;
	}

	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getCor()
	{
		return cor;
	}

	public void setCor(String cor)
	{
		this.cor = cor;
	}

	public String getMotorizacao()
	{
		return motorizacao;
	}

	public void setMotorizacao(String motorizacao)
	{
		this.motorizacao = motorizacao;
	}

	public String getCambio()
	{
		return cambio;
	}

	public void setCambio(String cambio)
	{
		this.cambio = cambio;
	}

	public float getPreco()
	{
		return preco;
	}

	public void setPreco(float preco)
	{
		this.preco = preco;
	}
}
