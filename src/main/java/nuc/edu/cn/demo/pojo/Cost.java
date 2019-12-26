package nuc.edu.cn.demo.pojo;

public class Cost {
    private int inhabitant_id;
    private int propertyfee_id;

    @Override
    public String toString() {
        return "Cost{" +
                "inhabitant_id=" + inhabitant_id +
                ", propertyfee_id=" + propertyfee_id +
                '}';
    }

    public int getInhabitant_id() {
        return inhabitant_id;
    }

    public void setInhabitant_id(int inhabitant_id) {
        this.inhabitant_id = inhabitant_id;
    }

    public int getPropertyfee_id() {
        return propertyfee_id;
    }

    public void setPropertyfee_id(int propertyfee_id) {
        this.propertyfee_id = propertyfee_id;
    }
}
