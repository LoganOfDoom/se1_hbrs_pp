package org.hbrs.se1.ws22.uebung2;

import java.util.Arrays;

public class ConcreteMember implements Member{

    private int pid = 0;
    private String vorname = "";
    private String nachname = "";
    private String rolle = "";
    private String abteilung = "";
    private String[][] expertisen = new String[2][3];
    private int counterExpertisen = 0;

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String name) {
        this.nachname = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setExpert(String exp, String lvl){
        expertisen[0][counterExpertisen] = exp;
        expertisen[1][counterExpertisen++] = lvl;
    }

    public String getExpertise(int w){
        return expertisen[0][w];
    }

    public int numExpertisen(){
        return counterExpertisen;
    }

    @Override
    public Integer getID() {
        return pid;
    }

    public String[][] getExpertisen(){
        return expertisen;
    }

    public String toString(){
        return "Member (ID = " + pid + ")" + " Vorname: " + vorname + " Nachname: " + nachname + " Expertisen: " + Arrays.deepToString(expertisen);
    }
}