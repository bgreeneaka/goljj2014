import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
	public static void main(String args[]) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		long startTimer = System.currentTimeMillis();
		Date startTime = new Date(startTimer);
		System.out.println("Multithreaded Time started: ");
		System.out.println(sdf.format(startTime));

		int i;
		//System.out.println(args.length);

		GoL game = new GoL();
		//game.printWorld();
		for (i = 0; i < 10; i++) {
			game.nextGeneration();
			// System.out.println("copied");
			//game.printWorld();

		}
		// placeholder to read configuration form the arguments provided on
		// runtime
		long stopTimer = System.currentTimeMillis();

		System.out.println("Multithreaded Time stopped: ");
		Date endTime = new Date(stopTimer);
		System.out.println(sdf.format(endTime));
		System.out.println("Multithreaded Run time: " + (stopTimer - startTimer) + " ms.");
	}
}
