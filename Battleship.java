import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Battleship! Both players will have four ships:\n"
                + "a 5x1 ship, a 4x1 ship, a 3x1 ship, and a 2x1 ship."
                + "\nBoth players, please type in the beginning coordinates of your four ships.\n");

        Scanner console = new Scanner(System.in);
        String[][] arr1a = new String[10][10];
        String[][] arr1b = new String[10][10];
        String[][] arr2a = new String[10][10];
        String[][] arr2b = new String[10][10];
        boolean bool = true;
        int a;
        int xShip = 0, yShip = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr1a[i][j] = "- ";
                arr2a[i][j] = "- ";
                arr1b[i][j] = "- ";
                arr2b[i][j] = "- ";
            }
        }

        System.out.print("  ");
        for (int f = 0; f < 10; f++) {
            System.out.print(f + " ");
        }
        System.out.println();
        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
            for (int d = 0; d < 10; d++) {
                System.out.print(arr1a[c][d]);
            }
            System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            bool = true;

            while (bool) {
                System.out.println(
                        "\nPlayer 1: Please type the X-Value from 0-9, going from left to right,\nfollowed by the Y-Value from 0-9,"
                                + "going from top to bottom.\nPlayer 1's next ship's beginning coordinates:\n");

                while (bool) {
                    try {
                        yShip = console.nextInt();
                        xShip = console.nextInt();
                        bool = false;
                    } catch (Exception e) {
                        System.out.println("That's not a coordinate on the board! Try again.");
                        console.next();
                        bool = true;
                    }
                }
                bool = true;

                if (xShip > 9 || yShip < 0 || yShip > 9 || xShip < 0) {
                    System.out.println("\nSorry, this ship is out of bounds. Try again.\n");
                    i--;
                    break;
                } else if (arr1a[xShip][yShip] == "O " || arr1a[xShip][yShip] == "O ") {
                    System.out.println("\nSorry, this ship interferes with another ship. Try again.\n");
                    i--;
                    break;
                } else {
                    System.out.println("\nDo you want your ship to be horizontal or vertical?");
                    String output = console.next();
                    if (output.equalsIgnoreCase("vertical")) {
                        System.out.println("\nDo you want your ship to be built upwards or downwards?");
                        output = console.next();
                        if (output.equalsIgnoreCase("upwards")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (xShip - a < 0 || xShip - a > 9) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;

                                } else if (arr1a[xShip - a][yShip] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                                if (a >= 4 - i) {
                                    for (a = 0; a < 5 - i; a++) {
                                        arr1a[xShip - a][yShip] = "O ";
                                        if (a == 4 - i) {
                                            bool = false;
                                        }
                                    }
                                }
                            }
                        } else if (output.equalsIgnoreCase("downwards")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (xShip + a < 0 || xShip + a > 9) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;
                                } else if (arr1a[xShip + a][yShip] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                                if (a >= 4 - i) {
                                    for (a = 0; a < 5 - i; a++) {
                                        arr1a[xShip + a][yShip] = "O ";
                                        if (a == 4 - i) {
                                            bool = false;
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out
                                    .println("\nPlease type either \"upwards\" or \"downwards\" next time. Try again.");
                        }

                    } else if (output.equalsIgnoreCase("horizontal")) {
                        System.out.println("\nDo you want your ship to be built going left or right?");
                        output = console.next();
                        if (output.equalsIgnoreCase("left")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (yShip - a > 9 || yShip - a < 0) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;
                                } else if (arr1a[xShip][yShip - a] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                            }
                            if (a >= 4 - i) {
                                for (a = 0; a < 5 - i; a++) {
                                    arr1a[xShip][yShip - a] = "O ";
                                    if (a == 4 - i) {
                                        bool = false;
                                    }
                                }
                            }
                        } else if (output.equalsIgnoreCase("right")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (yShip + a > 9 || yShip + a < 0) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;
                                } else if (arr1a[xShip][yShip + a] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                            }
                            if (a >= 4 - i) {
                                for (a = 0; a < 5 - i; a++) {
                                    arr1a[xShip][yShip + a] = "O ";
                                    if (a == 4 - i) {
                                        bool = false;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Please type either \"left\" or \"right\" next time. Try again.");
                            i--;
                            break;
                        }

                    } else {
                        System.out.println("Please type either \"horizontal\" or \"vertical\" next time. Try again.");
                        i--;
                        break;
                    }
                }
                System.out.println("\nPlayer 1's ship(s):\n");

                break;
            }

            System.out.print("  ");
            for (int f = 0; f < 10; f++) {
                System.out.print(f + " ");
            }
            System.out.println();
            for (int c = 0; c < 10; c++) {
                System.out.print(c + " ");
                for (int d = 0; d < 10; d++) {
                    System.out.print(arr1a[c][d]);
                }
                System.out.println();
            }

        }

        System.out.print("\n\n\n\n  ");
        for (int f = 0; f < 10; f++) {
            System.out.print(f + " ");
        }
        System.out.println();
        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
            for (int d = 0; d < 10; d++) {
                System.out.print(arr1b[c][d]);
            }
            System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            bool = true;

            while (bool) {
                System.out.println(
                        "\nPlayer 2: Please type the X-Value from 0-9, going from left to right,\nfollowed by the Y-Value from 0-9,"
                                + "going from top to bottom.\nPlayer 2's next ship's beginning coordinates:\n");

                while (bool) {
                    try {
                        yShip = console.nextInt();
                        xShip = console.nextInt();
                        bool = false;
                    } catch (Exception e) {
                        System.out.println("That's not a coordinate on the board! Try again.");
                        console.next();
                        bool = true;
                    }
                }
                bool = true;

                if (xShip > 9 || yShip < 0 || yShip > 9 || xShip < 0) {
                    System.out.println("\nSorry, this ship is out of bounds. Try again.\n");
                    i--;
                    break;
                } else if (arr2a[xShip][yShip] == "O " || arr2a[xShip][yShip] == "O ") {
                    System.out.println("\nSorry, this ship interferes with another ship. Try again.\n");
                    i--;
                    break;
                } else {
                    System.out.println("\nDo you want your ship to be horizontal or vertical?");
                    String output = console.next();
                    if (output.equalsIgnoreCase("vertical")) {
                        System.out.println("\nDo you want your ship to be built upwards or downwards?");
                        output = console.next();
                        if (output.equalsIgnoreCase("upwards")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (xShip - a < 0 || xShip - a > 9) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;

                                } else if (arr2a[xShip - a][yShip] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                                if (a >= 4 - i) {
                                    for (a = 0; a < 5 - i; a++) {
                                        arr2a[xShip - a][yShip] = "O ";
                                        if (a == 4 - i) {
                                            bool = false;
                                        }
                                    }
                                }
                            }
                        } else if (output.equalsIgnoreCase("downwards")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (xShip + a < 0 || xShip + a > 9) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;
                                } else if (arr2a[xShip + a][yShip] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                                if (a >= 4 - i) {
                                    for (a = 0; a < 5 - i; a++) {
                                        arr2a[xShip + a][yShip] = "O ";
                                        if (a == 4 - i) {
                                            bool = false;
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out
                                    .println("\nPlease type either \"upwards\" or \"downwards\" next time. Try again.");
                        }

                    } else if (output.equalsIgnoreCase("horizontal")) {
                        System.out.println("\nDo you want your ship to be built going left or right?");
                        output = console.next();
                        if (output.equalsIgnoreCase("left")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (yShip - a > 9 || yShip - a < 0) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;
                                } else if (arr2a[xShip][yShip - a] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                            }
                            if (a >= 4 - i) {
                                for (a = 0; a < 5 - i; a++) {
                                    arr2a[xShip][yShip - a] = "O ";
                                    if (a == 4 - i) {
                                        bool = false;
                                    }
                                }
                            }
                        } else if (output.equalsIgnoreCase("right")) {
                            for (a = 0; a < 5 - i; a++) {
                                if (yShip + a > 9 || yShip + a < 0) {
                                    System.out.println("\nSorry, this ship is out of bounds. Try again.");
                                    i--;
                                    break;
                                } else if (arr2a[xShip][yShip + a] == "O ") {
                                    System.out.println("\nSorry, this ship interferes with another ship. Try again.");
                                    i--;
                                    break;
                                }
                            }
                            if (a >= 4 - i) {
                                for (a = 0; a < 5 - i; a++) {
                                    arr2a[xShip][yShip + a] = "O ";
                                    if (a == 4 - i) {
                                        bool = false;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Please type either \"left\" or \"right\" next time. Try again.");
                            i--;
                            break;
                        }

                    } else {
                        System.out.println("Please type either \"horizontal\" or \"vertical\" next time. Try again.");
                        i--;
                        break;
                    }
                }
                System.out.println("\nPlayer 1's ship(s):\n");

                break;
            }

            System.out.print("  ");
            for (int f = 0; f < 10; f++) {
                System.out.print(f + " ");
            }
            System.out.println();
            for (int c = 0; c < 10; c++) {
                System.out.print(c + " ");
                for (int d = 0; d < 10; d++) {
                    System.out.print(arr2a[c][d]);
                }
                System.out.println();
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr1b[i][j] = "- ";
            }
        }

        int currentx = 0, currenty = 0;
        boolean check = true;
        int count = 2;
        int hitCount1 = 0;
        int hitCount2 = 0;

        System.out.println("\n\n\n\nNow time to guess coordinates and sink your opponent's ships!\n"
                + "If a player hits a ship, it will show up as an \"O\" character.\nIf a player"
                + " misses the ships, it will show up as an \"X\" character.\n");

        System.out.print("  ");
        for (int f = 0; f < 10; f++) {
            System.out.print(f + " ");
        }
        System.out.println();

        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
            for (int d = 0; d < 10; d++) {
                System.out.print(arr1b[c][d]);
            }
            System.out.println();
        }

        while (check) {
            try {

                if (count % 2 == 0) {
                    System.out.println("\nPlayer 1, here are your guesses so far:\n");
                    System.out.print("  ");
                    for (int f = 0; f < 10; f++) {
                        System.out.print(f + " ");
                    }
                    System.out.println();

                    for (int c = 0; c < 10; c++) {
                        System.out.print(c + " ");
                        for (int d = 0; d < 10; d++) {
                            System.out.print(arr1b[c][d]);
                        }
                        System.out.println();
                    }
                    System.out.println("\nPlayer 1, guess Player 2's ships with a set of coordinates:\n");
                    currenty = console.nextInt();
                    currentx = console.nextInt();

                    if (arr1b[currentx][currenty] == "$ " || arr1b[currentx][currenty] == "X ") {
                        System.out.println("You already guessed that! Try again.");
                    } else if (arr2a[currentx][currenty] == "O ") {
                        System.out.println("\nHit! Go again!\n");
                        arr1b[currentx][currenty] = "$ ";
                        hitCount1++;

                        System.out.print("  ");
                        for (int i = 0; i < 10; i++) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                        for (int c = 0; c < 10; c++) {
                            System.out.print(c + " ");
                            for (int d = 0; d < 10; d++) {
                                System.out.print(arr1b[c][d]);
                            }
                            System.out.println();
                        }
                    } else if (arr2a[currentx][currenty] == "- ") {
                        System.out.println("\nMiss!\n");
                        arr1b[currentx][currenty] = "X ";
                        count++;

                        System.out.print("  ");
                        for (int i = 0; i < 10; i++) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                        for (int c = 0; c < 10; c++) {
                            System.out.print(c + " ");
                            for (int d = 0; d < 10; d++) {
                                System.out.print(arr1b[c][d]);
                            }
                            System.out.println();
                        }
                    }
                    if (hitCount1 == 14) {
                        System.out.println("\nPlayer 1 wins!\n");
                        foolean = false;
                    }
                } else {
                    System.out.println("\nPlayer 2, here are your guesses so far:\n");
                    System.out.print("  ");
                    for (int f = 0; f < 10; f++) {
                        System.out.print(f + " ");
                    }
                    System.out.println();

                    for (int c = 0; c < 10; c++) {
                        System.out.print(c + " ");
                        for (int d = 0; d < 10; d++) {
                            System.out.print(arr2b[c][d]);
                        }
                        System.out.println();
                    }
                    System.out.println("\nPlayer 2, guess Player 1's ships with a set of coordinates:\n");
                    currenty = console.nextInt();
                    currentx = console.nextInt();

                    if (arr2b[currentx][currenty] == "$ " || arr2b[currentx][currenty] == "X ") {
                        System.out.println("You already guessed that! Try again.");
                    } else if (arr1a[currentx][currenty] == "O ") {
                        System.out.println("\nHit! Go again!\n");
                        arr2b[currentx][currenty] = "$ ";
                        hitCount2++;

                        System.out.print("  ");
                        for (int i = 0; i < 10; i++) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                        for (int c = 0; c < 10; c++) {
                            System.out.print(c + " ");
                            for (int d = 0; d < 10; d++) {
                                System.out.print(arr2b[c][d]);
                            }
                            System.out.println();
                        }
                    } else if (arr1a[currentx][currenty] == "- ") {
                        System.out.println("\nMiss!\n");
                        arr2b[currentx][currenty] = "X ";
                        count++;

                        System.out.print("  ");
                        for (int i = 0; i < 10; i++) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                        for (int c = 0; c < 10; c++) {
                            System.out.print(c + " ");
                            for (int d = 0; d < 10; d++) {
                                System.out.print(arr2b[c][d]);
                            }
                            System.out.println();
                        }
                    }
                    if (hitCount2 == 14) {
                        System.out.println("\nPlayer 2 wins!\n");
                        check = false;
                    }
                }

            } catch (Exception e) {
                System.out.println("That's not a coordinate on the board! Try again.");
                console.close();
                console = new Scanner(System.in);
            }
        }
        console.close();
    }
}
