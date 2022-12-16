package vendingmachine.domain;

public class VendingMachine {
    private final Coins leftCoins;
    private final Products sellProducts;

    public VendingMachine(final Coins leftCoins, final Products sellProducts) {
        this.leftCoins = leftCoins;
        this.sellProducts = sellProducts;
    }
}
