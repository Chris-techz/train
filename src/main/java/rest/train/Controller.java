package rest.train;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping("/get_reservation/{id}")
    Table reservation(@PathVariable int id) {
        MySQL obj = new MySQL();
        obj.retrieveReservation(id);
        return obj.getTable();
    }

    @GetMapping("/update_passagers_to_{number}/{id}")
    Table update(@PathVariable int id, @PathVariable int number) {
        MySQL obj = new MySQL();
        obj.updateNbPassagers(number, id);
        obj.retrieveReservation(id);
        return obj.getTable();
    }
}
