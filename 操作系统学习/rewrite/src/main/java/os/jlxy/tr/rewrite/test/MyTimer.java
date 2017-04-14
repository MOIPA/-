package os.jlxy.tr.rewrite.test;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
	private static int times = 10000;

	public MyTimer() {
		Timer time = new Timer();

		time.schedule(new TimerTask() {
			@Override
			public void run() {
				if (times > 0) {
					System.out.println("hello world!");
					times -= 5000;
				} else {
					System.out.println("stop");
					//time.cancel();
				}
			}
		}, 0, 5000);
	}
}