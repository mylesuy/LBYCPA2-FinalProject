import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {
    HashMap<String, LinkedList<String>> adjList = new HashMap<>();
    HashMap<String, LinkedList<Integer>> adjList2 = new HashMap<>();
    public String customerName;
    public String order;
    //public String price;
    public int price;

  /*  public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }*/

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

    //add order
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

    void addEdgeForPirce(String src, int dest){
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
    void removeEdge(String src, String dest){
        if(adjList.containsKey(src)){
            LinkedList<String> nodes= adjList.get(src);
            nodes.remove(dest);
            adjList.put(src,nodes);
        }
    }
    Set getNodes()  {
        return adjList.keySet();
    }
    // get all orders
    public List<String> getAllFriends(String src){
        return adjList.get(src);
    }
    public List<String> getAllOrders(String src){
        return adjList.get(src);
    }
    public List<Integer> getAllPrices(String src){
        return adjList2.get(src);
    }

    public static void main(String[] args){

    }
}
