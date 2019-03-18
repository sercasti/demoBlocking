package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/blocking")
	public String getSha512Hex(@RequestParam String id) throws IOException {
		String pathToFile = "/Users/sergio/Downloads/fotos/FOTO" + id + ".JPG";
		FileInputStream fileInputStream = null;
		String sha512Hex = null;
		try {
			fileInputStream = new FileInputStream(new File(pathToFile));
			sha512Hex = DigestUtils.sha512Hex(fileInputStream);
		} finally {
			fileInputStream.close();
		}
		return sha512Hex;
	}

}
