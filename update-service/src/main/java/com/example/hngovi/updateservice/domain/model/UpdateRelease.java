package com.example.hngovi.updateservice.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRelease {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String description;
}
