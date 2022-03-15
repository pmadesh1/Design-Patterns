package domain;

public class ProduceProductMenu implements ProductMenu {
    @Override
    public void showMenuButtons() {
        System.out.println("Show menu button in ProduceProductMenu");
    }

    @Override
    public void showAddButtons() {
        System.out.println("Show add buttons in ProduceProductMenu");
    }

    @Override
    public void showViewButtons() {
        System.out.println("Show view button in ProduceProductMenu");
    }

    @Override
    public void showComboBoxes() {
        System.out.println("Show combobox in ProduceProductMenu");
    }

    @Override
    public void showLabel() {
        System.out.println("Show label in ProduceProductMenu");
    }

    @Override
    public void showRadioButtons() {
        System.out.println("Show radio button in ProduceProductMenu");
    }
}
