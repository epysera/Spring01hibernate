package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Publisher;
import pl.coderslab.entity.PublisherDao;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    PublisherDao publisherDao;

    @Override
    public Publisher convert(String source) {
        return publisherDao.findPublisherById(Long.parseLong(source));
    }
}