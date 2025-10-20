import java.util.Scanner;

public class PE_04 {
    //Declarar LLums amb variables globals
    static boolean hallwayLight;
    static boolean kitchenLight;
    static boolean diningRoomLight;
    static boolean allLights;

    public static void main(String[] args) {
        
        Scanner lights = new Scanner(System.in);
        System.out.println("Welcome to my Domotic House");
        System.out.println("Lighting control system.");
        System.out.println("-----------------------------");

        hallwayLight = true;
        kitchenLight = false;
        diningRoomLight = true;

        updateAllLights(); 

        System.out.println("¿All are on? " + allLights);
    
    }

    public static void updateAllLights() {
        allLights= hallwayLight && kitchenLight && diningRoomLight;
    }
}
