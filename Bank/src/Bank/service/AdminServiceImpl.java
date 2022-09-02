package Bank.service;

import Bank.DB.DB;
import Bank.module.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {


    @Override
    public void acceptOrDecline_User(User user) {
        Scanner sc = new Scanner(System.in);
        char checkUser = 'y';
        System.out.println("Hello Admin: Do you want to accept he new User: " + user.getFirst_name() + " [Y/N]");

        if (checkUser == sc.next().charAt(0)) {
            try {
                String sql = "insert into cb(First_Name,Last_Name,Temporary_Address, Permanent_Address, Citizenship_Number, Phone_Number, Email, Total_Balance, Password) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement stm = DB.connectDB().prepareStatement(sql);
                stm.setString(1, user.getFirst_name());
                stm.setString(2, user.getLast_name());
                stm.setString(3, user.getTemp_address());
                stm.setString(4, user.getPermanent_address());
                stm.setString(5, user.getCitizenship_num());
                stm.setLong(6, user.getPhone_num());
                stm.setString(7, user.getEmail());
                stm.setFloat(8, user.getTotalBalance());
                stm.setString(9, user.getPassword());

                stm.execute();
                DB.connectDB().close();
                System.out.println("user " + user.getEmail() + " is added by the admin please proceed for further ");


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("The Admin has decline your request Please Try again");

        }
    }

    @Override
    public void handleUser(User user) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Admin do you want to remove any user: [Y/N]: ");
        char check = 'y';

        check=sc.next().charAt(0);
        if(check=='y'){

            try{
                System.out.println("Enter the users ID to remove  ");
                int id = sc.nextInt();
                String sql = "DELETE FROM cb WHERE id='"+id+"' ";
                Statement stm = DB.connectDB().createStatement();
                stm.execute(sql);

                System.out.println("User with ID "+id+ " is Removed");

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }


    @Override
    public List<User> viewUserDetails() {
        List<User> showUsers =new ArrayList<>();

        try{
            String sql = "Select * from cb";
            Statement stm = DB.connectDB().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirst_name(rs.getString("First_Name"));
                user.setLast_name(rs.getString("Last_Name"));
                user.setTemp_address(rs.getString("Temporary_Address"));
                user.setPermanent_address(rs.getString("Permanent_Address"));
                user.setCitizenship_num(rs.getString("Citizenship_Number"));
                user.setPhone_num(rs.getLong("Phone_Number"));
                user.setEmail(rs.getString("Email"));
                user.setTotalBalance(rs.getFloat("Total_Balance"));
                user.setPassword(rs.getString("Password"));

                showUsers.add(user);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return showUsers;
    }


}
