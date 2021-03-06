package duke.storage;

import java.util.ArrayList;
import java.util.List;

import duke.command.CommandString;
import duke.exception.DukeException;
import duke.task.Task;
import duke.tools.Format;
import duke.tools.FormatString;
import duke.tools.Time;

/**
 * Edits the file with a provided path.
 */
public class DukeFileEditor extends DukeFile {

    /**
     * Constructs a Duke file editor.
     *
     * @param path a string which contains
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
     * @param lineNum the index of task that the user want to
     *                delete.
     * @throws DukeException throws when readFile() or write() has error.
     */
    public void deleteLine(int lineNum) throws DukeException {
        if (doesFileExist()) {
            List<String> taskStrings = super.readFile();
            taskStrings.remove(lineNum - 1);
            super.write(taskStrings);
        }
    }

    /**
     * Clears all tasks recorded in the file
     * with directory in the FileDirectory in Directory class.
     *
     * @throws DukeException throws when write() has error.
     */
    public void clearFile() throws DukeException {
        List<String> newList = new ArrayList<>();
        super.write(newList);
    }

    /**
     * Clears all completed tasks in the file
     *
     * @throws DukeException throws when readFile() or write() has error.
     */
    public void clearDoneTask() throws DukeException {
        if (doesFileExist()) {
            List<Integer> removeList = new ArrayList<>();
            List<String> taskStrings = super.readFile();
            for (int i = 0; i < taskStrings.size(); i++) {
                if (taskStrings.get(i).substring(4, 5).equals(FormatString.TICK.toString())) {
                    removeList.add(i);
                }
            }

            for (int i = removeList.size() - 1; i >= 0; i--) {
                taskStrings.remove(i);
            }
            super.write(new ArrayList<>());
            super.write(taskStrings);
        }
    }

    /**
     * Sets the corresponding
     * task to be marked as done in Duke.txt.
     *
     * @param lineNum the index of task that the user want to
     *                delete.
     * @throws DukeException throws when readFile() or write() has error.
     */
    public void setTaskDone(int lineNum) throws DukeException {
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
     * @param lineNum the lineNum of the Task shown by list command.
     * @param input the detail that the user wants to change to.
     * @return the string of the Task being updated.
     * @throws DukeException throws when readFile() or write() has error.
     */
    public Task update(int lineNum, String command, String input) throws DukeException {
        List<String> taskStrings = readFile();
        String[] requiredTask = taskStrings.remove(lineNum - 1).split(" ");
        int len = requiredTask.length;
        StringBuilder editedTask = new StringBuilder(requiredTask[0] + " ");

        if (command.equals(CommandString.UPDATE_DETAIL)) {
            if (requiredTask[0].substring(1, 2).equals("T")) {
                editedTask.append(input);
            } else {
                editedTask.append(input).append(" ")
                        .append(requiredTask[len - 2])
                        .append(" ")
                        .append(requiredTask[len - 1]);
            }
        } else if (command.equals(CommandString.UPDATE_TIME)) {
            for (int i = 1; i < len - 1; i++) {
                editedTask.append(requiredTask[i]).append(" ");
            }
            Time time = new Time(input);
            editedTask.append(time.toString()).append(")");
        } else {
            editedTask = null;
        }

        assert editedTask != null : "command is neither time or detail";

        taskStrings.add(lineNum - 1, editedTask.toString());
        write(new ArrayList<>());
        write(taskStrings);
        return Format.decodeTask(editedTask.toString());
    }
}
