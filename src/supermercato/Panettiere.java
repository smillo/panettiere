package supermercato;

public class Panettiere extends Thread {
	
	String nome;
	BoundedBuffer<Pane> bancone;
	double peso;
	


public Panettiere(String nome,BoundedBuffer<Pane>bancone){
	
	this.nome= nome;
	this.bancone= bancone;
	peso=0;
	
}

public void produci() throws InterruptedException{
	double kg= (((Math.random() * 10) % 4.9) + 0.1);
	bancone.put(new Pane(kg));
	peso=peso+kg;
	
}
public void run(){
	
	for(int i=0;i<5;i++){
		try {
			produci();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	System.out.println(nome + " Ho prodotto: " +String.format("%1$,.2f", peso)  + " Kg.");
}
}