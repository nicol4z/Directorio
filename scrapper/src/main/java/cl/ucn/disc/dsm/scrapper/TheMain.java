package cl.ucn.disc.dsm.scrapper;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
 * Main class to scrappe the Directorio Telefonico of UCN.
 * @author Nicolas Barrios
 */

@Slf4j
public class TheMain {


    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * The starting point
     * @param args to use
     */

    public static void main(String[] args) throws IOException {


        log.debug("Starting the scrapping ..");

        //The id
        int id = 142;

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

        //Call The constructor
        Funcionario f = Funcionario.builder().id(id)
                .nombre(nombre)
                .cargo(cargo)
                .unidad(unidad)
                .email(email)
                .telefono(telefono)
                .oficina(oficina)
                .direccion(direccion)
                .build();

        //The list of Funcionarios
        List<Funcionario> funcionarios = new ArrayList<>();

        // Add the Funcionario into the list
        funcionarios.add(f);

        // Write the list of Funcionarios in JSON format
        FileUtils.writeStringToFile(new File("funcionarios.json"),
                GSON.toJson(funcionarios),
                StandardCharsets.UTF_8);

        log.debug("Done.");
    }

}