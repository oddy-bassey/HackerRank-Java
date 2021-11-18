package ParkingDilemma.solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static int stepCount = 0;

    public static void main(String[] args){
        System.out.println("\n result : "+carParkingRoof(Arrays.asList(6L, 2L, 12L, 7L), 3));
    }

    public static String carParkingRoof(List<Long> cars, int k){

        int  coverCount;
        long initCarPosition, finalCarPosition = 0, minRoofLength = 0;
        //sort list
        cars = cars.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < cars.size(); i++) {
            initCarPosition = cars.get(i);
            coverCount = 1;

            for(int j = i; j < cars.size(); j++){
                if(i<j) {
                    coverCount += 1;

                    if (coverCount == k) {
                        finalCarPosition = cars.get(j);
                        break;
                    }
                }
            }

            if(coverCount == k){
                System.out.println(String.format("( %d +1) -  %d \n", finalCarPosition, initCarPosition));

                long roofCount = (finalCarPosition+1) - initCarPosition;

                if(minRoofLength == 0){

                    minRoofLength = roofCount;
                }else if (roofCount < minRoofLength){

                    minRoofLength = roofCount;
                }
                System.out.println(String.format("initPos: %d finalPos: %d minRoofLength: %d", initCarPosition, finalCarPosition, roofCount));
            }
        }
        
        return String.valueOf(minRoofLength);
    }

    public static void incrementStep(){
        stepCount += 1;
    }
}
