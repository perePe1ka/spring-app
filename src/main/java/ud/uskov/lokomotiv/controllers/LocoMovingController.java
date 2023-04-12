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
import java.util.List;

@RestController
@RequestMapping("/locoMove")
@AllArgsConstructor
public class LocoMovingController {
    private final LocoMovingService locoMovingService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody LocoMoving locoMoving) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        locoMovingService.creat(locoMoving);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/read")
    @ResponseBody
    public List<LocoMoving> read() throws ParserConfigurationException, IOException, SAXException {
        return locoMovingService.readAll();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<LocoMoving>>read(@PathVariable(name="id") int id) throws ParserConfigurationException, IOException, ClassNotFoundException, SAXException {
        final LocoMoving weapon=locoMovingService.read(id);

        return weapon!=null
                ? new  ResponseEntity<>(HttpStatus.OK)
                : new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody LocoMoving locoMoving) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        final boolean updated = locoMovingService.update(locoMoving, id);

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
}
