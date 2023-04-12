package ud.uskov.lokomotiv.repository;
//

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import ud.uskov.lokomotiv.models.LocoMoving;


@Repository
public class ILocoMovingRepository {
    public List<LocoMoving> findAll() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<LocoMoving> locoMovings = new ArrayList<>();
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = sf.newSchema(new File("src/main/resources/data.xsd"));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setValidating(false);
        factory.setSchema(s);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new LocoMovingRepository());

        Document document = builder.parse(new File("src/main/resources/LocomotiveMovingContext.xml"));
        NodeList locosElement = document.getDocumentElement().getElementsByTagName("locoMoving");
        // Перебор всех элементов employee
        for (int i = 0; i < locosElement.getLength(); i++) {
            Node employee = locosElement.item(i);
            // Получение атрибутов каждого элемента
            NamedNodeMap attributes = employee.getAttributes();
            // Добавление сотрудника. Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
            locoMovings.add(new LocoMoving(
                    Integer.parseInt(attributes.getNamedItem("id").getNodeValue()),
                    Integer.parseInt(attributes.getNamedItem("mileage").getNodeValue()),
                    Integer.parseInt(attributes.getNamedItem("tankVolume").getNodeValue()),
                    Integer.parseInt(attributes.getNamedItem("serialNumber").getNodeValue()),
                    Boolean.parseBoolean(attributes.getNamedItem("isMoving").getNodeValue())
            ));
        }
        return locoMovings;
    }

    public LocoMoving findById(Integer id) throws ClassNotFoundException, ParserConfigurationException, IOException, SAXException {
        final List<LocoMoving> locoList = findAll();
        for (LocoMoving locoMoving : locoList
        ) {
            if (id == locoMoving.getSerialNumber()) {
                return locoMoving;
            }
        }

        throw new ClassNotFoundException();
    }

    public void save(LocoMoving locoMoving) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        List<LocoMoving> locoMovings = findAll();
        locoMovings.add(locoMoving);
        LocoWriteAll(locoMovings);
    }

    public void deleteById(int id) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        final List<LocoMoving> locoMovings = findAll().stream()
                .filter(w -> w.getSerialNumber() != id)
                .collect(Collectors.toList());
        LocoWriteAll(locoMovings);
    }

    public void update(LocoMoving locoMoving, int id) throws ParserConfigurationException, IOException, SAXException {
        List<LocoMoving> locoMovings = findAll();
        for (int i = 0; i < locoMovings.size(); i++) {
            if (locoMovings.get(i).getSerialNumber() == id) {
                locoMovings.set(i, locoMoving);
            }
        }
    }





    public void LocoWriteAll(List<LocoMoving> list) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("locoMovings");
        doc.appendChild(rootElement);

        for (LocoMoving r: list
        ) {
            Element locoMoving = doc.createElement("locoMoving");
            // add staff to root
            rootElement.appendChild(locoMoving);
            locoMoving.setAttribute("id", String.valueOf(r.getId()));
            locoMoving.setAttribute("serialNumber", String.valueOf(r.getSerialNumber()));
            locoMoving.setAttribute("mileage", String.valueOf(r.getMileage()));
            locoMoving.setAttribute("tankVolume", String.valueOf(r.getTankVolume()));
            locoMoving.setAttribute("isMoving", String.valueOf(r.isMoving()));
        }
        // add xml attribute


        //...create XML elements, and others...

        // write dom document to a file
        try (FileOutputStream output =
                     new FileOutputStream("src/main/resources/data.xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}
