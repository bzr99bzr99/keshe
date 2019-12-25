package nuc.edu.cn.demo.pojo;

public class InhabitantSon extends Inhabitant {
    private int flag = 0;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "InhabitantSon{" +
                "flag=" + flag +
                '}';
    }
}
