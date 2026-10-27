// import bibliotek do tworzenia interfejsu graficznego

import javax.swing.*;       // elementy interfejsu graficznego (JFrame, JButton, JLabel, JCombo Box)
import java.awt.*;          // tworzenie interfejsu graficznego i rozmieszczanie jego elementów (FlowLayout)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterInterfacev2 {

    JFrame frame = new JFrame("Licznik");       // okno programu
    JButton button = new JButton("Kliknij!");   // przycisk
    JLabel label = new JLabel("0");             // etykieta
    JButton reset = new JButton("Reset");

    public static void main(String[] args) {
        new CounterInterfacev2().run();
    }

    JComboBox<Counter> counters = new JComboBox<>(new Counter[]{    // lista rozwijalna
            new SimpleCounter(),
            new DoubleCounter(),
            new OverflowCounter(),
    });

    void run() {
        // umieszcza elementy obok siebie
        frame.setLayout(new FlowLayout());          // umieszcza elementy obok siebie
        frame.add(button);
        frame.add(label);
        frame.add(counters);
        frame.add(reset);

        // Obsługa przycisku "Kliknij!"
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Counter counter = (Counter) counters.getSelectedItem();
                counter.increase();

                label.setText(Integer.toString(counter.currentValue()));
                frame.pack();
            }
        });

        // Obsługa przycisku "Reset"
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Counter counter = (Counter) counters.getSelectedItem();
                counter.reset();

                label.setText(Integer.toString(counter.currentValue()));
                frame.pack();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // po zamknięciu okna zakończenie działania aplikacji
        frame.pack();                               // dopasowuje rozmiar okna do jego zawartości
        frame.setVisible(true);                     // okno staje się widoczne
    }
}