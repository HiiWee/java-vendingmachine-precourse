package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Coins;

public class CoinsRepository {
    private static final CoinsRepository instance = new CoinsRepository();
    private static final List<Coins> store = new ArrayList<>();
    private static final int COIN_INDEX = 0;

    private CoinsRepository() {
    }

    public static Coins saveCoins(final Coins coins) {
        delete();
        store.add(coins);
        return find();
    }

    public static Coins find() {
        return store.get(COIN_INDEX);
    }

    private static void delete() {
        store.clear();
    }
}
