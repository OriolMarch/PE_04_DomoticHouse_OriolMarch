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

        while (true) {
            System.out.println("Welcome to my Domotic House");
            System.out.println("Lighting control system.");
            System.out.println("-----------------------------");
            System.out.println("Select an option: ");
            System.out.println("1) Lights💡");
            System.out.println("2) Windows 🪟");
            System.out.println("3) Roomba 🧹");
            System.out.println("--------------------");

            try {
                question = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // limpiar buffer
                continue;
            }

            // Menú llums
            if (question == 1) {
                System.out.println("1) Restroom Lights");
                System.out.println("2) Kitchen Lights");
                System.out.println("3) Living Room Lights");
                System.out.println("4) All lights");
                System.out.println("--------------------");
                System.out.print("Select an option for the lights: ");

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
                        if (restroomLight) {
                            System.out.println("Restroom light is now ON");
                        } else {
                            System.out.println("Restroom light is now OFF");
                        }
                        break;

                    case 2:
                        kitchenLight = !kitchenLight;
                        if (kitchenLight) {
                            System.out.println("Kitchen light is now ON");
                        } else {
                            System.out.println("Kitchen light is now OFF");
                        }
                        break;

                    case 3:
                        livingRoomLight = !livingRoomLight;
                        if (livingRoomLight) {
                            System.out.println("Living room light is now ON");
                        } else {
                            System.out.println("Living room light is now OFF");
                        }
                        break;

                    case 4:
                        boolean newState = !(restroomLight && kitchenLight && livingRoomLight);
                        restroomLight = newState;
                        kitchenLight = newState;
                        livingRoomLight = newState;

                        if (newState) {
                            System.out.println("All lights are now ON");
                        } else {
                            System.out.println("All lights are now OFF");
                        }
                        break;

                    default:
                        System.out.println("Invalid option");
                }

                updateAllLights();
                System.out.println("All lights ON? " + allLights);
                System.out.println();
            }

            // Crida de metodè finestres
            if (question == 2) {
                windowsMenu(input);
                System.out.println();
            }

            // Roomba
            if (question == 3) {
                roombamenu(input);
                System.out.println();
            }

            if (question == 4) {
                System.out.println("Shutting down the system...");
                break; // Sortir del bucle
            }
        }

        input.close();
    }

    // Metodés llums
    public static void updateAllLights() {
        allLights = restroomLight && kitchenLight && livingRoomLight;
    }

    // Menú finestres
    public static void windowsMenu(Scanner input) {
        System.out.println();
        System.out.println("Which Windows open?");
        System.out.println();
        System.out.println("1) Kitchen Window");
        System.out.println("2) Living Room Window");
        System.out.println("3) Panoramic Window");
        System.out.println("4) All Windows");
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
                if (kitchenwind) {
                    System.out.println("Kitchen window is now OPEN");
                } else {
                    System.out.println("Kitchen window is now CLOSED");
                }
                break;

            case 2:
                livingRoomwind = !livingRoomwind;
                if (livingRoomwind) {
                    System.out.println("Living room window is now OPEN");
                } else {
                    System.out.println("Living room window is now CLOSED");
                }
                break;

            case 3:
                panoramicwind = !panoramicwind;
                if (panoramicwind) {
                    System.out.println("Panoramic window is now OPEN");
                } else {
                    System.out.println("Panoramic window is now CLOSED");
                }
                break;

            case 4:
                boolean newState = !(kitchenwind && livingRoomwind && panoramicwind);
                kitchenwind = newState;
                livingRoomwind = newState;
                panoramicwind = newState;

                if (newState) {
                    System.out.println("All windows are now OPEN");
                } else {
                    System.out.println("All windows are now CLOSED");
                }
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

    public static void roombamenu(Scanner input){
        System.out.println();
        System.out.println("Options for roomba: ");
        System.out.println();
        System.out.println("1) Clean kitchen");
        System.out.println("2) Clean Living Room ");
        System.out.println("3) Clean restroom");
        System.out.println("4) Clean all the House");
        System.out.println("--------------------");
        System.out.print("Select an option: ");

        int roombamenu;
        try{
            roombamenu = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            input.nextLine();
            return;
        }
        switch (roombamenu) {
            case 1:
            clKitchen = !clKitchen;
                if (clKitchen) {
                    System.out.println("Kitchen is now Cleaning");
                } else {
                    System.out.println("Kitchen is not cleanning or turned OFF");
                }
                break;
                case 2:
                
                clLiving = !clLiving;
                if (clLiving) {
                    System.out.println("Living Room now is cleaning");
                } else{
                    System.out.println("Living room is not cleaning");
                }
                break;
            default:
                break;
        }
    }
}
