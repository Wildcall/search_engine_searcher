package ru.malygin.searcher.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.malygin.searcher.model.SearchResponse;
import ru.malygin.searcher.searcher.util.AlphabetType;
import ru.malygin.searcher.searcher.util.Lemmantisator;
import ru.malygin.searcher.service.PageService;
import ru.malygin.searcher.service.SearchService;

import java.util.List;

import static ru.malygin.searcher.exception.ResponseException.fluxResponseNoContent;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private final PageService pageService;

    @Override
    public Flux<SearchResponse> search(Long siteId,
                                       String query) {
        List<String> words = Lemmantisator.getLemmas(query, AlphabetType.CYRILLIC);
        return pageService
                .search(siteId, words)
                .switchIfEmpty(fluxResponseNoContent("no pages"));
    }
}
