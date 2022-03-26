package student.hcmus.edu.vn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SlangDictionary implements DictionaryInterface {

    private static final String STORAGE = "slang.txt";
    private static HashMap<String, String> m_Dictionary;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<Map.Entry<String, String>> lookup(String key) {
        return null;
    }

    @Override
    public void insert(String key, String value) throws DuplicateKeyException {

    }

    @Override
    public void delete(String key) throws KeyNotFoundException {

    }

    @Override
    public void makeEmpty() {

    }

    public void loadData() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean word = false;
                boolean meaning = false;
                String s_word, s_meaning;
                StringBuilder data = null;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("word")) word = true;
                    else if (qName.equalsIgnoreCase("meaning")) meaning = true;
                    data = new StringBuilder();
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (word) {
                        s_word = data.toString();
                        word = false;
                    }
                    else if (meaning) {
                        s_meaning = data.toString();
                        meaning = false;
                    }
                    else if (qName.equalsIgnoreCase("record")) {
                        m_Dictionary.put(s_word, s_meaning);
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    data.append(new String(ch, start, length));
                }
            };
            File file = new File(STORAGE);
            try {
                InputStream inputStream = new FileInputStream(file);
                Reader reader = new InputStreamReader(inputStream, "UTF-8");

                InputSource is = new InputSource(reader);
                is.setEncoding("UTF-8");
                saxParser.parse(is, handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
