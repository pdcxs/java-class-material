import java.util.concurrent.*;

class ProducerForBlockingQueue extends Thread
{
	private BlockingQueue<String> bq;
	public ProducerForBlockingQueue(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		var strArr = new String[]
		{
			"Java",
			"Struts",
			"Spring"
		};
		for (var i = 0; i < 999999999; i++)
		{
			System.out.println(getName() + " as a ProducerForBlockingQueue puts data into the queue");
			try
			{
				Thread.sleep(200);
				bq.put(strArr[i % 3]);
			}
			catch (Exception ex) {ex.printStackTrace();}
			System.out.println(getName() + " stops to put data into " + bq);
		}
	}
}
class ConsumerForBlockingQueue extends Thread
{
	private BlockingQueue<String> bq;
	public ConsumerForBlockingQueue(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		while (true)
		{
			System.out.println(getName() + " as a ConsumerForBlockingQueue gets data from queue");
			try
			{
				Thread.sleep(200);
				bq.take();
			}
			catch (Exception ex) {ex.printStackTrace();}
			System.out.println(getName() + " stops to get data from " + bq);
		}
	}
}
public class BlockingQueueTest
{
	public static void main(String[] args)
	{
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
		new ProducerForBlockingQueue(bq).start();
		new ProducerForBlockingQueue(bq).start();
		new ProducerForBlockingQueue(bq).start();
		new ConsumerForBlockingQueue(bq).start();
	}
}