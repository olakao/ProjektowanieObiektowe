// import bibliotek do tworzenia interfejsu graficznego
import javax.swing.*;       // elementy interfejsu graficznego (JFrame, JButton, JLabel)
import java.awt.*;          // tworzenie interfejsu graficznego i rozmieszczanie jego elementów (FlowLayout)
import java.awt.event.*;    // obsługa zdarzeń (Action Listener)

public class CounterApp implements ActionListener {

    JFrame frame = new JFrame("Licznik");       // okno programu
    JButton button = new JButton("Kliknij!");   // przycisk
    JLabel label = new JLabel("0");             // etykieta

    public static void main(String[] args) {
        new CounterApp().run();
    }

    void run() {
        // umieszcza elementy obok siebie
        frame.setLayout(new FlowLayout());          // umieszcza elementy obok siebie
        frame.add(button);
        frame.add(label);
        button.addActionListener(this);           // reakcja na kliknięcie

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // po zamknięciu okna zakończenie działania aplikacji
        frame.pack();                               // dopasowuje rozmiar okna do jego zawartości
        frame.setVisible(true);                     // okno staje się widoczne
    }

    int count = 0;                                  // zmienna licząca kliknięcia

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;                                    // zwiększenie licznika o 1
        label.setText(Integer.toString(count));     // aktualizuje tekst na etykiecie
    }
}
