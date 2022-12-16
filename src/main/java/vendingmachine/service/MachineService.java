package vendingmachine.service;

import vendingmachine.domain.Coins;
import vendingmachine.util.RandomCoinGenerator;

public class MachineService {

    public void putInitialMoney(final int machinePrice) {
        Coins coins = new Coins(RandomCoinGenerator.generateRandomCoins(machinePrice));
    }
}
