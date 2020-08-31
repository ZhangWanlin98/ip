package Duke.exception;

import Duke.main.Format;

/**
 * This class consists all exceptions related to Duke input.
 */
public class DukeException {
    public static void classCastException() {
        System.out.println(new Format<>(Exceptions.CLASSCASTEXCEPTION.toString()));
    }

    public static void numberFormatException() {
        System.out.println(new Format<>(Exceptions.NUMBERFORMATEXCEPTION.toString()));
    }

    public static void numberExcessException() {
        System.out.println(new Format<>(Exceptions.NUMBEREXCESSEXCEPTION.toString()));
    }

    public static void emptyTaskException() {
        System.out.println(new Format<>(Exceptions.EMPTYTASKEXCEPTION.toString()));
    }

    public static void inputFormatException() {
        System.out.println(new Format<>(Exceptions.INPUTFORMATEXCEPTION.toString()));
    }

    public static void timeMissingException() {
        System.out.println(new Format<>(Exceptions.NOTIMEEXCEPTION.toString()));
    }

    public static void FileException() {
        System.out.println(new Format<>(Exceptions.FILEEXCEPTION.toString()));
    }

    public static void ReadLineException() {
        System.out.println(new Format<>(Exceptions.READLINEEXCEPTION.toString()));
    }


    public static void timeFormatException() {
        System.out.println(new Format<>(Exceptions.TIMEFORMATEXCEPTION.toString()));
    }
}
