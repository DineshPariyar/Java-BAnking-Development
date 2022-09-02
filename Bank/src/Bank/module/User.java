package Bank.module;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String temp_address;
    private String permanent_address;
    private String citizenship_num;
    private long phone_num;
    private String email;
    private float totalBalance;

    private String password;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTemp_address() {
        return temp_address;
    }
    public void setTemp_address(String temp_address) {
        this.temp_address = temp_address;
    }

    public String getPermanent_address() {
        return permanent_address;
    }
    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getCitizenship_num() {
        return citizenship_num;
    }
    public void setCitizenship_num(String citizenship_num) {
        this.citizenship_num = citizenship_num;
    }

    public long getPhone_num() {
        return phone_num;
    }
    public void setPhone_num(long phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public float getTotalBalance() {
        return totalBalance;
    }
    public void setTotalBalance(float totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "\n"+"[" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ",   last_name='" + last_name + '\'' +
                ",   temp_address='" + temp_address + '\'' +
                ",   permanent_address='" + permanent_address + '\'' +
                ",   citizenship_num='" + citizenship_num + '\'' +
                ",   phone_num=" + phone_num +
                ",   email='" + email + '\'' +
                ",   totalBalance=" + totalBalance +
                ",   password='" + password + '\'' +
                ']';
    }
}
