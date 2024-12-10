import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);

        String[][] bP1 = Board.emptyBoard();
        String[][] bP2 = Board.emptyBoard();
        int P1ShipNo = 0;
        int P2ShipNo = 0;

        boolean addNew = true;

        while (addNew) {
            System.out.println("Type \"a\" to add new ship, \"b\" to see the board, \"p\" to play or \"q\" to quit.");
            String response = ask.nextLine().toLowerCase();

            if (response.equals("a")) {
                while (P1ShipNo < 5) {
                    System.out.println("- - - Creating player 1 ship #" + (P1ShipNo + 1) + " - - -");
                    System.out.println("What length?");
                    int length = Integer.valueOf(ask.nextLine());
                    while (!(length == 2 || length == 3 || length == 4 || length == 5)) {
                        System.out.println("Invalid ship size! Enter length again.");
                        length = Integer.valueOf(ask.nextLine());
                    }

                    System.out.println("Which orientation? Type \"horizontal\" or \"vertical\".");
                    String orientationStr = ask.nextLine();
                    while (!(orientationStr.equals("horizontal") || orientationStr.equals("vertical"))) {
                        System.out.println("Invalid orientation! Enter orientation again.");
                        orientationStr = ask.nextLine();
                    }
                    int orientation = 0;
                    if (orientationStr.equals("horizontal")) {
                        orientation = 1;
                    } else if (orientationStr.equals("vertical")) {
                        orientation = 0;
                    }

                    System.out.println("Which row?");
                    int r = Integer.valueOf(ask.nextLine());
                    while (orientation == 0 && r > 10 - length) {
                        System.out.println("Your ship doesn't fit! Enter row again");
                        r = Integer.valueOf(ask.nextLine());
                    }
                    System.out.println("Which column?");
                    int c = Integer.valueOf(ask.nextLine());
                    while ((orientation == 1 && c > 10 - length)) {
                        System.out.println("Your ship doesn't fit! Enter column again");
                        c = Integer.valueOf(ask.nextLine());
                    }
                    if (!Board.addShip(bP1, r, c, length, orientation)) {
                        System.out.println("Ship overlaps with another ship. Try again.");
                    } else {
                        P1ShipNo++;
                        System.out.println("Board created! Look at your board.");
                        System.out.println(Board.showBoard(bP1));
                    }
                }
                while (P2ShipNo < 5) {
                    System.out.println("- - - Creating player 2 ship #" + (P2ShipNo + 1) + " - - -");
                    System.out.println("What length?");
                    int length = Integer.valueOf(ask.nextLine());
                    while (!(length == 2 || length == 3 || length == 4 || length == 5)) {
                        System.out.println("Invalid ship size! Enter length again.");
                        length = Integer.valueOf(ask.nextLine());
                    }

                    System.out.println("Which orientation? Type \"horizontal\" or \"vertical\".");
                    String orientationStr = ask.nextLine();
                    while (!(orientationStr.equals("horizontal") || orientationStr.equals("vertical"))) {
                        System.out.println("Invalid orientation! Enter orientation again.");
                        orientationStr = ask.nextLine();
                    }
                    int orientation = 0;
                    if (orientationStr.equals("horizontal")) {
                        orientation = 1;
                    } else if (orientationStr.equals("vertical")) {
                        orientation = 0;
                    }

                    System.out.println("Which row?");
                    int r = Integer.valueOf(ask.nextLine());
                    while (orientation == 0 && r > 10 - length) {
                        System.out.println("Your ship doesn't fit! Enter row again");
                        r = Integer.valueOf(ask.nextLine());
                    }
                    System.out.println("Which column?");
                    int c = Integer.valueOf(ask.nextLine());
                    while ((orientation == 1 && c > 10 - length)) {
                        System.out.println("Your ship doesn't fit! Enter column again");
                        c = Integer.valueOf(ask.nextLine());
                    }
                    if (!Board.addShip(bP2, r, c, length, orientation)) {
                        System.out.println("Ship overlaps with another ship. Try again.");
                    } else {
                        P2ShipNo++;
                        System.out.println("Board created! Look at your board.");
                        System.out.println(Board.showBoard(bP2));
                    }
                }
            } else if (response.equals("b")) {
                System.out.println("1: Board for player 1");
                System.out.println("2: Board for player 2");
                int showBoardResponse = Integer.valueOf(ask.nextLine());
                if (showBoardResponse == 1) {
                    System.out.println(Board.showBoard(bP1));
                } else if (showBoardResponse == 2) {
                    System.out.println(Board.showBoard(bP2));
                }
            } else if (response.equals("p")) {
                Board.playGame(bP1, bP2, ask);
            } else if (response.equals("q")) {
                return;
            }
        }
    }
}