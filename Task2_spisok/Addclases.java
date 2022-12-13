import java.util.*;

public class Addclases {
    public String[] workers;
    public Map<Integer, String> dbWorkers;
    public ArrayList<Map<String, Integer>> dbAnalysed2;
    public Addclases() {
        this.workers = new String[] {"Иван", "Петр", "Антон", "Маша", "Антон", "Антон", "Петр", "Витя", "Маша"};
        this.dbWorkers = new HashMap<Integer, String>();
        this.dbAnalysed2 = new ArrayList<>();
    }
    public void initSets() {
        for (Integer i = 0; i < this.workers.length; i++) {
            this.dbWorkers.put(i, this.workers[i]); 
        }

    }
public void namesDB() {
    
    HashSet<String> mamesWorkers2 = new HashSet<String>(this.dbWorkers.values());
    for (String i: mamesWorkers2) {
        Integer counter = 0;
        for (Integer j = 0; j < this.dbWorkers.size(); j++) {
            if (i == this.dbWorkers.get(j)) counter += 1;
        }
        Map<String, Integer> dbAnalysedPAir = new HashMap<String, Integer>();

        dbAnalysedPAir.put(i, counter);
        this.dbAnalysed2.add(dbAnalysedPAir);
    }
   

}

    public void sortMap() {
     
        for (int i = 0; i < this.dbAnalysed2.size(); i++) {
            boolean isNotChanged = true;
            for (int j = 0; j < this.dbAnalysed2.size() - 1 - i; j++) {
                Integer val1 = this.findVAlue(this.dbAnalysed2.get(j));
                Integer val2 = this.findVAlue(this.dbAnalysed2.get(j+1));
                if (val1 < val2) {
                    Map<String, Integer> min = this.dbAnalysed2.get(j);
                    this.dbAnalysed2.set(j, this.dbAnalysed2.get(j+1));
                    this.dbAnalysed2.set(j+1, min);
                    isNotChanged = false;
                
                }
                
            }
            if (isNotChanged) {break;}
        }

    }

    public Integer findVAlue(Map<String, Integer> map) {
        Integer value = 0;
        for (String i: map.keySet()) {
            value = map.get(i);
        }
        return value;
    }


    public void printMap(String note) {
        System.out.println(note);
        System.out.println(this.dbAnalysed2);
    }
}
