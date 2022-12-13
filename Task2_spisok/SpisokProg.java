public class SpisokProg {
    public static void main(String[] args) {
        Addclases obj = new Addclases();
        obj.initSets();
        obj.namesDB();
        obj.printMap("Несортированный Map");
        obj.sortMap();
        obj.printMap("Сортированный Map");
    }
    
}
