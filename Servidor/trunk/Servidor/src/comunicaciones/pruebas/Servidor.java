
package comunicaciones.pruebas;

import comunicaciones.demonio.Demonio;
public class Servidor {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Demonio demonio = new Demonio();
		demonio.setServidor(true);
		demonio.start();
		demonio.wait();
	}

}
