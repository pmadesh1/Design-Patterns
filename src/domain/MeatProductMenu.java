package domain;

import ptbs.DataManager;

import java.util.List;
import java.util.Map;

public class MeatProductMenu implements ProductMenu {
    @Override
    public void showMenuButtons() throws Exception {
//        System.out.println("Show menu button in MeatProductMenu");
        DataManager dm = new DataManager();
        Map<String, List<String>> map = dm.getDataMap("ProductInfo.txt");
        System.out.println("Meat Product Menu: " +map.get("Meat"));

    }

    @Override
    public void showAddButtons() {
        System.out.println("Show add buttons in MeatProductMenu");
    }

    @Override
    public void showViewButtons() {
        System.out.println("Show view button in MeatProductMenu");
    }

    @Override
    public void showComboBoxes() {
        System.out.println("Show combobox in MeatProductMenu");
    }

    @Override
    public void showLabel() {
        System.out.println("Show label in MeatProductMenu");
    }

    @Override
    public void showRadioButtons() {
        System.out.println("Show radio button in MeatProductMenu");
    }
}
