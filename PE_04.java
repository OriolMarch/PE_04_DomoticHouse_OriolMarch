import java.util.InputMismatchException;
import java.util.Scanner;

public class PE_04 {

    // Llums globals
    static boolean restroomLight;
    static boolean kitchenLight;
    static boolean livingRoomLight;
    static boolean allLights;

    // Finestres globals
    static boolean kitchenwind;
    static boolean livingRoomwind;
    static boolean panoramicwind;
    static boolean allwindows;

    // Roomba globals
    static boolean clKitchen;
    static boolean clLiving;
    static boolean clRestroom;
    static boolean clAllHouse;
    // Hores de Roomba
    static int horaKitchen = -1;
    static int horaLiving = -1;
    static int horaRestroom = -1;

    // Temperatura
    static int tempKitchen;
    static int tempLiving;
    static int tempRestroom;
    // Hores temperatura
    static int hourKitchen = -1;
    static int hourLiving = -1;
    static int hourRestroom = -1;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int question = 0;

        // Bucle principal del menú
        while (true) {
            System.out.println();
            System.out.println(" Welcome to my Domotic House");
            System.out.println("-----------------------------");
            System.out.println("1) Lights ");
            System.out.println("2) Windows ");
            System.out.println("3) Roomba ");
            System.out.println("4) Temperature");
            System.out.println("5) System status ");
            System.out.println("6) Shut down ");
            System.out.println("-----------------------------");
            System.out.print("Select an option: ");
            

            try {
                question = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input. Please enter a number.");
                input.nextLine(); // netejar buffer
                continue;
            }

            // Menú llums
            if (question == 1) {
                System.out.println();
                System.out.println("LIGHT CONTROL");
                System.out.println("1) Restroom Lights");
                System.out.println("2) Kitchen Lights");
                System.out.println("3) Living Room Lights");
                System.out.println("4) All lights");
                System.out.println("5) Return to main menu");
                System.out.println("--------------------");
                System.out.print("Select an option: ");

                int lightOption;
                try {
                    lightOption = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    input.nextLine();
                    continue;
                }

                switch (lightOption) {
                    case 1:
                        if (restroomLight == true) {
                            restroomLight = false;
                            System.out.println("Restroom light is now OFF");
                        } else {
                            restroomLight = true;
                            System.out.println("Restroom light is now ON");
                        }
                        break;

                    case 2:
                        if (kitchenLight == true) {
                            kitchenLight = false;
                            System.out.println("Kitchen light is now OFF");
                        } else {
                            kitchenLight = true;
                            System.out.println("Kitchen light is now ON");
                        }
                        break;

                    case 3:
                        if (livingRoomLight == true) {
                            livingRoomLight = false;
                            System.out.println("Living room light is now OFF");
                        } else {
                            livingRoomLight = true;
                            System.out.println("Living room light is now ON");
                        }
                        break;

                    case 4:
                        if (restroomLight == true && kitchenLight == true && livingRoomLight == true) {
                            restroomLight = false;
                            kitchenLight = false;
                            livingRoomLight = false;
                            System.out.println("All lights are now OFF");
                        } else {
                            restroomLight = true;
                            kitchenLight = true;
                            livingRoomLight = true;
                            System.out.println("All lights are now ON");
                        }
                        break;

                    case 5:
                        System.out.println("Returning to main menu...");
                        break;

                    default:
                        System.out.println("Invalid option");
                        break;
                }

                updateAllLights();
                System.out.println("All lights ON? " + allLights);
            }

            // Menú finestres
            if (question == 2) {
                windowsMenu(input);
            }

            // Menú Roomba
            if (question == 3) {
                roombamenu(input);
            }

            // Menú temperatura
            if (question == 4) {
                temperaturemenu(input);
            }

            // Estat general del sistema
            if (question == 5) {
                showSystemStatus();
            }

            // Sortida del sistema
            if (question == 6) {
                System.out.println(" Shutting down the system...");
                return;
            }
        }
    }

    // Mètodes llums
    public static void updateAllLights() {
        allLights = restroomLight && kitchenLight && livingRoomLight;
    }

    // Menú finestres
    public static void windowsMenu(Scanner input) {
        System.out.println();
        System.out.println("WINDOWS CONTROL");
        System.out.println("1) Kitchen Window");
        System.out.println("2) Living Room Window");
        System.out.println("3) Panoramic Window");
        System.out.println("4) All Windows");
        System.out.println("5) Return to main menu");
        System.out.println("--------------------");
        System.out.print("Select an option: ");

        int windowsoption;
        try {
            windowsoption = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            input.nextLine();
            return;
        }

        switch (windowsoption) {
            case 1:
                if (kitchenwind == true) {
                    kitchenwind = false;
                    System.out.println("Kitchen window is now closed");
                } else {
                    kitchenwind = true;
                    System.out.println("Kitchen window is now open");
                }
                break;

            case 2:
                if (livingRoomwind == true) {
                    livingRoomwind = false;
                    System.out.println("Living Room window is now closed");
                } else {
                    livingRoomwind = true;
                    System.out.println("Living Room window is now open");
                }
                break;

            case 3:
                if (panoramicwind == true) {
                    panoramicwind = false;
                    System.out.println("Panoramic window is now closed");
                } else {
                    panoramicwind = true;
                    System.out.println("Panoramic window light is now open");
                }
                break;

            case 4:
                if (kitchenwind == true && livingRoomwind == true && panoramicwind == true) {
                    kitchenwind = false;
                    livingRoomwind = false;
                    panoramicwind = false;
                    System.out.println("All windows are now closed");
                } else {
                    kitchenwind = true;
                    livingRoomwind = true;
                    panoramicwind = true;
                    System.out.println("All windows are now open");
                }
                break;

            case 5:
                System.out.println("Returning to main menu...");
                break;

            default:
                System.out.println("Invalid option");
                break;
        }

        updateAllWindows();
        System.out.println("All windows OPEN? " + allwindows);
    }

    // Estat global finestres
    public static void updateAllWindows() {
        allwindows = kitchenwind && livingRoomwind && panoramicwind;
    }

    // Menú Roomba
    public static void roombamenu(Scanner input) {
        int roombamenu = 0;

        do {
            System.out.println();
            System.out.println("ROOMBA CONTROL");
            System.out.println("1) Clean kitchen");
            System.out.println("2) Clean living room");
            System.out.println("3) Clean restroom");
            System.out.println("4) Clean all the house");
            System.out.println("5) Return to main menu");
            System.out.println("------------------------------");
            System.out.print("Select an option: ");

            try {
                roombamenu = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                input.nextLine();
                continue;
            }

            switch (roombamenu) {
                case 1:
                    clKitchen = !clKitchen;
                    if (clKitchen) {
                         horaKitchen = preguntarHora(input, "Kitchen");
                        System.out.println("Kitchen cleaning scheduled at " + horaKitchen + ":00h.");
                    } else {
                        System.out.println("Kitchen cleaning turned OFF.");
                    }
                    break;

                case 2:
                    clLiving = !clLiving;
                    if (clLiving) {
                         horaLiving = preguntarHora(input, "Living Room");
                        System.out.println("Living Room cleaning scheduled at " + horaLiving + ":00h.");
                    } else {
                        System.out.println("Living Room cleaning turned OFF.");
                    }
                    break;

                case 3:
                    clRestroom = !clRestroom;
                    if (clRestroom) {
                         horaRestroom = preguntarHora(input, "Restroom");
                        System.out.println("Restroom cleaning scheduled at " + horaRestroom + ":00h.");
                    } else {
                        System.out.println("Restroom cleaning turned OFF.");
                    }
                    break;

                case 4:
                    clAllHouse = !clAllHouse;
                    if (clAllHouse) {
                        int horaAll = preguntarHora(input, "All House");
                        System.out.println("Whole house cleaning scheduled at " + horaAll + ":00h.");
                    } else {
                        System.out.println("Whole house cleaning turned OFF.");
                    }
                    break;

                case 5:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Please enter a valid option (1-5).");
                    break;
            }

        } while (roombamenu != 5);
    }

    public static void temperaturemenu(Scanner input) {
        int temperaturemenu = 0;


        do {
            System.out.println();
            System.out.println("TEMPERATURE CONTROL");
            System.out.println("1) Set kitchen temperature");
            System.out.println("2) Set living room temperature");
            System.out.println("3) Set restroom temperature");
            System.out.println("4) Return to main menu");
            System.out.println("------------------------------");
            System.out.print("Select an option: ");

            try {
                temperaturemenu = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                input.nextLine();
                continue;
            }

            switch (temperaturemenu) {
                case 1 -> {
                    System.out.print("Enter desired kitchen temperature (ºC): ");
                    tempKitchen = input.nextInt();

                    if (tempKitchen >= 40 || tempKitchen <= 0) {
                        System.out.println("Put a number between (1 - 39)");
                        return;
                    }

                    System.out.print("At what hour should it change? (0–23): ");
                    hourKitchen = input.nextInt();

                    if (hourKitchen > 23 || hourKitchen < 0) {
                        System.out.println("The hour should be 0- 23");
                        return;
                    }

                    System.out.println("Kitchen temperature set to " + tempKitchen + " ºC at " + hourKitchen + ":00h.");
                }

                case 2 -> {
                    System.out.print("Enter desired living room temperature (ºC): ");
                    tempLiving = input.nextInt();

                    if (tempLiving >=40 || tempLiving <=0) {
                        System.out.println("Put a number between (1 - 39)");
                        return;
                    }

                    System.out.print("At what hour should it change? (0 - 23): ");
                    hourLiving = input.nextInt();

                    if (hourLiving > 23 || hourLiving <0) {
                        System.out.println("The hour needs to be between 0 or 23");
                        return;
                    }

                    System.out.println("Living room temperature set to " + tempLiving + " ºC at " + hourLiving + ":00h.");
                }

                case 3 -> {
                    System.out.print("Enter desired restroom temperature (ºC): ");
                    tempRestroom = input.nextInt();

                    if (tempRestroom >= 40 || tempRestroom <=0) {
                        System.out.println("Put a number between (1 - 39)");
                        return;
                    }

                    System.out.print("At what hour should it change? (0 - 23): ");
                    hourRestroom = input.nextInt();

                    if (hourRestroom > 23 || hourRestroom < 0) {
                        System.out.println("The hour needs to be between 0 or 23");
                        return;
                    }

                    System.out.println("Restroom temperature set to " + tempRestroom + " ºC at " + hourRestroom + ":00h.");
                }

                default -> System.out.println("Please enter a valid option (1 - 5).");
            }

        } while (temperaturemenu != 4);
    }

    // INTENT DE CONTROLAR HORES I MINUTS.
    // public static int temphores(int tempKitchen, int hourKitchen, int tempLiving, int hourLiving, int tempRestroom,int  hourRestroom){
    //     for(int hour = 0; hour <24; hour++){
    //         for(int min = 0; min <60; min++){
    //             if (hour == hourKitchen && min == 0) {
    //                 System.out.println("Kitchen temperature change to " + tempKitchen + hour + min);
    //             } if (hour == hourLiving && min == 0) { {
    //                 System.out.println("Living room temperature change to " + tempLiving + hour + min);
    //             } if (hour == hourRestroom && min == 0) {
    //                 System.out.println("Restroom temperature change to " + tempRestroom + hour + min);
    //             }
    //         }
    //     }
    //     }
    //     return 0;
    // }

    public static void showSystemStatus(){

        System.out.println();
        System.out.println("Lights Status: ");
        System.out.println("");
        if (restroomLight == true) {
            System.out.println("Restroom Light is ON");
        }else{
            System.out.println("Restroom Light is OFF");
        }

        if (kitchenLight == true) {
            System.out.println("Kitchen Light is ON");
        }else{
            System.out.println("Kitchen Light is OFF");
        }

        if (livingRoomLight == true) {
            System.out.println("Living Room Light is ON");
        }else{
            System.out.println("Living Room Light is OFF");
        }
        System.out.println("------------------------------");

        System.out.println();
        System.out.println("Windows Status: ");
        System.out.println();

        if (kitchenwind == true) {
            System.out.println("Kitchen windows is OPEN");
        }else{
            System.out.println("Kitchen windows is CLOSED");
        }

        if (livingRoomwind == true) {
            System.out.println("Living Room windows is OPEN");
        }else{
            System.out.println("Living Room windows is CLOSED");
        }

        if (panoramicwind == true) {
            System.out.println("Panoramic window is OPEN");
        }else{
            System.out.println("Panoramic window is CLOSED");
        }
        System.out.println("------------------------------");

        System.out.println();
        System.out.println("Roomba Status: ");
        System.out.println();

        if (horaKitchen  != -1) {
            System.out.println("Kitchen is up to clean at: " + horaKitchen + ":00h.");
            
        }else{
            System.out.println("Is not program or not cleaning");
        }

         if (horaLiving  != -1) {
            System.out.println("Kitchen is up to clean at: " + horaLiving + ":00h.");
            
        }else{
            System.out.println("Is not program or not cleaning");
        }
         if (horaRestroom  != -1) {
            System.out.println("Kitchen is up to clean at: " + horaRestroom + ":00h.");
            
        }else{
            System.out.println("Is not program or not cleaning");
        }

        System.out.println("------------------------------");

        System.out.println();
        System.out.println("Temperature Status: ");
        System.out.println();

        if (tempKitchen != -1) {
    System.out.println("The Kitchen temperature is set at " + tempKitchen + " ºC at " + hourKitchen + ":00h.");
    } else {
    System.out.println("The Kitchen temperature is not set (default).");
    }

        if (tempLiving != -1) {
    System.out.println("The Living Room temperature is set at " + tempLiving + " ºC at " + hourLiving + ":00h.");
    } else {
    System.out.println("The Living Room temperature is not set (default).");
    }

    if (tempRestroom != -1) {
    System.out.println("The Restroom temperature is set at " + tempRestroom + " ºC at " + hourRestroom + ":00h.");
    } else {
    System.out.println("The Restroom temperature is not set (default).");
    }



    }
    // Mètode auxiliar: preguntar hora & amb un do while, es una mica nynyogi pero volia provar.
    public static int preguntarHora(Scanner input, String habitacio) {
        int hour = -1;
        boolean correcte = false;

        do {
            System.out.print("At what hour do you want to start cleaning the " + habitacio + " (0 - 23)? ");
            try {
                hour = input.nextInt();
                if (hour >= 0 && hour <= 23) {
                    correcte = true;
                } else {
                    System.out.println("Please enter a valid hour between 0 and 23.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (!correcte);

        return hour;

    }
}

