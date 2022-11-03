package Crossers;

import java.util.List;

public interface IcrossingStrategy {

    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders);

    public List<ICrosser> getInitialCrossers();

    public String[] getInstructions();
}
