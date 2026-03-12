/*
 * Author: Bhagwat Patel
 * Date: 10 May 2025
 * Purpose: Munipulate data space exploration data.
 */

import java.util.*;

public class SpaceExplorationSystem 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        String fileChoice;
        Mission[] missionArray;

        try
        {
            do
            {
                userChoice();
                userChoice = scanner.nextInt();
                scanner.nextLine();

                if ((userChoice > 0) && (userChoice <= 9))
                {
                    switch (userChoice)
                    {
                        //read the csv file and prints all the data. 
                        case 1: 
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();

                            MissionController.readFile(fileChoice);
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;
                        
                        //Print all manned missions
                        case 2: 
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();

                            missionArray = MissionController.storeInArray(fileChoice);
                            MissionController.mannedMissions(missionArray);
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;

                        //Print all unmanned missions
                        case 3:
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();

                            missionArray = MissionController.storeInArray(fileChoice);
                            MissionController.unmannedMissions(missionArray);
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;

                        //View a specific mission's astronauts
                        case 4:
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();

                            missionArray = MissionController.storeInArray(fileChoice);
                            MissionController.findAstronauts(missionArray);
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;

                        //Add a new mission
                        case 5:
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();

                            Astronaut[] astronautArray = null; //initialise astronaut array
                            Mission missionObject = MissionController.missionObject(); //calling the mission object from mission controller
                                if (missionObject.getMissionManned() == true)
                                {
                                    astronautArray = MissionController.astronautArray(); //creating astronaut object if the mission is manned 
                                    missionObject.setAstronauts(astronautArray);
                                    MissionController.addMissiondetails(fileChoice, missionObject); //writing it into the file
                                }
                                else 
                                {
                                    MissionController.addMissiondetails(fileChoice, missionObject); //writing it into the file if the mission is unmanned 
                                }
                            MissionController.storeInArray(fileChoice); //sync and save changes into the array.
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;

                        //Edit an existing mission
                        case 6:
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();

                            missionArray = MissionController.storeInArray(fileChoice);
                            MissionController.editMission(fileChoice, missionArray);
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;

                        //Provide a summary of the success rates of missions 
                        case 7:
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();

                            missionArray = MissionController.storeInArray(fileChoice);
                            MissionController.missionSummary(missionArray);
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;

                        case 8:
                            chooseFile(); //Calling a method to get user input to choose a file
                            fileChoice = scanner.nextLine();
                            
                            missionArray = MissionController.storeInArray(fileChoice);
                            MissionController.findNationality(missionArray);
                            System.out.println(" "); //create a space between the data from the file and the next mission command panel.
                        break;
                        

                    }
                }
                else 
                {
                    System.out.println("Please enter a number between 1-9\n"); //validating user choice
                }
            }
            while (userChoice != 9); //exiting program
            scanner.close();

        }
        catch (InputMismatchException error)
        {
            System.out.println("You have entered the wrong type of input! " + error);
        } 
        
    }

    //Method to print all user options.
    private static void userChoice()
    {
        System.out.println("Welcome to Mission Command!");
        System.out.println("Please select what you would like to do: ");
        System.out.println("1> View all missions.");
        System.out.println("2> View all manned missions.");
        System.out.println("3> View all unmanned missions.");
        System.out.println("4> View a mission's astronauts.");
        System.out.println("5> Add a new mission.");
        System.out.println("6> Edit an existing mission.");
        System.out.println("7> Summary of missions' success rates (average, highest, lowest).");
        System.out.println("8> List astronauts for a given nationality.");
        System.out.println("9> Exit Contoller");
    }

    //Method to print file choice prompt.
    private static void chooseFile()
    {
        System.out.print("which file would you like to use? ");
    }

}
