package bridge.utill;

import bridge.domain.Error;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum MoveCondition {
    UP(1, "U"),
    DOWN(0, "D");

    private final String move;
    private final int value;
    private static final Map<Integer, String> MATCH_VALUE_AND_MOVE = Arrays.stream(values())
            .collect(Collectors.toMap(MoveCondition::getValue, MoveCondition::getMove));

    MoveCondition(int value, String move) {
        this.value = value;
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public int getValue() {
        return value;
    }

    public static String getMatchMove(int value) {
        return MATCH_VALUE_AND_MOVE.get(value);
    }

    public static void validMove(String inputMove) {
        for (MoveCondition move : MoveCondition.values()) {
            if (move.getMove().equals(inputMove)) {
                return;
            }
        }
        throw new IllegalArgumentException(Error.NOT_IN_RANGE_BRIDGE_ALPHABET.getMessage());
    }
}
