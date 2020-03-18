package edu.drexel.TrainDemo;

//import java.math.BigInteger;
import java.util.Locale;
import java.text.ParseException;

import org.springframework.format.Formatter;

import edu.drexel.TrainDemo.models.Path;

public class PathFormatter implements Formatter<Path> {

    @Override
    public String print(Path path, Locale locale) {
		return path.getId();
	}

	@Override
	public Path parse(String id, Locale locale) throws ParseException {
		Path path = new Path();
		path.setId(id);
		return path;
	}
}
