
package com.numbers.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Wed Dec 30 14:50:06 IST 2015
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "primeResponse", namespace = "http://numbers.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "primeResponse", namespace = "http://numbers.com/")

public class PrimeResponse {

    @XmlElement(name = "return")
    private int _return;

    public int getReturn() {
        return this._return;
    }

    public void setReturn(int new_return)  {
        this._return = new_return;
    }

}
