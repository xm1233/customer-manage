package ui;

import bean.Customer;
import service.CustomerList;
import utiliy.utility;

import javax.swing.plaf.multi.MultiToolTipUI;

public class CustomerView {
    private CustomerList customerList=new CustomerList(10);
    public  CustomerView(){

    }
    private void enterMainMenu() {
        boolean isflag = true;
        while (isflag) {
            System.out.println("\n---------------------客户信息管理软件-------------------------------\n");
            System.out.println("                           1:添加客户");
            System.out.println("                           2:修改客户");
            System.out.println("                           3:删除客户");
            System.out.println("                           4:客户列表");
            System.out.println("                            5.退  出\n");
            System.out.print("                          请选择（1-5）:");
            char menu= utility.readmenue();
            switch (menu){
                case'1':addNewCustomer();break;
                case'2':modifyCustomer();break;
                case'3':deleteCustomer();break;
                case'4':listAllCustomer();break;
                case'5':System.out.print("是否退出(Y/N)?");char isExit=utility.out();
                if(isExit=='Y'){
                    isflag=false;
                }
            }
        }
    }
    private void addNewCustomer(){
        //System.out.println("添加客户操作");
        System.out.println("----------------------添加客户-----------------------------\n");
        System.out.print("姓名：");
        String name=utility.readstring();
        System.out.print("性别：");
        char gender=utility.readchar();
        System.out.print("年龄：");
        int age=utility.readint();
        System.out.print("电话：");
        String phone=utility.readstring();
        System.out.print("邮箱：");
        String email=utility.readstring();
        Customer customer=new Customer(name,gender,age,phone,email);
        boolean issuccess=customerList.addCustomer(customer);
        if(issuccess){
            System.out.println("----------------------客户添加成功-----------------------------\n");
        }else{
            System.out.println("----------------------客户目录已满，添加失败-----------------------------\n");
        }
    }
    private void modifyCustomer() {
        //System.out.println("更改客户操作");
        System.out.println("----------------------修改客户-----------------------------\n");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择修改客户编号（-1退出）：");
            number = utility.readint();
            if (number == -1) return;
             cust= customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户");
            } else {
                break;
            }
        }
        System.out.print("姓名("+cust.getName()+"):");
        String name=utility.readstring(cust.getName());
        System.out.print("性别("+cust.getGender()+"):");
        char gender=utility.readchar(cust.getGender());
        System.out.print("年龄("+cust.getAge()+"):");
        int age=utility.readint(cust.getAge());
        System.out.print("电话("+cust.getPhone()+"):");
        String phone=utility.readstring(cust.getPhone());
        System.out.print("邮箱("+cust.getEmail()+"):");
        String email=utility.readstring(cust.getEmail());
        Customer custk=new Customer(name,gender,age,phone,email);
        boolean issuccess=customerList.replaceCustomer(number-1,custk);
        if(issuccess){
            System.out.println("----------------------客户修改成功-----------------------------\n");
        }else{
            System.out.println("----------------------客户修改失败-----------------------------\n");
        }
    }
    private void deleteCustomer() {
        //System.out.println("删除客户操作");
        System.out.println("----------------------删除客户-----------------------------\n");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择删除客户的编号（-1退出）：");
            number = utility.readint();
            if (number == -1) return;
            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户");
            } else {
                break;
            }
        }
        System.out.print("是否确认删除（Y/N）？");
        char isdelete = utility.out();
        if (isdelete == 'Y') {
            boolean issuccess = customerList.deleteCustomer(number - 1);
            if (issuccess) {
                System.out.println("----------------------客户删除成功-----------------------------\n");
            } else {
                System.out.println("----------------------客户删除失败-----------------------------\n");
            }
        }else{
            return;
        }
    }
    private void listAllCustomer(){
      //  System.out.println("显示客户列表");
        System.out.println("\n---------------------客户列表-------------------------------\n");
        if(customerList.getTotal()==0){
            System.out.println("没有客户记录");
        }else
        {System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
        Customer[] custs=customerList.getAllCustomers();
        for(int i=0;i<custs.length;i++){
            Customer cust=custs[i];
            System.out.println((i+1)+"\t\t"+cust.getName()+"\t"+
                    cust.getGender()+"\t\t"+cust.getAge()+"\t\t"+
                    cust.getPhone()+"\t"+cust.getEmail());
        }
        }


        System.out.println("\n---------------------客户列表显示完成----------------------------\n");

    }
    public static void main(String[] args){
        CustomerView customerView=new CustomerView();
        customerView.enterMainMenu();

    }
}
