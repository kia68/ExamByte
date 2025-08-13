package com.example.exambyte.persistence.repositories.exam;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

//@Table("aufgabe")
//public class AufgabeDto implements Persistable<UUID> {
//
//    @Id
//    private UUID id;
//    private UUID examId;
//    private String title;
//    private Integer punkt;
//    private String type;
//    private String beschreibung;
//
//    @Transient
//    private boolean isNew;
//
//    public AufgabeDto(UUID id, UUID examId, String title, Integer punkt, String type, String beschreibung) {
//        this.id = id;
//        this.examId = examId;
//        this.title = title;
//        this.punkt = punkt;
//        this.type = type;
//        this.beschreibung = beschreibung;
//        this.isNew = (id == null); // neue Entitäten ohne ID → INSERT
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public UUID getExamId() {
//        return examId;
//    }
//
//    public void setExamId(UUID examId) {
//        this.examId = examId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Integer getPunkt() {
//        return punkt;
//    }
//
//    public void setPunkt(Integer punkt) {
//        this.punkt = punkt;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getBeschreibung() {
//        return beschreibung;
//    }
//
//    public void setBeschreibung(String beschreibung) {
//        this.beschreibung = beschreibung;
//    }
//
//    public void setNew(boolean aNew) {
//        isNew = aNew;
//    }
//
//    @Override public UUID getId() { return id; }
//    @Override public boolean isNew() { return isNew; }
//    public void markNotNew() { this.isNew = false; } // optional
//}



@Table("aufgabe")
public record AufgabeDto(@Id UUID id,
                         UUID examId,
                         String title,
                         Integer punkt,
                         String type,
                         String beschreibung) {
}