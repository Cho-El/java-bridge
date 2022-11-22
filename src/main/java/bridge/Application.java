package bridge;

import org.junit.jupiter.api.Test;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        while(true) {
            try{
                inputView.readBridgeSize();
            } catch(IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
