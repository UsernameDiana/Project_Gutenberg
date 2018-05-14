/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author diana
 */
public interface ICity {

    void setName(String name);

    void setLat(double lat);

    void setLon(double lon);

    String getName();

    double getLat();

    double getLon();
}
