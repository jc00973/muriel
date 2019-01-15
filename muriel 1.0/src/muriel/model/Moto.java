package muriel.model;

import javax.persistence.Entity;

@Entity
public class Moto extends Veiculo {
	
	private double cilindrada;

	public double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}

}
