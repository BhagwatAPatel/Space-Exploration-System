/*********************************************************
 * Author: Bhagwat Patel                                 *
 * Date: 22 Apr 2025                                     *
 * Purpose: MissionController class for use in           *
 * PDI Assignment. This holds the methods for all        *  
 * interactions such as adding, viewing or editing       *
 * mission data, and reading and writing to csv file.    *
 *********************************************************/
import java.io.*;
import java.util.*;


public class MissionController
{
    private static Scanner scanner = new Scanner(System.in);
    public static int numOfMissions = 0;

    //READ DATA FROM CSV FILE AND STORE IN AN ARRAY OF OBJECTS
    public static Mission[] storeInArray(String pDataFile) 
    {
        FileInputStream fileStream = null;
        InputStreamReader reader;
        BufferedReader bufferedReader;
        String line;
        Mission[] missions = new Mission[100];
        try 
        {
            fileStream = new FileInputStream(pDataFile);
            reader = new InputStreamReader(fileStream);
            bufferedReader = new BufferedReader(reader);
            numOfMissions = 0;
            line = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null)
            {                
                //parsing from: https://stackoverflow.com/questions/70217948/turning-csv-numeric-string-values-into-an-integer-java
                //split all the mission data 
                String[] missionParts = line.split(",", -1);
                Astronaut[] missionAstronauts = new Astronaut[0];

                if (missionParts[6].isEmpty())
                {
                    //if there are no astronauts then create an empty array
                    missionAstronauts = new Astronaut[0];
                } 
                
                else 
                {
                    //split all the astronauts 
                    String[] numberOfAstronauts = missionParts[6].split("\\|");
                    missionAstronauts = new Astronaut[numberOfAstronauts.length];

                    //create astronaut object and store in array
                    for (int i = 0; i < numberOfAstronauts.length; i++)
                    {
                        String[] astronautParts = numberOfAstronauts[i].split(":");
                        missionAstronauts[i] = new Astronaut(astronautParts[0], astronautParts[1], Integer.parseInt(astronautParts[2]), astronautParts[3]);
                    }
                }

                //creating mission object array
                missions[numOfMissions++] = new Mission(missionParts[0], missionParts[1], missionParts[2], Integer.parseInt(missionParts[3]), Double.parseDouble(missionParts[4]), Boolean.parseBoolean(missionParts[5]), missionAstronauts); 
            }

            fileStream.close();
        }
        catch(IOException errorDetails) 
        {
            if(fileStream != null) 
            {
                try 
                {
                    fileStream.close();
                }
                catch(IOException ex2) 
                { }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
        return missions;
    }

    //OPTION 1: READ FILE
    public static void readFile(String pDataFile) 
    {
        FileInputStream fileStream = null;
        InputStreamReader reader;
        BufferedReader bufferedReader; 
        String line;
        try 
        {
            fileStream = new FileInputStream(pDataFile);
            reader = new InputStreamReader(fileStream);
            bufferedReader = new BufferedReader(reader);
            line = bufferedReader.readLine();
            while(line != null)
            {
                //printing the read file
                System.out.println(line);
                line = bufferedReader.readLine();
            }
                fileStream.close();
        }
        catch(IOException errorDetails) 
        {
            if(fileStream != null) 
            {
                try 
                {
                    fileStream.close();
                }
                catch(IOException ex2) 
                { }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
    }

    //OPTION 2: VIEW ALL MANNED MISSIONS
    public static void mannedMissions(Mission[] missions)
    {
        try
        {
            for (int i = 0; i < missions.length; i++)
            {
                if (missions[i] != null) //ensuring that the object has mission data.
                {
                    if (missions[i].getMissionManned()) //checking to see if mannedMission is true for given element of array. 
                    {
                        Mission mission = missions[i];
                        System.out.println(missions[i] + "\n"); //printing the missions that are manned. 
                        if (mission.getAstronaut() != null)
                        {
                            System.out.println("Astronauts part of " + missions[i].getMissionName() + ":");
                            for (Astronaut astronaut : mission.getAstronaut() ) // From: https://stackoverflow.com/questions/9305632/java-for-each-loop-and-references
                            {
                                if (astronaut != null) //ensuring that the object has astronaut data.
                                {
                                    System.out.println(astronaut + "\n"); //printing the astronauts which are part of the manned mission.
                                }
                            }

                        }
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException error)
        {
            System.out.println("Something went wrong! " + error);
        }
    }

    //OPTION 3: VIEW ALL UNMANNED MISSIONS
    public static void unmannedMissions(Mission[] missions)
    {
        try
        {
            for (int i = 0; i < missions.length; i++)
            {
                if (missions[i] != null) //ensuring that the object has mission data.
                {
                    if (!missions[i].getMissionManned()) //checking if mannedMission is false.
                    {
                        System.out.println(missions[i] + "\n"); //printing unmanned missions.
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException error)
        {
            System.out.println("Something went wrong! " + error);
        }
    }

    //OPTION 4: VIEW A MISSION'S ASTRONAUTS
    public static void findAstronauts(Mission[] missions)
    {
        System.out.println("Which mission's Astronaut would you like to view? ");
        String missionAstronaut = scanner.nextLine();

        try
        {
            for (int i = 0; i < missions.length; i++) 
            {
                Mission mission = missions[i];
                if (mission != null) //ensuring that the object has mission data.
                {
                    //searching for the mission the user requested.
                    if (mission.getMissionCode().equalsIgnoreCase(missionAstronaut) || mission.getMissionName().equalsIgnoreCase(missionAstronaut)) 
                    {
                        if (mission.getMissionManned() && mission.getAstronaut() != null) //checking if the mission does actually have astronauts.
                        {
                            System.out.println("Astronauts in " + mission.getMissionName() + ":");
                            for (Astronaut astronauts : mission.getAstronaut()) 
                            {
                                if (astronauts != null) //ensuring that the object has astronaut data.
                                {
                                    
                                    System.out.println(astronauts + "\n"); //printing the astronauts which are part of the mission.
                                }
                            }
                        } 
                        else 
                        {
                            System.out.println("\nMission is unmanned.\n");
                        }
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException error)
        {
            System.out.println("Something went wrong! " + error);
        }

    }
    
    //OPTION 5: CREATE NEW MISSION OBJECT
    public static Mission missionObject() 
    {
    
        // Collect new user input about Mission details
        System.out.print("Enter mission name: ");
        String missionName = scanner.nextLine();

        System.out.print("Enter mission code: ");
        String missionCode = scanner.nextLine();

        System.out.print("Enter destination planet: ");
        String destinationPlanet = scanner.nextLine();

        System.out.print("Enter launch year: ");
        int launchYear = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter success rate: ");
        double successRate = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Is the mission manned?: ");
        String missionManned = scanner.nextLine();

        //Create a mission object from user input.
        Mission adventures = new Mission(missionName, missionCode, destinationPlanet, launchYear, successRate, isManned(missionManned)); 
        
        return adventures;
        
    }

    //OPTION 5: DETERMINES WHETHER MISSION IS MANNED OR UNMANNED
    public static boolean isManned(String isManned)
    {
        boolean manned;
        if (isManned.equalsIgnoreCase("yes") || isManned.equalsIgnoreCase("true")) 
            {
                manned = true;   
                return manned;             
            }
            else
            {
                manned = false;
                return manned;
            }

    }

    //OPTION 5: CREATING NEW ASTRONAUT ARRAY
    public static Astronaut[] astronautArray()
    {
        int numberOfAstronaut;
        System.out.print("How many astronauts are part of this mission? "); //number of astronauts wanted 
        numberOfAstronaut = scanner.nextInt();
        scanner.nextLine(); // consume leftover new line.

        Astronaut[] astronauts = new Astronaut[numberOfAstronaut];

        // Collect new user input
        for (int i = 0; i < numberOfAstronaut; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter role: ");
            String role = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); //comsume leftover new line

            System.out.print("Enter nationality: ");
            String nationality = scanner.nextLine();

            //creating astronaut objects and storing into an array.
            astronauts[i] = new Astronaut(name, role, age, nationality);
        }
        
        return astronauts;

    }


    //OPTION 5 & 6: WRTIES USER INPUT INTO THE FILE USING MISSION OBJECT
    public static void addMissiondetails(String fileName, Mission[] adventures)
    {
        FileOutputStream fileStream = null;
        PrintWriter pw;
        try
        {
            fileStream = new FileOutputStream(fileName);
            pw = new PrintWriter(fileStream);	 
            pw.println("Mission Name,Mission Code,Destination Planet,Launch Year,Success Rate,Manned Mission,Astronauts"); //printing the header.
            for (Mission mission : adventures)
            {
                if (mission != null) {
                    pw.print(mission.toCSV() + "\n"); //printing mission into the csv file.
                }
            }
            pw.close();					 
        }
        catch(IOException error)
        {			 
            System.out.println("Error in writing to file: " + error.getMessage());
        }   


    }

    //OPTION 5: IF MISSION IS UNMMANNED THEN THIS METHOD WRITES MISSION OBJECT INTO THE FILE
    public static void addMissiondetails(String fileName, Mission adventures)
    {
        FileOutputStream fileStream = null;
        PrintWriter pw;
        try
        {
            fileStream = new FileOutputStream(fileName, true);
            pw = new PrintWriter(fileStream);	 
            pw.println(" ");	//Skipping line
            pw.print(adventures.toCSV()); //printing missions without the astronauts into the csv. 
            pw.close();					 
        }
        catch(IOException error)
        {			 
            System.out.println("Error in writing to file: " + error.getMessage());
        }   

    }


    //OPTION 6: EDIT MISSIONS
    public static void editMission(String pDataFile, Mission[] missionArray)
    {
        //Determining which mission needs to be edited
        System.out.print("What is the name of the mission you wish edit? ");
        String missionToEdit = scanner.nextLine();
        boolean found = false; //for use to determine if mission was found or not 

        //searching for the mission that needs to edited and editing it
        int i = 0;
        int matchIndex = -1;
        while (( i <= (missionArray.length -1 )) && (matchIndex == -1))
        {
            if (missionArray[i].getMissionName().equalsIgnoreCase(missionToEdit)) {
                System.out.println("Found: " + "\n" + missionArray[i]);

                //getting new user input.
                System.out.print("Enter new mission name: ");
                String newName = scanner.nextLine();
                missionArray[i].setMissionName(newName);

                System.out.print("Enter new mission code: ");
                String newCode = scanner.nextLine();
                missionArray[i].setMissionCode(newCode);

                System.out.print("Enter new Destination: ");
                String newDestination = scanner.nextLine();
                missionArray[i].setDestinationPlanet(newDestination);

                System.out.print("Enter new launch year: ");
                int newLaunchYear = scanner.nextInt();
                missionArray[i].setLaunchYear(newLaunchYear);
                
                System.out.print("Enter new success rate: ");
                double newSuccessRate = scanner.nextDouble();
                missionArray[i].setSuccessRate(newSuccessRate);

                System.out.print("mission is manned (true or false): ");
                boolean newMannedStatus = scanner.nextBoolean();
                scanner.nextLine();
                missionArray[i].setMissionManned(newMannedStatus);
                
                //edit astronauts if needed
                Mission mission = missionArray[i];
                        if (mission != null)
                        {
                            if (mission.getMissionManned() && mission.getAstronaut() != null) 
                            {
                                Astronaut[] newAstronauts = astronautArray();
                                mission.setAstronauts(newAstronauts);
                            } 
                        }
                missionArray[i] = mission; //storing updated values back into the missionArray

                found = true;
                matchIndex = i;
            }
            i++;
        }

        if (!found) {
            System.out.println("Cannot find Mission");
            return;
        }

        addMissiondetails(pDataFile, missionArray);
    }    

    //OPTION 7: PROVIDE SUMMARY OF A MISSION'S SUCCESS RATES 
    public static void missionSummary(Mission[] missions)
    {
        double[] successRates = new double[missions.length];
        double sum = 0;
        double average;

        for (int i = 0; i < numOfMissions; i++)
        {
            if (missions[i] != null)
            {
                successRates[i] = missions[i].getSuccessRate(); //creating an array with all mission's success rates. 
            }
        }

        for (int j = 0; j < numOfMissions; j++)
        {
            sum += successRates[j]; //adding all the success rates together. 
        }

        average = sum/numOfMissions;
        System.out.println("The average success rate is: " + average + "%");
        double[] sortedRates = sortedRates(successRates); //arranging the successRates array in order of largest to smallest.
        System.out.println("The highest success rate is: " + sortedRates[0] + "%");
        System.out.println("The lowest success rate is: " + sortedRates[numOfMissions - 1] + "%");
    }

    //OPTION 7: SELECTION SORT LARGEST TO SMALLEST
    public static double[] sortedRates(double[] successRates)
    {
        for (int i = 0; i < numOfMissions; i++)
        {
            int maxIndex = i; 
            for (int j = (i + 1); j < numOfMissions; j++)
            {
                if (successRates[j] > successRates[maxIndex])
                {
                    maxIndex = j;
                }
            }
            double temp = successRates[maxIndex];
            successRates[maxIndex] = successRates[i];
            successRates[i] = temp;
        }
        return successRates;
    }


    //OPTION 8: SHOW ALL ASTRONAUTS FOR A GIVEN NATIONALITY
    public static void findNationality(Mission[] missions)
    {
        System.out.println("Which nationality are you searching for? ");
        String missionAstronaut = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < numOfMissions; i++)
        {
            Mission mission = missions[i];

            if (mission.getMissionManned() && mission.getAstronaut() != null)
            {
                for (Astronaut astronaut : mission.getAstronaut())
                {
                    if (astronaut.getAstronautNationality().equalsIgnoreCase(missionAstronaut))
                    {
                        System.out.println(astronaut + "\n"); //printing the astronauts which are part of the mission.
                        found = true;
                    }
                }
            }
        }
        if (!found)
        {
            System.out.println("No astronaut found from " + missionAstronaut);
        }
    }
}

