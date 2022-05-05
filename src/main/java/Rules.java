public class Rules {
    //lab7 problem 5
    public static boolean checkValidAction(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn, char action) {

        Piece fromPiece;
        boolean isEmpty = game.getBoardSquares()[toRow][toColumn].isEmpty();
        boolean fromEmpty = game.getBoardSquares()[fromRow][fromColumn].isEmpty();









        if(fromEmpty == true) {
            fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
            if(fromPiece.getTeamColor().equals(game.getCurrentTeam().getTeamColor())!= true) {
                return false;
            }
        }
        else{
            return false;
        }

        if(game.getGameBoard().inBounds(fromRow,fromColumn ) != true) {
            return false;
        }
        if(game.getGameBoard().inBounds(toRow,toColumn ) != true) {
            return false;
        }



        //dont do it unless theres a piece there
            Piece toPiece = game.getBoardSquares()[toRow][toColumn].getPiece();


        switch (action) {
            case 'M':
                if (!isEmpty) {
                    System.out.println(" Square is not empty");
                    return false;
                    //check valide move, if its not return false
                }
                return isEmpty;

            case 'S':
                if (!isEmpty) {
                    System.out.println(" Square is not empty");
                    return false;
                }
                if (!fromPiece.canSpawn()) {
                    System.out.println("Square is not empty");
                    return false;
                }
                return true;


            case 'R':
                if (isEmpty) {
                    System.out.println("Piece your trying to recruit is empty");
                    return false;
                }
                if (!game.getOpponentTeam().getTeamPieces().contains(toPiece)) {
                    System.out.println("Recruit a piece I have");
                    return false;
                }



                if (fromPiece instanceof PieceBuzz) {
                    System.out.println("Your piece isn't able to recruit");
                    return false;
                }


                return true;


            case 'A':
                if (isEmpty) {
                    return false;
                }
                if (!game.getOpponentTeam().getTeamPieces().contains(toPiece)) {
                    return false;
                }
                if (fromPiece instanceof PieceBuzz) {
                    PieceBuzz temp = (PieceBuzz) fromPiece;
                    //return false;
                    if (!temp.canAttack()) {
                        return true;
                    }
                    //instance of minion etc and test cases needed
                }
                return true;

        }
        return true;
    }

   //case to exit
    }

