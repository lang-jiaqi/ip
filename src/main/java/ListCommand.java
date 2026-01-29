public class ListCommand extends Command {
    private TaskList taskList;

    public ListCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        ui.showListOfTasks(taskList);
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
