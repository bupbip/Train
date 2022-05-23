import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class XmlHomework {

    private void solve() {
        try {
            // Крадём из файла настройки
            File settings = new File("settings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(settings); // делаем из файла документ чтоб брать инфу
            Node node = doc.getElementsByTagName("array").item(0);
            String name = node.getAttributes().getNamedItem("name").getTextContent();
            node = doc.getElementsByTagName("attributeName").item(0);
            String value = node.getAttributes().getNamedItem("value").getTextContent();
            File library = new File("input.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(library);
            doc.getDocumentElement().normalize();
            Node bookStore = doc.getElementsByTagName(name).item(0); // берём из файла всё что в массиве name
            ArrayList<Node> resultNodes = new ArrayList<>();
            NodeList allBooksNodes = bookStore.getChildNodes();
            for (int i = 0; i < allBooksNodes.getLength(); i++) {
                if (allBooksNodes.item(i).getNodeType() == Node.ELEMENT_NODE) { // проверка на то что это не текст
                    resultNodes.add(allBooksNodes.item(i));
                }
            }
            resultNodes.sort(Comparator.comparing((Node o) -> o.getAttributes().getNamedItem(value).getTextContent()));
            for (int i = 0; i < resultNodes.size(); i++) { // замена
                node = allBooksNodes.item(i);
                Node newNode = resultNodes.get(i);
                bookStore.replaceChild(newNode, node);
            }
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes"); // энтер после записи ноды
            DOMSource source = new DOMSource(doc);
            FileOutputStream fos = new FileOutputStream("output.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            System.out.println("Ошибка, я в отпуск");
        }
    }

    public static void main(String[] args) {
        new XmlHomework().solve();
    }
}