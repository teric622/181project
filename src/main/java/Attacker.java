public interface Attacker {

    public abstract int getNumAttacks();

    public abstract void setNumAttacks(int recruited);

    public abstract boolean validAttackPath(int rowIndexAttacking, int columnIndexAttacking, int  rowIndexAttacked, int columnIndexAttacked);
}






