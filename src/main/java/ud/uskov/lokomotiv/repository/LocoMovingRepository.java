package ud.uskov.lokomotiv.repository;

import ud.uskov.lokomotiv.models.LocoMoving;
import org.springframework.stereotype.Repository;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class LocoMovingRepository implements ErrorHandler {
    public void warning(SAXParseException e)  {
        System.out.println(e.getMessage());
        System.out.println("---------------------------------------------------");
        System.out.println("Pavel Olegovich, i did it");
        System.out.println("---------------------------------------------------");

    }

    public void error(SAXParseException e)  {
        System.out.println(e.getMessage());
        System.out.println("---------------------------------------------------");
        System.out.println("Pavel Olegovich, i did it");
        System.out.println("---------------------------------------------------");



    }

    public void fatalError(SAXParseException e) {
        System.out.println(e.getMessage());
        System.out.println("---------------------------------------------------");
        System.out.println("Pavel Olegovich, i did it");
        System.out.println("---------------------------------------------------");

    }
}