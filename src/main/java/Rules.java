import java.util.ArrayList;


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
                }

                if(fromPiece instanceof PieceEvilMinion){
                    PieceEvilMinion tempEvil = (PieceEvilMinion) fromPiece;
                    if(tempEvil.canAttack()!= true){
                        if (!game.getOpponentTeam().getTeamPieces().contains(toPiece) || toPiece instanceof PieceMinion) {
                        //checking if its one of my pieces, if it does then move on to the minion
                        return true;
                    }
                    }
                }
                return true;

        }
        return true;
    }

    public static void main(String[] arg){
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // create a game
        GameS22 game = new GameS22(6,6,teamA,teamB);

        // clear Piece off the board
        for(int row = 0; row < game.getGameBoard().getNumRows();row++){
            for (int col = 0; col < game.getGameBoard().getNumColumns(); col++){
                game.getGameBoard().getSquares()[row][col].removePiece();
            }
        }
        System.out.println(game);

        // load your pieces in specific locations of your choice
        game.getGameBoard().getSquares()[0][0].setPiece(piecesTeamA.get(0));
        game.getGameBoard().getSquares()[0][1].setPiece(piecesTeamA.get(1));
        game.getGameBoard().getSquares()[0][2].setPiece(piecesTeamA.get(2));
        game.getGameBoard().getSquares()[0][3].setPiece(piecesTeamA.get(3));
        game.getGameBoard().getSquares()[2][0].setPiece(piecesTeamB.get(0));
        game.getGameBoard().getSquares()[2][1].setPiece(piecesTeamB.get(1));
        game.getGameBoard().getSquares()[2][2].setPiece(piecesTeamB.get(2));
        game.getGameBoard().getSquares()[2][3].setPiece(piecesTeamB.get(3));

        System.out.println(game);

        // Test some moves that should be valid
        // Test some moves that are invalid

        // This should be a valid move
        System.out.println(Rules.checkValidAction(game,
                0,0,
                1,4,'M'));

        // To Square isn't empty - should not be a valid move
        System.out.println(Rules.checkValidAction(game,
                0,0,
                0,1,'M'));
        // This isn't current team's piece - should not be valid
        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));


        // You can change the turn to test the other team pieces
        game.changeTurn();

        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));


    }










    }




















//regular piece minion

//                    if(!(fromPiece == tempEvil)){
//                       PieceEvilMinion newEvil = (PieceEvilMinion) fromPiece;
//                     fromPiece = newEvil;
//                   return false;
//             }
// if(fromPiece instanceof PieceEvilMinion){
//PieceEvilMinion tempEvil = (PieceEvilMinion) fromPiece;
//  if(tempEvil.canAttack()!= true){
//      return false;
//  }
