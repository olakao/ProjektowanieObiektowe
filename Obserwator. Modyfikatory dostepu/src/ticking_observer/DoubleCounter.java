package ticking_observer;

public class DoubleCounter extends AbstractCounter {
    @Override
    protected void step() {
        counter += 2;
    }
}
