package Kim.OwnHub.service;


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
    private final TeamRepository teamRepository;

    //유저아이디 조회용
    public boolean findUserId(String userId){

         if(userRepository.findByUserId(userId) != null){
             return false;
         }else{
             return true;
         }
    }



    public String getUserPw(String userId){

        return userRepository.findByUserId(userId).getUserPw();
    }

    //회원가입 데이터 영속화 용
    public void joining(UserInfo userInfo){

        userRepository.save(userInfo);
    }
}
