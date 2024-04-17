//死锁
class A
{
	public synchronized void foo(B b)
	{
		System.out.println("Current Thread: " + Thread.currentThread().getName()
			+ ", foo(B b) in A" );
		try
		{
			Thread.sleep(200);
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("Current Thread: " + Thread.currentThread().getName()
			+ ", b.last()");
		b.last();
	}
	public synchronized void last()
	{
		System.out.println("last() in A");
	}
}
class B
{
	public synchronized void bar(A a)
	{
		System.out.println("Current Thread: " + Thread.currentThread().getName()
			+ ", bar(A a) in B");
		try
		{
			Thread.sleep(200);
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("Current Thread: " + Thread.currentThread().getName()
			+ ", a.last()");
		a.last();
	}
	public synchronized void last()
	{
		System.out.println("last() in B");
	}
}
public class DeadLock implements Runnable
{
	A a = new A();
	B b = new B();
	public void init()
	{
		Thread.currentThread().setName("Object of A");
		a.foo(b);
		System.out.println("a.foo(b)");
	}
	public void run()
	{
		Thread.currentThread().setName("Object of B");
		b.bar(a);
		System.out.println("b.bar(a)");
	}
	public static void main(String[] args)
	{
		var dl = new DeadLock();
		new Thread(dl).start();
		dl.init();
	}
}

