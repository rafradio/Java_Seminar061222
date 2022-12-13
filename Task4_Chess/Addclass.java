import java.util.*;

public class Addclass {
    public Map<String, String> chessBoard;
    public String[][] chessBoardForMoving;
    public ArrayList<String> queensPosition;
    public Addclass() {
        this.chessBoard = new HashMap<String, String>();
        this.chessBoardForMoving = new String[8][8];
        this.queensPosition = new ArrayList<>();

    }

    public void initSets() {
        String[] horizont = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < horizont.length; i++) {
            for (int j = 1; j < 9; j++) {
                String key = horizont[i] + j;
                this.chessBoard.put(key, "Empty");
                this.chessBoardForMoving[i][j-1] = key;
            }
        }
  
    }

    public void putFirstQueen() {
        Random random = new Random();
        Integer i = random.nextInt(8);  
        Integer j = random.nextInt(8);
        
        this.chessBoard.put(this.chessBoardForMoving[i][j], "Queen");
        this.queensPosition.add(this.chessBoardForMoving[i][j]);
    }

    public void findNewPositions() {
        int initHorizont = 7;
        int initVert = 7;
        Boolean possibleTOPut = false;
        String queenPos = "";
        while (initHorizont >= 0) {

            while (initVert >= 0) {
                
                queenPos = this.chessBoardForMoving[initHorizont][initVert];
                
                if (this.chessBoard.get(queenPos) != "Queen") {
                
                    possibleTOPut = this.checkHorizont(queenPos, initVert);
                    if (possibleTOPut) possibleTOPut = this.checkVertical(queenPos, initHorizont);
                    if (possibleTOPut) possibleTOPut = this.checkDiagonals(initHorizont, initVert);
                    
                    
                } else {
                    possibleTOPut = false;
                   
                }
                if (possibleTOPut) break;
                initVert -= 1;
            }
            if (possibleTOPut) break;
            initVert = 7;
            initHorizont -= 1;
        }
        System.out.println("Новая позиция!" + queenPos);
        this.chessBoard.put(queenPos, "Queen");
        this.queensPosition.add(queenPos);
       
    }

    public Boolean checkHorizont(String pos, Integer vert) {
        Boolean checkFlag = true;
        for (int i = 0; i < 8; i++) {
            String checkPos = this.chessBoardForMoving[i][vert];
            if (this.chessBoard.get(checkPos) == "Queen") checkFlag = false;
            
        }
        return checkFlag;
    }

    public Boolean checkVertical(String pos, Integer horisont) {
        Boolean checkFlag = true;
        for (int i = 0; i < 8; i++) {
            String checkPos = this.chessBoardForMoving[horisont][i];
            if (this.chessBoard.get(checkPos) == "Queen") checkFlag = false;
            
        }
        return checkFlag;
    }

    public Boolean checkDiagonals(Integer vert, Integer horisont) {
        Boolean checkFlag = true;
        
        for (int i = 0; i < 8; i++) {
            try {
                String checkPos = this.chessBoardForMoving[vert+i][horisont+i];
                if (this.chessBoard.get(checkPos) == "Queen") {
                    checkFlag = false;
                    break;
                }
                
            } catch (IndexOutOfBoundsException e) {}
           
            try {
                String checkPos = this.chessBoardForMoving[vert-i][horisont-i];
                if (this.chessBoard.get(checkPos) == "Queen") {
                    checkFlag = false;
                    break;
                }
                
            } catch (IndexOutOfBoundsException e) {}

            try {
                String checkPos = this.chessBoardForMoving[vert-i][horisont+i];
                if (this.chessBoard.get(checkPos) == "Queen") {
                    checkFlag = false;
                    break;
                }
                
            } catch (IndexOutOfBoundsException e) {}

            try {
                String checkPos = this.chessBoardForMoving[vert+i][horisont-i];
                if (this.chessBoard.get(checkPos) == "Queen") {
                    checkFlag = false;
                    break;
                }
                
            } catch (IndexOutOfBoundsException e) {}

        }
        return checkFlag;
    }
}
