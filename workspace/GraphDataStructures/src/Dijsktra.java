class SPath{
	static final int V=9;
	int minDistance(int dist[],boolean sptSet[])
	{
		int min=Integer.MAX_VALUE;
		int min_index=-1;
		for(int i=0;i<V;i++)
		{
			if(dist[i]<=min && sptSet[i]==false)
			{
				min=dist[i];
				min_index=i;
			}
		}
		return min_index;
	}
	void printSolution(int dist[],int V)
	{
		for (int i = 0; i < V; i++) {
			System.out.println(i+" "+dist[i]);
		}
	}
	void Djisktra(int graph[][],int src)
	{
		int dist[]=new int[V];
		boolean sptSet[]=new boolean[V];
		for(int i=0;i<V;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		dist[src]=0;
		for (int count = 0; count < V-1; count++) {
			int u=minDistance(dist, sptSet);
			sptSet[u]=true;
			for (int v = 0; v < V; v++) {
				if(sptSet[v]==false  && dist[u]!=Integer.MAX_VALUE && 
						graph[u][v]!=0 && dist[v]>dist[u]+graph[u][v]) {
					dist[v]=dist[u]+graph[u][v];
				}
					
			}
		}
		printSolution(dist, V);
	}
}
public class Dijsktra {

	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
SPath t = new SPath();
t.Djisktra(graph, 0);

	}

}
