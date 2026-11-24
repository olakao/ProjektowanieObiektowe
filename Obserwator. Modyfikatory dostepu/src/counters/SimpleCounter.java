package counters;

public class SimpleCounter extends AbstractCounter {
    @Override
    protected void step() {
        ++counter;
    }
}
