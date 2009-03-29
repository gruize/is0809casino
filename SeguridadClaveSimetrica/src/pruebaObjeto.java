
public class pruebaObjeto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mensaje = new String();
		String mensajeCifrado = new String();
		String mensajeDescifrado = new String();
		
		mensaje="hola como estas";
		
		Cifrado c1 = new Cifrado("123");
		
		System.out.println("El mensaje sin cifra es:"+ mensaje);
		
		mensajeCifrado= c1.encrypt(mensaje);
		
		System.out.println("El mensaje cifrado es: "+ mensajeCifrado);
	
		mensajeDescifrado=c1.decrypt(mensajeCifrado);
		
		System.out.println("El mensaje Descifrado es: "+ mensajeDescifrado);
	
	
	
	}
	

}
