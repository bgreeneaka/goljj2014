import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GoL implements Runnable {
	public int[][] world;
	public int[][] newWolrd;

	

	public GoL() {
		// default run 10 x 10 board, 10 generations
		Random r = new Random();
		int i, j;
		world = new int[8][10];
		newWolrd = new int[8][10];
		System.out.println(world.length);
		System.out.println(world[0].length);
		for (i = 0; i < world.length; i++) {
			for (j = 0; j < world[0].length; j++) {
				world[i][j] = r.nextInt(2);

			}
		}
	
	}

	public void setCell(int i, int j, int newValue){
		
		newWolrd[i][j]= newValue;
	}
	void printWorld() {
		int i, j;
		for (i = 0; i < world.length; i++) {
			for (j = 0; j < world[0].length; j++) {
				if (j == world[0].length - 1) {
					System.out.println(world[i][j]);
				} else
					System.out.print(world[i][j]);
			}
		}
		System.out.println();
	}

	void nextGeneration() {
		int i, j=0;
		for (i = 0; i < world.length; i++) {
				//for (j = 0; j < world.length; j++) {
				NeighbourThread n = new NeighbourThread(world,newWolrd,i, j); 
				n.start();
				//Thread b = new Thread();
				//b.run();
				}
		//}
	}

	@Override
	public void run() {
		System.out.println("ss");
		
	}

	

	
	

}
