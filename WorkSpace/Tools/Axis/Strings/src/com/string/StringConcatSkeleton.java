
/**
 * StringConcatSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package com.string;
    /**
     *  StringConcatSkeleton java skeleton for the axisService
     */
    public class StringConcatSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param concat 
             * @return concatResponse 
         */
        
                 public com.string.ConcatResponse concat
                  (
                  com.string.Concat concat
                  )
            {
                //TODO : fill this with the necessary business logic
                	 com.string.ConcatResponse c=new com.string.ConcatResponse();
             		String s=concat.getS1();
             		String a=concat.getS2();
             		String res=s+a;
             		c.set_return(res);
             		return c;
             		
        }
     
    }
    