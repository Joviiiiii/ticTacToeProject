public class Board {
    /* A class representation of a TicTacToe board.
    The board is a 9 element array. The constructor (provided)
    initializes these values to the strings "1", "2", ... "9".
    When a player makes a move on the board, that element in the
    array should be replaced by "X" or "O" respectively.
    https://en.wikipedia.org/wiki/Tic-tac-toe

    Complete the isEmptyPosition(pos), displayBoard(), winner(),
    and applyMove(move) methods.
    */
    public String[] board = new String[9];

    /**
    * The board is initialized to hold strings containing numbers
    * ["1" "2" "3" "4" "5" "6" "7" "8" "9"]
    */
    public Board() {
        for (int a = 0; a < 9; a++) {
            this.board[a] = String.valueOf(a + 1);
        }
    }

    /**
     * // TODO: Return if the desired position has not been filled yet.
     * @param pos the desired position 1-9
     * @return true if an X or O has already been placed at the position,
     *         or false a number is at the position.
     */
    public boolean isEmptyPosition(int pos) {
        if (board[pos-1].equals("O") || board[pos-1].equals("X") || pos > 9 || pos < 1){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * TODO: Display the current board in the console.
     */
    public void displayBoard() {
        /* An example of what an in progress game may look like:
        |---|---|---|
        | 1 | X | O |
        |-----------|
        | 4 | 5 | X |
        |-----------|
        | 7 | 8 | O |
        |---|---|---|
         */
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | " );
        System.out.println("|---|---|---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " | " );
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | " +board[7] + " | " + board[8] + " | " );
        System.out.println("|---|---|---|");
    }

    /**
     * TODO: Return the winner of the game or null.
     * @return "X" or "O" if a respective player has achieved 3 in a row,
     *         "draw" if the board is full and no player won,
     *         or null if there is no winner.
     */

    //These are a series of helper function that determines all possibility for a player to win or draw
    public boolean checkWinnerFirstRow(String playerLetter) {
        return (board[0].equals(playerLetter) && board[1].equals(playerLetter) && board[2].equals(playerLetter));
    }
    public boolean checkWinnerSecondRow(String playerLetter) {
        return (board[3].equals(playerLetter) && board[4].equals(playerLetter) && board[5].equals(playerLetter));
    }
    public boolean checkWinnerThirdRow(String playerLetter) {
        return (board[6].equals(playerLetter) && board[7].equals(playerLetter) && board[8].equals(playerLetter));
    }
    public boolean checkWinnerFirstColumn(String playerLetter) {
        return (board[0].equals(playerLetter) && board[3].equals(playerLetter) && board[6].equals(playerLetter));
    }
    public boolean checkWinnerSecondColumn(String playerLetter) {
        return (board[1].equals(playerLetter) && board[4].equals(playerLetter) && board[7].equals(playerLetter));
    }
    public boolean checkWinnerThirdColumn(String playerLetter) {
        return (board[2].equals(playerLetter) && board[5].equals(playerLetter) && board[8].equals(playerLetter));
    }
    public boolean checkWinnerDiagonalUp(String playerLetter) {
        return (board[2].equals(playerLetter) && board[4].equals(playerLetter) && board[6].equals(playerLetter));
    }
    public boolean checkWinnerDiagonalDown(String playerLetter) {
        return (board[0].equals(playerLetter) && board[4].equals(playerLetter) && board[8].equals(playerLetter));
    }

    //The helper function draw checks if all spots on board are filled
    //This function is used after verify all possible winning scenarios are invalid
    public boolean draw (){
        for (int i = 1; i < 10; i++){
            if (isEmptyPosition(i)){
                return false;
            }
        }
        return true;

    }

        public String winner() {
            if(checkWinnerFirstRow("X")){
                return "X";
            }
            else if(checkWinnerFirstRow("O")){
                return "O";
            }
            else if(checkWinnerSecondRow("X")){
                return "X";
            }
            else if(checkWinnerSecondRow("O")){
                return "O";
            }
            else if(checkWinnerThirdRow("O")){
                return "O";
            }
            else if(checkWinnerThirdRow("X")){
                return "X";
            }
            else if(checkWinnerFirstColumn("O")){
                return "O";
            }
            else if(checkWinnerFirstColumn("O")){
                return "O";
            }
            else if(checkWinnerSecondColumn("X")){
                return "X";
            }
            else if(checkWinnerSecondColumn("O")){
                return "O";
            }
            else if(checkWinnerThirdRow("X")){
                return "X";
            }
            else if(checkWinnerThirdRow("O")){
                return "O";
            }
            else if(checkWinnerDiagonalUp("X")){
                return "X";
            }
            else if(checkWinnerDiagonalUp("O")){
                return "O";
            }
            else if(checkWinnerDiagonalDown("X")){
                return "X";
            }
            else if(checkWinnerDiagonalDown("O")){
                return "O";
            }
            else if (draw()){
                return "draw";
            }

            else{
                return null;
            }



    }



    /**
     * TODO: Apply a given move to the board.
     * @param move contains the player's symbol (move.player.symbol)
     *             and the location they'd like to place it (move.pos).
     */

    public void applyMove(Move move) {
        if(isEmptyPosition(move.pos)){

            board[move.pos - 1] = move.player.symbol;

        }
        else{
            System.out.println("Occupied spot please try again");
            this.applyMove(move.player.getTurn());
        }

        }



    }

