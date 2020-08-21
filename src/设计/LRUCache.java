package 设计;
/*
 * 146. LRU缓存机制)
难度
中等

运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 
进阶:
你是否可以在 O(1) 时间复杂度内完成这两种操作？
*/

import java.util.HashMap;
//节点类
class Node{
	public int key,val;
	public Node next,prev;
	public Node() {
		
	}
	public Node(int k,int v) {
		this.key = k;
		this.val = v;
	}
}
//双向链表类
/*
class DNodeList{
	private Node head;
	private Node tail;
	public void addFirst(Node x) {
		x.prev = head;
		x.next = head.next;
		head.next.prev = x;
		head.next = x;
	}
	public void remove(Node x) {
		x
	}
	
	public Node removeLast();
	
	public int size();
}
*/
public class LRUCache{
	private HashMap<Integer, Node> map;
	private int capacity;
	private int size;
	private Node head;
	private Node tail;
    public LRUCache(int capacity) {
    	this.size = 0;
    	this.capacity = capacity;
    	map = new HashMap<>();
    	head = new Node();
    	tail = new Node();
    	head.next = tail;
    	tail.prev = head;
    }
    
    public int get(int key) {
    	Node node = map.get(key);
    	if(node==null) {
    		return -1;
    	}
    	//如果存在key，则将其移动到头部
    	moveToHead(node);
    	return node.val;
    }
    
    public void moveToHead(Node node) {
		// TODO Auto-generated method stub
		removeNode(node);
		addToHead(node);
	}

	public void addToHead(Node node) {
		// TODO Auto-generated method stub
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}

	public void removeNode(Node node) {
		// TODO Auto-generated method stub
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if(node==null) {
			Node newNode = new Node(key,value);
			//添加进哈希表
			map.put(key, newNode);
			//添加至双向链表的头部
			addToHead(newNode);
			++size;
			if(size>capacity) {
				//如果超出容量，则删除双向链表尾部的节点
				Node tail = removeTail();
				map.remove(tail.key);
				--size;
			}
		}else {
			node.val = value;
			moveToHead(node);
		}
    }
	public Node removeTail() {
		// TODO Auto-generated method stub
		Node resNode = tail.prev;
		removeNode(resNode);
		return resNode;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2); /* 缓存容量 */ 

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // 返回  1
		cache.put(3, 3);    // 该操作会使得关键字 2 作废
		cache.get(2);       // 返回 -1 (未找到)
		cache.put(4, 4);    // 该操作会使得关键字 1 作废
		cache.get(1);       // 返回 -1 (未找到)
		cache.get(3);       // 返回  3
		cache.get(4);       // 返回  4
	}
}
