package vendingmachine.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.repository.CoinsRepository;
import vendingmachine.repository.ProductsRepository;
import vendingmachine.repository.VendingMachineRepository;
import vendingmachine.util.RandomCoinGenerator;

public class MachineService {
    private static void saveProducts(final List<String> parseProducts) {
        ProductsRepository.saveProducts(new Products(parseProducts.stream()
                .map(product -> new Product(Arrays.stream(product.split(","))
                        .collect(Collectors.toList())))
                .collect(Collectors.toList())));
    }

    public Coins putInitialMoney(final int machinePrice) {
        return CoinsRepository.saveCoins(new Coins(RandomCoinGenerator.generateRandomCoins(machinePrice)));
    }

    public void putInitialProducts(final List<String> parseProducts) {
        saveProducts(parseProducts);
        initializeVendingMachine();
    }

    private void initializeVendingMachine() {
        VendingMachineRepository.save(new VendingMachine(CoinsRepository.find(), ProductsRepository.find()));
    }

    public void putMoneyInMachine(final int inputMoney) {
        VendingMachineRepository.find()
                .putMoney(inputMoney);

    }

    public int findCurrentInputMoney() {
        return VendingMachineRepository.find()
                .getCurrentMoney();
    }

    public void startBuyingProcess() {
        VendingMachineRepository.find()
                .validateMachineStatus();
    }


    public Coins findReturnCoins() {
        return null;
    }
}
