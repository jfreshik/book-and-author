package com.example.graphql.type;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Data
@NoArgsConstructor
public class CustomPaging {
    private int page;
    private int size;
    private CustomSort sort;

    public CustomPaging(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public CustomPaging(int page, int size, CustomSort sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public PageRequest toPageRequest() {
        if (sort != null) {
            return PageRequest.of(page, size, sort.toSort());
        }
        return PageRequest.of(page, size);
    }
}
