package nuc.edu.cn.demo.pojo;

public class LoginError {
    private int num;
    private String idError;
    private String pwdError;

    @Override
    public String toString() {
        return "LoginError{" +
                "num=" + num +
                ", idError='" + idError + '\'' +
                ", pwdError='" + pwdError + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getPwdError() {
        return pwdError;
    }

    public void setPwdError(String pwdError) {
        this.pwdError = pwdError;
    }
}
