package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.domain.enums.Coin.COIN_10;
import static vendingmachine.domain.enums.Coin.COIN_100;
import static vendingmachine.domain.enums.Coin.COIN_50;
import static vendingmachine.domain.enums.Coin.COIN_500;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CoinsTest {

    @DisplayName("코인 리스트에서 찾고자 하는 코인의 개수 반환 테스트")
    @Test
    void countOf() {
        // given
        Coins coins = new Coins(List.of(COIN_500, COIN_500, COIN_100, COIN_50, COIN_10));

        // when
        int count = coins.countOf(COIN_500);

        // then
        assertThat(count).isEqualTo(2);
    }

    @DisplayName("잔돈에 대해 코인 반환 테스트")
    @ParameterizedTest
    @CsvSource({"100,1", "200,2", "300,3", "500,4"})
    void createLeftCoins(final int leftMoney, final int returnCoinCounts) {
        // given
        Coins coins = new Coins(List.of(COIN_100, COIN_100, COIN_100, COIN_100));

        // when
        Coins returnCoins = coins.createLeftCoins(leftMoney);

        // then
        assertThat(returnCoins.countOf(COIN_100)).isEqualTo(returnCoinCounts);
    }
}