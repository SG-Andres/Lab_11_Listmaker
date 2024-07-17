import java.util.ArrayList;
import java.util.Scanner;

public class Listmaker {
    static ArrayList<String> list = new ArrayList<String>();
    Scanner console = new Scanner(System.in);

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        final String menu = "A - add D - Delete P - Print Q- Quit";
        boolean done = false;
        String cmd = "";


        do
        {
            //display list
            displayList();
            //display options
            //get choice
        cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
        cmd = cmd.toLowerCase();
        switch (cmd)
        {
                case "a":
                String addThing =SafeInput.getNonZeroLenString(console, "What Do you wish to add");
                list.add(String.valueOf(addThing));
                break;


                case "d":
                    int number = SafeInput.getInt(console, "What Do you wish to delete");
                    int actual = number - 1;
                    list.remove(actual);
                    break;

                case "p":
                displayList();
                break;

                case "q":
                boolean yn = SafeInput.getYNConfirm(console, "Would you like to quit?");
                if (yn)
                {
                    done = true;
                    break;
                }
                else
                {
                    break;
                }

        }
            System.out.println("cmd is " + cmd);


        }while(!done);

    }

    private static void displayList() {
        System.out.println("===========================================");
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d: %s\n", i + 1, list.get(i));
            }
        } else {
            System.out.println("The list is empty.");
        }
        System.out.println("===========================================");
    }
}