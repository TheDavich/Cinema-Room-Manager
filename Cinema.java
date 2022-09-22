package cinema;


import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seatsEachRow = scanner.nextInt();
        char[][] room = new char[rows][seatsEachRow];
        fillRoom(room);
        System.out.println();
        printRoom(room);
        runAppMenu(room);
    }

    private static void runAppMenu(char[][] room) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    printRoom(room);
                    break;
                case 2:
                    buyTicket(room);
                    break;
                case 3:
                    statistics(room);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Operation Try again!!");
                    break;
            }
        }
    }

    private static void statistics(char[][] room) {
        int numberOfPurchasedTickets = getNumberOfPurchasedTickets(room);
        double percentage = getPercentage(room, numberOfPurchasedTickets);
        int currentIncome = getCurrentIncome(room);
        int totalIncome = getTotalIncome(room);

        System.out.printf("Number of purchased tickets: %d\n", numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);
        System.out.println();
    }

    private static double getPercentage(char[][] room, int numberOfPurchasedTickets) {
        double percentage;
        int row = room.length;
        int col = room[0].length;
        int numberOfSeats = row * col;
        percentage = (double) (numberOfPurchasedTickets * 100) / numberOfSeats;
        return percentage;
    }

    private static int getCurrentIncome(char[][] room) {
        int currentIncome = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (room[i][j] == 'B') {
                    currentIncome += getTicketPrice(room, i, j);
                }
            }
        }
        return currentIncome;
    }

    private static int getNumberOfPurchasedTickets(char[][] room) {
        int count = 0;
        for (char[] chars : room) {
            for (int j = 0; j < room[0].length; j++) {
                if (chars[j] == 'B') {
                    count++;
                }
            }
        }

        return count;
    }

    private static void buyTicket(char[][] room) {
        boolean success = false;
        while (!success) {
            System.out.println("Enter a row number:");
            int rowNumber = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            int seatNumber = scanner.nextInt() - 1;
            System.out.println();
            if (isWrongInput(room, rowNumber, seatNumber)) {
                System.out.println("Wrong input!");
            } else if (hasPurchased(room, rowNumber, seatNumber)) {
                System.out.println("That ticket has already been purchased!");
            } else {
                int ticketPrice = getTicketPrice(room, rowNumber, seatNumber);
                room[rowNumber][seatNumber] = 'B';
                System.out.printf("Ticket price: $%d\n", ticketPrice);
                success = true;
            }
            System.out.println();
        }

    }

    private static boolean hasPurchased(char[][] room, int rowNumber, int seatNumber) {
        return room[rowNumber][seatNumber] == 'B';
    }


    private static boolean isWrongInput(char[][] room, int rowNumber, int seatNumber) {
        return rowNumber < 0 || rowNumber > room.length - 1 || seatNumber < 0 || seatNumber > room[0].length - 1;
    }

    private static int getTicketPrice(char[][] room, int rowNumber, int seatNumber) {

        int row = room.length;
        int col = room[0].length;

        if (isLarger(row, col)) {
            int[][] prices = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    prices[i][j] = 8;

                }
            }

            for (int i = 0; i < row / 2; i++) {
                for (int j = 0; j < col; j++) {
                    prices[i][j] = 10;
                }
            }
            return prices[rowNumber][seatNumber];
        }

        return 10;
    }

    private static int getTotalIncome(char[][] room) {
        int rows = room.length;
        int seatsEachRow = room[0].length;

        int totalIncome;
        if (isLarger(rows, seatsEachRow)) {
            int frontHalf = rows / 2;
            int backHalf = rows - frontHalf;
            totalIncome = frontHalf * seatsEachRow * 10 + backHalf * seatsEachRow * 8;
        } else {
            totalIncome = rows * seatsEachRow * 10;
        }
        return totalIncome;
    }

    private static boolean isLarger(int rows, int seatsEachRow) {
        return rows * seatsEachRow > 60;
    }


    private static void fillRoom(char[][] room) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                room[i][j] = 'S';
            }
        }
    }

    private static void printRoom(char[][] room) {
        System.out.println("Cinema:");
        System.out.print("  ");

        for (int i = 0; i < room[0].length; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < room.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < room[0].length; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}