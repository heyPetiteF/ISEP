import java.util.Date;
public class Emp {
    private Long empNo;
    private String ename;
    private String efirst;
    private String job;
    private Emp mgr;
    private Date hireDate;
    private int sal;
    private int comm;
    private int tel;
    private Dept department;
    public Long getEmpNo() {
        return empNo;
    }

    public String getEname() {
        return ename;
    }

    public String getEfirst() {
        return efirst;
    }

    public String getJob() {
        return job;
    }

    public Emp getMgr() {
        return mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public int getSal() {
        return sal;
    }

    public int getComm() {
        return comm;
    }

    public int getTel() {
        return tel;
    }

    public Dept getDepartment() {
        return department;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEfirst(String efirst) {
        this.efirst = efirst;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }

    public String toString() {
        return "Employee{" +
                "empno=" + empNo +
                ", ename='" + ename + '\'' +
                ", manager=" + (mgr != null ? mgr.getEname() : "None") +
                '}';
    }
}
