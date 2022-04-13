public class PieceEvilMinion extends PieceMinion{
    private int numAttacks;
    private boolean hungry;
    final private int MAX_NUM_ATTACKS = 4;


    public PieceEvilMinion(char symbol, String teamColor,
                           int numRecruits, int numAttacks,int numTimesSpawned,
                           boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        this.hungry = hungry;
        updateHungry();
    }


    public PieceEvilMinion(){
        this('E',"NON",0,0,0,false,true);
    }

    public boolean canAttack(){
        return this.hungry;
    }

    public int getNumAttacks(){
        return this.numAttacks;
    }

    public void setNumAttacks(int numAttacks){
        this.numAttacks = numAttacks;
    }


    public boolean updateHungry(){
        if (numAttacks < MAX_NUM_ATTACKS)
            this.hungry = true;

        return hungry;
    }

    @Override
    public void speak(){
        System.out.println("Roar!");
    }

    public boolean validMovePath(){
        return true;
    }

    public PieceEvilMinion spawn(){
        PieceEvilMinion bagel = new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1,
                0, 0, false, false);
        bagel.hungry = true;
        bagel.addNumTimesSpawned(1);
        return bagel;
    }


}