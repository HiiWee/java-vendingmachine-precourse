package vendingmachine.service;

import vendingmachine.domain.Coins;
import vendingmachine.repository.CoinsRepository;
import vendingmachine.util.RandomCoinGenerator;

public class MachineService {

    public Coins putInitialMoney(final int machinePrice) {
        return CoinsRepository.saveCoins(new Coins(RandomCoinGenerator.generateRandomCoins(machinePrice)));
    }
}
