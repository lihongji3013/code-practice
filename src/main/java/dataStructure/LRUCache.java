package dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hongji
 * @Date: 2021-08-23 18:52
 */
public class LRUCache {

    private int size;
    private Node first;
    private Node last;
    private Map<Integer,Node> map = new HashMap<>();

    class Node{
        private Integer key;
        private Integer val;
        private Node pre;
        private Node next;
    }

    public LRUCache(int size){
        this.size = size;
        map = new HashMap<>(size);
    }

    public int get(Integer key){
        if(map.get(key)==null){
            return -1;
        }
        Node node = map.get(key);

        return node.val;
    }
    public void movetoHead(Node node){

    }

    public void addToHead(Node node){

    }
    public void removeToLast(){

    }
    public void put(int key,int val){

    }



}
