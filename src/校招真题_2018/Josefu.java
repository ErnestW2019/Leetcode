package 校招真题_2018;
import java.util.Scanner;
public class Josefu {
	  public static void main(String[] args){
	      Scanner sc = new Scanner(System.in);
          while(sc.hasNext()){
              int n = sc.nextInt();
              int last = 0;
              for(int i=2;i<=n;i++){
                  last = (last+3)%i;
              }
              System.out.println(last);
          }
	  }
}
