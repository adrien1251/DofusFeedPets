package view;

import javax.swing.*;

public class NumberPetsPanel extends JPanel {
    private JSpinner spinnerNumberPets;
    public NumberPetsPanel(){
        SpinnerNumberModel m_numberSpinnerModel;
        m_numberSpinnerModel = new SpinnerNumberModel(22, 1, 45, 1);
        this.spinnerNumberPets = new JSpinner(m_numberSpinnerModel);

        this.add(new JLabel("Pets number"));
        this.add(spinnerNumberPets);
    }

    public int getNumberPets(){
        return (int)spinnerNumberPets.getValue();
    }

}
