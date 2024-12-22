import java.util.HashMap;
import java.util.Map;

public class BankSystem  extends Account {
public static int id;
Account account=new Account(5000);
    public HashMap<Integer, Account> productHashMap;

    boolean isFound=false;
    public BankSystem(double balance) {
        super(balance);
        productHashMap = new HashMap<>();
        productHashMap.put(12, new Account(1500));
        productHashMap.put(13, new Account(1000));
        productHashMap.put(14, new Account(3200));
        productHashMap.put(15, new Account(4000));
        productHashMap.put(16, new Account(3000));
    }

    public void print() {

        System.out.println(productHashMap);

    }

    public void addAccount(int id, Account account) {
        productHashMap.put(id, account);
        System.out.println("account added");
    }

    public void getAccount(int id) {

        for (int i = 0; i < productHashMap.size(); i++) {
            if (productHashMap.containsKey(id)) {
                isFound=true;
                System.out.println(productHashMap.get(id));
                break;
            }
            if(!isFound) {
                System.out.println("wrong input");
                break;
            }
        }
    }

@Override
    public void withdraw(int id, double amount,double balance) {
        for (Map.Entry<Integer, Account> entry : productHashMap.entrySet()) {
            Integer accountNumber = entry.getKey();
            Account account = entry.getValue();
            if(id==account.AccountNumber) {
                try {

                    if (amount > 0 && amount <= balance) {

                        balance = account.getBalance();

                        System.out.println("sizin qalan balans: ");
                        System.out.println(balance - amount);
                    }else if(amount<0) {
                        throw new IllegalArgumentException("daxil edilen mebleg menfi ola bilmez");
                    }else if(amount>balance) {
                        throw new BalanceNotEnough("Balansda kifayet qeder meblleg yoxdur");
                    }
                }catch (IllegalArgumentException E) {
                    System.out.println(E.getMessage());
                }
                catch (BalanceNotEnough E) {
                    System.out.println(E.getMessage());
                }

            }

                }


            }

    @Override
    public void deposit(int id, double amount, double balance) {
        for (Map.Entry<Integer, Account> entry : productHashMap.entrySet()) {
            Integer accountNumber = entry.getKey();
            Account account = entry.getValue();
            if(id==account.AccountNumber) {
                balance = account.getBalance();

                System.out.println(balance+amount);
            }

        }
    }
}







