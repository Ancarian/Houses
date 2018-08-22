package dev.chermenin.repository.util;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@NoArgsConstructor
public class PageRequestBuilder {
    private int page = 0;
    @Value("${pageable.size}")
    private int size = 15;
    private Sort sort;

    public PageRequestBuilder setPage(int page) {
        this.page = page;
        return this;
    }

    public PageRequestBuilder setSort(String sorts) {
        if (sorts == null) {
            return this;
        }
        String[] values = sorts.split(":");
        if (values.length == 2) {
            this.sort = new Sort(Sort.Direction.valueOf(values[0].toUpperCase()), values[1]);
        }
        return this;
    }

    public PageRequest build() {
        if (sort == null) {
            return PageRequest.of(page, size);
        }
        return PageRequest.of(page, size, sort);
    }

}
