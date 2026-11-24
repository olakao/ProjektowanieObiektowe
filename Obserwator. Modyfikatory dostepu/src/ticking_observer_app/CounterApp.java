package ticking_observer_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp implements ActionListener, CounterListener {

    JFrame frame = new JFrame("Licznik");
    JButton button = new JButton("Kliknij!");
    JLabel label = new JLabel("0");
    JButton reset = new JButton("Reset");

    JComboBox<Counter> counters = new JComboBox<>(new Counter[]{
            new SimpleCounter(),
            new DoubleCounter(),
            new OverflowCounter(),
            new Beeping(new SimpleCounter()),
            new Beeping(new DoubleCounter()),
            new Beeping(new OverflowCounter()),
            new Ticking(new SimpleCounter()),
            new Ticking(new DoubleCounter()),
            new Ticking(new OverflowCounter()),

//            new Ticking(new Beeping(new OverflowCounter())),
//            new Beeping(new Beeping(new DoubleCounter())),
    });

    public static void main(String[] args) {
        new CounterApp().run();
    }

    void run() {
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(label);
        frame.add(counters);
        frame.add(reset);

        button.addActionListener(this);
        reset.addActionListener(this);

        // rejestrowanie aplikacji jako słuchacza każdego licznika
        for (int i = 0; i < counters.getItemCount(); i++) {
            counters.getItemAt(i).addListener(this);
        }

        // aktualizacja etykiety po wybraniu innego licznika
        counters.addActionListener(e -> {
            Counter selected = (Counter) counters.getSelectedItem();
            if (selected != null) {
                label.setText(Integer.toString(selected.currentValue()));
                frame.pack();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // aktualizacja etykiety po zmianie wartości wybranego licznika
    @Override
    public void counterChanged(Counter source) {
        if (source == counters.getSelectedItem()) {
            label.setText(Integer.toString(source.currentValue()));
            frame.pack();
        }
    }

    // obsługa kliknięć przycisków
    @Override
    public void actionPerformed(ActionEvent e) {
        Counter counter = (Counter) counters.getSelectedItem();

        if (e.getSource() == button) {
            counter.increase();
        } else if (e.getSource() == reset) {
            counter.reset();
        }
    }
}
