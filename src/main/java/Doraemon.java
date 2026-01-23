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
            String[] parts = input.split(" ", 2);
            String command = parts[0];


            //Task t = new Task(input);
            try {
                if (command.equals("bye")) {
                    end = true;
                    System.out.println("    Bye. Hope to see you again soon!");
                    System.out.println("    ____________________________________________________________");
                } else if (command.equals("list")) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task curr_task = tasks.get(i);
                        System.out.println("    " + (i + 1) + ". " + curr_task.toString());
                    }
                    System.out.println("    ____________________________________________________________");
                } else if (command.equals("mark")) {
                    int task_number = Integer.parseInt(parts[1]);
                    Task curr_task = tasks.get(task_number - 1);
                    curr_task.markAsDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    Nice! I've marked this task as done:");
                    System.out.println("      " + curr_task.toString());
                    System.out.println("    ____________________________________________________________");
                } else if (command.equals("unmark")) {
                    int task_number = Integer.parseInt(parts[1]);
                    Task curr_task = tasks.get(task_number - 1);
                    curr_task.Unmark();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    OK, I've marked this task as not done yet:");
                    System.out.println("      " + curr_task.toString());
                    System.out.println("    ____________________________________________________________");
                } else if (command.equals("todo") || command.equals("deadline") || command.equals("event")) {
                    Task task = null;
                    if (command.equals("todo")) {
                        if (parts.length < 2 || parts[1].isBlank()) {
                            throw new DoraemonException("OOPS!!! The description of a todo cannot be empty, please try again with task description~");
                        }
                        String task_name = parts[1];
                        task = new ToDo(task_name);
                        tasks.add(task);
                    } else if (command.equals("deadline")) {
                        if (parts.length < 2 ) {
                            throw new DoraemonException("OOPS!!! Deadline can not be empty! please try again with task description and deadline~");
                        }
                        String[] content = parts[1].split("/", 2);
                        if (content.length < 2 || content[0].isBlank()|| content[1].isBlank()) {
                            throw new DoraemonException("OOPS!!! Deadline discription is incomplete, please try again with task description and deadline~");
                        }
                        String task_name = content[0];
                        String deadline = content[1];
                        task = new Deadline(task_name, deadline);
                        tasks.add(task);
                    } else if (command.equals("event")) {
                        if (parts.length < 2){
                            throw new DoraemonException("OOPS!!! Event cannot be empty!");
                        }
                        String[] content = parts[1].split("/", 3);
                        if (content.length < 3 || content[0].isBlank() || content[1].isBlank()|| content[2].isBlank()) {
                            throw new DoraemonException("OOPS!!! Event discription is incomplete, please try again with task description, start date and end date~");
                        }
                        String task_name = content[0];
                        String from = content[1];
                        String to = content[2];
                        task = new Event(task_name, from, to);
                        tasks.add(task);
                    }
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    Got it. I've added this task:\n" + "    " + task.toString());
                    System.out.println("    Now you have " + tasks.size() + " tasks in your list.");
                    System.out.println("    ____________________________________________________________");
                }
                else if (command.equals("delete")) {
                    int task_number = Integer.parseInt(parts[1]);
                    Task curr_task = tasks.get(task_number - 1);
                    tasks.remove(task_number - 1);
                    System.out.println("    ____________________________________________________________");
                    System.out.println("    Noted. I've removed this task:");
                    System.out.println("      " + curr_task.toString());
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("    ____________________________________________________________");
                }
                else {
                    throw new DoraemonException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DoraemonException e) {
                System.out.println("    ____________________________________________________________");
                System.out.println("    " + e.getMessage());
            }

        }
    }
}


