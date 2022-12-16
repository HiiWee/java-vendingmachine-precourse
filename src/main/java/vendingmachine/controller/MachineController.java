package vendingmachine.controller;

import static vendingmachine.util.InputValidator.parseProducts;
import static vendingmachine.util.InputValidator.validateMachinePrice;

import vendingmachine.domain.Coins;
import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MachineService machineService = new MachineService();

    public void run() {
        try {
            requestInputMachinePrice();
            requestInputProducts();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        }
    }

    private void requestInputProducts() {
        try {
            machineService.putInitialProducts(parseProducts(inputView.inputProducts()));
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestInputProducts();
        }
    }

    private void requestInputMachinePrice() {
        Coins coins = machineService.putInitialMoney(validateMachinePrice(inputView.inputMachinePrice()));
        outputView.printMachineHavingCoins(coins);
    }
}
