package vendingmachine.domain;

public class VendingMachine {
    private final Coins coins;
    private final Products sellProducts;

    public VendingMachine(final Coins coins, final Products sellProducts) {
        this.coins = coins;
        this.sellProducts = sellProducts;
    }
}
