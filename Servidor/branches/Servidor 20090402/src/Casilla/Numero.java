package Casilla;


public class Numero {
        //Valor del Numero
        private int numero;
	//String del Numero
	private String valor;
	//color del Numero
	private String color;
	//tipo_parImpar: par o impar
	private String tipo_parImpar;
	//tipo_faltaPasa : falta o pasa
	private String tipo_faltaPasa;
	//docena
	private String docena;
	//linea
	private String linea;
	
	public Numero(int numero,String valor,String color,String tipo_parImpar, String tipo_faltaPasa, String docena, String linea){
	
                this.numero=numero;
		this.valor = valor;
		this.color= color;
		this.tipo_parImpar = tipo_parImpar;
		this.tipo_faltaPasa = tipo_faltaPasa;
		this.docena = docena;
		this.linea = linea;
	}
// Getters y setters
        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipo_parImpar() {
		return tipo_parImpar;
	}

	public void setTipo_parImpar(String tipo_parImpar) {
		this.tipo_parImpar = tipo_parImpar;
	}

	public String getTipo_faltaPasa() {
		return tipo_faltaPasa;
	}

	public void setTipo_faltaPasa(String tipo_faltaPasa) {
		this.tipo_faltaPasa = tipo_faltaPasa;
	}

	public String getDocena() {
		return docena;
	}

	public void setDocena(String docena) {
		this.docena = docena;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	
}
