package ru.malygin.searcher.service;

import reactor.core.publisher.Flux;
import ru.malygin.searcher.model.SearchResponse;

public interface SearchService {

    Flux<SearchResponse> search(Long siteId,
                                String query);
}
