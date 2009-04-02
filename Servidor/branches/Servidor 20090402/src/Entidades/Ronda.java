package Entidades;

public class Ronda {
	
	

	private int ronda;
	private int partida;
	private int valorMesa;
	private int ganador;
	
	public Ronda(){}
	
	public Ronda(int ronda, int partida, int valorMesa, int ganador)
	{
		this.ronda=ronda;
		this.partida=partida;
		this.valorMesa=valorMesa;
		this.ganador=ganador;
	}
	
	public Ronda(int partida, int valorMesa, int ganador)
	{
		this.partida=partida;
		this.valorMesa=valorMesa;
		this.ganador=ganador;
	}

	//Accedentes
	public int getRonda() {
		return ronda;
	}
	public int getPartida() {
		return partida;
	}
	public int getValorMesa() {
		return valorMesa;
	}
	public int getGanador() {
		return ganador;
	}
	
	
	//Mutadores
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	public void setPartida(int partida) {
		this.partida = partida;
	}
	public void setValorMesa(int valorMesa) {
		this.valorMesa = valorMesa;
	}
	public void setGanador(int ganador) {
		this.ganador = ganador;
	}
	
}
