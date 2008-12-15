package servidorcasino;

//Esta clase esta aqui implementada para cuando se tenga
// que almacenar más de un jugador en la ruleta ya que
// podran jugar varios.
public class InformacionJugadores {

	private int codigo;
	private double saldo;
	
	public InformacionJugadores() {
		
		codigo = 0;
		saldo = 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
