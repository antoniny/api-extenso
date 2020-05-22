package br.org.certi.apiextenso.repository;

import br.org.certi.apiextenso.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository  extends JpaRepository<Language, Integer> {

    Language findByKeyAndLocale(String key, String locale);
}
