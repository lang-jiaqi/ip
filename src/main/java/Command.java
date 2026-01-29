/**
 * An abstract class af all command
 */
public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DoraemonException;

    public abstract boolean isExit();
}
