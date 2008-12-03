package Comunicacion.InterfazConexion;

public class a implements Runnable {

	private double b;
	@Override
	public void run() {
		//while (true)
		{
			synchronized {
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b = Math.random();
			System.out.write((int)b);
		}
		}
		
	}
	
}
