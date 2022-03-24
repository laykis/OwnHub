package Kim.OwnHub.service;

import Kim.OwnHub.entity.Team;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.TeamRepository;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private TeamRepository teamRepository;
    private UserRepository userRepository;

    public Team findTeam(String tname){
        Team fteam = teamRepository.findByTname(tname);

        return fteam;
    }

    public void joining(UserInfo userInfo){

        userRepository.save(userInfo);
    }
}
