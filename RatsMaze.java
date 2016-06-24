
public class Maze {
	
	private int[][]maze;
	private int row_bound;
	private int col_bound;
	public Maze(int[][] maze)
	{
		this.maze = maze;
		row_bound = maze.length;
		col_bound = maze[0].length;		
	}
	
	private boolean valid(int row,int col)
	{
		boolean val = true;
		if (row < 0  && row >= row_bound)
			val = false;
		if (col < 0  && col >= col_bound)
			val = false;
		return val;
	}
	private boolean move(int row, int col)
	{
		if (row==row_bound-1 && col==col_bound-1)
		{	
			System.out.println("Destination reached !!");
			System.out.println(String.format("(%d,%d)", row,col));
			return true;
		}
		if (!valid(row,col) || maze[row][col]==0)
			return false;
		// move front
		boolean success = move(row,col+1);
		if (success)
			{
				System.out.println(String.format("(%d,%d)", row,col));
				return success;
			}
		// if move front not successful move down
		success = move(row+1,col);
		if (success)
		{
			System.out.println(String.format("(%d,%d)", row,col));
			return success;
		}
		if (!success && row == 0 && col == 0)
			{
				System.out.println("No solution possible.");
			}
		return success;
	}
	
	public void solve()
	{
		move(0,0);
	}
	
	public static void main(String[] args)
	{
		int [][]M = {{1, 0, 0, 0},
					{1, 1, 0, 1},
					{0, 1, 0, 0},
					{1, 1, 1, 1}};
		Maze maze = new Maze(M);
		maze.solve();
	}

}
