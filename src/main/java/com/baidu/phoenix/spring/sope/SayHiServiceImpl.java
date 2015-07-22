package com.baidu.phoenix.spring.sope;

import org.springframework.stereotype.Service;

@Service
public class SayHiServiceImpl implements SayHiService {

	public void sayHi() {
		System.out.println("hello world");
	}

}
