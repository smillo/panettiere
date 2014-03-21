package supermercato;

public class Clienti extends Thread {
	
	String nome;
	BoundedBuffer<Pane> bancone;
	double peso_preso=0.0;


public Clienti(String nome,BoundedBuffer<Pane>bancone){
	
	this.nome= nome;
	this.bancone= bancone;
	
}

public void consuma() throws InterruptedException{
	
	Pane pane=bancone.get();
	peso_preso=peso_preso+pane.getPeso();
	
}

public void run(){
	
	for(int i=0;i<5;i++){
		try {
			consuma();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
System.out.println(nome + ": ho preso " + String.format("%1$,.2f", peso_preso) + " Kg di pane");
}
}