import java.util.ArrayList;
import java.util.Scanner;
public class Doraemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Doraemon\n    What can I do for you?");
        System.out.println("    ____________________________________________________________");
        Boolean end = false;
        while (!end) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];


            //Task t = new Task(input);

            if(command.equals("bye")){
                end = true;
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
            }
            else if(command.equals("list")){
                System.out.println("    ____________________________________________________________");
                System.out.println("    Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    Task curr_task = tasks.get(i);
                    System.out.println("    " + (i+1) + ". " + curr_task.getSatusIcon() + curr_task.description);
                }
                System.out.println("    ____________________________________________________________");
            }
            else if(command.equals("mark")){
                int task_number = Integer.parseInt(parts[1]);
                Task curr_task = tasks.get(task_number - 1);
                curr_task.markAsDone();
                System.out.println("    ____________________________________________________________");
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("      " + curr_task.getSatusIcon() + curr_task.getDescription());
                System.out.println("    ____________________________________________________________");
                }
            else if(command.equals("unmark")) {
                int task_number = Integer.parseInt(parts[1]);
                Task curr_task = tasks.get(task_number - 1);
                curr_task.Unmark();
                System.out.println("    ____________________________________________________________");
                System.out.println("    OK, I've marked this task as not done yet:");
                System.out.println("      " + curr_task.getSatusIcon() + curr_task.getDescription());
                System.out.println("    ____________________________________________________________");
            }
            else {
                Task task = new Task(input);
                tasks.add(task);
                System.out.println("    ____________________________________________________________");
                System.out.println("    added:" + task.getDescription());
                System.out.println("    ____________________________________________________________");
            }
            }

        }
    }
