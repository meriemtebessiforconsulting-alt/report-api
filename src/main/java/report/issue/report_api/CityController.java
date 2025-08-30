package report.issue.report_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityRepository repository;
    private final AtomicLong idGenerator = new AtomicLong(34096);

    public CityController(CityRepository repository) {
        this.repository = repository;
    }

    // ✅ POST : créer une ville
    @PostMapping
    public City createCity(@RequestBody City city) {
        if (city.getId() == null) {
            city.setId(idGenerator.incrementAndGet());
        }
        return repository.save(city);
    }

    // ✅ GET : récupérer toutes les villes
    @GetMapping
    public List<City> getCities() {
        return repository.findAll();
    }

    // ✅ POST : ajouter une note
    @PostMapping("/notes")
    public ResponseEntity<City> addNoteToCity(@RequestParam String cityName, @RequestBody Note note) {
        City city = repository.findByDefaultName(cityName)
                .orElseGet(() -> {
                    City newCity = new City();
                    newCity.setId(idGenerator.incrementAndGet());
                    newCity.setDefaultName(cityName);
                    return newCity;
                });

        // impose le provider = DC
        note.setSrvProviderCode("DC");
        city.getNotes().add(note);

        City saved = repository.save(city);
        return ResponseEntity.ok(saved);
    }
}
