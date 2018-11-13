package view;

import javax.swing.*;

public class NumberPetsPanel extends JPanel {
    private JSpinner spinnerNumberPets;
    private JTextArea howManyMinute;
    private JTextArea howManyTime;

    public NumberPetsPanel(){
        SpinnerNumberModel m_numberSpinnerModel;
        m_numberSpinnerModel = new SpinnerNumberModel(22, 1, 45, 1);
        this.spinnerNumberPets = new JSpinner(m_numberSpinnerModel);


        howManyMinute = new JTextArea("Hwo");
        howManyTime = new JTextArea("fefe");



        this.add(new JLabel("Pets number"));
        this.add(spinnerNumberPets);
        this.add(new JLabel("Delais lancement"));
        this.add(howManyMinute);
        this.add(new JLabel("Tout les combiens"));
        this.add(howManyTime);
    }

    public int getNumberPets(){
        return (int)spinnerNumberPets.getValue();
    }
    public int getDelaisLancement(){
        return Integer.parseInt(howManyMinute.getText());
    }
    public int getHowManyTime(){
        return Integer.parseInt(howManyTime.getText());
    }

}
