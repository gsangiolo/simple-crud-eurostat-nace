package com.luxoftInterview.demo.service;

import com.luxoftInterview.demo.model.Division;
import com.luxoftInterview.demo.repository.DivisionRepository;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DivisionService {

    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public void readDivisionsFromCSV(String filename) throws Exception {
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Division.class);

        Path filePath = Paths.get(filename);
        Reader reader = Files.newBufferedReader(filePath);
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(Division.class)
                .withMappingStrategy(mappingStrategy)
                .build();

        List<Division> items = csvToBean.parse();

        divisionRepository.saveAll(items);
    }

    public void insertDivisionItem(Division division) {
        divisionRepository.save(division);
    }

    public Division getDivisionById(String divisionId) {
        Optional<Division> divisionOptional = divisionRepository.findById(divisionId);
        if (divisionOptional.isPresent()) {
            return divisionOptional.get();
        }
        return null;
    }

    public void readDivisionsFromCSV(File file) throws Exception {
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Division.class);

        Reader reader = new FileReader(file);
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(Division.class)
                .withMappingStrategy(mappingStrategy)
                .build();

        List<Division> items = csvToBean.parse();

        divisionRepository.saveAll(items);
    }
}
