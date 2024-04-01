public class Dept {
    private long Deptno;
    private String Dname;
    private String loc;

     public String getLoc() {
        return loc;
    }

    public String getDname() {
        return Dname;
    }

    public long getDeptno() {
        return Deptno;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setDeptno(long deptno) {
        Deptno = deptno;
    }

    public String toString(){
        return "Dept[Deptno = " + Deptno + ", Dept name : " + Dname + "Dept location : " + loc + " ]";
    }

}
