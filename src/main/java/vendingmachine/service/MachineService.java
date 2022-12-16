package vendingmachine.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Product;
import vendingmachine.repository.CoinsRepository;
import vendingmachine.util.RandomCoinGenerator;

public class MachineService {

    public Coins putInitialMoney(final int machinePrice) {
        return CoinsRepository.saveCoins(new Coins(RandomCoinGenerator.generateRandomCoins(machinePrice)));
    }

    public void putInitialProducts(final List<String> parseProducts) {
        parseProducts.stream()
                .map(product -> new Product(Arrays.stream(product.split(","))
                        .collect(Collectors.toList())));
    }
}
