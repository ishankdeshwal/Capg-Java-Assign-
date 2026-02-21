import java.util.*;
import java.io.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

// class Student implements Serializable {
//     String name;
//     int id, marks;

//     Student(String name, int id, int marks) {
//         this.name = name;
//         this.id = id;
//         this.marks = marks;
//     }

//     @Override
//     public String toString() {
//         return id + " " + name + " " + marks;
//     }
// }

class Account {
    int accountNumber;
    String accountHolderName;
    double balance;

    Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        } else {
            balance -= amount;
        }
    }

    void transfer(Account toAccount, double amount) throws InsufficientBalanceException, AccountNotFoundException {
        if (toAccount == null) {
            throw new AccountNotFoundException("Destination account not found");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for transfer");
        } else {
            balance -= amount;
            toAccount.deposit(amount);
        }
    }
}


class Main {
    static void q1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        try {
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed");
        }
    }

    static void q2() {
        try {
            FileReader fr = new FileReader("input.txt");
            System.out.println("I/O operation completed successfully.");
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
        }
    }

    static void q3() {
        File file = new File("sample.dat");

        try {
            file.createNewFile();
            Student s1 = new Student("Smith", 1, 76);
            Student s2 = new Student("Allen", 2, 65);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(s1);
            oos.writeObject(s2);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            while (true) {
                try {
                    Student s = (Student) ois.readObject();
                    System.out.println(s);
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found.");
                } catch (EOFException e) {
                    System.out.println("end of file reached. all objects read.");
                    break;
                }
            }

            ois.close();

        } catch (IOException e) {
            System.out.println("An I/O error occurred while creating the file.");
        }
    }

    static void q4() {
        File file = new File("sample.txt");
        try {
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
            fw.write("This is a sample text");
            fw.close();

            FileReader fr = new FileReader(file);
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            fr.close();
        } catch (IOException e) {
            System.out.print("Error creating file.");
        }
    }

    static void q5() {
        HashMap<Integer, Account> accounts = new HashMap<>();
        accounts.put(1, new Account(1, "Alice", 1000));
        accounts.put(2, new Account(2, "Bob", 500));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source account number: ");
        int fromAccountNumber = sc.nextInt();
        System.out.print("Enter destination account number: ");
        int toAccountNumber = sc.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        sc.close();

        try {
            Account fromAccount = accounts.get(fromAccountNumber);
            Account toAccount = accounts.get(toAccountNumber);

            if (fromAccount == null) {
                throw new AccountNotFoundException("Source account not found");
            }
            if (toAccount == null) {
                throw new AccountNotFoundException("Destination account not found");
            }

            fromAccount.transfer(toAccount, amount);
            System.out.println("Transfer successful. New balance: " + fromAccount.balance);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction ended.");
        }   
    }

    static void q6() {
        Scanner sc = new Scanner(System.in);
        File file = new File("quotes.txt");
        System.out.print("What to do? (1: Add Quote, 2: View All Quotes, 3: Search Quote by Keyword, 4: Sort Quotes Alphabetically, 5: Generate Random Quote, 6. Exit): ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        while (choice != 6) {
            switch (choice) {
                case 1:
                    try {
                        file.createNewFile();
                        FileWriter fw = new FileWriter("quotes.txt", true);
                        System.out.print("Enter quote to add: ");
                        String quote = sc.nextLine();
                        fw.write(quote + "\n");
                        fw.close();
                    } catch (IOException e) {
                        System.out.println("An I/O error occurred while writing to the file.");
                    }
                    break;
                case 2:
                    try {
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                        fr.close();
                    } catch (IOException e) {
                        System.out.println("An I/O error occurred while reading the file.");
                    }
                    break;
                case 3:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    try {                
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.contains(keyword)) {
                                System.out.println(line);
                            }
                        }
                        br.close();
                    } catch (IOException e) {
                        System.out.println("An I/O error occurred while reading the file.");
                    }
                    break;
                case 4:
                    try {
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        List<String> quotes = new ArrayList<>();
                        String line;
                        while ((line = br.readLine()) != null) {
                            quotes.add(line);
                        }
                        br.close();
                        Collections.sort(quotes);
                        for (String q : quotes) {
                            System.out.println(q);
                        }
                    } catch (IOException e) {
                        System.out.println("An I/O error occurred while reading the file.");
                    }
                    break;
                case 5:
                    try {
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        List<String> quotes = new ArrayList<>();
                        String line;
                        while ((line = br.readLine()) != null) {
                            quotes.add(line);
                        }
                        br.close();
                        if (!quotes.isEmpty()) {
                            Random rand = new Random();
                            String randomQuote = quotes.get(rand.nextInt(quotes.size()));
                            System.out.println(randomQuote);
                        } else {
                            System.out.println("No quotes available.");
                        }
                    } catch (IOException e) {
                        System.out.println("An I/O error occurred while reading the file.");
                    }
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("What to do? (1: Add Quote, 2: View All Quotes, 3: Search Quote by Keyword, 4: Sort Quotes Alphabetically, 5: Generate Random Quote, 6. Exit): ");
            choice = sc.nextInt();
            sc.nextLine(); 
        }
        sc.close();
        System.out.println("Exiting the program. Goodbye!");
    }

    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 3, 50000));
        employees.add(new Employee("Bob", 1, 60000));
        employees.add(new Employee("Charlie", 2, 55000));

        System.out.println("Before sorting:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees);

        System.out.println("\nAfter sorting:");

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private int id, salary;

    Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + salary;
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int rollNo, marks;

    Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo       ;
    }
    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }

    @Override
    public String toString() {
        return rollNo + " " + name + " " + marks;
    }
}```