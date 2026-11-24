package ticking_observer;

public class OverflowCounter extends AbstractCounter {
    protected void step() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }
}
