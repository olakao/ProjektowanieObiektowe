package ticking_observer_app;

public class SimpleCounter extends AbstractCounter {
    @Override
    protected void step() {
        ++counter;
    }
}
