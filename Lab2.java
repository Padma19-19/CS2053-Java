public class Lab2 {
    public static void main(String args[]) {
        System.out.println("The number of arguments are: " + args.length);

        if (args.length == 4) {
            for (int i = 0; i < args.length; i++) {
                System.out.println("args[" + i + "]: " + args[i]);
            }

            String empId = args[0];
            String name = args[1];
            String department = args[2];
            String email = args[3];

            System.out.println("--- Employee Details ---");
            System.out.println("ID: " + empId);
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
            System.out.println("Email: " + email);
        }
    }
}