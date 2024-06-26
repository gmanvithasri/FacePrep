import java.util.*;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      String prefix="";
      String suffix ="";
      String ans = "";
      int first = 0;
      int last = s.length()-1;
      for (int i=0; i<s.length()-1;i++)
      {
        prefix = prefix + s.charAt(first);
        suffix = s.charAt(last) + suffix;
        first =first+1;
        last = last-1;
        if(prefix.equals(suffix))
          ans = prefix;
      }
      System.out.println(ans);
    }
}
