package Bank.view;

import Bank.module.User;
import Bank.service.AdminService;
import Bank.service.AdminServiceImpl;
import Bank.service.UserService;
import Bank.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        AdminService admin = new AdminServiceImpl();
        User user = new User();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("==============================  = ============================ Welcome to the Central Bank ======================================= " + "\n");
        System.out.println("                                Type 1 for admin and 2 for User ");
        System.out.println("                                1. Admin");
        System.out.println("                                2. User");
        System.out.println("**********************************************************************************************************************************" + "\n");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("                          Hello Admin ");
                System.out.println("                          Press 1 to View User Data AND 2 to Accept or Reject new User");
                System.out.println("                          1. View User Data ");
                System.out.println("                          2. User Handling");

                System.out.println("\n");
                int n = sc.nextInt();
                if(n==1){
                    List<User> viewUserDetail=admin.viewUserDetails();
                    System.out.println(viewUserDetail);
                } else if (n==2) {
                    admin.handleUser(user);

                }else{
                    System.out.println("Invalid Input Press 1 OR 2 only");

                }
                break;


            case 2:
                System.out.println("                                Hello User ");
//                boolean isTrue = true;

                char checkUser = 'y';
                System.out.println("                                Are you a new user: [Y/N]: ");
                checkUser = sc.next().charAt(0);
                if (checkUser == 'y') {
                    System.out.println("\n");
                    System.out.println("======================= FILL UP THE REGISTRATION FORM: ========================================");
                    System.out.println("Enter First Name: ");
                    user.setFirst_name(sc.next());

                    System.out.println("Enter Last Name: ");
                    user.setLast_name(sc.next());

                    System.out.println("Enter Temporary Address: ");
                    user.setTemp_address(sc.next());

                    System.out.println("Enter Permanent Address: ");
                    user.setPermanent_address(sc.next());

                    System.out.println("Enter Citizenship No: ");
                    user.setCitizenship_num(sc.next());

                    System.out.println("Enter Phone Number: ");
                    user.setPhone_num(sc.nextLong());

                    System.out.println("Enter Username: ");
                    user.setEmail(sc.next());

                    System.out.println("Create your Password: ");
                    user.setPassword(sc.next());

                    char secCh = 'y';
                    System.out.println("************************* Do You Want To Do Your First Deposit While Creating Account For First Time: [Y/N]*************************");
                    secCh = sc.next().charAt(0);
                    if (secCh == 'y') {
                        System.out.println("Enter First Deposit: ");
                        user.setTotalBalance(sc.nextFloat());
                    } else {
                        user.setTotalBalance(0);
                    }

                    System.out.println("-------------------------- Thank You For Requesting The New Account on OUR BANK | PLEASE Wait To Accept Your FORM From ADMIN --------------------------");

                    admin.acceptOrDecline_User(user);


                } else {

                    System.out.println("1. LOGIN");
                    System.out.println("2. RETURN TO HOME");
                    int num = sc.nextInt();
                    if (num == 1) {
                        UserService us = new UserServiceImpl();
                        System.out.println("Enter Email: ");
                        String email = sc.next();
                        System.out.println("Enter Password: ");
                        String pass = sc.next();

                        User u = us.login(email, pass);
                        if (u != null) {
//                        if (us.login(email, pass)==true) {
                            System.out.println("please select to to the following operation");
                            System.out.println("1. DEPOSIT");
                            System.out.println("2. WITHDRAW");
                            System.out.println("3. CHANGE PIN");

                            int id = u.getId();
                            System.out.println("name= " + email + " id= " + id);


                            switch (sc.nextInt()) {
                                case 1:

                                    us.deposit(id);
                                    break;
                                case 2:
                                    us.withdraw(id);
                                    break;
                                case 3:
                                    us.changePin(id);
                                    break;

                                default:
                                    System.out.println("INVALID INPUT");
                            }


                            break;
                        } else {
                            System.out.println("LOGOUT");
                        }


                    } else if (num == 2) {
                        System.out.println("RETURN TO HOME");
                    }
                }
                break;
            default:
                System.out.println("Invalid Selection please Type 1 or 2 in keyword");


        }


    }
}
