package counters;

public class DoubleCounter extends AbstractCounter {
    @Override
    protected void step() {
        counter += 2;
    }
}
