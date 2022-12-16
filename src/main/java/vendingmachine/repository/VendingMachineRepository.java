package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.VendingMachine;

public class VendingMachineRepository {
    private static final VendingMachineRepository instance = new VendingMachineRepository();
    private static final List<VendingMachine> store = new ArrayList<>();
    private static final int MACHINE_INDEX = 0;

    private VendingMachineRepository() {
    }


    public static VendingMachine save(final VendingMachine vendingMachine) {
        store.clear();
        store.add(vendingMachine);
        return find();
    }

    public static VendingMachine find() {
        return store.get(MACHINE_INDEX);
    }
}
