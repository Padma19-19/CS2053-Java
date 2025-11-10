// Lab Session:7 Multithreading and Synchronization
class Printer {

    private boolean isPrinting = false; // Flag to check if printer is busy


    // synchronized ensures only one user can access the printer at a time

    synchronized void printDocument(String user, String documentName) {

        while (isPrinting) { // if printer is busy, wait

            try {

                System.out.println(user + " is waiting for the printer...");

                wait(); // wait until notified

            } catch (InterruptedException e) {

                System.out.println(user + " interrupted while waiting.");

            }

        }


        // Printer becomes busy now

        isPrinting = true;

        System.out.println(user + " is printing: " + documentName);


        try {

            Thread.sleep(1000); // simulate printing time

        } catch (InterruptedException e) {

            System.out.println("Printing interrupted for " + user);

        }


        System.out.println(user + " finished printing: " + documentName);

        isPrinting = false;

        notify(); // notify other waiting users

    }

}


// User class implementing Runnable

class User implements Runnable {

    private String userName;

    private Printer printer;

    private boolean running = true;


    User(String name, Printer printer) {

        this.userName = name;

        this.printer = printer;

    }


    @Override

    public void run() {

        int docCount = 1;

        while (running && docCount <= 3) { // Each user prints 3 documents

            String docName = "Document_" + docCount;

            printer.printDocument(userName, docName);

            docCount++;


            try {

                Thread.sleep(500); // wait before sending next print

            } catch (InterruptedException e) {}

        }

        System.out.println(userName + " has completed all print jobs and stopped safely.");

    }


    public void stopUser() {

        running = false; // safely stop user thread

    }

}


// Main class

public class Lab 7 {

    public static void main(String[] args) throws InterruptedException {

        Printer sharedPrinter = new Printer();


        Thread user1 = new Thread(new User("User1", sharedPrinter));

        Thread user2 = new Thread(new User("User2", sharedPrinter));

        Thread user3 = new Thread(new User("User3", sharedPrinter));


        // Display thread states before starting

        System.out.println("Before start: " + user1.getName() + " state = " + user1.getState());


        user1.start();

        user2.start();

        user3.start();


        Thread.sleep(2000);


        // Display thread states during execution

        System.out.println("\nDuring execution:");

        System.out.println(user1.getName() + " state = " + user1.getState());

        System.out.println(user2.getName() + " state = " + user2.getState());

        System.out.println(user3.getName() + " state = " + user3.getState());


        // Wait for users to finish

        user1.join();

        user2.join();

        user3.join();


        System.out.println("\nAfter completion:");

        System.out.println(user1.getName() + " state = " + user1.getState());

        System.out.println(user2.getName() + " state = " + user2.getState());

        System.out.println(user3.getName() + " state = " + user3.getState());


        System.out.println("\nMain thread exiting...");

    }


}
