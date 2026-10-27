package beep_kompozycja_delegacja;

public class OverflowCounter extends AbstractCounter {
    public void increase() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }
}
