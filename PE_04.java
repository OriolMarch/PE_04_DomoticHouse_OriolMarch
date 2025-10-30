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
                input.nextLine(); // limpiar buffer
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
                        restroomLight = !restroomLight;
                        System.out.println(restroomLight ? "Restroom light is now ON" : "Restroom light is now OFF");
                        break;
                    case 2:
                        kitchenLight = !kitchenLight;
                        System.out.println(kitchenLight ? "Kitchen light is now ON" : "Kitchen light is now OFF");
                        break;
                    case 3:
                        livingRoomLight = !livingRoomLight;
                        System.out.println(livingRoomLight ? "Living room light is now ON" : "Living room light is now OFF");
                        break;
                    case 4:
                        boolean newState = !(restroomLight && kitchenLight && livingRoomLight);
                        restroomLight = kitchenLight = livingRoomLight = newState;
                        System.out.println(newState ? "All lights are now ON" : "All lights are now OFF");
                        break;
                    case 5:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid option");
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
                // temperaturemenu(input);
            }

            // Estat general del sistema (Work in progress)
            if (question == 5) {
                //showSystemStatus();
            }

            // Sortida del sistema 
            if (question == 6) {
                System.out.println(" Shutting down the system...");
                break;
            }
        }

        input.close();
    }


    // Mètodes llums
    
    public static void updateAllLights() {
        allLights = restroomLight && kitchenLight && livingRoomLight;
    }

    
    // Menú finestres
   
    public static void windowsMenu(Scanner input) {
        System.out.println();
        System.out.println(" WINDOWS CONTROL");
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
                kitchenwind = !kitchenwind;
                System.out.println(kitchenwind ? "Kitchen window is now OPEN" : "Kitchen window is now CLOSED");
                break;
            case 2:
                livingRoomwind = !livingRoomwind;
                System.out.println(livingRoomwind ? "Living room window is now OPEN" : "Living room window is now CLOSED");
                break;
            case 3:
                panoramicwind = !panoramicwind;
                System.out.println(panoramicwind ? "Panoramic window is now OPEN" : "Panoramic window is now CLOSED");
                break;
            case 4:
                boolean newState = !(kitchenwind && livingRoomwind && panoramicwind);
                kitchenwind = livingRoomwind = panoramicwind = newState;
                System.out.println(newState ? "All windows are now OPEN" : "All windows are now CLOSED");
                break;
            case 5:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid option");
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
            System.out.println("🧹 ROOMBA CONTROL");
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
                        int horaKitchen = preguntarHora(input, "Kitchen");
                        System.out.println("Kitchen cleaning scheduled at " + horaKitchen + ":00h.");
                    } else {
                        System.out.println("Kitchen cleaning turned OFF.");
                    }
                    break;

                case 2:
                    clLiving = !clLiving;
                    if (clLiving) {
                        int horaLiving = preguntarHora(input, "Living Room");
                        System.out.println("Living Room cleaning scheduled at " + horaLiving + ":00h.");
                    } else {
                        System.out.println("Living Room cleaning turned OFF.");
                    }
                    break;

                case 3:
                    clRestroom = !clRestroom;
                    if (clRestroom) {
                        int horaRestroom = preguntarHora(input, "Restroom");
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

    
    // Mètode auxiliar: preguntar hora
    
    private static int preguntarHora(Scanner input, String habitacio) {
        int hora = -1;
        boolean correcte = false;

        do {
            System.out.print("At what hour do you want to start cleaning the " + habitacio + " (0–23)? ");
            try {
                hora = input.nextInt();
                if (hora >= 0 && hora <= 23) {
                    correcte = true;
                } else {
                    System.out.println("Please enter a valid hour between 0 and 23.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (!correcte);

        return hora;
    }
}