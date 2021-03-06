# User Guide

Duke is a desktop chat bot that can help you manage your tasks. It is optimized by a 
Command Line interface and automatic save such that you can note it faster than conventional 
task manager application.  

* [Features](#features)
    * [Task management](#1-task-management)
    * [Task view](#2-task-view)
    * [Various time format support](#3-various-time-format-support)
* [Usage](#usage)
    * [help - view all functions](#view-all-functions)
    * [todo - create a todo task](#todo)
    * [deadline - create a task with a deadline](#deadline)
    * [event - create an event task](#event)
    * [done - mark a task as done](#done)
    * [delete - delete a task](#delete)
    * [list - view all tasks](#list)
    * [clear - delete all tasks](#clear)
    * [find - find the tasks containing keywords from the user](#find)
    * [update - update the detail or time of an existing task](#update)

&nbsp;

------------------------------------------------------------------------------

## Features 

### 1. Task management
Add tasks conveniently with easy commands:
* Assign
    * Simple todo tasks, `todo`.
    * Tasks with deadline, `deadline`.
    * Events to attend, `event`.
* Mark tasks as done, `done`.
* Delete tasks, `delete`.
* Update tasks, `update`.
* Clear all tasks, `clear`

&nbsp;

### 2. Task view
View all tasks via `list`.

&nbsp;

### 3. Various time format support
* Use different time format for the convenience of time.
Supported formats:<br>

&nbsp;

|Format | user input time | output|
|:-----: | :-----: | :----: |
|HHmm | 2359 | Wednesday_Sep_16_2020_23:59| 
|d | 16 | Wednesday_Sep_16_2020_00:00|
|d_HHmm | 16_2300 | Wednesday_Sep_16_2020_23:00|
|M/d | 9/16 | Wednesday_Sep_16_2020_00:00|
|M-d | 9-16 | Wednesday_Sep_16_2020_00:00|
|M/d_HHmm | 9/16_2300 | Wednesday_Sep_16_2020_23:00|
|M-d_HHmm | 9-16_2300 | Wednesday_Sep_16_2020_23:00|
|yyyy-M/d | 2020/9/16 | Wednesday_Sep_16_2020_00:00|
|yyyy-M-d | 2020-9-16 | Wednesday_Sep_16_2020_00:00|
|yyyy/M/d_HHmm | 2020/9/16_2300 | Wednesday_Sep_16_2020_23:00|
|yyyy-M-d_HHmm | 2020-9-16_2300 | Wednesday_Sep_16_2020_23:00|

&nbsp;

* Human communicative language for date and time support.
    * Date support:
        * `today` refers to `00:00` of current date.
        * `tomorrow` refers to `00:00` of the next day of current date.
    * Time support:
        * `morning` refers to `08:00`.
        * `noon` refers to `12:00`.
        * `afternoon` refers to `14:00`.
        * `night` refers to `20:00`.
        * `midnight` refers to `23:59`.
    * Notes: date must be provided before time is used.
    e.g. `today`, `today morning` are supported but `morning` alone is not.

&nbsp;

* Examples are given here.

|Format (Given today is 9/16/2020) | output|
|:-----: | :----: |
|`today`| Wednesday_Sep_16_2020_00:00 |
|`today morning` | Wednesday_Sep_16_2020_08:00 |

&nbsp;

------------------------------------------------------------------------------

## Usage

Command format: <br>
Words surrounded by `<>` are the input from the users.<br>
Words surrounded by `[]` are the command from the users.<br>
e.g. `[todo] <detail>` means the user needs to type `todo detail`, such as `todo work`.

&nbsp;

### View all functions
Show all the functions and respective usage, `help`.

&nbsp;

### `todo` 

`todo` - create a todo task.

Format: `[todo] <detail>`

Example:

* `todo homework` creates a new todo task `homework` that is yet done.

![todoImage](./image/todo.png)

&nbsp;

### `deadline` 

`deadline` - create a task with a deadline.

Format: `[deadline] <space> <detail> <space> </by> <Date and/or time>`

Example:
* `deadline UG /by 16_2359` creates a new deadline task `UG (by:Wednesday_Sep_16_2020_23:59)`
* More time format can be referred in `3.Various time format support`.

![deadlineImage](./image/deadline.png)

&nbsp;

### `event`

`event` - create a event to attend.

Format: `[event] <space> <detail> <space> </on> <Date and/or time>`

Example:
* `event midterm /on 16_1300` creates a new deadline task `midterm (on:Wednesday_Sep_16_2020_13:00)`
* More time format can be referred in `3.Various time format support`.

![eventImage](./image/event.png)

&nbsp;

### `done`

`done` - mark a task as done.

Format: `[done] <index>`

Example:
* `done 1` mark the first task in the list as done.

![doneImage](./image/done.png)

&nbsp;

### `delete`

`delete` - delete a task.

Format: `[delete] <index>`

Example:
*`delete 1` deletes the first task in the list.

![deleteImage](./image/delete.png)

&nbsp;

### `list`

`list` - view all tasks in the list.

Format: `[list]`

![listImage](./image/list.png)

&nbsp;

### `clear`

`clear` - delete all the tasks.

Format: `[clear] <all/done/(leave empty)>`

Example:
* `clear` and `clear all` clears all the tasks in the list.
* `clear done` clears completed tasks only.


![clearAllImage](./image/clear.png)
![clearDoneImage](./image/clearDone.png)

&nbsp;

### `find`

`find` - find the tasks containing each or all keywords from the user.

Format: `[find] <space> <keywords>`

Example:
* `find tutorial lesson` finds tasks that contains `tutorial` or `lesson` or `tutorial lesson`.

![findImage](./image/find.png)

&nbsp;

### `update`

`update` - update the detail or time of an existing task

Format: `[update] <space> <index> <space> <detail/time> <space> </to> <content>`

Example: 
* `update 2 detail /to CS2103T lesson` update the detail of the 2nd task to `CS2103T lesson`. 
* `update 3 time /to 1600` update the time of the 3rd task to `1600` of the present day.

![updateDetailImage](./image/update_detail.png)
![updateTimeImage](./image/update_time.png)

&nbsp;

### `bye`

`bye` - exit the program

Format: `bye`

![byeImage](./image/bye.png)