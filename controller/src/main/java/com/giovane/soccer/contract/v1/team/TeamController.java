package com.giovane.soccer.contract.v1.team;

import javax.validation.Valid;
import com.giovane.soccer.contract.model.response.TeamResponseController;
import com.giovane.soccer.contract.model.request.TeamRequestController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.giovane.soccer.config.swagger.annotations.standardcodes.*;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/soccer/team")
public class TeamController {

    private final TeamControllerFacade facade;

    @ResponseStatus(CREATED)
    @PostMapping
    @TeamSaveStandardsCode
    public TeamResponseController saveTeam(@RequestBody @Valid TeamRequestController team) {
       return facade.saveTeam(team);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "/{id}")
    @TeamPutStandardCode
    public TeamResponseController updateTeamById(@RequestBody @Valid TeamRequestController team, @PathVariable("id") Integer id) {
        return facade.updateTeamById(team, id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    @TeamDeleteIdStandardCode
    public void deleteTeamById(@PathVariable("id") Integer id) {
        facade.deleteTeamById(id);
    }

    @ResponseStatus(OK)
    @GetMapping(path = "/{id}")
    @TeamGetIdStandardCode
    public TeamResponseController findTeamById(@PathVariable("id") Integer id) {
        return facade.findTeamById(id);
    }

    @ResponseStatus(OK)
    @GetMapping(path = "/findAll")
    @TeamGetAllStandardCode
    public List<TeamResponseController> findAllTeams() {
        return facade.findAllTeams();
    }

}
