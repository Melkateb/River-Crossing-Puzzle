package Crossers;

import java.util.ArrayList;
import java.util.List;

public class Story2 implements IcrossingStrategy{
    @Override
    public boolean isValid(List<ICrosser> right, List<ICrosser> left, List<ICrosser> crossers) {
       boolean move=false;
        if (crossers.size() == 1) {
                for (int i = 0; i < crossers.size(); i++) {
                    double x=crossers.get(i).getWeight();
                    //System.out.println("waznyyyyyyy"+x);
                    if (x==20) {
                        move = false;
                        return move;
                    }

                }
            }
             if (crossers.size() == 2) {
                for (int i = 0; i < crossers.size(); i++) {
                    double x=crossers.get(0).getWeight();
                     double y=crossers.get(1).getWeight();
                     // System.out.println("waznyyyyyyylawetnen"+x+"     "+y);
                    if ((x + y)>100) {
                        move = false;
                        return move;
                    }

                }
            } 
          return true;   
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> c = new ArrayList<>();
        c.add(new Farmer1());
        c.add(new Farmer2());
        c.add(new Farmer3());
        c.add(new Farmer4());
        c.add(new Animal());
        return c;
    }

    @Override
    public String[] getInstructions() {
     String []I = new String[5];
     I[0]="Four farmers and their animal need to cross a river in a small boat. The weights of the farmers  are 90 kg, 80 kg,60 kg and 40 kg respectively, and the weight of the animal is 20 kg.";
     I[1]="Rules:";
     I[2]="1)The boat cannot bear a load heavier than 100 kg.";
     I[3]="2)All farmers can raft, while the animal cannot.";
     I[4]="How can they all get to the other side with their animal?";
     return I;
    } 
}


