import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.*;

public class Addclass {
    public String data;
    public Map<String, ArrayList<String>> dbTelBook;
    public String[][] finalArray;
    public String[][] premilArray2;

    public Addclass() {
        this.dbTelBook = new HashMap<String, ArrayList<String>>();

    }

    public void initSets() {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            this.data = myReader.nextLine();
            myReader.close();

          } catch (FileNotFoundException e) {
            
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void removeSymbols() {

        this.data = this.data.replaceAll("\\s", "");
        this.data = this.data.replaceAll("\\{", "");
        this.data = this.data.replaceAll("\\}", "");
    }

    public void splitLine() {
        String[] premilArray1 = this.data.split("\\;");
        int lengthArr = premilArray1.length;
        this.premilArray2 = new String[lengthArr][2]; ;
        for (int i = 0; i < lengthArr; i++) {
            this.premilArray2[i] = premilArray1[i].split("\\:");
        }

    }

    public void createMap() {
        for (int i = 0; i < this.premilArray2.length; i++) {
            this.premilArray2[i][1] = this.premilArray2[i][1].replaceAll("\\s", "");
            this.premilArray2[i][1] = this.premilArray2[i][1].replaceAll("\\[", "");
            this.premilArray2[i][1] = this.premilArray2[i][1].replaceAll("\\]", "");
            
            ArrayList<String> phones = new ArrayList<String> (Arrays.asList(this.premilArray2[i][1].split("\\,")));
            String keys = this.premilArray2[i][0];
            this.dbTelBook.put(keys, phones);
            // System.out.println(this.dbTelBook.get(keys)); 
        }

    }

    public void printMap(String note) {
        System.out.println(note);
        System.out.println(this.dbTelBook);
    }

    public void addPhoneToMap(String keyPet, String phone) {
        String keypet1 = "\"" + keyPet + "\"";
        ArrayList<String> phones = this.dbTelBook.get(keypet1);
        phones.add("\"" + phone + "\"");
     
    }
}
