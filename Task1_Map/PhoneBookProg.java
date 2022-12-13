public class PhoneBookProg {
    public static void main(String[] args) {
        Addclass obj = new Addclass();
        obj.initSets();
        obj.removeSymbols();
        obj.splitLine();
        obj.createMap();
        obj.printMap("Первоначальный Map");
        obj.addPhoneToMap("Petrov", "987464");
        obj.printMap("Map после добавления");
    }
}