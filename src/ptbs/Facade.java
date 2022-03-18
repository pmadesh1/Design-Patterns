package ptbs;

import domain.Trading;
import domain.Product;
import domain.NodeVisitor;
import domain.Person;
import domain.Buyer;
import domain.VisitableItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;


public class Facade implements VisitableItem {

    private Integer userType = null;
    private Product selectedProduct = null;
    private Integer theSelectedProduct = null;
    private ProductList productList = new ProductList();
    private Person currentUser = null;
    private DataManager dataManager = null;

    Scanner sc= new Scanner(System.in); //System.in is a standard input stream
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Facade() {
        dataManager = new DataManager();
        createProductList();
    }


    ProductList getProducts() {
        return productList;
    }
    static public boolean login(UserData userData)
    {
        Login login = new Login(userData);
        login.setVisible(true);
        System.out.println("-------Facade Pattern-------");
        return login.loginStatus;
    }

     public void CreateUser(UserData userData) throws Exception {

        System.out.println("-------Facade Pattern-------");
        System.out.println("Handling createUser and attach product to user using the Facade pattern");

        try{
            {
                currentUser = createUser(userData.userName);
                attachProductToUser(currentUser);
                //  productOperation();
                this.selectedProduct = selectProduct();
                this.theSelectedProduct = selectProductLevel();
                this.displayMenu(userData);
            }
            {
                //System.out.println("Incorrect userName or password");
                //System.exit(1);
            }
        } catch(Exception ex) {
            System.out.println("Incorrect User Name or Password");
            System.exit(1);
        }

    }
    void addProductItem( UserData userdata, String productName){
        System.out.println("********* Adding new product item *********");
        dataManager.addItemtoFile(userdata, productName);
    }


    void displayMenu(UserData userData) throws Exception {
        System.out.println("********* Choose an operation *********");
        System.out.println("1. Create product menu");
        System.out.println("2. Show product menu");
        System.out.println("3. Remind");
        System.out.println("4. Done");
        System.out.println("5. Add an item");

        try {
            int selectionIndex = Integer.parseInt(br.readLine());
            switch(selectionIndex) {
                case 1: {
                    productOperation();
                    displayMenu(userData);
                    break;
                }
                case 2: {
                    showProductMenuCreated();
                    break;
                }
                case 3: {
                    remind(); break;
                }
                case 5: {
                    System.out.println(" Enter item to be added ");
                    String product = sc.nextLine();
                    addProductItem(userData, product);
                    displayMenu(userData);
                    break;
                }
                default : {
                    System.out.println("Exiting...");
                    System.exit(1);
                    break;
                }
            }
            if(selectionIndex!=5) {
                displayMenu(userData);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    int selectProductLevel() {

        System.out.println("Enter Product type:");
        System.out.println("0 : MeatProductMenu");
        System.out.println("1 : ProduceProductMenu");

        try {
            int selectionIndex = Integer.parseInt(br.readLine());
            return selectionIndex;
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return 0;
    }

    private Person createUser(String name) throws Exception {
        return dataManager.initializePerson(name);
    }

    private void createProductList() {
        //Create product list for the whole system
        try {
            productList = new ProductList(dataManager.initializeAllProducts());
            for (Object product : productList) {
                ((Product) product).addTrading(new Trading(new Date()));
            }
        } catch(Exception ex) {
            ArrayList<Product> productList = new ArrayList<Product>();
            this.productList.addAll(productList);
        }

    }

    void attachProductToUser(Person person) throws Exception {
        //print attaching products to user
        //Read UserProduct.txt and add all products mapped to user object by calling User.addProduct(product)
        //Attach the product passed to user selected
        person.addProduct(dataManager.fetchProductMappingForUser(person.name));
    }

    Product selectProduct() {
        // show list of products and return selected products
        //display currentUser.addProduct - using iterator
        System.out.println("------Iterator pattern-------");
        System.out.println("Iterating the products for the user using iterator pattern");

        ProductIterator iterator = (ProductIterator) currentUser.getAddedProducts().iterator();
        int selectionIndex = 0;
        while(iterator.hasNext()) {
            System.out.println(selectionIndex + ": " + iterator.next().id);
            selectionIndex++;
        }

        System.out.println("Enter product selection:");
        try {
            selectionIndex = Integer.parseInt(br.readLine());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        Product selectedProduct = (Product) currentUser.getAddedProducts().get(selectionIndex);
        return selectedProduct;
    }

    void productOperation() {
        if(currentUser!=null) {
            currentUser.createProductMenu(theSelectedProduct);
            //Create product menu for currentUser
            //Show menu for selecting theSelectedProduct
        }
    }

    void showProductMenuCreated() throws Exception {
        currentUser.showProductMenu();
    }

    void remind() {
        accept(new RemainderVisitor());
    }

    @Override
    public void accept(NodeVisitor visitor) {
        //print accept in facade
        System.out.println("-------Visitor pattern-------");
        visitor.visit(this);
    }

    void addTrading(Product product, Trading trading) {
    }

    void gradeOffering(Offering offering) {
    }

    void submitOffering(Offering offering) {
    }

    void reportOffering(Offering offering) {
    }
}


class Offering{ }