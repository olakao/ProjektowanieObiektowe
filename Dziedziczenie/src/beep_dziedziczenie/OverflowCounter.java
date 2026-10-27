package beep_dziedziczenie;

public class OverflowCounter extends SimpleCounter {
    public void increase() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }
}
