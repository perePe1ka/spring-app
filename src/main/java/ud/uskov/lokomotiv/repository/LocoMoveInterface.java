package ud.uskov.lokomotiv.repository;


import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;
import ud.uskov.lokomotiv.models.LocoMoving;

import javax.swing.text.Document;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Repository
public interface LocoMoveInterface {

    LocoMoving findById(int id) throws ClassNotFoundException, ParserConfigurationException, IOException, SAXException;

    void save(LocoMoving locoMoving) throws ParserConfigurationException, TransformerException, IOException, SAXException;

    void deleteById(int id) throws ParserConfigurationException, TransformerException, IOException, SAXException;

    void update(LocoMoving locoMoving, int id) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    void LocoWriteAll(List<LocoMoving> list) throws ParserConfigurationException, TransformerException;

    List<LocoMoving> findAll() throws ParserConfigurationException, IOException, SAXException;


}
