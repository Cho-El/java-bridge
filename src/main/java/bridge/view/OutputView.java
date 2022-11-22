package bridge.view;

import bridge.utill.MapConverter;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> crossedBridge) {
        crossedBridge.forEach(this::printEachMap);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> crossedBridge, int tryCount, boolean isSuccess) {
        System.out.println(OutputMessage.END.getMessage());
        printMap(crossedBridge);
        printFinalGameResult(tryCount, isSuccess);
    }

    public void printStart() {
        System.out.println(InputMessage.START.getMessage() + "\n");
    }

    private void printFinalGameResult(int tryCount, boolean isSuccess) {
        System.out.println(OutputMessage.RESULT.getMessage(isSuccess));
        System.out.printf(OutputMessage.TRY.getMessage(tryCount));
    }

    private void printEachMap(List<String> crossedBridge) {
        System.out.println(MapConverter.convertToMap(crossedBridge));

    }
}
