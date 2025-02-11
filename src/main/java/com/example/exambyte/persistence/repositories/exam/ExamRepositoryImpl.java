package com.example.exambyte.persistence.repositories.exam;

import com.example.exambyte.applicationService.serviceRepository.ExamRepository;
import com.example.exambyte.domainLayer.model.exam.Exam;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public class  ExamRepositoryImpl implements ExamRepository {
    private final ExamDataRepository examDataRepository;

    public ExamRepositoryImpl(ExamDataRepository examDataRepository) {
        this.examDataRepository = examDataRepository;
    }

    private Exam toExam(ExamDto dto){
        return new Exam(dto.fachId(), dto.name(), dto.startTime(), dto.endTime());
    }

    private ExamDto toExamDto(Exam exam) {
        return new ExamDto(null,exam.getFachId(), exam.getName(), exam.getStartTime(),exam.getEndTime());
    }


    @Override
    public Collection<Exam> findAll() {
        return examDataRepository.findAll()
                .stream()
                .map(this::toExam)
                .toList();
    }


    @Override
    public Exam findById(UUID id) {
        return examDataRepository.findByFachId(id)
                .map(this::toExam)
                .orElse(null);
    }
    //inn save muss man fachlicheID speichern

    @Override
    public void save(Exam exam){

        ExamDto examDto = toExamDto(exam);
        examDataRepository.save(examDto);
    }

//    @Override
//    public void deleteTest(Exam test){
//        examDataRepository.findByFachId(test.getId());
//    }

}
