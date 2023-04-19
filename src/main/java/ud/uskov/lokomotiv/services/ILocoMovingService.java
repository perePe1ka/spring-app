package ud.uskov.lokomotiv.services;

import org.xml.sax.SAXException;
import ud.uskov.lokomotiv.models.LocoMoving;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface ILocoMovingService {
//    public void create(LocoMoving locoMoving) throws ParserConfigurationException, IOException, TransformerException, SAXException;

    void creat(LocoMoving locoMoving) throws ParserConfigurationException, IOException, TransformerException, SAXException;

    List<LocoMoving> readAll() throws ParserConfigurationException, IOException, SAXException;

    LocoMoving read(int id) throws ParserConfigurationException, IOException, ClassNotFoundException, SAXException;

    boolean update(LocoMoving locoMoving, int id) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    boolean delete(int id) throws ParserConfigurationException, IOException, TransformerException, SAXException;
}
