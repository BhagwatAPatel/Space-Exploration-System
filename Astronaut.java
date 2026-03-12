/*********************************************************
 * Author: Bhagwat Patel                                 *
 * Date: 10 May 2025                                     *
 * Purpose: Astronaut class for use in PDI Assignment    *
 *                                                       *
 *********************************************************/
public class Astronaut 
{
    //Class fields for Astronaut Object
    private String astronautName;
    private String astronautRole;
    private int astronautAge;
    private String astronautNationality;
    
    //All the accessors for this class:
    public String getAstronautName() 
    {
        return astronautName;
    }
    
    public String getAstronautRole() 
    {
        return astronautRole;
    }
    
    public int getAstronautAge() 
    {
        return astronautAge;
    }

    public String getAstronautNationality() 
    {
        return astronautNationality;
    }

    //All the mutators for this class:

    /*the if-else statements in the setAstronautName and setAstronautRole
    mutator ensures the astronautName and astronautRole is not an empty string */
    public void setAstronautName(String pAstronautName) 
    {
        if((pAstronautName != null) && (pAstronautName != ""))
        {
            astronautName = pAstronautName;
        }
        else 
        {
            System.out.println("Astronaut name field is empty.");
        }
    }

    public void setAstronautRole(String pAstronautRole) 
    {
        if((pAstronautRole != null) && (pAstronautRole != ""))
        {
            astronautRole = pAstronautRole;
        }
        else 
        {
            System.out.println("Astronaut role field is empty.");
        }
    }

    //if-else statment validates the age of the astronaut.
    public void setAstronautAge(int pAstronautAge)
    {
        if((pAstronautAge >= 18) && (pAstronautAge <= 65)) //upper boundary 65 as it is the age of retirement typically
        {
            astronautAge = pAstronautAge;
        }
        else 
        {
            System.out.println("Astronaut age is invalid.");
        }
    }

    /*the if-else statements in the setAstronautNationality mutator
    ensures the astronautName and astronautRole is not an empty string */
    public void setAstronautNationality(String pAstronautNationality) 
    {
        if((pAstronautNationality != null) && (pAstronautNationality != ""))
        {
            astronautNationality = pAstronautNationality;
        }
        else 
        {
            System.out.println("Astronaut's natioanlity field is empty.");
        }
    }

    //CONSTRUCTOR WITH PARAMETERS: creating an Astronaut object with imported values.
    public Astronaut(String pAstronautName, String pAstronautRole, int pAstronautAge, String pAstronautNationality)
    {
        setAstronautName(pAstronautName);
        setAstronautRole(pAstronautRole);
        setAstronautAge(pAstronautAge);
        setAstronautNationality(pAstronautNationality);
    }

    //Form string with the variables from this class.
    public String toCSV()
    {
        String astronautString;
        astronautString = astronautName + ":" + astronautRole + ":" + astronautAge + ":" + astronautNationality; 
        return astronautString;
    }

    //creates a string to format information to display information in terminal.
    public String toString()
    {
        String astronautString;
        astronautString = "Astronaut name: " + astronautName + "\nRole: " + astronautRole + "\nAge: " + astronautAge + "\nNationality: " + astronautNationality;
        return astronautString;
    }



}
