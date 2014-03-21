package supermercato;

public class Main extends Thread{
	
	public static void main(String[] args){
		
		
		BoundedBuffer<Pane> bancone= new BoundedBuffer<Pane>(8);
		
		
		new Panettiere("pan1",bancone).start();
		new Panettiere("pan2",bancone).start();
		new Clienti("con1",bancone).start();
		new Clienti("con2",bancone).start();
		
	}

	

	
	

}