package dziedziczenie_po_simplecounter;

public class OverflowCounter extends SimpleCounter {
    @Override
    public void increase() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }
}
