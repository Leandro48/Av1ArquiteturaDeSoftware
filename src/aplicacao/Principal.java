package aplicacao;

import entidade.Carro;
import entidade.Loja;

public class Principal
{

	public static void main(String[] args)
	{
		Loja loja = new Loja();
		
		Carro c1 = new Carro();
		c1.setChassi("teste1");
		c1.setCambio("cambio1");
		Carro c2 = new Carro();
		c2.setChassi("teste2");
		c2.setCambio("cambio2");
		
		loja.getCarros().add(c1);
		loja.getCarros().add(c2);
		
		for(Carro carro : loja.getCarros()) {
			System.out.println("c: " + carro.getChassi());
		}
	}

}
