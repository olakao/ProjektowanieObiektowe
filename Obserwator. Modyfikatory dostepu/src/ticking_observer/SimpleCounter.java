package ticking_observer;

public class SimpleCounter extends AbstractCounter {
    @Override
    protected void step() {
        ++counter;
    }
}
