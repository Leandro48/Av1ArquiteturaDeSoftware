package entidade;

public final class Motocicleta extends Veiculo
{
	
	public Motocicleta()
	{
	}

	public Motocicleta(String chassi, String montadora, String modelo,
			String tipo, String cor, String motorizacao, String cambio,
			float preco)
	{
		super(chassi, montadora, modelo, tipo, cor, motorizacao, cambio, preco);
	}

}
