public enum Status {
    GREET {
        @Override
        public String toString() {
            return "    Wonderful! It is nice to see you! \n" +
                    "    Is there anything I can help?";
        }
    },

    BYE {
        @Override
        public String toString() {
            return "    It is nice to talk to you. \n" +
                    "    Hope to see you again!";
        }
    },

    ADD {
        @Override
        public String toString() {
            return "    added: ";
        }
    },

    LIST {
        @Override
        public String toString() {
            return "    Here are the tasks in your list:\n";
        }
    },

    DONE {
        @Override
        public String toString() {
            return "    Nice! I've marked this task as done: \n" +
                    "      ";
        }
    },

    EXCESS {
        @Override
        public String toString() {
            return "    Oops, seems like you don't have this option \n" +
                    "    enter list to see options";
        }
    },

    CLASSCASTEXCEPTION {
        @Override
        public String toString() {
            return "    the content is not of data type of String";
        }
    },

    NUMBERFORMATEXCEPTION {
        @Override
        public String toString() {
            return "    Oops, the format of your index number is incorrect";
        }
    }




}
