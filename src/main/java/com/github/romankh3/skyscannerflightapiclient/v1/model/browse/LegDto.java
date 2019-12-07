package com.github.romankh3.skyscannerflightapiclient.v1.model.browse;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Data transfer object for "Leg".
 *
 * @since 0.1
 * @author Roman Beskrovnyi
 */
public class LegDto {

    @JsonProperty("OriginId")
    private Integer originId;

    @JsonProperty("DestinationId")
    private Integer destinationId;

    @JsonProperty("DepartureDate")
    private String departureDate;

    @JsonProperty("CarrierIds")
    private List<Integer> carrierIds;
}
