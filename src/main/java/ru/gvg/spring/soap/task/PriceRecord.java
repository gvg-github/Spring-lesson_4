package ru.gvg.spring.soap.task;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.08.2018.
 */
public class PriceRecord {
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected Date date;
    @XmlElement(required = true)
    protected double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
