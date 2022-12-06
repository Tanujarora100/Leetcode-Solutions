	public static boolean ratInAMaze(int maze[][]){
		int [][] path= new int[maze.length][maze.length];
		return Solve(maze, 0,0,path);
	}
	public static boolean Solve(int [][] maze, int i, int j, int[][] path)
	{
		//Checking if the Cell is a Valid cell
		int n= maze.length;
		if(i<0||i>=n||j<0||j>=n||maze[i][j]==0||path[i][j]==1)
			return false;
		path[i][j]=1;
		//Check if we already at destination cell
		if(i==n-1 && j==n-1)
		{
			return true;
		}
		if(Solve(maze, i+1, j, path)) return true;
		if (Solve(maze, i, j+1, path))
			return true;
		if (Solve(maze, i-1, j, path))
			return true;
		if (Solve(maze, i, j-1, path))
			return true;
	return false;
	}
