package Kim.OwnHub.service;


import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO getUserByUserId(String userId){
        UserInfo uinfo = userRepository.findByUserId(userId);
        UserDTO userDTO = new UserDTO();

        userDTO.setId(uinfo.getId());
        userDTO.setUserId(uinfo.getUserId());
        userDTO.setUserPw(uinfo.getUserPw());
        userDTO.setEmail(uinfo.getEmail());
        userDTO.setRole(uinfo.getRole());
        userDTO.setAuth(uinfo.getAuth());
        userDTO.setTeam(uinfo.getTeam());

        return userDTO;
    }

    public List<UserInfo> getAllUserByUsername(String username){

        List<UserInfo> ulist = new ArrayList<>();

        ulist = userRepository.findByUsername(username);

        return ulist;

    }

    public List<UserInfo> getAllUserByUserTeam(String team){

        List<UserInfo> ulist = new ArrayList<>();

        ulist = userRepository.findByTeam(team);
    

        return ulist;

    }


    //회원가입 데이터 영속화 용
    public void joining(UserInfo userInfo){

        userRepository.save(userInfo);
    }
}
