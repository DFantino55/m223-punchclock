package ch.zli.m223.model;

import javax.persistence.*;

import java.util.Set;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private long id;

  @Column(nullable = false)
  private String title;

  @OneToMany(mappedBy = "category")
  @JsonIgnore
  @Fetch(FetchMode.JOIN)
  private Set<Entry> entries;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}