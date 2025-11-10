// Lab Session:9 (Collections, List interface, iteration)

import java.util.ArrayList;
import java.util.Iterator;

public class Lab9 {
   public AutoBoxingWithCollection() {
   }

   public static void main(String[] var0) {
      ArrayList var1 = new ArrayList();
      var1.add(10);
      var1.add(20);
      var1.add(30);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         int var3 = (Integer)var2.next();
         System.out.println(var3);
      }

   }
}


