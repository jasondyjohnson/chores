package com.jasondyjohnson.formatter;

import com.jasondyjohnson.domain.Person;
import com.jasondyjohnson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by Jason on 3/14/2016.
 */
@Component
public class PersonFormatter implements Formatter<Person> {

    @Autowired
    private PersonRepository personRepository;

    public PersonFormatter() {
        super();
    }

    public Person parse(final String text, final Locale locale) throws ParseException {
        final Long personId = Long.valueOf(text);
        return this.personRepository.findById(personId);
    }

    public String print(final Person object, final Locale locale) {
        return (object != null ? Long.toString(object.getId()) : "");
    }

}
