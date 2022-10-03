package miniProject.accountBook.service;

import miniProject.accountBook.domain.Calculator;
import miniProject.accountBook.repository.CalculatorRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class CalculatorService {
    CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public String register(Calculator calculator) {
        calculatorRepository.save(calculator);
        return calculator.getId();
    }

    public List<Calculator> findCalculators() {
        return calculatorRepository.findAll();
    }

    public Optional<Calculator> findOneCalculator(String calculatorId){
        return calculatorRepository.findById(calculatorId);
    }
}
