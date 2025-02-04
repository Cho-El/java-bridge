package bridge.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MoveStatus {
    SUCCESS("O", true),
    FAIL("X", false),
    NONE(" ", null);

    private static final Map<Boolean, String> SUCCESS_MARK_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(MoveStatus::getSuccess, MoveStatus::getMark));
    private final String mark;
    private final Boolean isSuccess;

    MoveStatus(String mark, Boolean success) {
        this.mark = mark;
        this.isSuccess = success;
    }

    public static String findMarkByValue(Boolean isSuccess) {
        return SUCCESS_MARK_MAP.get(isSuccess);
    }

    private Boolean getSuccess() {
        return isSuccess;
    }

    private String getMark() {
        return mark;
    }
}
