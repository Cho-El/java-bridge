package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MySelect {
    private final List<String> mySelect;

    public MySelect() {
        this.mySelect = new ArrayList<>();
    }

    public void updateMySelect(boolean success) {
        mySelect.add(MoveStatus.findMarkByValue(success));
    }

    public List<String> getMySelect() {
        return mySelect;
    }

    public void initialize() {
        this.mySelect.clear();
    }
}
