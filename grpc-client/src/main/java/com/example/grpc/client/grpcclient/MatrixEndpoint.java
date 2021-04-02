package com.example.grpc.client.grpcclient;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.StringWriter;
import java.io.PrintWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class MatrixEndpoint {

	GRPCClientService grpcClientService;
	@Autowired
    	public MatrixEndpoint(GRPCClientService grpcClientService) {
        	this.grpcClientService = grpcClientService;
    	}

        @PostMapping
        public ResponseEntity<String> multiplyMatrix(@RequestParam String deadline, @RequestPart("matrix1") MultipartFile mat1Param, @RequestPart("matrix2") MultipartFile mat2Param){
                if(null == mat1Param.getOriginalFilename() || null == mat2Param.getOriginalFilename() || deadline == null)
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                try{
                        String mat1 = new String(mat1Param.getBytes());
                        String mat2 = new String(mat2Param.getBytes());
                        int deadlineParam = Integer.parseInt(deadline);
                        int[][] matrix1 = toSquareMatrix(mat1), matrix2 = toSquareMatrix(mat2);
                        if(matrix1 == null || matrix2 == null || matrix1.length != matrix2.length)
                                throw new IllegalArgumentException("Wrong arguments");
                        int[][] result = this.grpcClientService.multiplyMatrixBlock(matrix1, matrix2, deadlineParam);

                        return new ResponseEntity<>(Arrays.toString(result), HttpStatus.OK);
                }
                catch(IOException e){
                        return new ResponseEntity<>("IOException", HttpStatus.BAD_REQUEST);
                }
                catch(NumberFormatException e){
                        return new ResponseEntity<>("NumberFormatException", HttpStatus.BAD_REQUEST);
                }
		catch(Exception e){
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();

			String stackTrace = writer.toString();
			return new ResponseEntity<>(stackTrace, HttpStatus.OK);
		}

        }

        static int[][] toSquareMatrix(String matStr){
                String lines[] =  matStr.split("\\r?\\n");
                int size = lines.length;
                int matrix[][] = new int[size][size];

                for(int i = 0; i < size; i++){
                        String[] row = lines[i].split(" ");
                        if(row.length != size)
                                return null;
                        for(int j = 0; j < size; j++){
                                try{
                                        matrix[i][j] = Integer.parseInt(row[j]);
                                }
                                catch(NumberFormatException e){
                                        return null;
                                }
                        }
                }
                return matrix;
        }
}
