package searchengine.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.StatisticsService;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final StatisticsService statisticsService;

    public ApiController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }

    @GetMapping("/startIndexing")
    public ResponseEntity<?> startIndexing() {
        if (statisticsService.isIndexing()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "result", false,
                    "error", "Индексация уже запущена"
            ));
        }
        statisticsService.startIndexing();
        return ResponseEntity.ok(Map.of("result", true));
    }

    @GetMapping("/stopIndexing")
    public ResponseEntity<?> stopIndexing() {
        if (!statisticsService.isIndexing()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "result", false,
                    "error", "Индексация не запущена"
            ));
        }
        statisticsService.stopIndexing();
        return ResponseEntity.ok(Map.of("result", true));
    }

}
