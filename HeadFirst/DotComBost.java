import java.util.*;
import java.io.*;
class DotCom
{
    private ArrayList<String> locationCells ;
    private String name ; 

    public void setLocationCell(ArrayList<String> loc)
    {
        locationCells = loc;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String checkYourself(String userInput)
    {
        String result = "miss" ;
        int index = locationCells.indexOf(userInput);
        if (index >0) {
            locationCells.remove(index) ;

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Oh,you sunk"+name+":(");

            } 
            else{
                result = "hit";
            }
        }
        return result;
    }
//end
}

public class DotComBost
{
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0 ;

    private void SetUpGame()
    {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Your goal is sunk three dot com");
        System.out.println("Pets.com,eToys.com,Go2.com");
        System.out.println("Try to sink them all lalallalal~ ");

        for (DotCom dotComToSet : dotComList )
         {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCell(newLocation);
         }
        //end here
    }
    private void startPlaying()
    {
        while(!dotComList.isEmpty())
        {
            String userGuess = helper.getUserInput("Enter a word");
            checkUserGuess(userGuess);
        }
        finishGame();
        //end here
    }

    private void checkUserGuess(String userGuess)
    {
        numOfGuesses ++;
        String result = "miss";
        for (DotCom dotComToTest : dotComList ) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break ;
            }
            if (result.equals("kill")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    //end here

    private void finishGame()
    {
        System.out.println("All Dot com are dead ! Nice commander!");
        if (numOfGuesses <=18) {
            System.out.println("It's take you" + numOfGuesses +"to finishGame");
            System.out.println("You nice guy!");
        }
        else
        {
            System.out.println("omg,you have to sleep with fish");
        }
        //end
    }

    public static void main(String[] args) {
        DotComBost game = new DotComBost();
        game.setName();
        game.startPlaying();
    }
    //end
}

public class gameHelper
{
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49 ;
    private int [] grid = new int[gridSize];
    private int comCount = 0 ;

    public String getUserInput(String  prompt )
    {
        String inputLine = null;
        System.out.println(prompt+"   ");
        try
        {
            BuffereReader is = new BuffereReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;    
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException :" + e);
        }
        return inputLine.toLowCase();
    }

    public ArrayList<String> placeDotCom(int comSize)
    {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphacoords = new String[comSize];
        String temp = null ;
        int [] coords = new int[comSize];
        int attempts = 0;
        boolean success =false ;
        int location =0 ;

        comCount++ ; 
        int incr = 1 ;
        if ((comCount %2 ) == 1) {
            incr = gridLength;
        }

        while(!success & attempts++ <200 )
        {
            location = (int) (Math.random() * gridSize);
            int x =0;
            success =true ;
            while(success && x <comSize)
            {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr ;
                    if (location >= gridSize) {
                        success = false;    
                    }
                    if (x >0 && (location % gridLength ==0)) 
                    {
                        success = false;
                    }
                    else
                    {
                        success =false ;
                    }
                }
            }
        }

    int x = 0;
    int row =0;
    int column = 0;

    while (x <comSize)
    {
        grid[coords[x]] = 1;
        row = (int)  (coords[x] / gridLength) ;
        column = coords[x];
        temp =String.valueOf(alphabet.charAt(column));

        alphaCells.add(temp.concat(Integer.toString(row)));
        x++;
    }
    return alphaCells;
    }
   // end
}
