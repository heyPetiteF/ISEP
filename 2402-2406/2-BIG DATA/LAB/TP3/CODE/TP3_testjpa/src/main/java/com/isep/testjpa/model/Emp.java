package com.isep.testjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Emp {
    @Id
    @GeneratedValue
    private Long empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "efirst")
    private String efirst;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private Long mgr;
    @Column(name = "sal")
    private Long sal;
    public Long getEmpno() {
        return empno;
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

    public Long getMgr() {
        return mgr;
    }

    public Long getSal() {
        return sal;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
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

    public void setMgr(Long mgr) {
        this.mgr = mgr;
    }

    public void setSal(Long sal) {
        this.sal = sal;
    }
}