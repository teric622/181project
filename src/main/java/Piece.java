
abstract public class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    final public int MAX_NUM_ATTACKS = 3;

    Piece(char symbol,String teamColor,boolean hidden,boolean original ){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }




    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public boolean isHidden() {
            return hidden;
    }
    public boolean isOriginal() {
            return original;
        }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }

    public void speak(){
        System.out.println(" ");
    }


  //noting validMovePath

    public boolean canSpawn(){
        return true;
    }

}
