package ticking_observer_app;

public class DoubleCounter extends AbstractCounter {
    @Override
    protected void step() {
        counter += 2;
    }
}
