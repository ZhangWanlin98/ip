package Duke.main;

import Duke.exception.DukeException;
import Duke.task.Deadline;
import Duke.task.Event;
import Duke.task.Task;
import Duke.task.Todo;

/**
 * This class handles the final format
 * that is printed out by Duke
 *
 * @param <T>: T is the data type of the input.
 */
public class Formating<T> {
    private final T content;

    /**
     * Initialize Formating object with content.
     *
     * @param content object of any type.
     */
    public Formating(T content) {
        this.content = content;
    }

    /**
     * Returns the content in the format.
     *
     * @return content.
     */
    public T getContent() {
        return this.content;
    }

    /**
     * This method only can be used when the content
     * is of the type of String.
     *
     * Returns a Formating object whose content has been
     * shortened by eliminating the extra spaces at the
     * beginning of the content and at the end of the content.
     *
     * @return The above described Formating object.
     */
    public Formating<String> shorten() {
        try {
            String input = (String) content;
            int length = input.length();
            int frontPos = 0;
            int backPos = length - 1;
            while (frontPos < length && input.charAt(frontPos) == ' ') {
                frontPos++;
            }

            while (backPos >= 0 && input.charAt(backPos) == ' ') {
                backPos--;
            }

            if (frontPos > backPos) {
                return new Formating<>("");
            }
            return new Formating<>(input.substring(frontPos, backPos + 1));
        } catch (ClassCastException e) {
            DukeException.classCastException();
            return null;
        }
    }

    /**
     * This method only can be used when the content
     * is of the type of String.
     *
     * Returns Task whose output of toString method
     * is equal to the content.
     *
     * @return Task whose output of toString method
     *         is equal to the content.
     */
    public Task stringToTask() {
        try {
            String input = (String) content;
            String[] inputArray = input.split(" ");
            char typeOfTask = inputArray[0].charAt(1);
            boolean isDone = false;
            if (inputArray[0].substring(4, 5).equals("\u2713")) {
                isDone = true;
            }

            Task task;
            if (typeOfTask == 'T') {
                task = new Todo(inputArray[1]);
            } else {
                int lenOfArray = inputArray.length;
                int lenOfLastInArray = inputArray[lenOfArray - 1].length();
                String time = inputArray[lenOfArray - 1]
                        .substring(0, lenOfLastInArray - 1)
                        .substring(0, lenOfLastInArray - 1);
                if (typeOfTask == 'D') {
                    task = new Deadline(inputArray[1], time);
                } else {
                    task = new Event(inputArray[1], time);
                }
            }
            if (isDone) {
                task.setDone();
            }
            return task;
        } catch (ClassCastException e) {
            DukeException.classCastException();
            return null;
        }
    }

    @Override
    public String toString() {
        String underscore =
                "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        if (this.content instanceof Task) {

            return underscore + "\n" +
                    Status.TASKADDED.toString() +
                    content + "\n" +
                    String.format(Status.REPORT.toString(), Parser.taskList.getTaskList().size()) +
                    "\n" +
                    underscore;
        }

        return underscore + "\n" +
                content + "\n" +
                underscore;
    }
}

