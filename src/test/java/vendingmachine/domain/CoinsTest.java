package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.domain.enums.Coin.COIN_10;
import static vendingmachine.domain.enums.Coin.COIN_100;
import static vendingmachine.domain.enums.Coin.COIN_50;
import static vendingmachine.domain.enums.Coin.COIN_500;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}