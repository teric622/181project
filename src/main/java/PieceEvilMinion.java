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
 * @author Ameer Abdelnasser, Eric Tlaseca, Tabetha Chubb
 * @since 2022-04-12
 */
public class PieceEvilMinion extends PieceMinion implements Attacker,Recruiter{
    private int numAttacks;
    private boolean hungry;
    final private int MAX_NUM_ATTACKS = 4;

    /**
     * constructor for PieceEvilMinion object, which calls super class constructor. Also it calls update hungry which sets the hungry boolean value
     * @param symbol - char type parameter that represents the symbol
     * @param teamColor - string type that represents a teams color
     * @param numRecruits - int type that represents the number of recruits
     * @param numAttacks - int type that represents the number of attacks that have been used
     * @param numTimesSpawned - int type that represents the number of times a PieceEvilMinion has spawned
     * @param hidden - boolean type that shows whether the PieceEvilMinion is hidden or not
     * @param original - boolean type that shows whether or not the PieceEvilMinion is original
     */
    public PieceEvilMinion(char symbol, String teamColor,
                           int numRecruits, int numAttacks,int numTimesSpawned,
                           boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        this.hungry = hungry;
        updateHungry();
    }


    /**
     * Sets PieceEvilMinion values
     */
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

    /**
     * updates the hungry boolean value. If numAttacks are less than the MAX_NUM_ATTACKS constant, hungry is set
     * to true, otherwise it is false
     * @return - returns hungry boolean value
     */
    public boolean updateHungry(){
        if (numAttacks < MAX_NUM_ATTACKS)
            this.hungry = true;

        return hungry;
    }
    /**
     *  speak method from PieceMinion and prints out "Roar!"
     */

    public void speak(){
        System.out.println("Roar!");
    }

    public boolean validMovePath(){
        return true;
    }

    /**
     * method that creates new PieceEvilMinion instance, and sets hungry to true. Also whenever this method is called
     * the numTimesSpawned increases by one
     * @return returns new PieceEvilMinion instance
     */
    public PieceEvilMinion spawn(){
        PieceEvilMinion bagel = new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1,
                0, 0, false, false);
        bagel.hungry = true;
        bagel.addNumTimesSpawned(1);
        return bagel;
    }


    public boolean validAttackPath(int rowIndexAttacking, int columnIndexAttacking, int  rowIndexAttacked, int columnIndexAttacked){
        return true;
    }



    public boolean validRecruitPath(int rowIndexRecruiting, int columnIndexRecruiting, int  rowIndexRecruted, int columnIndexRecruted){
        return true;
    }

}