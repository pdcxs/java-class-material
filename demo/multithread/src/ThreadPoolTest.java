import java.util.concurrent.*;

public class ThreadPoolTest
{
	public static void main(String[] args) throws Exception
	{
		ExecutorService pool = Executors.newFixedThreadPool(6);
		Runnable target = () -> {
			for (var i = 0; i < 100; i++)
			{
				System.out.println(Thread.currentThread().getName() + "i = " + i);
			}
		};
		pool.submit(target);
		pool.submit(target);
		pool.shutdown();
	}
}

