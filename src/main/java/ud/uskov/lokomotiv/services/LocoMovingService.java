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
public class LocoMovingService implements ILocoMovingService{
    private final ILocoMovingRepository iLocoMovingRepository;

    @Override
    public void creat(LocoMoving locoMoving) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        iLocoMovingRepository.save(locoMoving);
    }

    @Override
    public List<LocoMoving> readAll() throws ParserConfigurationException, IOException, SAXException {
        return iLocoMovingRepository.findAll();
    }

    @Override
    public LocoMoving read(int id) throws ParserConfigurationException, IOException, ClassNotFoundException, SAXException {
        return iLocoMovingRepository.findById(id);
    }

    @Override
    public boolean update(LocoMoving locoMoving, int id) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        iLocoMovingRepository.update(locoMoving,id);
        return false;
    }

    @Override
    public boolean delete(int id) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        iLocoMovingRepository.deleteById(id);
        return true;
    }

    public int getLastId() throws ParserConfigurationException, IOException, SAXException {
        ILocoMovingRepository locoMovingRepository = new ILocoMovingRepository();
        List<LocoMoving> locoMovingList = locoMovingRepository.findAll();
        if (!locoMovingList.isEmpty()) {
            LocoMoving lastLocoMoving = locoMovingList.get(locoMovingList.size() - 1);
            return lastLocoMoving.getId();
        } else {
            return 0;
        }
    }


}
