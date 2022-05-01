public class GameS22 extends Game {

    public GameS22 (int numRows, int numCol, Team firstTeam, Team secondTeam){
        super( numRows,  numCol,  firstTeam,  secondTeam);
    }
    public boolean isAWinner(){
        if(firstTeam.getTeamPieces().size() == 0 && secondTeam.getTeamPieces().size() !=0){
            return true;
        }
        else if(secondTeam.getTeamPieces().size() == 0 && firstTeam.getTeamPieces().size() !=0){
            return true;
        }
        else{
            return false;
        }
    }


    /*
    The winner is the Team that still has pieces on the board.
     If there is no winner, getWinner should return a null value
     */
    public Team getWinner(){
        if(firstTeam.getTeamPieces().size() == 0 && secondTeam.getTeamPieces().size()!=0){
            return secondTeam;
        }
        else if (secondTeam.getTeamPieces().size() == 0 && firstTeam.getTeamPieces().size() != 0){
            return firstTeam;
        }
        else{
            return null;
        }
    }
    public boolean isGameEnded(){
        if(firstTeam.getTeamPieces().size() == 0 || secondTeam.getTeamPieces().size() ==0){
            return true;
        }
        else{
            return false;
        }
    }


}
