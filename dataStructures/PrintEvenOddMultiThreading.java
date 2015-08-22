
public class PrintEvenOddMultiThreading {

	public static void main(String[] args) {
		Printer prntr=new Printer();
		Thread t1=new Thread(new EvenOrOdd(10, true, prntr));
		Thread t2=new Thread(new EvenOrOdd(10, false, prntr));
		t2.start();
		t1.start();
	}

}
class EvenOrOdd implements Runnable{
	boolean isEven;
	int max;
	int min=0;
	Printer prntr;
	public EvenOrOdd(int max,boolean isEven,Printer prntr){
		this.max=max;
		this.isEven=isEven;
		this.prntr=prntr;
	}
	@Override
	public void run() {
		int seed=isEven?0:1;
		while(seed<=max){
			if(isEven){
				prntr.printEven(seed);
			}
			else{
				prntr.printOdd(seed);
			}
			seed+=2;
		}
	}
	
}
class Printer{
	boolean printEven=false;
	
	public  synchronized void printEven( int data ){
		try{
		while(printEven)
			wait();}
		catch(InterruptedException exp){
			exp.printStackTrace();
		}
		System.out.println(" Even :- "+data);
		printEven=true;
		notifyAll();
	}
	public  synchronized void printOdd( int data ){
		try{
		while(!printEven)
			wait();}
		catch(InterruptedException exp){
			exp.printStackTrace();
		}
		System.out.println(" Odd :- "+data);
		printEven=false;
		notifyAll();
	}
}