package vendingmachine.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.enums.Coin;
import vendingmachine.message.ErrorMessage;

class VendingMachineTest {

    @DisplayName("투입 금액 100원 이하시 예외 발생 테스트")
    @Test
    void inputMoney_invalid() {
        // given
        VendingMachine vendingMachine = new VendingMachine(new Coins(List.of(Coin.COIN_500)),
                new Products(List.of(new Product(List.of("a", "200", "20")))));

        // then
        Assertions.assertThatThrownBy(() -> vendingMachine.putMoney(99))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_USER_MONEY);
    }
}
