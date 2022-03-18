package ptbs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.IOException;

import domain.Product;
import domain.Seller;
import domain.Person;
import domain.Buyer;

public class DataManager {

    public final String FILE_PATH = "C:\\Users\\pravandu\\Documents\\Design-Patterns\\src\\ptbs\\";

    public List<Product> initializeAllProducts() throws Exception
    {
        /*Initialize base on Person TYPE */
        return getDataMap("ProductInfo.txt").keySet().stream().map(Product::new).collect(Collectors.toList());
    }

    public String fetchPassword(String userName, String fileName) throws Exception
    {
        System.out.println("userName - fetch " + userName);
        List<String> str =  getDataMap(fileName).get(userName) ;
        System.out.println("userName " + str.get(0));
        return str.get(0);
    }

    public Person initializePerson(String userName) throws Exception
    {
        /*Initialize base on Person TYPE */
        if(!getDataMap("SellerInfo.txt").containsKey(userName))
        {
            return new Buyer(userName);
        }
        return new Seller(userName);
    }
    public List<Product> fetchProductMappingForUser(String name) throws Exception
    {
        /*Fetch product file base on username*/
        Map<String, List<String>> productMapping =  getDataMap("UserProduct.txt");
        List<String> productList = productMapping.get(name);
        return productList.stream().map(strProduct -> new Product(strProduct)).collect(Collectors.toList());
    }
    public void addItemtoFile(UserData userdata, String productName){

        String fileName = "UserProduct.txt";
        String fileN = FILE_PATH+fileName;
        try {
            String data = userdata.userName+":"+productName;
            System.out.println("----- "+ data );
            System.out.println("file path "+ FILE_PATH+fileName);
            FileWriter fileWritter = new FileWriter(fileN,true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.newLine();
            bw.write(data);
            bw.close();
            System.out.println("Done");
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public Map<String, List<String>> getDataMap(String fileName) throws Exception
    {
        File file = new File(FILE_PATH+fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        HashMap<String, List<String>> dataMapping = new HashMap<>();
        while((str = br.readLine()) != null)
        {
            String[] token = str.split(":");
            List<String> valueList = new ArrayList<>() ;
            if(token.length==2) {
                if(dataMapping.containsKey(token[0])) {
                    valueList = dataMapping.get(token[0]);
                    valueList.add(token[1]);
                }
                else  valueList.add(token[1]);
            }

            dataMapping.put(token[0], valueList);
        }
        return dataMapping;
    }

}
