package com.epam.ermakov;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DOM {

    private static ArrayList<Human> humans = new ArrayList<>();
    // Константы для элементов
    private static final String EMPLOYEE = "employee";
    private static final String MANAGER = "manager";


    /**
     * Метод ищет информацию про теги по имени element и вносит всю информацию в коллекцию humans.
     * @param document Документ, в котором будем искать элементы.
     * @param element Имя элемента, теги которого нужно найти. Должна быть одна из констант, которые определяются выше.
     */
    private void collectInformation(Document document, final String element) {
        // Получение всех элементов по имени тега.
        NodeList elements = document.getElementsByTagName(element);

        // Перебор всех найденных элементов
        for (int i = 0; i < elements.getLength(); i++) {
            // Получение всех атрибутов элемента
            NamedNodeMap attributes = elements.item(i).getAttributes();
            String surname = attributes.getNamedItem("surname").getNodeValue();

            // В зависимости от типа элемента, нам нужно собрать свою дополнительну информацию про каждый подкласс, а после добавить нужные образцы в коллекцию.
            switch (element) {
                case EMPLOYEE: {
                    String name = attributes.getNamedItem("name").getNodeValue();
                    String year = attributes.getNamedItem("year").getNodeValue();
                    String phone= attributes.getNamedItem("phone").getNodeValue();
                    String manager= attributes.getNamedItem("manager").getNodeValue();
                    humans.add(new Employee(surname, name, year, phone, manager));
                } break;
                case MANAGER: {
                    String name = attributes.getNamedItem("name").getNodeValue();
                    String year = attributes.getNamedItem("year").getNodeValue();
                    String phone= attributes.getNamedItem("phone").getNodeValue();
                    String department= attributes.getNamedItem("department").getNodeValue();
                    humans.add(new Manager(surname, name, year, phone, department));
                } break;
            }
        }
    }

    public void dOMView() throws IOException, SAXException, ParserConfigurationException {


        // Ридер для считывания имени тега из консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(new File("src/main/resources/xml_file1.xml"));

        // Получение информации про каждый элемент отдельно
        collectInformation(document, EMPLOYEE);
        collectInformation(document, MANAGER);

        // Вывод информации
        humans.forEach(System.out::println);
    }
    public void dOMAddNote()throws IOException, SAXException, ParserConfigurationException{
        //Выбор элемента чтобы добавить новую запись в его конец

    }
    public void dOMSearchBySth()throws IOException, SAXException, ParserConfigurationException{
        //Выбор атрибута для поиска на основе switch

    }
}