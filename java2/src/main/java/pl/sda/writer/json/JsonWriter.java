package pl.sda.writer.json;

import com.google.gson.Gson;
import pl.sda.model.Employee;
import pl.sda.writer.Writable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 1. Powinien miec metode write
 * 2. Metoda write powinna miec taki sam argument jak metoda write na CsvWriterze
 * 3. W zwiazku z tym wydzielimy interfejs
 * 4. I go zaimplementujemy w obu klasach
 * 5. Po czym utworzymy fabryke, która to fabryka
 * na podstawie dostarczonego argumentu w postaci enuma
 * wybierze odpowiednią implementację writera.
 */
public class JsonWriter implements Writable {

    public void write(List<Employee> employees) throws IOException {
        Gson gson = new Gson();
        String s = gson.toJson(employees);
        FileWriter fileWriter = new FileWriter("employees.json");
        fileWriter.write(s);
        fileWriter.close();
    }
}
