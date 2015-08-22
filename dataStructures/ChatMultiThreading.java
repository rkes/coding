public class ChatMultiThreading {

	public static void main(String[] args) {
		Print prnt=new Print();
		Thread t1=new Thread(new SayOrHear(true, prnt));
		Thread t2=new Thread(new SayOrHear(false, prnt));
		t1.start();
		t2.start();
	}
}
class SayOrHear implements Runnable{
	boolean sayOrHere;
	int incr=0;
	String[]ar={"Hi","Hi","How Are You ?","I Am Fine","Ok Going Now Hear"," Ok Say You can Go"};
	Print prnt;
	public SayOrHear(boolean sayOrHere,Print prnt) {
		this.sayOrHere=sayOrHere;
		this.prnt=prnt;
	}
	
	@Override
	public void run() {
		incr=sayOrHere?0:1;
		while(incr<6){
			if(sayOrHere)
				prnt.say(ar[incr]);
			else
				prnt.hear(ar[incr]);
			incr+=2;
		}
	}
}
class Print{
	boolean say=false;
	public synchronized void say(String str){
		try{
			while(say)
				wait();
		}catch(InterruptedException exp){
			exp.printStackTrace();
		}
		
		System.out.println(" Saying :- "+str);
		say=true;
		notifyAll();
	}
	public synchronized void hear(String str){
		try{
		while(!say)
			wait();}
		catch(InterruptedException exp){
			exp.printStackTrace();
		}
		System.out.println(" Hearing :- "+str);
		say=false;
		notifyAll();
	}
}