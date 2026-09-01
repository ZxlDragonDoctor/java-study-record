package zxl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new Vector();
        list.add(new Book("三国志",12.0,"w"));
        list.add(new Book("水浒传",20.4,"x"));
        list.add(new Book("三国志",23.5,"y"));
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < i -j - 1; j++) {
               Book book1 = (Book)list.get(j);
               Book book2 = (Book)list.get(j + 1);
               if(book1.getPrice()>book2.getPrice()){
                   list.set(j+1,book1);
                   list.set(j,book2);
               }
            }
        }
        for (Object o :list) {
            System.out.println(o);
        }


    }
}
class Book{
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称" + name + "\t\t价格"  + price + "\t\t作者"  + author;
    }
}
