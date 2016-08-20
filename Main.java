import java.util.List;
import java.util.ArrayList;
public class Main {
    private enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }
    
    /*Size of the pattern*/
    int n = 5;
    int count = 1;
    int boundary;
    Direction direction = Direction.RIGHT;
    List < Integer > bluePrint = new ArrayList < Integer > ();
    int pattern[][] = new int[n][n];
    int x = 0, y = 0;
    
    
    public static void main(String[] args) {

        Main main = new Main();
        main.run();
    }

    public void run() {
        bluePrint.add(n);
        /*Preparing the blueprint to follow for boundaries*/
        for (int i = n - 1; i > 0; i--) {
            bluePrint.add(i);
            bluePrint.add(i);
        }
        
        for (int temp: bluePrint) {
            boundary = temp;
            //System.out.println(boundary + " " + direction);
            for (int i = 0; i < boundary; i++) {
                //System.out.println(x+ " "+ y);
                pattern[x][y] = count++;
                setNextCoordinates(i);
            }
            setNextDirection();
        }
        printPattern();
        /* for(int i=0;i<bluePrint.size();i++){
             System.out.println(bluePrint.get(i));
         }*/
    }
    
    /*Sets next coordinated according to current direction*/
    private void setNextCoordinates(int i) {
        if (direction == Direction.RIGHT) {
            if (i == boundary - 1)
                x++;
            else
                y++;
        } else if (direction == Direction.DOWN) {
            if (i == boundary - 1)
                y--;
            else
                x++;
        } else if (direction == Direction.LEFT) {
            if (i == boundary - 1)
                x--;
            else
                y--;;
        } else if (direction == Direction.UP) {
            if (i == boundary - 1)
                y++;
            else
                x--;
        }
    }
    
    /*Prints final pattern*/
    private void printPattern(){
        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<n;j++){
                System.out.print(pattern[i][j]+" ");
            }
            
        }
    }
    /*Sets next direction when the boundary is reached*/
    private void setNextDirection() {
        if (direction == Direction.RIGHT)
            direction = Direction.DOWN;
        else if (direction == Direction.DOWN)
            direction = Direction.LEFT;
        else if (direction == Direction.LEFT)
            direction = Direction.UP;
        else if (direction == Direction.UP)
            direction = Direction.RIGHT;
    }
}
