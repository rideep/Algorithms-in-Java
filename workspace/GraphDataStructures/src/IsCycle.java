class GraphT{
	int V,E;
	Edge edge[];
	class Edge
	{
		int src,dest;
	}
	GraphT(int V,int E)
	{
		this.V=V;
		this.E=E;
		edge=new Edge[E];
		for(int i=0;i<V;i++)
			edge[i]=new Edge();
		
	}
	int find(int parent[],int i)
	{
		if(parent[i]==-1)
			return i;
		return find(parent,parent[i]);
	}
	void Union(int parent[],int x,int y)
	{
		int setx=find(parent,x);
		int sety=find(parent,y);
		parent[setx]=sety;
	}
	public int isCycle(GraphT graph) {
		int parent[]=new int[graph.V];
		for(int i=0;i<V;i++)
			parent[i]=-1;
		for(int i=0;i<graph.E;i++ )
		{
			int x=graph.find(parent, graph.edge[i].src);
			int y=graph.find(parent, graph.edge[i].dest);
			if(x==y)
				return 1;
			Union(parent, x, y);
		}
		return 0;
	}
	
}
public class IsCycle {

	public static void main(String[] args) {
		int V = 3, E = 3;
        GraphT graph = new GraphT(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
 
        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );

	}

}
