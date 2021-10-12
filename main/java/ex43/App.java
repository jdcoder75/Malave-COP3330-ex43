package ex43;
/*
 *  UCF COP3330 Fall 2021 Assignment 43 Solution
 *  Copyright 2021 Jose Malave
 */
 import java.awt.Desktop;
 import java.io.*;
 import java.util.Scanner;

 //this one I had a bit of an issue getting to work. It was abel to make the html file.
// but when it came to making any other files, or directories, I didn't know exactly what to do
   public class App {

       //found this to be quite similar to making a text file
     //we are going to take the inputs from main and then have them create
       public static void create_website(String name, String author, char javaScript, char css)throws IOException
       {
           System.out.println("Created ./website/" + name);
           File f = new File("index.htm");
           System.out.println("Created ./website/" + name + "/index.html");

           BufferedWriter writer = new BufferedWriter(new FileWriter(f));
           writer.write("<html><body><meta name = "+author+">");
           writer.write("<title>"+ name+ "</title>");
           writer.write("<textarea cols=75 rows=10>");

           writer.write("</textarea>");
           writer.write("</body></html>");
           writer.close();
           if (javaScript == 'y' || javaScript == 'Y'){
               System.out.println("Created ./website/" + name + "/js/");
           }
           if (css == 'y' || css == 'Y'){
               System.out.println("Created ./website/" + name + "/css/");
           }
           Desktop.getDesktop().browse(f.toURI());
       }

//here we want to ask all the questions first before sending it all to the method above
       public static void main(String[] args) throws IOException {
           //all of our input variables
           Scanner sc = new Scanner(System.in);
           String name;
           String author;
           char javaScript;
           char css;

           System.out.println("Site name:");
           name = sc.nextLine();
           System.out.println("Author:");
           author = sc.nextLine();
           System.out.println("Do you want a folder for JavaScript?");
           javaScript = sc.next().charAt(0);
           System.out.println("Do you want a folder for CSS?");
           css = sc.next().charAt(0);

           //here is were we are going to make the method call
           create_website(name, author, javaScript, css);

       }
 }

