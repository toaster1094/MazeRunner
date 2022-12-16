package maze;

import java.util.*;

public class Graph {
    int vertices;
    //LinkedList<Edge>[] adjacencylist;
    //Vertex[][] vertexArray = new Vertex[100][100];
    private LinkedHashMap<Vertex, ArrayList<Edge>> adjVertices;

    ArrayList<Edge> allEdgesArray;

    public Graph() {
        adjVertices = new LinkedHashMap<>();
        allEdgesArray = new ArrayList<>();
        //this.vertices = vertices;
        //adjacencylist = new LinkedList[vertices];
        //for(int i = 0; i<vertices;i++) {
          //  adjacencylist[i] = new LinkedList<>();
        //}
    }

    public void addVertex(Vertex vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(String label) {
        //Vertex v= new Vertex(label);
        //adjVertices.values().stream().forEach(e -> e.remove(v));
        //adjVertices.remove(new Vertex(label));
    }

    public void populateAllEdgesArray(Edge edge) {
        Edge tempEdge = new Edge(edge.src,edge.dest, edge.weight);
        allEdgesArray.add(tempEdge);
    }
    public Edge checkForExistingEdge(Edge edge) {
        for(Edge e : allEdgesArray) {
            if ((e.getLabel().equals(edge.dest.getLabel() + edge.src.getLabel()))|| e.getLabel().equals(edge.getLabel())) {
               return e;
            }
        }
        return edge;
    }

    public Edge checkForExistingEdgeTwoEdges(Edge edge1, Edge edge2) {
        for(Edge e : allEdgesArray) {
            if ((e.getLabel().equals(edge1.getLabel()))|| e.getLabel().equals(edge2.getLabel())) {
                return e;
            }
        }
        return edge2;
    }

    public boolean returnBooleanForExistingEdge(Edge edge) {
        for(Edge e : allEdgesArray) {
            if ((e.getLabel().equals(edge.dest.getLabel() + edge.src.getLabel()))|| e.getLabel().equals(edge.getLabel())) {
                return true;
            }
        }
        return false;
    }

    public void addEdge(Edge edge) {

        Vertex v1;

        if(returnBooleanForExistingEdge(edge)) {
             v1 = edge.getSrc();
        }
        else {
             v1 = edge.getDest();
        }

        //System.out.print("V1 " + v1);
        ArrayList<Edge> tempList = new ArrayList<>();
        //tempList.add(edge);
        tempList = adjVertices.get(v1);
        if(!tempList.contains(edge)) {
            tempList.add(edge);
        }
        //adjVertices.get(v1).add(edge);
        //adjVertices.get(v2).add(v1);
    }

    public void printMap() {
        for(Vertex v : adjVertices.keySet() ) {
            System.out.println(v.getLabel());
        }
    }
    public void printValues() {
        for(Vertex v:adjVertices.keySet()) {
            ArrayList<Edge> tempArray = adjVertices.get(v);
            System.out.println();
            System.out.print("MAIN VErTEX "+v.getLabel() + " ");
            for(Edge e:tempArray) {
                System.out.print(e.getLabel() + " ");
            }
        }
    }

    public ArrayList<Edge> getEdgeArray() {
        return allEdgesArray;
    }
}
