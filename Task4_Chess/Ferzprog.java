public class Ferzprog {
    public static void main(String[] args) {
        Addclass obj = new Addclass();
        obj.initSets();
        obj.putFirstQueen();
        obj.findNewPositions();
        obj.findNewPositions();
        obj.findNewPositions();
        obj.findNewPositions();
        obj.findNewPositions();
        obj.findNewPositions();
        obj.findNewPositions();
        System.out.println("Королевы расположатся в следующих позициях: ");
        System.out.println(obj.queensPosition);
    }
    
}
