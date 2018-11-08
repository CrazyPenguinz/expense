//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class BookConsoleUI {
//    public void start() {
//        BookFileConnector bookFileConnector = new BookFileConnector();
//        Ledger ledger = new Ledger();
//        Scanner sc = new Scanner(System.in);
//        boolean status = true;
//
//        while (status) {
//            int stage = ledger.getStage();
//            if (stage == Ledger.TRANSACT) {
//                System.out.println("-------------------------------------------\nBalance : " + ((ledger.getBalance() != -1)? ledger.getBalance():"Wrong Stage\n"));
//                System.out.print("I = income, E = expenses, B = book, Q = quit : ");
//                char command = sc.next().charAt(0);
//                if (command == 'Q') {
//                    status = false;
//                } else if (command == 'I') {
//                    System.out.print("Amount : ");
//                    double amount = sc.nextDouble();
//                    System.out.print("Detail : ");
//                    sc.useDelimiter("\n");
//                    String detail = sc.next();
//                    ledger.receive(detail, amount);
//                } else if (command == 'E') {
//                    System.out.print("Amount : ");
//                    double amount = sc.nextDouble();
//                    System.out.print("Detail : ");
//                    sc.useDelimiter("\n");
//                    String detail = sc.next();
//                    try {
//                        ledger.pay(detail, amount);
//                    } catch (OverExpenseException message) {
//                        System.out.println(message.getMessage());
//                    }
//                } else if (command == 'B') {
//                    System.out.println(ledger.getRecord());
//                } else {
//                    System.out.println("Invalid Input.");
//                }
//            }
//        }
//    }
//}
