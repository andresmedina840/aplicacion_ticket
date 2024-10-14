package co.com.andresmedina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.andresmedina.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
