
public class NeighbourThread extends Thread {
	public int[][] world;
	public int[][] newWolrd;
	private Thread t;
	private int i;
	private int j;
	
	


	public NeighbourThread(int[][] world, int[][] newWolrd, int i, int j) {
		super();
		this.world = world;
		this.newWolrd = newWolrd;
		this.i = i;
		this.j = j;
	}

	@Override
	public void run() {
		for (j = 0; j < world[0].length; j++) {
		//System.out.println("thread no:  "+i);
		countNeighbours( i,  j);
		}
	}

	int countNeighbours(int i, int j) {

		int nCount, n, m, ILimit, JLimit;
		// set the starting value for nCount 0 if the cell is dead -1 if it is
		// alive
		if (world[i][j] == 0) {
			nCount = 0;

		} else if (world[i][j] == 1) {
			nCount = -1;
		} else {
			// should not happen
			nCount = 0;
		}

		ILimit = i + 1;
		JLimit = j + 1;
		for (n = i - 1; n <= ILimit; n = n + 1) {
			for (m = j - 1; m <= JLimit; m = m + 1) {
				// Exclude out of bounds values and the current cell value i.e
				// doesn't count itself as living neighbor

				if (n >= 0 && n <= world.length - 1 && m >= 0
						&& m <= world.length - 1) {

					if (world[n][m] == 1) {
						nCount++;
					}
				} else {

				}

			}
		}

		if (world[i][j] == 0) {
			if (nCount == 3) {
				newWolrd[i][j] = 1;
			} else {
				// do nothing - stay dead
				newWolrd[i][j] = 0;
			}

		}
		// computing data for a living cell
		else if (world[i][j] == 1) {
			// die if its overcrowded
			if (nCount > 3) {
				newWolrd[i][j] = 0;
			}
			// die of loneliness
			else if (nCount < 2) {
				newWolrd[i][j] = 0;
			} else {
				// do nothing - stay alive
				newWolrd[i][j] = 1;
			}

		}

System.arraycopy(newWolrd, 0, world, 0, world.length);
		return nCount;
	}


}
