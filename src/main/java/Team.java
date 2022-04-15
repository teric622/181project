import java.util.ArrayList;
/**
 * <h1>Lab5</h1>
 * <h2>CISC 181-012  2022 </h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab5() program implements an application that covers
 * the following topics: Refactoring Code to Creating object hierarchies, Creating and Extending Abstract Classes,
 * Overriding methods for polymorphism, Implementing pre-defined Object method toString,
 * Two-Dimensional Arrays with Reference Types
 *
 * @author Eric Tlaseca, Ameer Abdelnasser, Tabetha Chubb
 * @since 2022-04-12
 */
public class Team {
    private String teamColor;
    private ArrayList<Piece> piecesForTeam;

    /**m parameter constructor for team class
     * @param color - string that represents the team a piece will be on base don color
     * @param teamPieces - is a arraylist of a piece object, will be used to set x properties
     */
    public Team(String color,  ArrayList<Piece> teamPieces){
        teamColor = color;
        piecesForTeam = teamPieces;
    }
    //getter
    public String getTeamColor(){
        return teamColor;
    }
    //getter
    public  ArrayList<Piece> getTeamPieces(){
        return piecesForTeam;
    }

    /**
     * this method will hold the logic to remove a piece
     * from a teams board, which will be needed to know when a
     * certain piece or object is no longer ussable
     * @param piece
     */
    public void removePieceFromTeam(Piece piece){
        //removesetpiece from setteam
        piecesForTeam.remove(piece);
    }
    /**
     * this method will hold the logic to add a piece
     * to a teams board, which will be needed when
     * certian pieces spawn other, in addition,
     * the same team color must be pass to added piece
     * @param piece
     */
    public void addPieceToTeam(Piece piece){
        piecesForTeam.add(piece);
        piece.setTeamColor(teamColor);
    }


    /**
     * toString method that returns
     * a string with the team color and all
     * of the team’s Pieces’ toString values.
     * @return string with teams color and all its pieces in tostring values
     */
    public String toString(){
        String returnVal = "Team " + teamColor + " Pieces:\n";
        for (int i = 0 ; i < piecesForTeam.size(); i++){
            //iterate through the pieces and obtain the color and its pieces for set team
            //for the piece at set index
            returnVal = returnVal + piecesForTeam.get(i).toString();
        }
        return returnVal;
    }
}
