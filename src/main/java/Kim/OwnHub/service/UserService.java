package Kim.OwnHub.service;


import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO getUserByUserId(String userId){

        return userRepository.findByUserId(userId);
    }


    //회원가입 데이터 영속화 용
    public void joining(UserInfo userInfo){

        userRepository.save(userInfo);
    }
}
