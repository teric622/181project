public class PieceEvilMinion extends PieceMinion{
private int numAttacks;
private boolean hungry;
final private int MAX_NUM_SPAWNED = 3;
final private int MAX_NUM_ATTACKS = 4;



    public PieceEvilMinion(char symbol, String teamColor,
                       int numRecruits, int numTimesSpawned,
                       boolean hidden, boolean original, int numAttacks) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        this.hungry = hungry;
    }

    public PieceEvilMinion(){
        this('E',"NON",0,0,false,true,0);
    }

}
