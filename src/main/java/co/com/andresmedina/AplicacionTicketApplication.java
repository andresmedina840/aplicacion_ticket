package co.com.andresmedina;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionTicketApplication.class, args);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.of("es", "CO"));
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));

		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE dd/MM/yyyy hh:mm:ss a", Locale.of("es", "CO"));
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));

		System.out.println("Funcionando Backend Ticket: " + dateFormat.format(new Date()) + " - " + sdf.format(new Date()));

	}

}
