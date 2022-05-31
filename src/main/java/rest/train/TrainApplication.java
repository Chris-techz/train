package rest.train;

import java.sql.ResultSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainApplication {

	public static void main(String[] args) {
		MySQL obj = new MySQL();

		obj.getReservation(1);

		obj.updateNbPassagers(1, 1);

		obj.getReservation(1);

	}

}
