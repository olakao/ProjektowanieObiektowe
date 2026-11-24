package ticking_observer_app;

public class OverflowCounter extends AbstractCounter {
    protected void step() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }
}
