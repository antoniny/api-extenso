package br.org.certi.apiextenso.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "languages")
public class Language {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column
    private Integer id;

    @Size(max = 2) @NotNull @NotEmpty @Column
    private String locale;

    @NotNull @NotEmpty @Column(name = "messagekey")
    private String key;

    @NotNull @NotEmpty @Column(name = "messagecontent")
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language languages = (Language) o;

        if (id != null ? !id.equals(languages.id) : languages.id != null) return false;
        if (locale != null ? !locale.equals(languages.locale) : languages.locale != null) return false;
        if (key != null ? !key.equals(languages.key) : languages.key != null) return false;
        return content != null ? content.equals(languages.content) : languages.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
