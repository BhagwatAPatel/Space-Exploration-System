/*********************************************************
 * Author: Bhagwat Patel                                 *
 * Date: 22 Apr 2025                                     *
 * Purpose: Mission class for use in PDI Assignment      *
 *                                                       *
 *********************************************************/
public class Mission
{
    //Class fields for this Mission object
    private String missionName;
    private String missionCode;
    private String destinationPlanet;
    private int launchYear;
    private double successRate;
    private boolean missionManned;
    private Astronaut[] astronauts;

    //All the accessors for this class:
    public String getMissionName()
    {
        return missionName;   
    }

    public String getMissionCode()
    {
        return missionCode;
    }

    public String getDestinationPlanet()
    {
        return destinationPlanet;
    }

    public int getLaunchYear()
    {
        return launchYear;
    }

    public double getSuccessRate()
    {
        return successRate;
    }

    public boolean getMissionManned()
    {
        return missionManned;
    }

    public Astronaut[] getAstronaut()
    {
        return astronauts;
    }

    //All the mutators for this class:

    //the if-else statements in the next 3 methods ensure that the missionName, missionCode, and destinationPlanet strings are non-empty. 
    public void setMissionName(String pMissionName)
    {
        if((pMissionName != null) && (pMissionName != ""))
        {
            missionName = pMissionName;
        }
        else 
        {
            System.out.println("Mission name field is empty.");
        }
    }

    public void setMissionCode(String pMissionCode)
    {
        if((pMissionCode != null) && (pMissionCode != ""))
        {
            missionCode = pMissionCode;
        }
        else
        {
            System.out.println("Mission code field is empty.");
        }
    }

    public void setDestinationPlanet(String pDestinationPlanet)
    {
        if((pDestinationPlanet != null) && (pDestinationPlanet != ""))
        {
            destinationPlanet = pDestinationPlanet;
        }
        else 
        {
            System.out.println("Destination field is empty.");
        }
    }

    //the if-else statement in the code below is ensuring the launch year value is between the years 1900 and 2100.
    public void setLaunchYear(int pLaunchYear)
    {
        if((pLaunchYear >= 1900) && (pLaunchYear <= 2100))
        {
            launchYear = pLaunchYear;
        }
        else
        {
            System.out.println("Year not in range (1900-2100).");
        }
    }

    //the if-else statement in the setSuccessRate method below is ensuring the updated value is a percentage.
    public void setSuccessRate(double pSuccessRate)
    {
        if((pSuccessRate >= 0.0) && (pSuccessRate <= 100.0))
        {
            successRate = pSuccessRate;
        }
        else 
        {
            System.out.println("Invalid success rate.");
        }
    }

    public void setMissionManned(boolean pMissionManned)
    {
        missionManned = pMissionManned;
    }

    public void setAstronauts(Astronaut[] pAstronauts)
    {
        astronauts = pAstronauts;
    }

    //CONSTRUCTOR WITH PARAMETERS: creating a mission object with imported values.
    public Mission(String pMissionName, String pMissionCode, String pDestinationPlanet, int pLaunchYear, double pSuccessRate, boolean pMissionManned)
    {
        setMissionName(pMissionName);
        setMissionCode(pMissionCode);
        setDestinationPlanet(pDestinationPlanet);
        setLaunchYear(pLaunchYear);
        setSuccessRate(pSuccessRate);
        setMissionManned(pMissionManned);
    }

    public Mission(String pMissionName, String pMissionCode, String pDestinationPlanet, int pLaunchYear, double pSuccessRate, boolean pMissionManned, Astronaut[] missionAstronauts) 
    {
        setMissionName(pMissionName);
        setMissionCode(pMissionCode);
        setDestinationPlanet(pDestinationPlanet);
        setLaunchYear(pLaunchYear);
        setSuccessRate(pSuccessRate);
        setMissionManned(pMissionManned);
        setAstronauts(missionAstronauts);

    }

    //Form strings from all variables for this class.
    public String toCSV()
    {
        String astronautInfo = "";
        if (missionManned && astronauts != null) {
            for (int i = 0; i < astronauts.length; i++) {
                if (astronauts[i] != null) {
                    astronautInfo += astronauts[i].toCSV() + "|"; //forming a string from the astronauts array
                }
            }
            if (!astronautInfo.isEmpty()) {
                astronautInfo = astronautInfo.substring(0, astronautInfo.length() - 1); // remove last '|'
            }
        }
        //adding the astronauts substring to the mission string.
        return missionName + "," + missionCode + "," + destinationPlanet + "," + launchYear + "," + successRate + "," + missionManned + "," + astronautInfo;
    }

    //creates a string to format information to display information in terminal.
    public String toString()
    {
        String missionString;
        missionString = "Mission name: " + missionName + "\nMission code: " + missionCode + "\nDestination planet: " + destinationPlanet + "\nLaunch year: " + launchYear + "\nSuccess rate: " + successRate + "\nMission manned: " + missionManned;
        return missionString;
    }

}