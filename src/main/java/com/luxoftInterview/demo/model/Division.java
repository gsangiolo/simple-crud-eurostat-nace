package com.luxoftInterview.demo.model;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "eurostatMetadata")
public class Division {
    //"Order","Level","Code",
    // "Parent","Description","This item includes",
    // "This item also includes","Rulings",
    // "This item excludes","Reference to ISIC Rev. 4"

    @Id
    @Column(name = "divisionOrder")
    @CsvBindByPosition(position = 0)
    private String order;

    @CsvBindByPosition(position = 1)
    @Column(name = "level")
    private String level;

    @CsvBindByPosition(position = 2)
    @Column(name = "code")
    private String code;

    @CsvBindByPosition(position = 3)
    @Column(name = "parent")
    private String parent;

    @CsvBindByPosition(position = 4)
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @CsvBindByPosition(position = 5)
    @Column(name = "itemIncludes", columnDefinition = "text")
    private String itemIncludes;

    @CsvBindByPosition(position = 6)
    @Column(name = "itemAlsoIncludes", columnDefinition = "text")
    private String itemAlsoIncludes;

    @CsvBindByPosition(position = 7)
    @Column(name = "rulings", columnDefinition = "text")
    private String rulings;

    @CsvBindByPosition(position = 8)
    @Column(name = "itemExcludes", columnDefinition = "text")
    private String itemExcludes;

    @CsvBindByPosition(position = 9)
    @Column(name = "referenceISICRev4", columnDefinition = "text")
    private String referenceISICRev4;

    public Division() {

    }

    public Division(String order, String level, String code, String parent, String description, String itemIncludes, String itemAlsoIncludes, String rulings, String itemExcludes, String referenceISICRev4) {
        this.order = order;
        this.level = level;
        this.code = code;
        this.parent = parent;
        this.description = description;
        this.itemIncludes = itemIncludes;
        this.itemAlsoIncludes = itemAlsoIncludes;
        this.rulings = rulings;
        this.itemExcludes = itemExcludes;
        this.referenceISICRev4 = referenceISICRev4;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemIncludes() {
        return itemIncludes;
    }

    public void setItemIncludes(String itemIncludes) {
        this.itemIncludes = itemIncludes;
    }

    public String getItemAlsoIncludes() {
        return itemAlsoIncludes;
    }

    public void setItemAlsoIncludes(String itemAlsoIncludes) {
        this.itemAlsoIncludes = itemAlsoIncludes;
    }

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }

    public String getItemExcludes() {
        return itemExcludes;
    }

    public void setItemExcludes(String itemExcludes) {
        this.itemExcludes = itemExcludes;
    }

    public String getReferenceISICRev4() {
        return referenceISICRev4;
    }

    public void setReferenceISICRev4(String referenceISICRev4) {
        this.referenceISICRev4 = referenceISICRev4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return order.equals(division.order) && level.equals(division.level) && code.equals(division.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, level, code);
    }
}
