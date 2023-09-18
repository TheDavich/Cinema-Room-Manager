# Cinema Ticket Booking System

This is a cinema ticket booking system implemented in Java. It allows users to view available seats, purchase tickets, and view statistics. The system provides a simple command-line interface for interaction.

## Features

1. Show the Seats: Users can view the seating arrangement of the cinema.

2. Buy a Ticket: Users can purchase tickets by specifying the row and seat number. The system validates the input, checks seat availability, and calculates the ticket price based on the seating arrangement.

3. Statistics: Users can view statistics such as the number of purchased tickets, the percentage of occupancy, current income, and total income.

## Getting Started

To run the cinema ticket booking system, follow these steps:

1. Ensure you have Java installed on your system.

2. Download or clone the repository containing the code.

3. Compile the `Cinema.java` file using the Java compiler:
   ```
   javac Cinema.java
   ```

4. Run the compiled code:
   ```
   java Cinema
   ```

5. Follow the prompts on the command line to interact with the cinema ticket booking system.

## Usage

1. Upon running the program, you will be prompted to enter the number of rows and seats in each row of the cinema.

2. Once the cinema seating arrangement is initialized, you will see a menu with the following options:
   - Show the seats: Displays the current seating arrangement.
   - Buy a ticket: Allows you to purchase a ticket by specifying the row and seat number.
   - Statistics: Shows statistics about ticket sales and income.
   - Exit: Terminates the program.

3. Select the desired option by entering the corresponding number.

4. Follow the instructions provided by the system to complete the chosen action.

## Example

Here's an example interaction with the cinema ticket booking system:

```
Enter the number of rows:
5
Enter the number of seats in each row:
6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
Enter the number corresponding to your choice: 1

Cinema:
   1 2 3 4 5 6
1  S S S S S S
2  S S S S S S
3  S S S S S S
4  S S S S S S
5  S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
Enter the number corresponding to your choice: 2

Enter a row number: 3
Enter a seat number in that row: 4

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
Enter the number corresponding to your choice: 1

Cinema:
   1 2 3 4 5 6
1  S S S S S S
2  S S S S S S
3  S S S B S S
4  S S S S S S
5  S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
Enter the number corresponding to your choice: 3

Number of purchased tickets: 1
Percentage: 3.33%
Current income: $10
Total income: $300

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
Enter the number corresponding to your choice: 0

Thank you for using the cinema ticket booking system!
```

## Author

This cinema ticket booking system was developed by KYZTEK Akhmet-Davud.
