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

    public void store(Mbti mbti){
        mbtiRepository.save(mbti);
    }

    public Optional<Mbti> findByName(String username){
        return mbtiRepository.findByUsername(username);
    }
}
