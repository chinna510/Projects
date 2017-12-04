package com.jcg;

import org.apache.log4j.Logger;

public class Bean {
	static Logger log=Logger.getLogger(Bean.class);
	public void sayHello() {
		log.info("Hello from loaded Bean class !!!");
	}

}
