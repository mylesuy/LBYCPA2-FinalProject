import java.util.*;

public class Graph {
    HashMap<String, LinkedList<String>> adjList = new HashMap<>();      //hashmap for order
    HashMap<String, LinkedList<Integer>> adjList2 = new HashMap<>();    //hashmap for price of order
    public String customerName;
    public String order;
    public int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrder() {
        return order;
    }

    //add connection of customer to order
    void addEdgeForOrder(String src, String dest){
        LinkedList<String> nodes;
        if(!adjList.containsKey(src)){
            nodes = new LinkedList<>();
        }
        else{
            nodes = adjList.get(src);
        }
        nodes.add(dest);
        adjList.put(src,nodes);
    }
    //add connection of customer to price
    void addEdgeForPrice(String src, int dest){
        LinkedList<Integer> nodes;
        if(!adjList2.containsKey(src)){
            nodes = new LinkedList<>();
        }
        else{
            nodes = adjList2.get(src);
        }
        nodes.add(dest);
        adjList2.put(src,nodes);
    }

    //remove order
    void removeEdgeForOrder(String src, String dest){
        if(adjList.containsKey(src)){
            LinkedList<String> nodes= adjList.get(src);
            nodes.remove(dest);
            adjList.put(src,nodes);
        }
    }
    //remove price
    void removeEdgeForPrice(String src, int dest){
        if(adjList2.containsKey(src)){
            LinkedList<Integer> nodes= adjList2.get(src);
            //nodes.remove(dest);
            nodes.remove(Integer.valueOf(dest));

            adjList2.put(src,nodes);
        }
    }

    void removeAll(){
        adjList.clear();
        adjList2.clear();
    }
    Set getNodes()  {
        return adjList.keySet();
    }
    // get all orders

    public List<String> getAllOrders(String src){
        return adjList.get(src);
    }
    public List<Integer> getAllPrices(String src){
        return adjList2.get(src);
    }


    public static void main(String[] args){
        //test
        Graph graph = new Graph();
        graph.addEdgeForPrice("abc",5);
        graph.addEdgeForPrice("abcd",7);

    }
}
