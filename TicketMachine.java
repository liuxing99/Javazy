import sun.security.krb5.internal.Ticket;;
import java.util.Scanner;

public class TicketMachine
{
    private int price;
    private int balance;
    private int total;
    public TicketMachine(int ticketCost)
    {
        price =ticketCost;
        balance=0;
        total=0;
    }
    public int getPrice()
    {
        return price;
    }
    public int getBalance()
    {
        return balance;
    }
    public void insertMoney(int amount)
    {
        if(amount>0)
        {
            balance += amount;
        }
        else
        {
            System.out.println("输入金额错误:"+amount);
        }
    }
    public void printTicket(int Number) {
        if (balance >= price*Number)
        {
            System.out.println("################");
            System.out.println("# 分割线");
            System.out.println("# Ticket");
            System.out.println("票价" + price*Number + "元");
            System.out.println("票数:"+Number+"张");
            System.out.println("################");
            System.out.println();
            total += balance;
            balance -= price*Number;
        }
        else
        {
            System.out.println("你必须至少投入:"+(price*Number-balance)+"元");
        }
    }
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund=balance;
        balance=0;
        return amountToRefund;
    }
    public void showTotal()
    {
        System.out.println("今日售票:"+total/price+"张");
        total=0;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        TicketMachine T1=new TicketMachine(10);
        System.out.println("！！票价10元！！");
        System.out.println("请投币");
        int money=sc.nextInt();
        System.out.println("请输入购买票数");
        int num=sc.nextInt();
        T1.insertMoney(money);
        T1.printTicket(num);
        T1.refundBalance();
        T1.showTotal();
    }
}


