import java.util.InputMismatchException;
import java.util.Scanner;

public class PE_04 {
    // Declarar llums com variables globales
    static boolean restroomLight;
    static boolean kitchenLight;
    static boolean livingRoomLight;
    static boolean allLights;

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
            
            try{
                question = input.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a number");
                input.nextLine();
                continue;
            }
            

            if (question == 1) {
                System.out.println("1) Restroom Lights");
                System.out.println("2) Kitchen Lights");
                System.out.println("3) Living Room Lights");
                System.out.println("4) All lights");
                System.out.println("--------------------");
                System.out.println("");
                System.out.print("Select an option for the lights: ");

                int lightOption = input.nextInt();  // Reutilitzar el scanner :)
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

            }if (question == 2) {
                System.out.println("");
                System.out.println("Hijo de puta");
                System.out.println("");
            }
                
            }
        }
    }

   

