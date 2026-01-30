package doraemon;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException {
        ui.showListOfTasks(tasks);
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
