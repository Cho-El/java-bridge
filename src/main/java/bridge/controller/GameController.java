package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Restart;
import bridge.domain.TargetBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private final OutputView outputView;
    private boolean isPlaying;
    private int tryCount;

    public GameController() {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView = new OutputView();
        initGame();
    }

    public void play() {
        while (isPlaying) {
            move();
            printMoveResult();
            checkGameEnd();
        }
        printFinalResult();
    }

    private void printFinalResult() {
        outputView.printResult(bridgeGame.getCurrentMap(), tryCount, bridgeGame.isGamePass());
    }

    private void initGame() {
        printGameStart();
        bridgeGame = new BridgeGame(generateTargetBridge());
        isPlaying = true;
        tryCount = 1;
    }

    private void printGameStart() {
        outputView.printStart();
    }

    private void move() {
        while (true) {
            try {
                bridgeGame.move(inputView.readMoving());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private TargetBridge generateTargetBridge() {
        while (true) {
            try {
                return new TargetBridge(bridgeMaker.makeBridge(inputSize()));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void printMoveResult() {
        outputView.printMap(bridgeGame.getCurrentMap());
    }

    private int inputSize() {
        return inputView.readBridgeSize();

    }

    private void checkGameEnd() {
        if (bridgeGame.isGameOver()) {
            requestGameRestart();
            return;
        }
        if (bridgeGame.isGamePass()) {
            isPlaying = false;
        }
    }

    private void requestGameRestart() {
        String restartCommand;
        while (true) {
            try {
                restartCommand = inputView.readGameCommand();
                checkGameRestart(restartCommand);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void checkGameRestart(String command) {
        isPlaying = Restart.isRestart(command);
        if (isPlaying) {
            bridgeGame.retry();
        }
    }
}
