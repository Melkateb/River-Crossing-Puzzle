package Controller;

import Crossers.ICrosser;
import Crossers.IcrossingStrategy;
import Crossers.Story1;
import Crossers.Story2;
import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static ArrayList<ICrosser> llist = new ArrayList<>();
  public static ArrayList<ICrosser> blist = new ArrayList<>();
    public static ArrayList<ICrosser> rlist = new ArrayList<>(); 
    private static Lists list;

    private Lists(IcrossingStrategy str)
    {
        if(str instanceof Story1){
        
        Story1 s = new Story1();
        llist.addAll(s.getInitialCrossers());
        rlist = new ArrayList<>();}
        else if(str instanceof Story2)
        {
            Story2 s = new Story2();
        llist.addAll(s.getInitialCrossers());
        rlist = new ArrayList<>();
        }
        
    }
   
   public static Lists getList(IcrossingStrategy str)
   {
   
   if(list == null)
       list = new Lists(str);
   
   return list;
   
   
   }
   public static void setList(Lists list) {
        Lists.list = list;
    }

    public static void setLlist(ArrayList<ICrosser> llist) {
        Lists.llist = llist;
    }

    public static void setBlist(ArrayList<ICrosser> blist) {
        Lists.blist = blist;
    }

    public static void setRlist(ArrayList<ICrosser> rlist) {
        Lists.rlist = rlist;
    }
   
}
