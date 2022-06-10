package ru.malygin.searcher.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.malygin.searcher.model.SearchResponse;
import ru.malygin.searcher.service.SearchService;

@Slf4j
@RestController
@RequestMapping("api/v1/searcher")
@RequiredArgsConstructor
public class SearcherController {

    private final SearchService searchService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<SearchResponse> search(@RequestParam Long siteId,
                                       @RequestParam String query) {
        return searchService.search(siteId, query);
    }
}
