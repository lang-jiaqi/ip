import java.util.Scanner;
public class Doraemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                System.out.println("    list");
                System.out.println("    ____________________________________________________________");
            }
            else if(input.equals("blah")){
                System.out.println("    ____________________________________________________________");
                System.out.println("    blah");
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}