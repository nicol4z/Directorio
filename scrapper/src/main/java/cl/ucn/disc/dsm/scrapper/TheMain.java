package cl.ucn.disc.dsm.scrapper;




import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;


import lombok.extern.slf4j.Slf4j;

/**
 * Main class to scrappe the Directorio Telefonico of UCN.
 * @author Nicolas Barrios
 */

@Slf4j
public class TheMain {
    /**
     * The starting point
     * @param args to use
     */

    public static void main(String[] args) throws IOException {


        log.debug("Starting the scrapping ..");

        //connect and get the Document
        Document doc = Jsoup.connect("https://admision01.ucn.cl/directoriotelefonicoemail/fichaGenerica/?cod=142").get();

        //Scrapping
        String nombre = doc.getElementById("lblNombre").text();
        String cargo = doc.getElementById("lblCargo").text();
        String unidad = doc.getElementById("lblUnidad").text();
        String email = doc.getElementById("lblEmail").text();
        String telefono = doc.getElementById("lblTelefono").text();
        String oficina = doc.getElementById("lblOficina").text();
        String direccion = doc.getElementById("lblDireccion").text();


        log.debug("Nombre: {}, Cargo: {}", nombre, cargo);

        log.debug("Done.");
    }

}