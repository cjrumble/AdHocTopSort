import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

        public class TopSort
        {
            Stack<Node> stack;

            public TopSort() {
                stack=new Stack<>();
            }
            static class Node
            {
                int data;
                boolean visited;
                List<Node> neighbors;

                Node(int data)
                {
                    this.data=data;
                    this.neighbors=new ArrayList<>();

                }
                public void addneighbors(Node neighbourNode)
                {
                    this.neighbors.add(neighbourNode);
                }
                public List<Node> getNeighbors() {
                    return neighbors;
                }
                public void setNeighbours(List<Node> neighbors) {
                    this.neighbors = neighbors;
                }
                public String toString()
                {
                    return ""+data;
                }
            }

            // Recursive toplogical Sort
            public  void toplogicalSort(Node node)
            {
                List<Node> neighbors=node.getNeighbors();
                for (int i = 0; i < neighbors.size(); i++) {
                    Node n=neighbors.get(i);
                    if(n!=null && !n.visited)
                    {
                        toplogicalSort(n);
                        n.visited=true;
                    }
                }
                stack.push(node);
            }

            public static void main(String arg[])
            {

                TopSort topological = new TopSort();
                Node node40 =new Node(40);
                Node node10 =new Node(10);
                Node node20 =new Node(20);
                Node node30 =new Node(30);
                Node node60 =new Node(60);
                Node node50 =new Node(50);
                Node node70 =new Node(70);

                node40.addneighbors(node10);
                node40.addneighbors(node20);
                node10.addneighbors(node30);
                node20.addneighbors(node10);
                node20.addneighbors(node30);
                node20.addneighbors(node60);
                node20.addneighbors(node50);
                node30.addneighbors(node60);
                node60.addneighbors(node70);
                node50.addneighbors(node70);

                System.out.println("Topological Sorting Order:");
                topological.toplogicalSort(node40);

                // Print contents of stack
                Stack<Node> resultStack=topological.stack;
                while (resultStack.empty()==false)
                    System.out.print(resultStack.pop() + " ");
            }

        }



        /*
        //Assumption: graph is stored as adjacency list
        function topsort(graph):
            N = graph.numberOfNodes(); // number of Nodes in the graph
            V = [false,...,false] // Length N   represents visited Nodes
            ordering = [0,...,0] // Length N result of the function, sort order
            i = N - 1; // Index for ordering array, insertion position of the next element in the topo ordering
        // starts at N - 1 because we insert backwards

        for(at = 0; at < N; at++); // iterate overall nodes in graph. at tracks the ID of the node we are processing
            if V[at] == false: // are we on a visited node? No, continue.
                visitedNodes = []; before DFS, init array of visited nodes, add nodes as we find them
                dfs(at, V, visitedNodes, graph) // depth first search
                        for nodeId in visitedNodes: //look at nodes in visited and add to ordering result
                        ordering[i] = nodeId; // add visited nodes to ordering
                        return ordering;


        function dfs(at, V, visitedNodes, graph): // pass in visited Nodes
            V[at] = true; // mark the node were at as visited
            edges = graph.getEdgesOutFromNode(at) // look at children
                for edge in edges: // for edges, make sure not in visited
                    if V[edge.to] == false:
                        dfs(edge.to, V, visitedNodes, graph) // edge.to is destination node.
        // recursive call if we get stuck at the bottom w/ no kids
                        visitedNodes.add(at)
*/

