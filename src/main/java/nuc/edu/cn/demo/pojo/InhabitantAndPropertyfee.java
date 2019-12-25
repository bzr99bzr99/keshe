package nuc.edu.cn.demo.pojo;

import java.util.List;

public class InhabitantAndPropertyfee {
    private int inhabitantId;
    private String inhabitantName;
    private List<Propertyfee> propertyfees;



    public int getInhabitantId() {
        return inhabitantId;
    }

    public void setInhabitantId(int inhabitantId) {
        this.inhabitantId = inhabitantId;
    }

    public String getInhabitantName() {
        return inhabitantName;
    }

    public void setInhabitantName(String inhabitantName) {
        this.inhabitantName = inhabitantName;
    }


    public List<Propertyfee> getPropertyfees() {
        return propertyfees;
    }

    public void setPropertyfees(List<Propertyfee> propertyfees) {
        this.propertyfees = propertyfees;
    }
}
