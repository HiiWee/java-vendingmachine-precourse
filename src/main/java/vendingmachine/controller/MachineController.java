package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.util.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MachineService machineService = new MachineService();

    public void run() {
        try {
            requestInputMachinePrice();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        }
    }

    private void requestInputMachinePrice() {
        machineService.putInitialMoney(InputValidator.validateMachinePrice(inputView.inputMachinePrice()));

    }
}
