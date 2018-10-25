import java.util.Iterator;
import java.util.LinkedList;
import java.util.*;

public class Graph {
	private int mVertices;
	private LinkedList<Integer> mAdjList[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v)
	{
		mVertices = v;
		mAdjList = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			mAdjList[i] = new LinkedList<Integer>();
		}
	}
	public void AddEdge(int v, int w)
	{
		mAdjList[v].add(w);
		mAdjList[w].add(v);
	}
	public void BFS(int s)
	{
		boolean visited[] = new boolean[mVertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0)
		{
			s = queue.poll();
			System.out.print(s + ", ");
			Iterator<Integer> iter = mAdjList[s].listIterator();
			while(iter.hasNext())
			{
				int n = iter.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	public void DFS(int s)
	{
		Vector<Boolean> visited = new Vector<Boolean>();
		for(int i=0;i<mVertices;i++)
		{
			visited.add(false);
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while(stack.empty() == false)
		{
			s = stack.peek();
			stack.pop();
			if(visited.get(s) == false)
			{
				System.out.print(s + " ");
				visited.set(s, true);
			} 
			Iterator<Integer> itr = mAdjList[s].iterator();
			while(itr.hasNext())
			{
				int v = itr.next();
				if(!visited.get(v))
					stack.push(v);
			}
		}
	}
	public void DFSUtil(int s, Vector<Boolean> visited)
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while(stack.empty() == false)
		{
			s = stack.peek();
			stack.pop();
			if(visited.get(s) == false)
			{
				System.out.print(s + ", ");
				visited.set(s, true);
			}
			Iterator<Integer> iter = mAdjList[s].iterator();
			while(iter.hasNext())
			{
				int v = iter.next();
				if(!visited.get(v))
				{
					stack.push(v);
				}
			}
		}
	}
	public void DFS()
	{
		Vector<Boolean> visited = new Vector<Boolean>(mVertices);
		for(int i=0; i<mVertices;i++)
		{
			visited.add(false);
		}
		for(int i=0;i<mVertices;i++)
		{
			if(!visited.get(i))
				DFSUtil(i, visited);
		}
	}
}
