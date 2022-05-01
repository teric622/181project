public interface Recruiter {



    public abstract int getNumRecruits();

    public abstract void setNumRecruits(int recruited);

    public abstract boolean validRecruitPath(int rowIndexRecruiting, int columnIndexRecruiting, int  rowIndexRecruted, int columnIndexRecruted);
}
