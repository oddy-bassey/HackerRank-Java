package ReachTheEndInTime.solution;

import java.util.List;

public class Main {

    private static int stepCount = 0;

    public static void main(String[] args){

    }

    public static String reachTheEnd(List<String> grid, int maxTime){

        int topLeft = 0, nextPosition, nextPositionRow;

        for (int i = 0; i < grid.size(); i++) {

            char[] gridRow = grid.get(i).toCharArray();

            //if starting at top left
            if(i == 0){

                if(gridRow[topLeft+1] == '.'){
                    nextPosition = 1;
                    nextPositionRow = i;

                    incrementStep();

                }else if(grid.get(i+1).toCharArray()[0] == '.'){
                    nextPosition = 1;
                    nextPositionRow = i+1;

                    incrementStep();
                }
            }else{
                // if not top left
                //if()
            }
        }
        
        return "";
    }

    public static void incrementStep(){
        stepCount += 1;
    }
}
