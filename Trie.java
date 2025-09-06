import java.util.*;

public class Trie {

    Node root = new Node();

    public void insert(String word){

	word = word.toLowerCase();

        Node curr = root ;
        
        for (int i = 0 ; i < word.length() ; i++) {
            Character c = word.charAt(i);
            if(!(curr.children.containsKey(c))){
                Node tmp = new Node();
                curr.children.put(c, tmp);
            }
            curr = curr.children.get(c);
        }
        curr.flag = true ;
    }

    public void PrintWord(){
        System.out.println("----------------------------------------------------");
        System.out.println("Words in Trie : ");
        System.out.print("-> ");
        PrintWord(root, ""); // start from root with empty string
    }

    private void PrintWord(Node d, String s){
        if(d.flag) {
            System.out.print(s + ", ");
        } 
        for (Character key : d.children.keySet()) { // keySet() returns a set view of the keys contained in this map
            PrintWord(d.children.get(key), s + key); // recursive call for each child node
        }
    }

    public void PrintTrie()
    {
        System.out.println("----------------------------------------------------");
        boolean last = false;
        System.out.println("root --+ ");
        int i = 0 ;
        for (Character key : root.children.keySet()) {
            i++;
            System.out.println("       +- " + key);
            if (i == root.children.size()) 
                last = true;
            PrintTrie(root.children.get(key),"",last);
        }
    }

    private void PrintTrie(Node d, String indent, boolean last)
    {
        int i = 0;
        boolean tmp = false;
        if(last) indent+="  " ;
        else indent+="| " ;
        for (Character key : d.children.keySet()) {
             i++;
             System.out.println("       "+indent+"+- " + key);
             if (i == d.children.size()) 
                tmp = true;
            PrintTrie(d.children.get(key),indent,tmp);    
        } 
    }  
}

class Node{
    boolean flag ;
    Hashtable<Character,Node> children ;

    public Node(){
        flag = false ;
        children = new Hashtable<>();
    }
}


