package educativity.algojava.graf;

public class CheckBFS {
    public static String bfs(Graph g){

        String result = "";

        //Checking if the graph has no vertices
        if (g.vertices < 1){
            return result;
        }

        //Boolean Array to hold the history of visited nodes (by default-false)
        boolean[] visited = new boolean[g.vertices];

        for(int i=0;i<g.vertices;i++)
        {
            //Checking whether the node is visited or not
            if(!visited[i])
            {
                result = result + bfsVisit(g, i, visited);
            }
        }
        return result;
    }
    public static String bfsVisit(Graph g, int source, boolean[] visited) {

        String result = "";

        //Create Queue for Breadth First Traversal and enqueue source in it
        Queue<Integer> queue = new Queue<>(g.vertices);

        queue.enqueue(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()) {

            //Dequeue a vertex/node from queue and add it to result
            int current_node = queue.dequeue();

            result += String.valueOf(current_node);

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then enqueue them in the Queue
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; //Visit the current Node
                }
                temp = temp.nextNode;
            }
        }//end of while
        return result;
    }
}
