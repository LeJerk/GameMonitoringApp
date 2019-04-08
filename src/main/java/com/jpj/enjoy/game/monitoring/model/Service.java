package com.jpj.enjoy.game.monitoring.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "customer")
public class Service
{

	//	@Id
	//	@GeneratedValue(strategy = GenerationType.AUTO)
    // private long id;

    //	@Column(name = "system")
    private String system;

    //	@Column(name = "activeModules")
    private int activeModules;

    private int logsPerSecond;

    private int todaysErrorLogs;

    public Service() {
    }

    public Service(String system, int activeModules) {
        this.system = system;
        this.activeModules = activeModules;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public int getActiveModules() {
        return activeModules;
    }

    public void setActiveModules(int activeModules) {
        this.activeModules = activeModules;
    }

    public int getLogsPerSecond() {
        return logsPerSecond;
    }

    public void setLogsPerSecond(int logsPerSecond) {
        this.logsPerSecond = logsPerSecond;
    }

    public int getTodaysErrorLogs() {
        return todaysErrorLogs;
    }

    public void setTodaysErrorLogs(int todaysErrorLogs) {
        this.todaysErrorLogs = todaysErrorLogs;
    }

}
