package com.example.gateway.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResponses {

        @JsonProperty("status")
        private String status;

        @JsonProperty("data")
        private List<CommonResponses> employeeList;
}
