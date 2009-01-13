
package comunicaciones.pruebas;

import comunicaciones.demonio.Demonio;
public class Servidor {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demonio demonio = new Demonio();
		demonio.setServidor(true);
		demonio.start();
		
		
	}
}
