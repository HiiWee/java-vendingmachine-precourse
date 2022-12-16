package vendingmachine.message;

public class ErrorMessage {
    public static final String INVALID_NUMERIC = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String INVALID_MACHINE_PRICE = "[ERROR] 자판기 금액은 10원 단위로 입력해야 합니다.";
    public static final String INVALID_COIN = "[ERROR] 변환할 수 있는 동전이 없습니다.";


    private ErrorMessage() {
    }
}
