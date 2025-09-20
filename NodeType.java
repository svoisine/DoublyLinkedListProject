/*
 * Class NodeType
 * 
 * This class uses generics to create a NodeType object
 * with variables, info (being the value), next being 
 * the next value that the Node can point to and back being
 * the previous value the node points to.
 * 
 * Name: Seth Voisine
 * UGA ID: 811906637
 * Date: 09/20/2025
 */
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;
}
