class Book {
    String title;
    String author;
    double price;
    public Book(String title, String author, double price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void display()
    {
        System.out.println("The title of the book is: " + title);
        System.out.println("The author of the book is: "+ author);
        System.out.println("The price of the book is:$ "+price);
    }
}
public class Lab1{
    public static void main(String args[])
    {
        Book b1=new Book("The Great Gatsby","F. Scott Fitzgerald",279.99);
        
        Book b2 = new Book("1984", "George Orwell", 199.99);
        b1.display();
        b2.display();
    }
} 

