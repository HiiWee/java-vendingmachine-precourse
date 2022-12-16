package vendingmachine.controller;

import vendingmachine.util.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            InputValidator.validateMachinePrice(inputView.inputMachinePrice());
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        }
    }
}
