import java.util.ArrayList;

public class Team {
    private String teamColor;
    private ArrayList<Piece> piecesForTeam;

    public Team(String color,  ArrayList<Piece> teamPieces){
        teamColor = color;
        piecesForTeam = teamPieces;
    }
    public String getTeamColor(){
        return teamColor;
    }
    public  ArrayList<Piece> getTeamPieces(){
        return piecesForTeam;
    }
    public void removePieceFromTeam(Piece piece){
        piecesForTeam.remove(piece);
    }
    public void addPieceToTeam(Piece piece){
        piecesForTeam.add(piece);
        piece.setTeamColor(teamColor);
    }
    public String toString(){
        String returnVal = "Team " + teamColor + " Pieces:\n";
        for (int i = 0 ; i < piecesForTeam.size(); i++){
            returnVal = returnVal + piecesForTeam.get(i).toString();
        }
        return returnVal;
    }
}
