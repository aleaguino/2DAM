package ArchivosTexto;

/**
 *
 * @author aleag
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CrearXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element persona = doc.createElement("persona");
            persona.setAttribute("profesion", "cantante");

            Element nombre = doc.createElement("nombre");
            Text nombreText = doc.createTextNode("Elsa");
            nombre.appendChild(nombreText);

            Element mujer = doc.createElement("mujer");

            Element fechaDeNacimiento = doc.createElement("fecha_de_nacimiento");
            Element mes = doc.createElement("mes");
            Text mesText = doc.createTextNode("6");
            mes.appendChild(mesText);

            Element ano = doc.createElement("ano");
            Text anoText = doc.createTextNode("1996");
            ano.appendChild(anoText);

            fechaDeNacimiento.appendChild(mes);
            fechaDeNacimiento.appendChild(ano);

            Element ciudad = doc.createElement("ciudad");
            Text ciudadText = doc.createTextNode("Pamplona");
            ciudad.appendChild(ciudadText);

            persona.appendChild(nombre);
            persona.appendChild(mujer);
            persona.appendChild(fechaDeNacimiento);
            persona.appendChild(ciudad);

            doc.appendChild(persona);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("persona.xml"));

            transformer.transform(source, result);

            System.out.println("Archivo XML creado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

