import java.util.Random;

public class GoL {
	private int[][] world;

	public static void main(String args[]) {
		int i, generations;
		System.out.println(args.length);
		if (args.length == 0) {
			GoL game = new GoL();
			game.printWorld();
			for (i = 0; i < 10; i++) {
				game.nextGeneration();
				game.printWorld();
				game.drawFrame();
			}
		}
		// placeholder to read configuration form the arguments provided on
		// runtime

	}

	public GoL() {
		// default run 10 x 10 board, 10 generations
		Random r = new Random();
		int i, j;
		world = new int[10][10];
		for (i = 0; i < world.length; i++) {
			for (j = 0; j < world.length; j++) {
				world[i][j] = r.nextInt(2);

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
		System.out.println();
	}

	void nextGeneration() {
		int i, j, neighboutCount;
		for (i = 0; i < world.length; i++) {
			for (j = 0; j < world.length; j++) {
				neighboutCount = countNeighbours(i, j);
				// computing data for a dead cell- it can only get alive or stay
				// unchanged
				if (world[i][j] == 0) {
					if (neighboutCount == 3) {
						world[i][j] = 1;
					} else {
						// do nothing - stay dead
					}

				}
				// computing data for a living cell
				else if (world[i][j] == 1) {
					// die if its overcrowded
					if (neighboutCount > 3) {
						world[i][j] = 0;
					}
					// die of loneliness
					if (neighboutCount < 2) {
						world[i][j] = 0;
					} else {
						// do nothing - stay alive
					}

				}

			}
		}
	}

	int countNeighbours(int i, int j) {

		int nCount = 0, n, m, limit;
		// calculate count for not at any border
		if (i > 0 && j > 0 & i < world.length - 1 & j < world.length - 1) {
			limit = i + 1;
			for (n = i - 1; n < limit; n++) {
				for (m = j - 1; m < limit; m++) {
					if (world[n][m] == 1) {
						nCount++;
					}
				}
			}

		}
		// calculate count for north border

		// calculate count for south border

		// calculate count for west border

		// calculate count for east border

		return nCount;
	}

	private void drawFrame() {
		int i;
		for (i = 0; i < world.length - 1; i++) {
			world[0][i] = 9;
			world[world.length - 1][i] = 9;
			world[i][0] = 9;
			world[i][world.length - 1] = 9;
		}
		world[world.length - 1][world.length - 1] = 9;
	}
}
