import java.util.Map;
import java.util.Scanner;

public class BankApp {
    public static void main ( String[] args ) throws WrongInputException, BalanceNotEnough, IllegalArgumentException {
        Scanner sc = new Scanner ( System.in );
        BankSystem bankSystem = new BankSystem ( 1230 );
        System.out.println ( "Bank sistemine xos gelmisiniz " );
        System.out.println ( "0-cixis et" );
        System.out.println ( "1-hesab elave et (Administrator icazesi lazimdir)" );
        System.out.println ( "2-id-ye gore melumata bax" );
        System.out.println ( "3-butun istifadecileri gor (Administrator icazesi lazimdir)" );
        System.out.println ( "4-balansdan pul cixar" );
        System.out.println ( "5-balansa pul elave et" );

        int adminPassword = 220101016;
        while ( true ) {
            System.out.println ( "Secim daxil et : " );
            int choose = sc.nextInt ( );
            switch ( choose ) {
                case 0:
                    System.out.println ( "cixis et..." );
                    return;
                case 1:
                    System.out.println ( "sifre daxil et: " );
                    int password = sc.nextInt ( );
                    try {
                        if ( password != adminPassword ) {
                            throw new WrongInputException ( "Yanlış şifrə daxil edildi!" );
                        }

                        System.out.println ( "Yeni ID daxil et:" );
                        int id = sc.nextInt ( );

                        System.out.println ( "Balans daxil et:" );
                        int balance = sc.nextInt ( );

                        bankSystem.addAccount ( id, new Account ( balance ) );
                        bankSystem.print ( );
                    } catch ( WrongInputException e ) {
                        System.out.println ( "Xəta: " + e.getMessage ( ) );
                    }
                    break;


                case 2:
                    System.out.println ( "baxmaq istediyiniz hesabin id-sini daxil edin:  " );
                    int get_id = sc.nextInt ( );
                    bankSystem.getAccount ( get_id );
                    break;
                case 3:
                    System.out.println ( "prosese davam etmek ucun parolu daxil et: " );
                    int passwordForPrint = sc.nextInt ( );
                    try {
                        if ( passwordForPrint != adminPassword ) {
                            throw new WrongInputException ( "Yanlis sifre daxil edildi" );
                        }
                        bankSystem.print ( );
                    } catch ( WrongInputException e ) {
                        System.out.println ( "Xeta " + e.getMessage ( ) );

                    }
                    break;
                case 4:
                    boolean isFound = false;
                    System.out.println ( "hesab nomresi daxil edin: " );
                    int myAccountNumber = sc.nextInt ( );
                    for ( Map.Entry < Integer, Account > entry : bankSystem.productHashMap.entrySet ( ) ) {
                        Integer accountNumber = entry.getKey ( );
                        Account myaccount = entry.getValue ( );

                        if ( myAccountNumber == myaccount.AccountNumber ) {
                            isFound = true;
                            System.out.println ( "Sizin balans: " + myaccount.balance );
                            System.out.println ( "mebleg daxil edin: " );
                            double amount = sc.nextDouble ( );

                            bankSystem.withdraw ( myAccountNumber, amount, myaccount.balance );

                        }
                    }
                    if ( ! isFound ) {
                        try {
                            throw new WrongInputException ( "Yanlis hesab nomresi" );
                        } catch ( WrongInputException e ) {
                            System.out.println ( "Xeta : " + e.getMessage ( ) );
                        }
                    }


                    break;
                case 5:
                    boolean isFounded = false;
                    System.out.println ( "hesab nomresi daxil edin: " );
                    int myAccountNumber_2 = sc.nextInt ( );
                    for ( Map.Entry < Integer, Account > entry : bankSystem.productHashMap.entrySet ( ) ) {
                        Integer accountNumber = entry.getKey ( );
                        Account myaccount = entry.getValue ( );
                        if ( myAccountNumber_2 == myaccount.AccountNumber ) {
                            isFounded = true;
                            System.out.println ( "Sizin balans: " + myaccount.balance );
                            System.out.println ( "mebleg daxil edin: " );
                            double amount = sc.nextDouble ( );
                            System.out.println ( "medaxilden sonraki  balans " );
                            bankSystem.deposit ( myAccountNumber_2, amount, myaccount.balance );
                            break;
                        }
                    }
                    if ( ! isFounded ) {
                        System.out.println ( "WRONG INPUT" );
                        break;
                    }
            }
        }
    }
}