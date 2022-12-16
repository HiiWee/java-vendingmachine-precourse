package vendingmachine.service;

import vendingmachine.util.RandomCoinGenerator;

public class MachineService {

    public void putInitialMoney(final int machinePrice) {
        RandomCoinGenerator.generateRandomCoins(machinePrice);
    }
}
