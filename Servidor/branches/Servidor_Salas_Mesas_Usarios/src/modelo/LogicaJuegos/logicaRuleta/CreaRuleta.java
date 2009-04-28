package modelo.LogicaJuegos.logicaRuleta;


public class CreaRuleta {
	
	//clase que crea todos los numeros de la ruleta
	//devulve un array con todos los numeros creados
	// la posicion del array es la misma al Numero al que hace referencia esa posicion.

	
	//array de numeros
	Numero[] arrayNumeros = new Numero[37];
	
	public CreaRuleta(){
		
	}
	
	public Numero[] InicializarRuleta(){
		
		arrayNumeros[0]= new Numero(0,"CERO","VERDE","","","","");
		arrayNumeros[1]= new Numero(1,"UNO","ROJO","IMPAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[2]= new Numero(2,"DOS","NEGRO","PAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[3]= new Numero(3,"TRES","ROJO","IMPAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[4]= new Numero(4,"CUATRO","NEGRO","PAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[5]= new Numero(5,"CINCO","ROJO","IMPAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[6]= new Numero(6,"SEIS","NEGRO","PAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[7]= new Numero(7,"SIETE","ROJO","IMPAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[8]= new Numero(8,"OCHO","NEGRO","PAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[9]= new Numero(9,"NUEVE","ROJO","IMPAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[10]= new Numero(10,"DIEZ","NEGRO","PAR","FALTA","PRIMERA","LINEA_UNO");
		arrayNumeros[11]= new Numero(11,"ONCE","NEGRO","IMPAR","FALTA","PRIMERA","LINEA_DOS");
		arrayNumeros[12]= new Numero(12,"DOCE","ROJO","PAR","FALTA","PRIMERA","LINEA_TRES");
		arrayNumeros[13]= new Numero(13,"TRECE","NEGRO","IMPAR","FALTA","SEGUNDA","LINEA_UNO");
		arrayNumeros[14]= new Numero(14,"CATORCE","ROJO","PAR","FALTA","SEGUNDA","LINEA_DOS");
		arrayNumeros[15]= new Numero(15,"QUINCE","NEGRO","IMPAR","FALTA","SEGUNDA","LINEA_TRES");
		arrayNumeros[16]= new Numero(16,"DIEZ Y SEIS","ROJO","PAR","FALTA","SEGUNDA","LINEA_UNO");
		arrayNumeros[17]= new Numero(17,"DIEZ Y SIETE","NEGRO","IMPAR","FALTA","SEGUNDA","LINEA_DOS");
		arrayNumeros[18]= new Numero(18,"DIEZ Y OCHO","ROJO","PAR","FALTA","SEGUNDA","LINEA_TRES");
		arrayNumeros[19]= new Numero(19,"DIEZ Y NUEVE","ROJO","IMPAR","PASA","SEGUNDA","LINEA_UNO");
		arrayNumeros[20]= new Numero(20,"VEINTE","NEGRO","PAR","PASA","SEGUNDA","LINEA_DOS");
		arrayNumeros[21]= new Numero(21,"VEINTIUNO","ROJO","IMPAR","PASA","SEGUNDA","LINEA_TRES");
		arrayNumeros[22]= new Numero(22,"VEINTI Y DOS","NEGRO","PAR","PASA","SEGUNDA","LINEA_UNO");
		arrayNumeros[23]= new Numero(23,"VEINTI Y TRES","ROJO","IMPAR","PASA","SEGUNDA","LINEA_DOS");
		arrayNumeros[24]= new Numero(24,"VEINTI Y CUATRO","NEGRO","PAR","PASA","SEGUNDA","LINEA_TRES");
		arrayNumeros[25]= new Numero(25,"VEINTI Y CINCO","ROJO","IMPAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[26]= new Numero(26,"VEINTI Y SEIS","NEGRO","PAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[27]= new Numero(27,"VEINTI Y SIETE","ROJO","IMPAR","PASA","TERCERA","LINEA_TRES");
		arrayNumeros[28]= new Numero(28,"VEINTI Y OCHO","NEGRO","PAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[29]= new Numero(29,"VEINTI Y NUEVE","NEGRO","IMPAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[30]= new Numero(30,"TREINTA","ROJO","PAR","PASA","TERCERA","LINEA_TRES");
		arrayNumeros[31]= new Numero(31,"TREINTA Y UNO","NEGRO","IMPAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[32]= new Numero(32,"TREINTA Y DOS","ROJO","PAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[33]= new Numero(33,"TREINTA Y TRES","NEGRO","IMPAR","PASA","TERCERA","LINEA_TRES");
		arrayNumeros[34]= new Numero(34,"TREINTA Y CUATRO","ROJO","PAR","PASA","TERCERA","LINEA_UNO");
		arrayNumeros[35]= new Numero(35,"TREINTA Y CINCO","NEGRO","IMPAR","PASA","TERCERA","LINEA_DOS");
		arrayNumeros[36]= new Numero(36,"TREINTA Y SEIS","ROJO","PAR","PASA","TERCERA","LINEA_TRES");
				
				
		
		return arrayNumeros;
		
	}
	public Numero getNumero(int i){
        
        return arrayNumeros[i];
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
