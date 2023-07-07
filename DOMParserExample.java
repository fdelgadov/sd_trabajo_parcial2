import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParserExample {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(args[0]));
            Element root = document.getDocumentElement();

            System.out.println("Elemento raíz: " + root.getNodeName());

            print(root, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public static void print(Element e, String t) {
        System.out.println(t + "Elemento: " + e.getNodeName());
        NodeList nl = e.getChildNodes();
        if(nl.getLength() == 1) {
            System.out.println(t + "Contenido: " + e.getTextContent() + "\n");
        }
       
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeType() == Node.ELEMENT_NODE) {
                Element temp = (Element) n;
                print(temp, t + "  ");
            }
        }
    }
}

