package 数学;
/*
 * 168. Excel表列名称
难度
简单

给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
示例 1:
输入: 1
输出: "A"
示例 2:
输入: 28
输出: "AB"
示例 3:
输入: 701
输出: "ZY"
 */
public class Solution168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char c;
        while(n>0){
            --n;
            int mod = n%26;
            n = n/26;
            sb.append((char)('A'+mod));
        }
        return sb.reverse().toString();
    }
}
