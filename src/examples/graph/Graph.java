package examples.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	public Node rootNode;
	public ArrayList nodes= new ArrayList();
	public  int[][] adjMatrix; // To represent edges
	int size;
	public Node getRootNode() {
		return rootNode;
	}
	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public void addNode(Node n){
		nodes.add(n);
	}
	
	/**
	 * Method to connect two nodes
	 **/
	
	public void connectNode(Node start, Node end) {
		if(adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
					}
		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] =1;
	}
	 
	private Node getUnvisitedNode(Node n) {
		int index =nodes.indexOf(n);
		int j  = 0;
		while( j < size) {
			if(adjMatrix[index][j] == 1 && ((Node)nodes.get(j)).visited == false) {
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}
	public void dfs(){
		Stack s = new Stack();
			s.push(this.rootNode);
			rootNode.visited = true;
			printNode(rootNode);
			while(!s.isEmpty()) {
				Node n =(Node)s.peek();
				Node child = getUnvisitedNode(n);
				if(child != null) {
					child.visited = true;
					printNode(child);
					s.push(child);
				}
				else {
					s.pop();
				}
			}
			clearNodes();
	}
	private void clearNodes() {
		int i = 0;
		while(i < size) {
			Node n = (Node)nodes.get(i);
			n.visited = false;
			i++;
		}
		
	}
	private void printNode(Node rootNode2) {
		// TODO Auto-generated method stub
		System.out.print(rootNode2.label+" ");
	}
	
	public void bfs() {
		Queue q = new LinkedList();
		q.add(this.rootNode);
		printNode(rootNode);
		rootNode.visited = true;
		while( !q.isEmpty()){
			Node n = (Node)q.remove();
			Node child = null;
			while((child = getUnvisitedNode(n))!= null){
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}
		clearNodes();
		
	}
	 
	
	
	
}
