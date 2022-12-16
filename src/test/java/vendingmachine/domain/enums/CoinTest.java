package vendingmachine.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.domain.enums.Coin.COIN_10;
import static vendingmachine.domain.enums.Coin.COIN_100;
import static vendingmachine.domain.enums.Coin.COIN_50;
import static vendingmachine.domain.enums.Coin.COIN_500;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {

    @DisplayName("Enum 리스트를 총 합으로 반환하는 테스트")
    @Test
    void convertCoinToSumAmount_success() {
        // given
        List<Coin> coins = List.of(COIN_500, COIN_100, COIN_50, COIN_10);

        // when
        int sumAmount = Coin.convertCoinToSumAmount(coins);

        // then
        assertThat(sumAmount).isEqualTo(660);
    }
}