package WaitSleep;

public class StaticSleep {
	public void wait(int num)
	{
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
