package com.returns.calculator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Domain {

        private final long id;
        private final String content;

        public Domain(long id, String content) {
            this.id = id;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        @JsonProperty(required = true)
        @ApiModelProperty(notes = "Domain object", required = true)
        public String getContent() {
            return content;
        }
}
