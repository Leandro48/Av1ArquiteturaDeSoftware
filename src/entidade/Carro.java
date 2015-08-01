package entidade;

public final class Carro extends Veiculo
{

	public Carro()
	{
	}

	public Carro(String chassi, String montadora, String modelo, String tipo,
			String cor, String motorizacao, String cambio, float preco)
	{
		super(chassi, montadora, modelo, tipo, cor, motorizacao, cambio, preco);
	}

}
