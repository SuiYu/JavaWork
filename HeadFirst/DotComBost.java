import java.util.*;

class DotCom
{
    private ArrayList<String> locationCells ;
    private Srting name ; 

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
        Srting result = "miss" ;
        int index = locationCells.indexOf(userInput);
        if (index >0) {
            locationCells.remove(index) ;

            if (locationCells.isEmpty) {
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