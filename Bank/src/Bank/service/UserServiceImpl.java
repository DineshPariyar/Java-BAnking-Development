package Bank.service;

import Bank.DB.DB;
import Bank.module.User;
import com.mysql.cj.result.SqlDateValueFactory;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

    Scanner sc = new Scanner(System.in);


    @Override
    public User login(String email, String pass) {
        User u = new User();
        try {
            String sql = "select * from cb where Email = '" + email + "' and Password = '" + pass + "' ";
            Statement stm = DB.connectDB().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                System.out.println("\n");
                System.out.println("======== Logged In Successfully MR/MRS: " + email + " ========" + "\n");
                System.out.println("======== Please proceed for the following ========");

                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("Email"));
            } else {
                System.out.println("Wrong Email and  Password Please re-enter email and password: ");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return u;

    }

    @Override
    public void deposit(int id) {

        System.out.println("=============================== Enter the amount you want to Deposit: ===============================");
        float depositAmount = sc.nextFloat();

        try {
            String sql = "select Total_Balance from cb where id = '" + id + "'";//
            Statement stm = DB.connectDB().createStatement();
            ResultSet rs = stm.executeQuery(sql);


            if (rs.next()) {


                float amountInBank = rs.getFloat("Total_Balance");
                System.out.println("=============================== Your Current Amount " + amountInBank + ".00 ==============================" + "\n");
                float newBalance = depositAmount + amountInBank;
                sql = "UPDATE cb SET Total_Balance =  '" + newBalance + "' where id= '" + id + "' ";
                stm.execute(sql);
                System.out.println("=============================== Your New BLance is Rs." + newBalance + ".00 ==============================");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void withdraw(int id) {
        System.out.println("enter the amount you want to withdraw");
        float withdrawAmount = sc.nextFloat();

        if (withdrawAmount >= 500) {
            try {
                String sql = "select Total_Balance from cb where id = '" + id + "' ";
                Statement stm = DB.connectDB().createStatement();
                ResultSet rs = stm.executeQuery(sql);

                if (rs.next()) {
                    float amountInBank = rs.getFloat("Total_Balance");
                    System.out.println("=============================== Your Current Amount " + amountInBank + ".00 ==============================" + "\n");
                    float newBalance = amountInBank - withdrawAmount;
                    sql = "UPDATE cb SET Total_Balance =  '" + newBalance + "' where id= '" + id + "' ";
                    stm.execute(sql);
                    System.out.println("=============================== Your New BLance is Rs." + newBalance + ".00 ==============================");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("Sorry the Withdraw Amount Must Be Greater than 500 or Multiple of 500");
        }

    }

    @Override
    public void changePin(int id) {
        System.out.println("Enter a new Password: ");
        String newPassword = sc.next();
        if(newPassword!=null){
            try{
                String sql = "select Password from cb where id = '" + id + "' ";
                Statement stm = DB.connectDB().createStatement();
                ResultSet rs = stm.executeQuery(sql);

                if(rs.next()){
                    sql = "update cb SET Password = '"+ newPassword+"' where id = '"+id+"' ";
                    stm.execute(sql);

                    System.out.println("Your Password was changed To: "+newPassword);

                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Password Cannot Be Empty");
        }

    }
}
