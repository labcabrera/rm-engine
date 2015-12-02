package org.lab.rm.engine.core.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Singleton;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.lab.rm.engine.core.actor.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class SettingsManager {

	private static final Logger LOG = LoggerFactory.getLogger(SettingsManager.class);
	private static final String CONFIG_FILE_CHARSET = "UTF8";
	private static final String PATTERN_SECTION = "\\[(.+)\\]";

	private Map<String, Properties> sections = null;

	public Properties getProperties(String sectionName) {
		if (sections == null) {
			throw new RuntimeException("Service is not initialized. Call method load before");
		} else if (!sections.containsKey(sectionName)) {
			throw new RuntimeException(String.format("Missing section name %s", sectionName));
		} else {
			return sections.get(sectionName);
		}
	}

	public String getProperty(String sectionName, String property) {
		Properties properties = getProperties(sectionName);
		if (!properties.containsKey(property)) {
			throw new RuntimeException(String.format("Missing property %s in section %s", property, sectionName));
		}
		return properties.getProperty(property);
	}

	@SuppressWarnings("unchecked")
	public <T> T getProperty(String sectionName, String property, Class<T> typeClass) {
		String stringValue = getProperty(sectionName, property);
		if (String.class.isAssignableFrom(typeClass)) {
			return (T) stringValue;
		} else if (Integer.class.isAssignableFrom(typeClass)) {
			return (T) new Integer(stringValue);
		} else {
			throw new InvalidParameterException(String.format("Class %s is not a valid type", typeClass.getName()));
		}
	}

	public SettingsManager load(String classPathResource) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream configInputStream = classLoader.getResourceAsStream(Constants.CONFIG_PATH);
		Validate.notNull(configInputStream, String.format("Missing configuration file '%s' in classpath", Constants.CONFIG_PATH));
		return load(configInputStream);
	}

	public SettingsManager load(InputStream inputStream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(CONFIG_FILE_CHARSET)));
		try {
			sections = new HashMap<String, Properties>();
			Pattern patternSection = Pattern.compile(PATTERN_SECTION);
			String currentSection = StringUtils.EMPTY;
			String line;
			while ((line = reader.readLine()) != null) {
				if (!StringUtils.isBlank(line) && !StringUtils.trim(line).startsWith("#") && !StringUtils.trim(line).startsWith("//")) {
					Matcher matcherSection = patternSection.matcher(line);
					if (matcherSection.matches()) {
						currentSection = matcherSection.group(1);
						sections.put(currentSection, new Properties());
						LOG.trace(String.format("Starting section %s", currentSection));
					} else {
						int index = line.indexOf("=");
						String key = line.substring(0, index);
						String value = line.substring(index + 1, line.length());
						sections.get(currentSection).put(key, value);
						LOG.trace(String.format("Readed '%s' = '%s'", key, value));
					}
				}
			}
			return this;
		} catch (IOException ex) {
			throw new RuntimeException("Error reading configuration", ex);
		} finally {
			try {
				reader.close();
			} catch (Exception ignore) {
			}
		}
	}
}
