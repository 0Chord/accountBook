package miniProject.accountBook.service;

import miniProject.accountBook.domain.Calculator;
import miniProject.accountBook.repository.CalculatorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CalculatorService {
    CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public String register(Calculator calculator) {
        calculatorRepository.save(calculator);
        return calculator.getUsername();
    }

    public List<Calculator> findCalculators() {
        return calculatorRepository.findAll();
    }

    public Optional<Calculator> findOneCalculator(String calculatorId){
        Optional<Calculator> calculator = calculatorRepository.findById(calculatorId);
        if(calculator.isPresent()){
            return calculator;
        }else{
            return null;
        }
    }

    public String delete(Calculator calculator){
        calculatorRepository.remove(calculator);
        return calculator.getUsername();
    }
}
