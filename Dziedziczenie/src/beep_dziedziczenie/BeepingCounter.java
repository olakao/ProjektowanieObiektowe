package beep_dziedziczenie;

public class BeepingCounter extends SimpleCounter{
    public void increase() {
        super.increase();
        java.awt.Toolkit.getDefaultToolkit().beep();
    }
}
