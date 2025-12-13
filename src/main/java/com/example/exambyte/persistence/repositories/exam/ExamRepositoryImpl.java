package com.example.exambyte.persistence.repositories.exam;

import com.example.exambyte.applicationService.serviceRepository.ExamRepository;
import com.example.exambyte.domainLayer.model.exam.Aufgabe;
import com.example.exambyte.domainLayer.model.exam.Exam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ExamRepositoryImpl implements ExamRepository {
    private final ExamDataRepository examDataRepository;
    private final AufgabeDataRepository aufgabeDataRepository;

    public ExamRepositoryImpl(ExamDataRepository examDataRepository, AufgabeDataRepository aufgabeDataRepository) {
        this.examDataRepository = examDataRepository;
        this.aufgabeDataRepository = aufgabeDataRepository;
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
        ExamDto examDto = examDataRepository.findByFachId(id);

        if (examDto == null) {
            return null;
        }
        Exam exam = toExam(examDto);

        List<Aufgabe> aufgaben = aufgabeDataRepository.findByExamId(id)
                .stream()
                .map(this::toAufgabe)
                .collect(Collectors.toCollection(ArrayList::new));
        exam.setAufgabe(aufgaben);
        return exam;

        // return toExam(results.get(0)); // oder ggf. bessere Auswahl
    }

    private Exam toExam(ExamDto dto) {
        return new Exam(dto.fachId(), dto.name(), dto.startTime(), dto.endTime(), dto.publishDate(), new ArrayList<>());
    }

    private Aufgabe toAufgabe(AufgabeDto aufgabeDto) {
        return new Aufgabe(aufgabeDto.id(), aufgabeDto.examId(), aufgabeDto.title(), aufgabeDto.punkt(),
                aufgabeDto.type(), aufgabeDto.beschreibung(), aufgabeDto.loesung(), aufgabeDto.optionen(),
                aufgabeDto.erklaerung());
    }

    private ExamDto toExamDto(Exam exam) {
        return new ExamDto(null, exam.getExamId(), exam.getName(), exam.getStartTime(), exam.getEndTime(),
                exam.getPublishDate());
    }

    private AufgabeDto toAufgabeDto(Aufgabe aufgabe) {
        return new AufgabeDto(
                aufgabe.getId(),
                aufgabe.getExamId(),
                aufgabe.getTitle(),
                aufgabe.getPunkt(),
                aufgabe.getType(),
                aufgabe.getBeschreibung(),
                aufgabe.getLoesung(),
                aufgabe.getOptionen(),
                aufgabe.getErklaerung());
    }

    @Override
    public void saveAufgabe(Aufgabe aufgabe) {
        AufgabeDto dto;
        if (aufgabe.getId() == null) {
            dto = new AufgabeDto(
                    null,
                    aufgabe.getExamId(),
                    aufgabe.getTitle(),
                    aufgabe.getPunkt(),
                    aufgabe.getType(),
                    aufgabe.getBeschreibung(),
                    aufgabe.getLoesung(),
                    aufgabe.getOptionen(),
                    aufgabe.getErklaerung());
        } else {
            dto = toAufgabeDto(aufgabe);
        }
        aufgabeDataRepository.save(dto);
    }

    @Override
    public void save(Exam exam) {
        // ExamDto exist = examDataRepository.findByFachId(exam.getFachId());
        examDataRepository.save(toExamDto(exam));
    }

}
