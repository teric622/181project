/**
 * <h1>Lab5</h1>
 * <h2>CISC 181-012  2022 </h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab5() program implements an application that covers
 * the following topics: Refactoring Code to Creating object hierarchies, Creating and Extending Abstract Classes,
 * Overriding methods for polymorphism, Implementing pre-defined Object method toString,
 * Two-Dimensional Arrays with Reference Types
 * This  class will be a sub class from the super class piece which will
 * inheret propertites from in which polymorphism will take place
 *
 * @author  Eric Tlaseca, Ameer Abdelnasser,Tabetha Chubb
 * @since 2022-04-12
 */


public class PieceBlueHen extends Piece implements Attacker,Recruiter{

    private int numAttacks;
    private int numRecruits;
    private boolean flies;
//maximum number of attacks bluehen can have
    final private int MAX_NUM_ATTACKS = 3;

    /**
     *  PieceBlueHen multiple parameter constructor that calls the super class’ constructor.
     *
     * @param symbol - char type parameter that represents the symbol
     * @param teamColor - string type that represents a teams color
     * @param numRecruits - int type that represents the number of recruits
     * @param numAttacks - int type that represents the number of attacks that have been used
     * @param hidden - boolean type that shows whether the PieceBlueHen is hidden or not
     * @param original - boolean type that shows whether or not the PieceBlueHen is original
     */
    public PieceBlueHen (char symbol, String teamColor, int numAttacks,
                         int numRecruits, boolean hidden, boolean original){
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        this.hidden = hidden;
        updateFly();
    }

    /**
     * A no parameter constructor  calls the 7 parameter
     * constructor of this class and creates a default a PieceBlueHen.
     */
    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }


//getter for numAttacks
    public int getNumAttacks()    {
        return this.numAttacks;
    }
    //getter for numRecruits
    public int getNumRecruits(){
        return this.numRecruits;
    }

// getter to see if a bluehenpiece can fly
    public boolean canFly()    {
        return this.flies;
    }


    /**
     * @param numAttacks
     * mutator method to set current values of a bluehen
     * to see if it can fly, hence why updatefly() is called, in order
     * for set property to update
     */
    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }
    //setter for numRecruits
    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }


    /**
     * updateFly() method will
     * see if the number of cerrent attacks it holds is less, than the max allowed,
     * if this is true, then the piece can containue to fly
     * else it cant fly anymore, and the property for set piece is updated
     */
    private void updateFly()    {
        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }

    /**
     *utilizes the abstract piece method speak from piece class which will print go ud
     */
    public void speak(){
        System.out.println("Go UD!");
    }

    /**
     * validmovepath()
     * implements validMovePath method that was abstract in piece superclass
     *  as the bluehen will have a diffrent path
     *   and properties, in which all the same parameter where
     * the same throughout, but used diffrently with diffrent out comes in each subclass
     */

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    /**
     * this method will be used to spawn aka obtain a new piece bluehen
     * that will allow a piece to spawn another of this kind, by creating a new object
     * with set properties to make the spawned one diffrent from the originsl
     * @return it will return a new hen objetc (a copy of the orignal diffrent values)
     */
    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }



    /**
     * @return boolean value of true instutuing that a piece can spawn
     */
    public boolean canSpawn(){

        return true;

    }


    public boolean validAttackPath(int rowIndexAttacking, int columnIndexAttacking, int  rowIndexAttacked, int columnIndexAttacked){
        return true;
    }



    public boolean validRecruitPath(int rowIndexRecruiting, int columnIndexRecruiting, int  rowIndexRecruted, int columnIndexRecruted){
        return true;
    }




}
