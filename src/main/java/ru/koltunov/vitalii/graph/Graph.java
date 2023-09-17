package ru.koltunov.vitalii.graph;

import java.lang.reflect.Array;
import java.util.*;

/*
Инициализироваться граф должен по числе N -- количеству вершин в графе
add_edge(a, b) -- добавление ребра из a в b
dfs() -- выводящий на экран все вершины в порядке обхода
bfs() -- выводящий на экран все вершины в порядке обхода
is_bipartite_graph() -- возвращающий TRUE в случае, если граф двудолен и FALSE иначе.
calculate_connectivity_components() -- возвращающий количество компонент связности.
 */


public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(graph.vertices.get(0), graph.vertices.get(1));
        graph.addEdge(graph.vertices.get(1), graph.vertices.get(2));
//        graph.addEdge(graph.vertices.get(1), graph.vertices.get(4));
        graph.addEdge(graph.vertices.get(2), graph.vertices.get(3));
        graph.addEdge(graph.vertices.get(4), graph.vertices.get(5));
        graph.bfs();
        graph.dfs();
        System.out.println(graph.is_bipartite_graph());
        System.out.println("Connectivity components = " + graph.calculate_connectivity_components());
    }

    List<Edge> edges;
    List<Vertex> vertices;
    private Set<Vertex> visited = new HashSet<>();

    public Graph(int size) {
        this.vertices = new ArrayList<Vertex>(size);
        for (int i = 0; i < size; i++) {
            this.vertices.add(new Vertex(i + 1));
        }
        this.edges = new ArrayList<Edge>();
    }

    void addEdge(Vertex v1, Vertex v2) {
        Edge edge = new Edge(v1, v2);
        edge.road = true;
        edges.add(edge);
    }


    private StringJoiner sj;
    private int found_vertices = 0;
    public void dfs() {
        found_vertices = 0;
        sj = new StringJoiner(", ");
        visited.clear();
        dfs(vertices.get(0));
        System.out.println("dfs: " + sj.toString());
    }

    public void bfs() {
        found_vertices = 0;
        sj = new StringJoiner(", ");
        visited.clear();
        bfs(vertices.get(0));
        System.out.println("bfs: " + sj);
    }
    public void bfs(Vertex u) {
        Deque<Vertex> queue = new ArrayDeque<>();
        queue.offer(u);
        while (!queue.isEmpty()) {
            Vertex k = queue.poll();
            visited.add(k);
            sj.add(k.toString());
            for (Edge edge : edges) {
                if (edge.v1 == k && !visited.contains(edge.v2)) {
                    queue.offer(edge.v2);
                }
            }
        }
    }

    private void dfs(Vertex v) {
        sj.add(v.toString());
        visited.add(v);
        for (Edge edge : edges) {
            if (edge.v1 == v && !visited.contains(edge.v2)) {
                dfs(edge.v2);
            }
        }
    }

    public boolean is_bipartite_graph() {
        return calculate_connectivity_components() == 2;
    }

    public int calculate_connectivity_components() {
        List<Vertex> vertexList = new ArrayList<>(vertices);
        int count = 0;
        while (!vertexList.isEmpty()) {
            Deque<Vertex> queue = new ArrayDeque<>();
            queue.offer(vertexList.get(0));
            visited.clear();
            while (!queue.isEmpty()) {
                Vertex k = queue.poll();
                vertexList.remove(k);
                visited.add(k);
                for (Edge edge : edges) {
                    if (edge.v1 == k && !visited.contains(edge.v2)) {
                        queue.offer(edge.v2);
                    }
                }
            }
            count++;
        }
        return count;
    }
}


class Edge {
    Vertex v1;
    Vertex v2;
    boolean road;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.road = true;
    }

    public Edge() {
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", road=" + road +
                '}';
    }
}

class Vertex {
    int vertex;
    public Vertex(int vertex) {
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return Integer.toString(vertex);
    }
}
