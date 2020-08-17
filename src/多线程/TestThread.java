package 多线程;

public class TestThread implements Runnable{
	int i=1;
	@Override
	public void run(){
		while(i<=100){
			synchronized(this){
				notify();
				try{
					Thread.currentThread();
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				if(i<=100){
					System.out.println(Thread.currentThread().getName()+":"+i);
					i++;
					try{
						wait();  //释放锁
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args){
		TestThread t = new TestThread();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.setName("线程1");
		t2.setName("线程2");
		t1.start();
		t2.start();
	}

}
