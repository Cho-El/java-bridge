package bridge.view;

public enum OutputMessage {
    RESULT("게임 성공 여부: %s"),
    TRY("총 시도한 횟수: %d"),
    END("최종 게임 결과"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getMessage() {
        return this.value;
    }

    public String getMessage(boolean isSuccess) {
        if (isSuccess) {
            return String.format(value, SUCCESS.value);
        }
        return String.format(value, FAIL.value);
    }

    public String getMessage(int tryCount) {
        return String.format(value, tryCount);
    }
}
