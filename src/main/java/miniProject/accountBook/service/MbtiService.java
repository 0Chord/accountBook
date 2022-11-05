package miniProject.accountBook.service;

import miniProject.accountBook.domain.Mbti;
import miniProject.accountBook.repository.MbtiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class MbtiService {

    MbtiRepository mbtiRepository;

    public MbtiService(MbtiRepository mbtiRepository) {
        this.mbtiRepository = mbtiRepository;
    }

    public void store(Mbti mbti) {
        mbtiRepository.save(mbti);
    }

    public Mbti findByName(String username) {
        System.out.println(        mbtiRepository.findByUsername(username)
);
        Optional<Mbti> mbti = mbtiRepository.findByUsername(username);
        if(mbti.isEmpty()){
            return null;
        }else{
            return mbti.get();
        }
    }

    public void updateMbti(String username, String result) {
        Mbti mbti = mbtiRepository.findByUsername(username).get();
        mbti.updateMbti(result);
    }
}
