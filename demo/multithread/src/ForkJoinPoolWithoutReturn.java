import java.util.concurrent.*;

// 无返回值的任务 RecursiveAction
class PrintTask extends RecursiveAction
{
	private static final int THRESHOLD = 50;
	private int start;
	private int end;
	public PrintTask(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	@Override
	protected void compute()
	{
		if (end - start < THRESHOLD)
		{
			for (var i = start; i < end; i++)
			{
				System.out.println(Thread.currentThread().getName()
					+ " index label: " + i);
			}
		}
		else
		{
			int middle = (start + end) / 2;
			var left = new PrintTask(start, middle);
			var right = new PrintTask(middle, end);
			// 将大任务分解成若干小任务
			left.fork();
			right.fork();
		}
	}
}
public class ForkJoinPoolWithoutReturn
{
	public static void main(String[] args) throws Exception
	{
		var pool = new ForkJoinPool();
		pool.submit(new PrintTask(0, 300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		pool.shutdown();
		pool.close();
	}
}

