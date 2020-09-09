package duke.storage;

import java.util.ArrayList;
import java.util.List;

import duke.main.Command;
import duke.main.Statement;
import duke.task.Task;
import duke.tools.Format;
import duke.tools.FormatString;
import duke.tools.Response;
import duke.tools.Time;

/**
 * This class is to edit the file with a provided path.
 */
public class DukeFileEditor extends DukeFile {

    /**
     * Constructs a DukeFileEditor object.
     *
     * @param path A string which contains
     *             the directory of the file
     *             that is to be read.
     */
    public DukeFileEditor(String path) {
        super(path);
    }

    /**
     * Deletes the task recorded in the file
     * provided by the Directory class
     * with the corresponding line number.
     *
     * @param lineNum The index of task that the user want to
     *                delete.
     */
    public void deleteLine(int lineNum) {
        if (doesFileExist()) {
            List<String> taskStrings = super.readFile();
            taskStrings.remove(lineNum - 1);
            super.write(taskStrings);
        }
    }

    /**
     * Clears all tasks recorded in the file
     * with directory in the FileDirectory in Directory class.
     */
    public void clearFile() {
        List<String> newList = new ArrayList<>();
        super.write(newList);
    }

    /**
     * Sets the corresponding
     * task to be marked as done in Duke.txt.
     *
     * @param lineNum The index of task that the user want to
     *                delete.
     */
    public void setTaskDone(int lineNum) {
        if (doesFileExist()) {
            List<String> taskStrings = readFile();
            String requiredTask = taskStrings.remove(lineNum - 1);

            String editedTask = requiredTask.substring(0, 4)
                    + FormatString.TICK.toString()
                    + requiredTask.substring(5);

            taskStrings.add(lineNum - 1, editedTask);
            write(taskStrings);
        }
    }

    /**
     * Updates the corresponding task and returns the string of the task.
     *
     * @param lineNum The lineNum of the Task shown by list command.
     * @param input The detail that the user wants to change to.
     * @return The string of the Task being updated.
     */
    public String update(int lineNum, String command, String input) {
        List<String> taskStrings = readFile();
        String[] requiredTask = taskStrings.remove(lineNum - 1).split(" ");
        int len = requiredTask.length;
        String editedTask = requiredTask[0] + " ";

        if (command.equals(Command.UPDATEDETAIL.toString())) {
            editedTask += input + " " + requiredTask[len - 2] + requiredTask[len - 1];
        } else if (command.equals(Command.UPDATETIME.toString())) {
            for (int i = 1; i < len - 1; i++) {
                editedTask += requiredTask[i] + " ";
            }
            Time time = new Time(input);
            editedTask += time.toString() + ")";
        } else {
            editedTask = null;
        }

        assert editedTask != null : "command is neither time or detail";

        taskStrings.add(lineNum - 1, editedTask);
        write(taskStrings);
        Task task = new Format<>(editedTask).stringToTask();
        Response response = new Response(
                Statement.UPDATE.toString() + task
        );

        return new Format<>(response).toString();
    }
}
