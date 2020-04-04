package com.example.graphql.resolver;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Data
@NoArgsConstructor
public class CustomPaging {
    private int page;
    private int size;

    public CustomPaging(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageRequest toPageRequest() {
        return PageRequest.of(page, size);
    }
}
