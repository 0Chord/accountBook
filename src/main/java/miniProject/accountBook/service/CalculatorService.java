package miniProject.accountBook.service;

import miniProject.accountBook.calculator.Calculator;
import miniProject.accountBook.controller.CalculatorForm;
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

    public String register(CalculatorForm calculatorForm) {
        Calculator calculator = new Calculator();
        calculator.setId(calculatorForm.getId());
        calculator.setImport_sum(calculatorForm.getImport_sum());
        calculator.setExport_sum(calculatorForm.getExport_sum());
        calculator.setDate(calculatorForm.getDate());
        return calculator.getId();
    }

    public List<Calculator> findCalculators() {
        return calculatorRepository.findAll();
    }

    public Optional<Calculator> findOneCalculator(String calculatorId){
        return calculatorRepository.findById(calculatorId);
    }
}
