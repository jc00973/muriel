package muriel.model;

import javax.persistence.Entity;

@Entity
public class Carro extends Veiculo {
	
	private int qtdPorta;
    private int capacidadePortaMala;
	private double motor;
	
	public int getQtdPorta() {
		return qtdPorta;
	}
	public void setQtdPorta(int qtdPorta) {
		this.qtdPorta = qtdPorta;
	}
	public int getCapacidadePortaMala() {
		return capacidadePortaMala;
	}
	public void setCapacidadePortaMala(int capacidadePortaMala) {
		this.capacidadePortaMala = capacidadePortaMala;
	}
	public double getMotor() {
		return motor;
	}
	public void setMotor(double motor) {
		this.motor = motor;
	}
	
	

}
