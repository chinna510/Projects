package com.bizruntime.springboot;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateKeyController {

	private AtomicInteger atomicInteger = new AtomicInteger();
	
	@RequestMapping("/generateKey")
	public GenerateUniqueKey generateKey() {
		
		GenerateUniqueKey generateUniqueKey = new GenerateUniqueKey(atomicInteger.incrementAndGet());
		return generateUniqueKey;
		
	}
	
	
}
