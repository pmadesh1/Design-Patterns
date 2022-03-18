package domain;

public class Buyer extends Person {
    public Buyer(String name) {
        super(name, 0);
    }

    @Override
    public ProductMenu createProductMenu(int productType) {
        System.out.println("-------Factory Pattern---------");
        if(productType == 0)
            productMenu = new MeatProductMenu() ;
        else
            productMenu = new ProduceProductMenu();
        System.out.println("Initialized" + (productType==0?" Meat Product Menu":" Produce Product Menu") + " product menu for Buyer");

        //display - Instantiated product menu for student with product type - $productType
        return productMenu;
    }


    @Override
    public void showProductMenu() throws Exception {
        System.out.println("-------Bridge Pattern---------");

        productMenu.showMenuButtons();
        productMenu.showViewButtons();
        productMenu.showRadioButtons();
        productMenu.showComboBoxes();
        productMenu.showLabel();
    }
}
