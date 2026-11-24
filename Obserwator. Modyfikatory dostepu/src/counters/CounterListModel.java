package counters;

import javax.swing.DefaultComboBoxModel;

public class CounterListModel extends DefaultComboBoxModel<Counter> implements CounterListener {

    public CounterListModel(Counter[] counters) {
        super(counters);

        for (Counter counter : counters) {
            counter.addListener(this);
        }
    }

    @Override
    public void counterChanged(Counter source) {
        int index = getIndexOf(source);

        if (index >= 0) {
            fireContentsChanged(this, index, index);
        }
    }
}
