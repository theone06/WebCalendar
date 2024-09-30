package webCalendarSpring;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * Retrieves the events for today.
 *
 */
@RestController
@Validated
public class WebCalendarController {

    @Autowired
    private EventRepository eventRepository;

    String eventAddedMsg = "The event has been added!";

    @GetMapping(path = "/event/today")
    public ResponseEntity<?> getTodayEvents() {
        LocalDate today = LocalDate.now();
        List<Event> todayEvents = eventRepository.findByDate(today);
        return ResponseEntity
                .ok()
                .body(todayEvents);
    }

    /**
     * Handles HTTP POST requests to add a new event.
     *
     * @param event the Event object to be added, validated using @Valid annotation
     * @return a successful HTTP response with a message, event name, and event date
     */

    @PostMapping(path = "/event", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addEvent(@Valid @RequestBody Event event) {
        eventRepository.save(event);
        Map<String, String> response = new HashMap<>();
        response.put("message", eventAddedMsg);
        response.put("event", event.getEvent());
        response.put("date", event.getDate().toString());
        return ResponseEntity
                .ok()
                .body(response);
    }

    @GetMapping(path = "/event")
    public ResponseEntity<?> getAllEvents() {
        List<Event> allEvents = eventRepository.findAll();
        return allEvents.isEmpty() ? ResponseEntity
                .noContent()
                .build() : ResponseEntity
                .ok()
                .body(allEvents);
    }


    @GetMapping("/event/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") Long id) {
        Optional<Event> event = eventRepository.findById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "The event doesn't exist!");
        if (event.isEmpty()) {
          return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event.get(), HttpStatus.OK);
    }

    @DeleteMapping("/event/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable("id") Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "The event doesn't exist!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        eventRepository.deleteById(id);
        return new ResponseEntity<>(event.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/event", params = {"start_time", "end_time"})
    public ResponseEntity<?> getEventsByDate(@RequestParam("start_time") LocalDate startTime,
                                             @RequestParam("end_time") LocalDate endTime) {
        List<Event> events = eventRepository
                .findByDateBetween(startTime,endTime);
        if (events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}


