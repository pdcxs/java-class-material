import java.util.concurrent.*;
import java.util.*;

// 带有返回值的 RecursiveTask<Task>
class CalTask extends RecursiveTask<Integer>
{
	private static final int THRESHOLD = 20;
	private int arr[];
	private int start;
	private int end;
	public CalTask(int[] arr, int start, int end)
	{
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	@Override
	protected Integer compute()
	{
		int sum = 0;
		if (end - start < THRESHOLD)
		{
			for (var i = start; i < end; i++)
			{
				sum += arr[i];
			}
			return sum;
		}
		else
		{
			int middle = (start + end) / 2;
			var left = new CalTask(arr, start, middle);
			var right = new CalTask(arr, middle, end);
			left.fork();
			right.fork();
			
			return left.join() + right.join();
		}
	}
}
public class ForkJoinPoolWithReturn
{
	public static void main(String[] args) throws Exception
	{
		var arr = new int[100];
		var rand = new Random();
		var total = 0;
		for (int i = 0, len = arr.length; i < len; i++)
		{
			int tmp = rand.nextInt(20);
			total += (arr[i] = tmp);
		}
		System.out.println(total);
		ForkJoinPool pool = ForkJoinPool.commonPool();
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		pool.shutdown();
		pool.close();
	}
}

