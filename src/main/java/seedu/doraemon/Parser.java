public class Parser {
    public static Command parse(String fullCommand) throws DoraemonException {
        String[] parts = fullCommand.trim().split(" ", 2);
        String commandWord = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";

        switch (commandWord) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "mark":
                try{
                    int idx = Integer.parseInt(parts[1]);
                    return new MarkCommand(idx);
                } catch (NumberFormatException e){
                    throw new DoraemonException("Invalid index:" + arguments);
                }
            case "unmark":
                try{
                    int idx = Integer.parseInt(parts[1]);
                    return new UnmarkCommand(idx);
                } catch (NumberFormatException e){
                    throw new DoraemonException("Invalid index:" + arguments);
                }
            case "delete":
                try{
                    int idx = Integer.parseInt(parts[1]);
                    return new DeleteCommand(idx);
                } catch (NumberFormatException e){
                    throw new DoraemonException("Invalid index:" + arguments);
                }
            case "todo":
                if(arguments.isEmpty()) throw new DoraemonException("The description of a todo cannot be empty");
                ToDo todo = new ToDo(arguments);
                return new AddCommand(todo);
            case "deadline":
                String[] dParts = arguments.split(" / ", 2);
                if(dParts.length != 2) throw new DoraemonException("Deadline format: description / by date");
                Deadline deadline = new Deadline(dParts[0], dParts[1]);
                return new AddCommand(deadline);
            case "event":
                String[] eParts = arguments.split(" / ", 3);
                if(eParts.length != 3) throw new DoraemonException("Event format: description / from start / to end");
                Event event = new Event(eParts[0], eParts[1], eParts[2]);
                return new AddCommand(event);
            default:
                throw new DoraemonException("Unknown command: " + commandWord);

        }




    }
}
