package com.example.graphql.type;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;


@Data
@NoArgsConstructor
public class CustomSort {

    private String field;
    private CustomDirection order;

    public CustomSort(String field, CustomDirection order) {
        this.field = field;
        this.order = order;
    }

    public Sort toSort() {
        return Sort.by(Sort.Direction.fromString(order.name()), field);
    }
}


