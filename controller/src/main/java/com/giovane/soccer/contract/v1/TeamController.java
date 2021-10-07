package com.giovane.soccer.contract.v1;

import com.giovane.soccer.config.swagger.annotations.standardcodes.*;
import com.giovane.soccer.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.giovane.soccer.service.TeamService;
import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/soccer/team")
public class TeamController {

    private final TeamService service;

    @ResponseStatus(CREATED)
    @PostMapping
    @TeamSaveStandardsCode
    public TeamResponse saveTeam(@RequestBody @Valid TeamRequest team) {
        return service.saveTeam(team);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "/{id}")
    @TeamPutStandardCode
    public void updateTeamById(@RequestBody @Valid TeamRequest team, @PathVariable("id") Integer id) {
        service.updateTeamById(team, id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    @TeamDeleteStandardCode
    public void deleteTeamById(@PathVariable("id") Integer id) {
        service.deleteTeamById(id);
    }

    @ResponseStatus(OK)
    @GetMapping(path = "/{id}")
    @TeamGetStandardCode
    public TeamResponse findTeamById(@PathVariable("id") Integer id) {
        return service.findTeamById(id);
    }

    @ResponseStatus(OK)
    @GetMapping(path = "/findAll")
    @TeamGetAllStandardCode
    public List<TeamResponse> findAllTeams() {
        return service.findAllTeams();
    }

}
