
public class CrearRuleta {
	
	//clase que crea todos los numeros de la ruleta
	//devulve un array con todos los numeros creados
	// la posicion del array es la misma al numero al que hace referencia esa posicion.

	
	//array de numeros
	Numero[] arrayNumeros = new Numero[37];
	// variable para los bucles
	int i=0;
	
	public CrearRuleta(){
		
	}
	
	public Numero[] InicializarRuleta(){
		/*for (i=0; i<arrayNumeros.length ; i++){
			arrayNumeros[i]= new numero("","","","");	
			
		}
		*/
		arrayNumeros[0]= new Numero("CERO","VERDE","","","","");
		arrayNumeros[1]= new Numero("UNO","ROJO","IMPAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[2]= new Numero("DOS","NEGRO","PAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[3]= new Numero("TRES","ROJO","IMPAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[4]= new Numero("CUATRO","NEGRO","PAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[5]= new Numero("CINCO","ROJO","IMPAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[6]= new Numero("SEIS","NEGRO","PAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[7]= new Numero("SIETE","ROJO","IMPAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[8]= new Numero("OCHO","NEGRO","PAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[9]= new Numero("NUEVE","ROJO","IMPAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[10]= new Numero("DIEZ","NEGRO","PAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[11]= new Numero("ONCE","NEGRO","IMPAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[12]= new Numero("DOCE","ROJO","PAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[13]= new Numero("TRECE","NEGRO","IMPAR","FALTA","SEGUNDA","LINEA_UNO");
		arrayNumeros[14]= new Numero("CATORCE","ROJO","PAR","FALTA","SEGUNDA","LINEA_DOS");
		arrayNumeros[15]= new Numero("QUINCE","NEGRO","IMPAR","FALTA","SEGUNDA","LINEA_TRES");
		arrayNumeros[16]= new Numero("DIEZ Y SEIS","ROJO","PAR","FALTA","SEGUNDA","LINEA_UNO");
		arrayNumeros[17]= new Numero("DIEZ Y SIETE","NEGRO","IMPAR","FALTA","SEGUNDA","LINEA_DOS");
		arrayNumeros[18]= new Numero("DIEZ Y OCHO","ROJO","PAR","FALTA","SEGUNDA","LINEA_TRES");
		arrayNumeros[19]= new Numero("DIEZ Y NUEVE","ROJO","IMPAR","PASA","SEGUNDA","LINEA_UNO");
		arrayNumeros[20]= new Numero("VEINTE","NEGRO","PAR","PASA","SEGUNDA","LINEA_DOS");
		arrayNumeros[21]= new Numero("VEINTIUNO","ROJO","IMPAR","PASA","SEGUNDA","LINEA_TRES");
		arrayNumeros[22]= new Numero("VEINTI Y DOS","NEGRO","PAR","PASA","SEGUNDA","LINEA_UNO");
		arrayNumeros[23]= new Numero("VEINTI Y TRES","ROJO","IMPAR","PASA","SEGUNDA","LINEA_DOS");
		arrayNumeros[24]= new Numero("VEINTI Y CUATRO","NEGRO","PAR","PASA","SEGUNDA","LINEA_TRES");
		arrayNumeros[25]= new Numero("VEINTI Y CINCO","ROJO","IMPAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[26]= new Numero("VEINTI Y SEIS","NEGRO","PAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[27]= new Numero("VEINTI Y SIETE","ROJO","IMPAR","PASA","TERCERA","LINEA_TRES");
		arrayNumeros[28]= new Numero("VEINTI Y OCHO","NEGRO","PAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[29]= new Numero("VEINTI Y NUEVE","NEGRO","IMPAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[30]= new Numero("TREINTA","ROJO","PAR","PASA","TERCERA","LINEA_TRES");
		arrayNumeros[31]= new Numero("TREINTA Y UNO","NEGRO","IMPAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[32]= new Numero("TREINTA Y DOS","ROJO","PAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[33]= new Numero("TREINTA Y TRES","NEGRO","IMPAR","PASA","TERCERA","LINEA_TRES");
		arrayNumeros[34]= new Numero("TREINTA Y CUATRO","ROJO","PAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[35]= new Numero("TREINTA Y CINCO","NEGRO","IMPAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[36]= new Numero("TREINTA Y SEIS","ROJO","PAR","PASA","TERCERA","LINEA_TRES");
				
				
		
		return arrayNumeros;
		
	}
	
	public void pintarRuleta(){
		int i=0;
		for (i=0; i<arrayNumeros.length ; i++){
			
			System.out.println();
			System.out.println();
			System.out.println("Numero:"+arrayNumeros[i].getValor());
			System.out.println("Atributos");
			System.out.println("	Color:"+arrayNumeros[i].getColor());
			System.out.println("	Par o Impar:"+arrayNumeros[i].getTipo_parImpar());
			System.out.println("	Falta o Pasa:"+arrayNumeros[i].getTipo_faltaPasa());
			System.out.println("	Docena:"+arrayNumeros[i].getDocena());
			System.out.println("	Linea:"+arrayNumeros[i].getLinea());
			
		}
	}
}
