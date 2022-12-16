package vendingmachine.controller;

import static vendingmachine.util.InputValidator.parseProducts;
import static vendingmachine.util.InputValidator.validateInputPrice;
import static vendingmachine.util.InputValidator.validateMachinePrice;

import vendingmachine.domain.Coins;
import vendingmachine.exception.NoPossibleProductToBuyException;
import vendingmachine.exception.NoQuantityException;
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
            requestInputBuyingPrice();
            requestInputBuyingProduct();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        }
    }

    private void requestInputMachinePrice() {
        Coins coins = machineService.putInitialMoney(validateMachinePrice(inputView.inputMachinePrice()));
        outputView.printMachineHavingCoins(coins);
    }

    private void requestInputProducts() {
        try {
            machineService.putInitialProducts(parseProducts(inputView.inputProducts()));
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestInputProducts();
        }
    }

    private void requestInputBuyingPrice() {
        try {
            machineService.putMoneyInMachine(validateInputPrice(inputView.inputBuyingPrice()));
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestInputBuyingPrice();
        }
    }

    private void requestInputBuyingProduct() {
        try {
            machineService.startBuyingProcess();
            responseCurrentInputMoney();
            requestInputProduct();
        } catch (NoQuantityException | NoPossibleProductToBuyException exception) {
            responseLeftMoney();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestInputBuyingProduct();
        }
    }

    private void responseCurrentInputMoney() {
        outputView.printCurrentInputMoney(machineService.findCurrentInputMoney());
    }

    private void requestInputProduct() {
        machineService.buyProduct(inputView.inputProduct());
        requestInputBuyingProduct();

    }

    private void responseLeftMoney() {
        outputView.printReturnMoney(machineService.findCurrentInputMoney(), machineService.findReturnCoins());

    }
}
