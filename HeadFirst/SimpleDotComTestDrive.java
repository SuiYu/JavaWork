import java.io.*;
import java.util.*;
/*
public class SimpleDotComTestDrive
{
    public static void main(String[] args) {
        
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocationCells(locations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
    }
}*/

class SimpleDotCom
{
    int [] locationCells ; 
    int numOfHits = 0 ;

    public void setLocationCells(int a[])
    {
        locationCells = a;
    }

    public String checkYourself(String stringGuess)
    {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for (int cell : locationCells ) {
            if (guess == cell) {
                result = "hit";
                numOfHits ++;
                break;
            }
        } 
        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}

class GameHelper
{
    public String getUserInput(String prompt)
    {
        String inputLine = null;
        System.out.println(prompt+"    ");
        try
        {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;  
        } 
             catch (IOException e)
              {
                System.out.println("IOException :" + e);
             }
        return inputLine;
    }
}

class SimpleDotComTestDrive
{
    public static void main(String[] args)
     {
        
    int numOfGuess =0;
    GameHelper helper = new GameHelper();

    SimpleDotCom theDotCom = new SimpleDotCom();
    int randomNum = (int) (Math.random() * 5);

    int[] locations = {randomNum , randomNum + 1, randomNum+2};
    theDotCom.setLocationCells(locations);
    boolean isAlive = true;

    while(isAlive == true)
    {
        String guess = helper.getUserInput("enter a num");
        String result = theDotCom.checkYourself(guess);
        numOfGuess++;
        if (result.equals("kill")) 
        {
            isAlive = false;
            System.out.println("You took "+numOfGuess+"guesses");   
        }
    }
    }
}


