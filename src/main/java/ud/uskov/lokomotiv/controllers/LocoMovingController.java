package ud.uskov.lokomotiv.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import ud.uskov.lokomotiv.models.LocoMoving;
import ud.uskov.lokomotiv.services.LocoMovingService;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/locoMove")
@AllArgsConstructor
public class LocoMovingController {
    private final LocoMovingService locoMovingService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody LocoMoving locoMoving) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        if (isDuplicateId(locoMoving.getId())) {
            return new ResponseEntity<>("Ебло стяни, ID занято", HttpStatus.BAD_REQUEST);
        }
        locoMovingService.creat(locoMoving);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/read")
    @ResponseBody
    public List<LocoMoving> read() throws ParserConfigurationException, IOException, SAXException {
        return locoMovingService.readAll();
    }
    @GetMapping(value = "/{id}")
    public List<LocoMoving> readID(@PathVariable int id) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException {
        return Collections.singletonList(locoMovingService.read(id));
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody LocoMoving locoMoving) throws ParserConfigurationException, IOException, SAXException, TransformerException {
//        final boolean updated = locoMovingService.update(locoMoving, id);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody LocoMoving locoMoving) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        if (isDuplicateId(locoMoving.getId())) {
            return new ResponseEntity<>("Duplicate ID found", HttpStatus.BAD_REQUEST);
        }
        locoMoving.setId(id); // устанавливаем ID объекта
        final boolean updated = locoMovingService.update(locoMoving, id); // обновляем объект
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        final boolean deleted = locoMovingService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    private boolean isDuplicateId(int id) throws ParserConfigurationException, IOException, SAXException {
        List<LocoMoving> locoMovingList = locoMovingService.readAll();
        for (LocoMoving locoMoving : locoMovingList) {
            if (locoMoving.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
