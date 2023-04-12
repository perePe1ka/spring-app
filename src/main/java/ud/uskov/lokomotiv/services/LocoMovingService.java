package ud.uskov.lokomotiv.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import ud.uskov.lokomotiv.models.LocoMoving;
import ud.uskov.lokomotiv.repository.ILocoMovingRepository;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class LocoMovingService {
    private final ILocoMovingRepository iLocoMovingRepository;

    public void creat(LocoMoving locoMoving) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        iLocoMovingRepository.save(locoMoving);
    }

    public List<LocoMoving> readAll() throws ParserConfigurationException, IOException, SAXException {
        return iLocoMovingRepository.findAll();
    }

    public LocoMoving read(int id) throws ParserConfigurationException, IOException, ClassNotFoundException, SAXException {
        return iLocoMovingRepository.findById(id);
    }

    public boolean update(LocoMoving locoMoving, int id) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        iLocoMovingRepository.update(locoMoving,id);
        return false;
    }

    public boolean delete(int id) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        iLocoMovingRepository.deleteById(id);
        return true;
    }
}
