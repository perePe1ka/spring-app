package ud.uskov.lokomotiv.repository;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class LocoMovingRepository implements ErrorHandler {
    public void warning(SAXParseException e)  {
        System.out.println(e.getMessage());
        System.out.println("---------------------------------------------------");
        System.out.println("Dmitriy, its work");
        System.out.println("---------------------------------------------------");

    }

    public void error(SAXParseException e)  {
        System.out.println(e.getMessage());
        System.out.println("---------------------------------------------------");
        System.out.println("Dmitriy, its work");
        System.out.println("---------------------------------------------------");



    }

    public void fatalError(SAXParseException e) {
        System.out.println(e.getMessage());
        System.out.println("---------------------------------------------------");
        System.out.println("Dmitriy, its work");
        System.out.println("---------------------------------------------------");

    }
}