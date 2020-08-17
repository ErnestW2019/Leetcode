package 前缀树;
/*
 * 208. 实现 Trie (前缀树)
难度
中等

实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 */
public class TrieNode{
    public TrieNode [] child;
    public int path;
    public int end;
    boolean isEnd;
    public TrieNode(){
        child = new TrieNode[26];
        isEnd = false;
        path = 0;
        end = 0;
    }
}
class Trie {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.child[ch-'a']==null){
                node.child[ch-'a'] = new TrieNode();
            }
            node = node.child[ch-'a'];
            node.path++;
        }
        //node.end++;
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null||word.length()==0) return false;
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.child[ch-'a']==null){
                return false;
            }else{
                node = node.child[ch-'a'];
            }
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null||prefix.length()==0) return false;
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(node.child[ch-'a']==null) return false;
            node = node.child[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
