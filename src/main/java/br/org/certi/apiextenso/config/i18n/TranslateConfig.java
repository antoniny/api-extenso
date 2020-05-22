package br.org.certi.apiextenso.config.i18n;

import br.org.certi.apiextenso.model.Language;
import br.org.certi.apiextenso.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class TranslateConfig {

    @Autowired
    private LanguageRepository languageRepository;

    private static final String DEFAULT_LOCALE_CODE = "en";
    private static final String DEFAULT_LOCALE_CODE_APP = "pt";

    public String resolveCode(String key, Locale locale) {
        if (key == null || key.isEmpty() || locale.getLanguage() == DEFAULT_LOCALE_CODE_APP){
            return key;
        }

        Language message = languageRepository.findByKeyAndLocale(key,locale.getLanguage());
        if (message == null) {
            message = languageRepository.findByKeyAndLocale(key,DEFAULT_LOCALE_CODE);
        }
        return message.getContent();
    }
}
