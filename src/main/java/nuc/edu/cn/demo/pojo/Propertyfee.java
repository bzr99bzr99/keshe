package nuc.edu.cn.demo.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Propertyfee {
    private int id;
    private String name;
    private String describe;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddate;
    private int cost;

    @Override
    public String toString() {
        return "Propertyfee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", begindate=" + begindate +
                ", enddate=" + enddate +
                ", cost=" + cost +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
