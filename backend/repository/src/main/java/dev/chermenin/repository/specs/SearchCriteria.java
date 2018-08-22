package dev.chermenin.repository.specs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}