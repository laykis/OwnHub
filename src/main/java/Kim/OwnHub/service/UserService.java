package Kim.OwnHub.service;


import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.TeamRepository;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저아이디 조회용
    public boolean findUserId(String userId){

         if(userRepository.findByUserId(userId) != null){
             return false;
         }else{
             return true;
         }
    }

    public UserDTO getUserByUserId(String userId){

        return userRepository.findByUserId(userId);
    }


    //회원가입 데이터 영속화 용
    public void joining(UserInfo userInfo){

        userRepository.save(userInfo);
    }
}
