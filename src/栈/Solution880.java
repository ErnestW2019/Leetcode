package 栈;
/*
 * 880. 索引处的解码字符串
难度
中等
给定一个编码字符串 S。为了找出解码字符串并将其写入磁带，从编码字符串中每次读取一个字符，并采取以下步骤：
如果所读的字符是字母，则将该字母写在磁带上。
如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 
示例 1：
输入：S = "leet2code3", K = 10
输出："o"
解释：
解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
字符串中的第 10 个字母是 "o"。
示例 2：
输入：S = "ha22", K = 5
输出："h"
解释：
解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
示例 3：
输入：S = "a2345678999999999999999", K = 1
输出："a"
解释：
解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
 
提示：
2 <= S.length <= 100
S 只包含小写字母与数字 2 到 9 。
S 以字母开头。
1 <= K <= 10^9
解码后的字符串保证少于 2^63 个字母。
 */
public class Solution880 {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        //统计总的展开后长度
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(Character.isDigit(ch)){
                size *= ch-'0';
            }else{
                size++;
            }
        }
        //从后往前遍历
        for(int i=S.length()-1;i>=0;i--){
            char ch = S.charAt(i);
            K%=size;
            if(K==0&&Character.isLetter(ch)) {
                //String
                return String.valueOf(ch);
            }
            if(Character.isDigit(ch)){
                size /= ch-'0';
            }else{
                size--;
            }
        }
        return "";
    }
}
