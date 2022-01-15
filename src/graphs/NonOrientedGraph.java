package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class NonOrientedGraph {

    // Rque : on modélise la liste d'adjacence avec une LinkedList, mais elle peut aussi être modélisée par :
    // - Un tableau classique : à condition de recréer un tableau à chaque modification (ajout/suppression)
    // - Un ArrayList
    // - etc
    // Encore une fois il est important de comprendre que la notion de Graph est un Type de données abstrait
    // qui peut être représenté de plusieurs façons.
    // Un autre moyen est d'avoir une matrice d'adjacence pour modéliser notre graphe (plus gourmand en espace mémoire)

    private int nbVertices;   // Nombre de noeuds
    private LinkedList<Integer>[] adjacencyList; // Liste d'adjacence

    // Constructor

    NonOrientedGraph(int nbVertices) {
        this.nbVertices = nbVertices;
        adjacencyList = new LinkedList[nbVertices];
        for (int i = 0; i < nbVertices; ++i) {
            adjacencyList[i] = new LinkedList();
        }
    }

    // Methods

    void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
    }


    // BFS = Breadth First Search
    // source = point d'entrée de notre BFS
    void BFS(int currentVertex) {

        System.out.println("** BFS from " + currentVertex);

        // visited nous permet de garder une trace sur les noeuds qui ont déjà été visités
        // on ajoute dedans les numéros des noeuds au fur et à mesure qu'ils sont visités
        boolean [] visited = new boolean[nbVertices];

        // queue enables to keep a trace on vertices which has been visited and can have
        // la queue (FIFO) permet de conserver une trace sur les noeuds visités et pour lequels nous
        // n'avons pas encore regardé les potentiels voisins
        LinkedList<Integer> queue = new LinkedList();

        // On commence par marquer le premier noeud comme visité
        visited[currentVertex] = true;
        queue.add(currentVertex);

        while (queue.size() != 0) {

            // On dequeue le premier élément courant puis on l'affiche
            currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // On recupere l'ensemble des voisins de notre élément courant et on les parcourt, s'ils ne l'ont pas déjà été
            // 1- On les marque comme visité
            // 2- On les ajoute à la queue pour parcourir leurs voisins
            Iterator<Integer> neighbor = adjacencyList[currentVertex].listIterator();
            while (neighbor.hasNext()) {
                int n = neighbor.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    // DFS = Depth First Search
    // source = point d'entrée de notre BFS
    void DFS(int currentVertex) {

        System.out.println("** DFS from " + currentVertex);

        // visited nous permet de garder une trace sur les noeuds qui ont déjà été visités
        // on ajoute dedans les numéros des noeuds au fur et à mesure qu'ils sont visités
        boolean [] visited = new boolean[nbVertices];

        DFSRecursion(currentVertex, visited);

        System.out.println();
    }

    private void DFSRecursion(int vertex, boolean [] visited) {
        // On marque le current vertex comme visité et on l'affiche
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // On part en recurrence sur les vertices voisins de notre currentVertex
        Iterator<Integer> i = adjacencyList[vertex].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSRecursion(n, visited);
            }
        }
    }
}
