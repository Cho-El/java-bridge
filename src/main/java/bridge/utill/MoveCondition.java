package bridge.utill;

import java.util.HashMap;
import java.util.Map;

public enum MoveCondition {
    UP(1, "U"),
    DOWN(0, "D");

    private final String move;
    private final int value;
    private static final Map<Integer, String> MATCH_VALUE_AND_MOVE = new HashMap<>();

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

    public static void initMap() {
        for (MoveCondition move : MoveCondition.values()) {
            MATCH_VALUE_AND_MOVE.put(move.getValue(),move.getMove());
        }
    }
}
