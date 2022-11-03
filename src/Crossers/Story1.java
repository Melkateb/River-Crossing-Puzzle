package Crossers;


import java.util.ArrayList;
import java.util.List;



public class Story1 implements IcrossingStrategy {
    Farmer farmer = Farmer.getInstance();
    int i, j;
    private boolean valid = false;
     @Override
    public boolean isValid(List<ICrosser> right, List<ICrosser> left, List<ICrosser> boatRiders) {
        if (boatRiders.size() == 1 || boatRiders.size() == 2) {

            for (int i = 0; i < boatRiders.size(); i++) {
                ICrosser object = boatRiders.get(i);
                if (object.canSail()) {
                    valid = true;

                }

            }

        }
        if (valid == true) {
            for (i = 0; i < boatRiders.size(); i++) {
                for (j = 0; j < left.size(); j++) {
                    if (boatRiders.get(i) == left.get(j)) {
                        System.out.print("removed object form left bank " + left.get(j) + "\n");
                        left.remove(j);

                    }
                }
            }
            for (i = 0; i < left.size() - 1; i++) {

                int x = left.get(i).getEatingRank();
                int y = left.get(i + 1).getEatingRank();
                if ((x - y) == 1 || (x - y) == -1) {
                    System.out.print("what you left on the bank will eat each other\n");
                    valid = false;
                    return valid;

                }

            }
            for (i = 0; i < boatRiders.size(); i++) {
                for (j = 0; j < right.size(); j++) {
                    if (boatRiders.get(i) == right.get(j)) {
                        // System.out.print("removed object form left bank " + left.get(j) + "\n");
                        right.remove(j);

                    }
                }
            }
            for (i = 0; i < right.size() - 1; i++) {

                int x = right.get(i).getEatingRank();
                int y = right.get(i + 1).getEatingRank();
                if ((x - y) == 1 || (x - y) == -1) {
                    //System.out.print("what you left on the bank will eat each other\n");
                    valid = false;
                    return valid;

                }

            }

        }

        return valid;
    }
    /*@Override
    public boolean isValid(List<ICrosser> right, List<ICrosser> left, List<ICrosser> boatRiders) {
        boolean valid = false;
        for (int i = 0; i < boatRiders.size(); i++) {
            ICrosser x = boatRiders.get(i);
            if (x.canSail()) {
                valid = true;
                break;
            }
        }
        if (valid == false) {
            return false;
        }
        if (left.size() == 3) {
            return false;
        } else if (left.size() == 2) {
            int diff=left.get(0).getEatingRank()-left.get(1).getEatingRank();
        if(diff==1 ||diff==-1)
            return false;
        }
        return true;
    }*/

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> c = new ArrayList<>();
        Factory f = new Factory();
                
        c.add(new Plant());
        c.add(f.getCrosser("Fox"));
        c.add(farmer.makeCopy());
        c.add(f.getCrosser("Goat"));

        return c;
    }

    @Override
    public String[] getInstructions() {
 String[] I = new String[5];
        I[0] = "A farmer wants to cross a river and take with him a carnivorous, a herbivorous and a plant.";
        I[1] = "Rules:";
        I[2] = "1)The farmer is the only one who can sail the boat.He can only take one passenger in addition to himself.";
        I[3] = "2)You can not leave any two crossers on the same bank if they can harm(eat) each other";
        I[4] = "How can the farmer get across the river with all the 2 animals and the plant without any losses?";

        return I;
    
    }

}
