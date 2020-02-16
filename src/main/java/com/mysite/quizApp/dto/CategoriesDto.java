package com.mysite.quizApp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@Getter
public class CategoriesDto {

    @JsonProperty("trivia_categories")
    private List<CategoryDto> categories;

    @NoArgsConstructor
    @Getter
    @ToString
    public static class CategoryDto {
        private int id;
        private String name;
    }


}
