package com.pat.basicapp.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TestJava8 j8 = new TestJava8();
        j8.display();
        j8.lambda();
        j8.display(j8.filter());
        j8.map();
        j8.reduce();
        j8.comparator();
        j8.sorted();
    }
}
