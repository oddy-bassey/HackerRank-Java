package CompetitiveGaming.solution;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

        System.out.println("Number of qualified players: "+numPlayers(3, Arrays.asList(20, 100, 60, 90, 45, 45, 45, 90, 78, 80, 100)));
    }

    public static int numPlayers(int k, List<Integer> scores){
        List<Integer> ranks = new ArrayList<>();

        scores = scores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int rank = 0, scoreFrequency = 0, currentScore = 0, qualifiedPlayers = 0;

        for (Integer score : scores) {

            // if score tie's
            if(score == currentScore) {

                //set frequency of current score
                scoreFrequency+=1;
            }else{ //if score doesn't tie

                currentScore = score;
                rank = getRank(rank, scoreFrequency);

                //reset frequency of current score
                scoreFrequency = 1;
            }

            ranks.add(rank);

            if(rank <= k){
                qualifiedPlayers += 1;
            }

            System.out.println(String.format("Score: %d Rank: %d", score, rank));
        }

        return qualifiedPlayers;
    }

    //derive gamers rank
    public static int getRank(int rank, int frequency){
        if(rank == 0){
            rank = 1;
        }else{
            rank = (frequency>1)? rank + frequency : rank + 1;
        }

        return rank;
    }
}
