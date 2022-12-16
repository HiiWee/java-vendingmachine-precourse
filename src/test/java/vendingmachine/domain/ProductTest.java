package vendingmachine.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import vendingmachine.message.ErrorMessage;

class ProductTest {
    private static Stream<Arguments> generateValidProduct() {
        return Stream.of(
                Arguments.of(List.of("콜라", "1000", "20")),
                Arguments.of(List.of("사이다", "1000", "20")),
                Arguments.of(List.of("맥주", "4000", "20")),
                Arguments.of(List.of("치킨", "15000", "10"))
        );
    }

    private static Stream<Arguments> generateInvalidProduct() {
        return Stream.of(
                Arguments.of(List.of("콜라", "1001", "20"), ErrorMessage.INVALID_PRODUCT_MEASURE),
                Arguments.of(List.of("사이다", "100-", "20"), ErrorMessage.INVALID_PRICE_NUMERIC),
                Arguments.of(List.of("맥주", "4000", "2-"), ErrorMessage.INVALID_QUANTITY_NUMERIC),
                Arguments.of(List.of("치킨", "90", "10"), ErrorMessage.INVALID_PRODUCT_PRICE)
        );
    }

    @DisplayName("상품 생성 성공 테스트")
    @ParameterizedTest
    @MethodSource("generateValidProduct")
    void makeProduct_success(final List<String> products) {
        // then
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Product(products));
    }

    @DisplayName("상품 생성 실패 예외 테스트")
    @ParameterizedTest
    @MethodSource("generateInvalidProduct")
    void makeProduct_fail(final List<String> products, final String message) {
        // then
        Assertions.assertThatThrownBy(() -> new Product(products))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }
}