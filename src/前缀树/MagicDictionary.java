package 前缀树;


import 数组.Solution283;

public class MagicDictionary {
	static class TrieNode{
	    public int end;
	    public int path;
	    public TrieNode child[];
	    public boolean isEnd;
	    public TrieNode(){
	        child = new TrieNode[26];
	        end = 0;
	        path = 0;
	    }
	}
    public TrieNode root;;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        
        for(String str:dict){
        	TrieNode node = root;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(node.child[ch-'a']==null){
                    node.child[ch-'a'] = new TrieNode();
                }
                node = node.child[ch-'a'];
                node.path++;
            }
            node.isEnd = true;
        }
        
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode node = root;
        char[] chs = word.toCharArray();
        return magicSearch(node,chs,0,1);
    }
    private boolean magicSearch(TrieNode root,char[] chs,int index,int magicCnt){
        if(root==null) return false;
        if(index == chs.length){
            return root.isEnd&&magicCnt==0;
        }
        else{          
            char ch = chs[index];
            for(int i=0;i<26;i++){
                if(root.child[i]!=null){
                    if(i+'a'==ch){
                        if(magicSearch(root.child[i],chs,index+1,magicCnt)) return true;
                    }
                    else{
                        //--magicCnt;
                        if(magicSearch(root.child[i],chs,index+1,magicCnt-1)) return true;;
                    }
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
    	String[] strings = {"hello","hallo","leetcode"};
    	MagicDictionary magicDictionary = new MagicDictionary();
    	magicDictionary.buildDict(strings);
    	System.out.println(magicDictionary.search("hello"));
    	System.out.println(magicDictionary.search("hallo"));
    	System.out.println(magicDictionary.search("hell"));
    	System.out.println(magicDictionary.search("leetcode"));
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */