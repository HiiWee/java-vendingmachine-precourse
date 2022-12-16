package vendingmachine.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vendingmachine.domain.enums.Coin;
import vendingmachine.message.ErrorMessage;

class RandomCoinGeneratorTest {

    @DisplayName("투입 금액에 대한 랜덤 동전 정상 생성 테스트")
    @ParameterizedTest
    @CsvSource({"5000", "1230", "2310", "2350", "1200", "1500"})
    void generateRandomCoin_success(int expectedAmount) {
        // when
        List<Coin> coins = RandomCoinGenerator.generateRandomCoins(expectedAmount);
        int actualAmount = Coin.convertCoinToSumAmount(coins);

        // then
        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("투입 금액에 대한 랜덤 동전 예외 테스트")
    @ParameterizedTest
    @CsvSource({"5001", "1234", "2316", "2359", "1208", "1503"})
    void generateRandomCoin_fail(int expectedAmount) {
        // then
        assertThatThrownBy(() -> RandomCoinGenerator.generateRandomCoins(expectedAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MACHINE_PRICE);
    }
}