/**
 * AreaServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package org.tempuri.areaservice;

/**
 * AreaServiceSkeleton java skeleton for the axisService
 */
public class AreaServiceSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param parameters
	 * @return area
	 */

	public org.tempuri.areaservice.Area calculateRectArea(
			org.tempuri.areaservice.Parameters parameters) {
		org.tempuri.areaservice.Area area = new org.tempuri.areaservice.Area();
		area.setArea(parameters.getParameters().getHeight()
				* parameters.getParameters().getWidth());
		return area;
	}

}
