package co.com.andresmedina.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import co.com.andresmedina.entity.Ticket;
import co.com.andresmedina.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Page<Ticket> getAllTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setFechaActualizacion(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setUsuario(updatedTicket.getUsuario());
            ticket.setEstatus(updatedTicket.getEstatus());
            ticket.setFechaActualizacion(LocalDateTime.now());
            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

