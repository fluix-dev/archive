Avid Dev
August 15, 2019
Budgeting App

Files:
  Main.java, Goal.java, Transaction.java
    These files are the java source code files. Most of the functionality,
    along with the main method are in the Main.java file. The Transaction.java
    file is a class for creating transactions which store their name, category,
    amount, and date. The Goal.java file is another class which is used to store
    goals and their names, category, amounts, and priorities.
  categories.txt
    A file to store all categories the user has created. First line is amount
    of categories (n), followed by n lines, each line a string (the category
    name).
  transactions.txt
    A file to store all transactions (income + expense). The first line is
    the number of transactions (n), followed by n*5 lines. Each group of five
    lines contains the name of the transaction, the cateory, the amount,
    the date, stored as dd/MM/yyyy, and a blank line.
  goals.txt
    A file to store all goals. The first line is number of goals (n), followed
    by n*5 lines. Each group of five lines contains the name of the goal, the
    category, the amount, the priority, and a blank line.
  plans.txt
    A file to store all plans. The first line is the number of entries (categories, n).
    The next n lines contain the planned amount of spending for the category with the
    same id.

  A quick note on the files: If any file fails to be read correctly, they will
  all be reset to their original state. This means that they will all have a 0
  on their first line, and a blank second line. However, no bug has been discovered
  that could cause this.

  The above will also occur if the file(s) don't exist.

Goal:
  The goal of this program is to make it easier for a user to keep track of
  their day-to-day transactions. It also makes it easy for the user to plan ahead
  for how much they want to spend during the month, along with goals that they
  can save up for. Output menus allow the user to visualize everything they need
  in a quick and efficient way. The program also allows custom categories.

Coding:
  The program was coded with the idea that nothing but basic object were stored.
  Any calculations done and then displayed happened when necessary. This was done
  so that every time a value was updated (ie. a transaction/goal was added), these
  values did not have to be updated. Instead, these values can be calculated when
  the user requests for them. Objects (Transaction, Goal) were also used to eliminate
  the need to constantly convert between strings and different types, as would be
  necessary if one used a 2D array. This made the code cleaner and easier to read.

Install:
  When you install the program, you should expect to see a message welcoming you
  for the first time (or stating that your files are corrupt). Once this message
  appears, feel free to press <ENTER> and see the main menu. From here, explore
  as you wish and get a feeling for how to use the program. If you ever want to start
  from a clean slate, DELETE transactions.txt, goals.txt, plans.txt, and categories.txt
  or make one of these files invalid.

Uniqueness:
  This budgeting software allows you to give priority to certain goals over others.
  This is done on a scale from 1-100 which the user enters when creating a goal.
  Then, once the user chooses to display the goals View > Planning & Goals, their
  savings will be split across the goals based on priority. The higher the priority,
  the larger the portion of money that is displayed for the goal. Technically, this
  is done as follows [Lines 395-410 & 421 Main.java]:

    All priorities are added up (totalPriority).
    All savings are calculated (savings) - current balance, excluding current month.
    A savings per priority is calculated (priorityValue) by dividing savings by totalPriority.
    For every goal, savings towards that goal is calcuted (priority * priorityValue).

Problems & Bugs (Features) & Issues:
  With the ability to remove and modify categories, many problems came along.
  Firstly, it was imperative that the plan got updated with the categories.
  This meant that every time a category was added, an 0 value was added to the plan.
  Whenever a category was removed, its corresponding plan value was removed and
  both arrays were shifted. This also caused the bug described in the Beta testing
  stage.

  When using this program, you may find that you cannot exit a sub-menu or cancel
  your task. This is not a bug, but I wouldn't really call it a feature either.
  If you would like to return back to the main menu, or cancel what you are doing
  (ie. creating a transaction), you can safely quit the program and start it again.
  You will not lose any work as saving happens every time the press <ENTER>
  prompt is shown.

  No known bugs are currently in the system, but certain tasks were not completed.
  Primarily, the binary search for searching dates was not done, as described in
  the last journal entry. This does not affect the functionality of the software,
  other than maybe slowing it down when searching for dates on a large amount of
  transactions. Additionally, some of the methods could have been slightly cleaned
  up, such as moving all of the transaction printing to a method inside of the
  Transaction class.

  Visually, any of the menus involving selecting dates are quite clunky because they
  show all months between the first and last transaction. Also, not all of the menu
  options are quite clear. If I had more time, I would try to explain what the
  different functions do and allow a way to exit any prompt (perhaps with ':q').