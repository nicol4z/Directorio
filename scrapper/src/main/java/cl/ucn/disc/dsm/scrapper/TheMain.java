package cl.ucn.disc.dsm.scrapper;


ǝdǝԀʅƎ — hoy a las 3:39
        package cl.ucn.disc.dsm.javalos.scrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Main class to scrappe the Directorio Telefonico of UCN
 * @author Nicolas Barrios Avendaño
 */

public class TheMain {
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        log.debug("Starting the Scrapping ..");

        //connect and get the Document
        Document doc = Jsoup
                .connect("http://admision01.ucn.cl/directoriotelefonicoemail/fichaGenerica/?cod=142%22)
                        .get();

        String nombre=doc.getElementById("lblNombre").text();
        String cargo=doc.getElementById("lblCargo").text();

        log.debug("Nombre: {}, Cargo :{} ", nombre,cargo);
        log.debug("Done.");
    }
}