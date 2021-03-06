package com.giovane.soccer.config.swagger.annotations.standardcodes;

import java.lang.annotation.*;
import io.swagger.annotations.*;
import com.giovane.soccer.exceptions.details.ExceptionDetailsNotFound;
import static java.lang.annotation.ElementType.*;
import static com.giovane.soccer.config.swagger.annotations.constants.TeamConstantsParameterSwagger.*;
import static com.giovane.soccer.config.swagger.annotations.constants.TeamConstantsOperationSwagger.*;

@Target({ METHOD, ANNOTATION_TYPE, TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(code = 204, message = "Team has been updated"),
        @ApiResponse(code = 400, message = "Body or request did not respect the constraints"),
        @ApiResponse(code = 404, message = "Team ID does not exist", response = ExceptionDetailsNotFound.class)
})
@ApiImplicitParams({
        @ApiImplicitParam(name = "id", required = true,  value = TEAM_ID_DESCRIPTION_PARAM),
        @ApiImplicitParam(name = "team", required = true,  value = TEAM_DESCRIPTION_PARAM)
})
@ApiOperation(value = TEAM_PUT_SUMMARY_OP, notes = TEAM_PUT_DESCRIPTION_OP)
public @interface TeamPutStandardCode {

}
