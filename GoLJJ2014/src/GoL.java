public class GoL {
	private int[][] world;

	public static void main(String args[]) {
		GoL game = new GoL();
		game.printWorld();
	}

	public GoL() {
		int i, j;
		world = new int[5][5];
		for (i = 0; i < world.length; i++) {
			for (j = 0; j < world.length; j++) {
				

			}
		}

	}

	void printWorld() {
		int i, j;
		for (i = 0; i < world.length; i++) {
			for (j = 0; j < world.length; j++) {
				if (j == world.length - 1) {
					System.out.println(world[i][j]);
				} else
					System.out.print(world[i][j]);
			}
		}

	}

	void nextGeneration() {

	}
}
