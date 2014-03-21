package supermercato;


public class BoundedBuffer<Pane>{
 private Pane bancone[];
 private int indice1;
 private int indice2;
 private int oggetti_sul_bancone=0;
 private int dimensione;

 public BoundedBuffer(int length){
 dimensione=length;
 bancone=(Pane[]) new Object [dimensione];
 indice2=0;
 indice1=0;
 }
 public synchronized void put(Pane item) throws InterruptedException {
 while(oggetti_sul_bancone == dimensione )
 wait();
 indice2 = (indice2 + 1)%dimensione;
 oggetti_sul_bancone++;
 bancone[indice2] = item ;
 notifyAll() ;
}
 public synchronized Pane get() throws InterruptedException {
 while(oggetti_sul_bancone == 0)
 wait() ;
 indice1 = ( indice1 + 1)%dimensione;
 oggetti_sul_bancone--;
 notifyAll() ;
 return bancone[indice1];
 }
 }