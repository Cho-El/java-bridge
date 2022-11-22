package bridge.domain;

public enum Error {
    DEFAULT("[ERROR] "),
    NOT_NUMBER("자연수를 입력하셔야 합니다."),
    NOT_IN_RANGE("3과 20사이의 숫자를 입력하셔야 합니다."),
    NOT_UPPER_CASE_ALPHABET("알파벳 대문자를 입력하셔야 합니다.");
    private final String message;
    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return DEFAULT.message + message;
    }
}
