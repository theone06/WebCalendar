package webCalendarSpring;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
   List<Event> findByDate(LocalDate date);
   Optional<Event> findById(Long id);
   List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);
   void deleteById(Long id);

}

