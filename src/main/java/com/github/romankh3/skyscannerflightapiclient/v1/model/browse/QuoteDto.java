package com.github.romankh3.skyscannerflightapiclient.v1.model.browse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data transfer object Quota.
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
@Data
public class QuoteDto {

    @JsonProperty("QuoteId")
    private Integer quoteId;

    @JsonProperty("MinPrice")
    private Integer minPrice;

    @JsonProperty("Direct")
    private Boolean direct;

    @JsonProperty("OutboundLeg")
    private LegDto outboundLeg;

    @JsonProperty("InboundLeg")
    private LegDto inboundLeg;

    @JsonProperty("QuoteDateTime")
    private String quoteDateTime;
}
