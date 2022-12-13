public class Ferzprog {
    public static void main(String[] args) {
        
        for (int i=0; i < 1000; i++) {
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
            if (!(obj.queensPosition.get(7).contains("a1"))) {
                System.out.println(i);
                System.out.println("Королевы расположатся в следующих позициях: ");
                System.out.println(obj.queensPosition);
                break;
            }
        }
        
    }
    
}
