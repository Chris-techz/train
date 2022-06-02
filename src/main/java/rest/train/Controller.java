package rest.train;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/reserver_trajet_direct/{destination}/{nbPassagers}")
    Table reserveDirect(@PathVariable String destination, @PathVariable int nbPassagers) {
        MySQL obj = new MySQL();
        if (!destination.isEmpty() && nbPassagers != 0) {
            obj.reserve(destination, true, nbPassagers);
        }
        else {
            throw new BadArgumentException();
        }
        return obj.getTable();
    }

    @GetMapping("/reserver_trajet_non_direct/{destination}/{nbPassagers}")
    void reserveIndirect(@PathVariable String destination, @PathVariable int nbPassagers) {
        MySQL obj = new MySQL();
        if (!destination.isEmpty() && nbPassagers != 0) {
            obj.reserve(destination, false, nbPassagers);
        }
        else {
            throw new BadArgumentException();
        }
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable int id) {
        MySQL obj = new MySQL();
        obj.deleteEntry(id);
    }

}
