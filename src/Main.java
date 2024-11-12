import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> myArrList = new ArrayList<>();
    public static void main(String[] args) {
        String command = "";
        boolean done = false;
        do {
            System.out.println("\n---------------------------------\n");
            display();
            System.out.println("\nA - Add an item to the list\nD - Delete an item from the list\nI - Insert an item into the list\nP - Print (i.e. display) the list\nQ - Quit the program\n");
            command = SafeInput.getRegExString(in, "Please select an option", "[AaDdIiPpQq]");

            if (command.equalsIgnoreCase("q")) {
                done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
            } else if (command.equalsIgnoreCase("a")) {
                addItem();
            } else if (command.equalsIgnoreCase("d")) {
                deleteItem();
            } else if (command.equalsIgnoreCase("i")) {
                insertItem();
            } else if (command.equalsIgnoreCase("p")) {
                printList();
            }
        } while(!done);
    }

    private static void display() {
        System.out.println(myArrList);
    }

    private static void displayNumbered() {
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println("[" + i + "] - " + myArrList.get(i));
        }
    }

    private static void printList() {
        display();
    }

    private static void insertItem() {
        displayNumbered();
        int index = SafeInput.getRangedInt(in, "Please enter the position that you want to insert to", 0, myArrList.size());
        String value = SafeInput.getNonZeroLenString(in, "Please enter the desired value");
        myArrList.add(index, value);
    }

    private static void deleteItem() {
        displayNumbered();
        int index = SafeInput.getRangedInt(in, "Please enter the position that you want to delete", 0, myArrList.size()-1);
        myArrList.remove(index);
    }

    private static void addItem() {
        String value = SafeInput.getNonZeroLenString(in, "Please enter the desired value");
        myArrList.add(value);
    }
}