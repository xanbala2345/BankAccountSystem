public class Account {
 int AccountNumber;
 double balance;
static int idCounter=0;
    public Account(double balance) {
        this.AccountNumber=idCounter++;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(int id,double amount,double balance) {
        balance = getBalance();

 if(amount>=0&&balance>=amount) {


     System.out.println("Qalan balans:   ");
     System.out.println(balance - amount);

 }

 }



    public void deposit(int id,double amount,double balance) {
        balance=getBalance();
        if(id==getAccountNumber()) {
            System.out.println("Sizin balans: " + balance);
            if ( amount > 0) {

                System.out.println("Medaxilden sonraki balans:   ");
                System.out.println(balance+amount);
            } else {
                System.out.println("ERROR");
            }
        }
    }
    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber=" + AccountNumber +
                ", balance=" + balance +
                '}';
    }
}
