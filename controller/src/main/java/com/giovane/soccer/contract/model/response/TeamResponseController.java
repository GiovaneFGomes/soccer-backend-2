package com.giovane.soccer.contract.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class TeamResponseController {

    @ApiModelProperty(example = "1")
    private Integer id;

    @ApiModelProperty(example = "Real Madrid")
    private String name;

    @ApiModelProperty(example = "Santiago Bernabéu")
    private String stadium;

    @ApiModelProperty(example = "Spain")
    private String country;

}
