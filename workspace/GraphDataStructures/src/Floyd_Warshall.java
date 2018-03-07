
public class Floyd_Warshall {
	public static final int INF=9999;
	int V=4;
	void floydWarshall(int graph [][])
	{
		int dist[][]=new int[V][V];
		for(int i=0;i<V;i++)
			for (int j = 0; j < V; j++) {
				dist[i][j]=graph[i][j];
			}
		for(int k=0;k<V;k++)
		{
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j])
						dist[i][j]=dist[i][k]+dist[k][j];
				}
			}
		}
		printSolution(dist);
	}
	void printSolution(int dist[][])
	{
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if(dist[i][j]==INF)
					System.out.print("INF ");
				else 
					System.out.print(dist[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
              };
Floyd_Warshall a = new Floyd_Warshall();

// Print the solution
a.floydWarshall(graph);

	}

}
