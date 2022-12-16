package vendingmachine.message;

public class ErrorMessage {
    public static final String INVALID_NUMERIC = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String INVALID_MACHINE_PRICE = "[ERROR] 자판기 금액은 10원 단위로 입력해야 합니다.";


    private ErrorMessage() {
    }
}
