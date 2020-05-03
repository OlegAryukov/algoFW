package otus.algo.tester;

import java.util.List;

public class StringLength implements ITask {
    @Override
    public String run(List<String> data) {
        return String.valueOf(data.get(0).length());
    }
}
