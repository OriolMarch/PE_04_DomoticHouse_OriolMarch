import java.util.InputMismatchException;
import java.util.Scanner;

public class PE_04 {
    // LLums globals
    static boolean restroomLight;
    static boolean kitchenLight;
    static boolean livingRoomLight;
    static boolean allLights;

    // Finestres globals
    static boolean kitchenwind;
    static boolean livingRoomwind;
    static boolean panoramicwind;
    static boolean allwindows;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int question = 0;

        while (true) {
            System.out.println("Welcome to my Domotic House");
            System.out.println("Lighting control system.");
            System.out.println("-----------------------------");
            System.out.println("Select an option: ");
            System.out.println("1) Lights");
            System.out.println("2) Windows");
            System.out.println("--------------------");

            try {
                question = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // netejar buffer
                continue;
            }

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
                    input.nextLine(); // netejar  buffer
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

            } else if (question == 2) {
                windowsMenu(input); // menú de finestres amb el metodè apart 
                System.out.println();

            } else {
                System.out.println("Invalid main option. Try again.");
            }
        }
    }

    // Metode llum
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
            input.nextLine(); // netejar buffer
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

    // Estat global de finestres.
    public static void updateAllWindows() {
        allwindows = kitchenwind && livingRoomwind && panoramicwind;
    }
}