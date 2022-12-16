package vendingmachine.message;

public class ErrorMessage {
    public static final String INVALID_NUMERIC = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String INVALID_MACHINE_PRICE = "[ERROR] 자판기 금액은 10원 단위로 입력해야 합니다.";
    public static final String INVALID_COIN = "[ERROR] 변환할 수 있는 동전이 없습니다.";
    public static final String INVALID_PRICE_NUMERIC = "[ERROR] 상품 가격은 숫자만 입력해야 합니다.";
    public static final String INVALID_PRODUCT_MEASURE = "[ERROR] 상품 가격은 10원 단위로 나누어 떨어져야 합니다.";
    public static final String INVALID_PRODUCT_PRICE = "[ERROR] 상품 가격은 100원 이상이어야 합니다.";
    public static final String INVALID_QUANTITY_NUMERIC = "[ERROR] 상품 수량은 숫자마 입력해야 합니다.";
    public static final String INVALID_USER_MONEY = "[ERROR] 100이상의 금액을 투입해야 합니다.";

    private ErrorMessage() {
    }
}
