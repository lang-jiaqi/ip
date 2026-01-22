import java.util.ArrayList;
import java.util.Scanner;
public class Doraemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Doraemon\n    What can I do for you?");
        System.out.println("    ____________________________________________________________");
        Boolean end = false;
        while (!end) {
            String input = sc.nextLine();
            if(input.equals("bye")){
                end = true;
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
            }
            else if(input.equals("list")){
                System.out.println("    ____________________________________________________________");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println("    " + (i+1) + ". " + tasks.get(i));
                }
                System.out.println("    ____________________________________________________________");
            }
            else {
                tasks.add(input);
                System.out.println("    ____________________________________________________________");
                System.out.println("    added:" + input);
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}