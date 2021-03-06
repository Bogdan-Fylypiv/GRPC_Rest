package com.example.grpc.client.grpcclient;

import java.util.*;
import java.lang.Math;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.TimeUnit;
import com.example.grpc.server.grpcserver.MultiplyRequest;
import com.example.grpc.server.grpcserver.MultiplyResponse;
import com.example.grpc.server.grpcserver.AddRequest;
import com.example.grpc.server.grpcserver.AddResponse;
import com.example.grpc.server.grpcserver.MatrixServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class GRPCClientService {
    public int[][] multiplyMatrixBlock(int[][] A, int [][] B, int deadline) {
                int MAX = A.length;
                int bSize = MAX / 2;
                int[][] A1 = new int[MAX][MAX];
                int[][] A2 = new int[MAX][MAX];
                int[][] A3 = new int[MAX][MAX];
                int[][] A4 = new int[MAX][MAX];
                int[][] A5 = new int[MAX][MAX];
                int[][] B1 = new int[MAX][MAX];
                int[][] B2 = new int[MAX][MAX];
                int[][] B3 = new int[MAX][MAX];
                int[][] B4 = new int[MAX][MAX];
                int[][] B5 = new int[MAX][MAX];
                int[][] C1 = new int[MAX][MAX];
                int[][] C2 = new int[MAX][MAX];
                int[][] C3 = new int[MAX][MAX];
                int[][] C4 = new int[MAX][MAX];
                int[][] C5 = new int[MAX][MAX];
                int[][] D1 = new int[MAX][MAX];
                int[][] D2 = new int[MAX][MAX];
                int[][] D3 = new int[MAX][MAX];
                int[][] D4 = new int[MAX][MAX];
                int[][] D5 = new int[MAX][MAX];
                int[][] res= new int[MAX][MAX];

                for (int i = 0; i < bSize; i++)
                {
                    for (int j = 0; j < bSize; j++)
                        {
                                A1[i][j]=A[i][j];
                                A2[i][j]=B[i][j];
                        }
                }
                for (int i = 0; i < bSize; i++)
                {
                        for (int j = bSize; j < MAX; j++)
                        {
                                B1[i][j-bSize]=A[i][j];
                                B2[i][j-bSize]=B[i][j];
                        }
                }
                for (int i = bSize; i < MAX; i++)
                {
                        for (int j = 0; j < bSize; j++)
                        {
                                C1[i-bSize][j]=A[i][j];
                                C2[i-bSize][j]=B[i][j];
                        }
                }
                for (int i = bSize; i < MAX; i++)
                {
                                        for (int j = bSize; j < MAX; j++)
                        {
                                D1[i-bSize][j-bSize]=A[i][j];
                                D2[i-bSize][j-bSize]=B[i][j];
                        }
                }

                List<String> ipAddresses = new ArrayList<>();
                initialiseIPAddresses(ipAddresses);

                final ArrayList<MatrixServiceGrpc.MatrixServiceBlockingStub> stubs = new ArrayList<>();
                final ArrayList<MultiplyRequest> requests = new ArrayList<>();
                final ArrayList<MultiplyResponse> multResponses = new ArrayList<>(7);

		for (int i = 0; i < 7; i++)
			multResponses.add(null);

                List<ManagedChannel> channels = initialiseStubs(ipAddresses, stubs);

                ManagedChannel channel = ManagedChannelBuilder.forAddress("3.91.208.41", 9090).usePlaintext().build();
		MatrixServiceGrpc.MatrixServiceBlockingStub stub = MatrixServiceGrpc.newBlockingStub(channel);

                ArrayList<java.lang.Integer> listA1 = new ArrayList<>();
                ArrayList<java.lang.Integer> listA2 = new ArrayList<>();
                ArrayList<java.lang.Integer> listA3 = new ArrayList<>();
                ArrayList<java.lang.Integer> listA4 = new ArrayList<>();
                ArrayList<java.lang.Integer> listA5 = new ArrayList<>();
                ArrayList<java.lang.Integer> listB1 = new ArrayList<>();
                ArrayList<java.lang.Integer> listB2 = new ArrayList<>();
                ArrayList<java.lang.Integer> listB3 = new ArrayList<>();
                ArrayList<java.lang.Integer> listB4 = new ArrayList<>();
                ArrayList<java.lang.Integer> listB5 = new ArrayList<>();
                ArrayList<java.lang.Integer> listC1 = new ArrayList<>();
                ArrayList<java.lang.Integer> listC2 = new ArrayList<>();
                ArrayList<java.lang.Integer> listC3 = new ArrayList<>();
                ArrayList<java.lang.Integer> listC4 = new ArrayList<>();
                ArrayList<java.lang.Integer> listC5 = new ArrayList<>();
                ArrayList<java.lang.Integer> listD1 = new ArrayList<>();
                ArrayList<java.lang.Integer> listD2 = new ArrayList<>();
                ArrayList<java.lang.Integer> listD3 = new ArrayList<>();
		ArrayList<java.lang.Integer> listD4 = new ArrayList<>();
                ArrayList<java.lang.Integer> listD5 = new ArrayList<>();

                arrayToList(A1, A2, listA1, listA2);
                arrayToList(A3, A4, listA3, listA4);
                arrayToList(B1, B2, listB1, listB2);
                arrayToList(B3, B4, listB3, listB4);
                arrayToList(C1, C2, listC1, listC2);
                arrayToList(C3, C4, listC3, listC4);
                arrayToList(D1, D2, listD1, listD2);
                arrayToList(D3, D4, listD3, listD4);

                addRequests(requests, listA1, listA2, listB1, listB2, listC1, listC2, listD1, listD2);

                int footprint = (int)measureMultTime(stub, listA1, listA2, A4, listA4);
		int numServers = (int)Math.ceil((footprint * 7.0) / (deadline*1.0));
		numServers = numServers < 1 ? 1 : numServers;
		numServers = numServers > 7 ? 7 : numServers;

		System.out.println("Footprint: " + footprint + "Servers required: " + numServers);
		try{
	        	multiply(multResponses, stubs, requests, numServers);
		}
		catch(InterruptedException e){
			System.out.println("Interrupted");
		}

                AddResponse addResponse = stub.add(AddRequest.newBuilder()
                        .addAllMatrix1(toSmallerMatrix(listA4))
                        .addAllMatrix2(toSmallerMatrix(toSmallerMatrix(multResponses.get(0).getMatrixList()))).build());
                listToArray(addResponse.getMatrixList(), A3);

                addResponse = stub.add(AddRequest.newBuilder()
                        .addAllMatrix1(toSmallerMatrix(toSmallerMatrix(multResponses.get(1).getMatrixList())))
                        .addAllMatrix2(toSmallerMatrix(toSmallerMatrix(multResponses.get(2).getMatrixList()))).build());
                listToArray(addResponse.getMatrixList(), B3);


                addResponse = stub.add(AddRequest.newBuilder()
                        .addAllMatrix1(toSmallerMatrix(toSmallerMatrix(multResponses.get(3).getMatrixList())))
                        .addAllMatrix2(toSmallerMatrix(toSmallerMatrix(multResponses.get(4).getMatrixList()))).build());
                listToArray(addResponse.getMatrixList(), C3);


                addResponse = stub.add(AddRequest.newBuilder()
                        .addAllMatrix1(toSmallerMatrix(toSmallerMatrix(multResponses.get(5).getMatrixList())))
                        .addAllMatrix2(toSmallerMatrix(toSmallerMatrix(multResponses.get(6).getMatrixList()))).build());
                listToArray(addResponse.getMatrixList(), D3);

                channel.shutdown();
		for(ManagedChannel ch : channels)
			ch.shutdown();

                for (int i = 0; i < bSize; i++)
                {
                    for (int j = 0; j < bSize; j++)
                    {
                        res[i][j]=A3[i][j];
                    }
                }
                for (int i = 0; i < bSize; i++)
                {
                    for (int j = bSize; j < MAX; j++)
                    {
                        res[i][j]=B3[i][j-bSize];
                    }
                }
                for (int i = bSize; i < MAX; i++)
                {
                    for (int j = 0; j < bSize; j++)
                    {
                        res[i][j]=C3[i-bSize][j];
                    }
                }
                for (int i = bSize; i < MAX; i++)
                {
                    for (int j = bSize; j < MAX; j++)
                    {
                        res[i][j]=D3[i-bSize][j-bSize];
                    }
                }
                return res;
        }

	static List<java.lang.Integer> toSmallerMatrix(List<java.lang.Integer> list){
		List<java.lang.Integer> newList = new ArrayList<>();
		int size = (int)(Math.sqrt(list.size())/2), c = 0;
		for (int i=0; i<size; i++)
                {
                        for (int j=0; j<size;j++)
                        {
                                newList.add(list.get(c));
				if(j < size - 1)
					c++;
                        }
			c += size + 1;
                }

		return newList;
	}

        static void printMatrix(List<java.lang.Integer> list){
                int size = (int) Math.sqrt(list.size());
                int c = 0;
                for(int i = 0; i < size; i++){
                        for (int j = 0; j < size; j++){
                                System.out.print(list.get(c));
                                c++;
                        }
			System.out.println("");
		}
        }

        static long measureMultTime(MatrixServiceGrpc.MatrixServiceBlockingStub stub, List<java.lang.Integer> list1, List<java.lang.Integer> list2, int[][] A4, List<java.lang.Integer> listA4){
                Instant start = Instant.now();

		MultiplyResponse multResponse = stub.multiply(MultiplyRequest.newBuilder()
                .addAllMatrix1(toSmallerMatrix(list1))
                .addAllMatrix2(toSmallerMatrix(list2)).build());

		long footprint = Duration.between(start, Instant.now()).toMillis();

                List<java.lang.Integer> result = multResponse.getMatrixList();
		int c = 0, size = (int)Math.sqrt(result.size());
                for(int i = 0; i < result.size(); i++){
                	listA4.set(i, result.get(i));
               	}

                return footprint;
        }

        static void multiply(ArrayList<MultiplyResponse> multResponses, ArrayList<MatrixServiceGrpc.MatrixServiceBlockingStub> stubs, ArrayList<MultiplyRequest> requests, int numServers)throws InterruptedException{
                ExecutorService executor = Executors.newFixedThreadPool(numServers);
                if(numServers == 1){
                        Runnable runnableTask = () -> {
                                multResponses.set(0, stubs.get(0).multiply(requests.get(0)));
                                multResponses.set(1, stubs.get(0).multiply(requests.get(1)));
                                multResponses.set(2, stubs.get(0).multiply(requests.get(2)));
                                multResponses.set(3, stubs.get(0).multiply(requests.get(3)));
                                multResponses.set(4, stubs.get(0).multiply(requests.get(4)));
                                multResponses.set(5, stubs.get(0).multiply(requests.get(5)));
                                multResponses.set(6, stubs.get(0).multiply(requests.get(6)));
                        };
                        executor.execute(runnableTask);
                }
                else if(numServers == 2){
                        Runnable runnableTask = () -> {
                                multResponses.set(0, stubs.get(0).multiply(requests.get(0)));
                                multResponses.set(1, stubs.get(0).multiply(requests.get(1)));
                                multResponses.set(2, stubs.get(0).multiply(requests.get(2)));
                                multResponses.set(3, stubs.get(0).multiply(requests.get(3)));
                        };
                        Runnable runnableTask1 = () -> {
                                multResponses.set(4, stubs.get(1).multiply(requests.get(4)));
                                multResponses.set(5, stubs.get(1).multiply(requests.get(5)));
                                multResponses.set(6, stubs.get(1).multiply(requests.get(6)));
                        };
                        executor.execute(runnableTask);
                        executor.execute(runnableTask1);
                }
                else if(numServers == 3){
                        Runnable runnableTask = () -> {
                                multResponses.set(0, stubs.get(0).multiply(requests.get(0)));
                                multResponses.set(1, stubs.get(0).multiply(requests.get(1)));
                                multResponses.set(2, stubs.get(0).multiply(requests.get(2)));
                        };
                        Runnable runnableTask1 = () -> {
                                multResponses.set(3, stubs.get(1).multiply(requests.get(3)));
                                multResponses.set(4, stubs.get(1).multiply(requests.get(4)));
                                multResponses.set(5, stubs.get(1).multiply(requests.get(5)));
                        };
                        Runnable runnableTask2 = () -> {
	                        multResponses.set(6, stubs.get(2).multiply(requests.get(6)));
                        };
                        executor.execute(runnableTask);
                        executor.execute(runnableTask1);
                        executor.execute(runnableTask2);
                }
                else if(numServers == 4){
                        Runnable runnableTask = () -> {
                                multResponses.set(0, stubs.get(0).multiply(requests.get(0)));
                                multResponses.set(1, stubs.get(0).multiply(requests.get(1)));
                        };
                        Runnable runnableTask1 = () -> {
                                multResponses.set(2, stubs.get(1).multiply(requests.get(2)));
                                multResponses.set(3, stubs.get(1).multiply(requests.get(3)));
                        };
                        Runnable runnableTask2 = () -> {
                                multResponses.set(4, stubs.get(2).multiply(requests.get(4)));
                                multResponses.set(5, stubs.get(2).multiply(requests.get(5)));
                        };
                        Runnable runnableTask3 = () -> {
                                multResponses.set(6, stubs.get(3).multiply(requests.get(6)));
                        };
                        executor.execute(runnableTask);
                        executor.execute(runnableTask1);
                        executor.execute(runnableTask2);
                        executor.execute(runnableTask3);
                }
                else if(numServers == 5){
                        Runnable runnableTask = () -> {
                                multResponses.set(0, stubs.get(0).multiply(requests.get(0)));
                                multResponses.set(1, stubs.get(0).multiply(requests.get(1)));
                        };
                        Runnable runnableTask1 = () -> {
                                multResponses.set(2, stubs.get(1).multiply(requests.get(2)));
                        };
                        Runnable runnableTask2 = () -> {
                                multResponses.set(3, stubs.get(2).multiply(requests.get(3)));
                                multResponses.set(4, stubs.get(2).multiply(requests.get(4)));
                        };
                        Runnable runnableTask3 = () -> {
                                multResponses.set(5, stubs.get(3).multiply(requests.get(5)));
                                multResponses.set(6, stubs.get(3).multiply(requests.get(6)));
                        };

                        executor.execute(runnableTask);
                        executor.execute(runnableTask1);
                        executor.execute(runnableTask2);
                        executor.execute(runnableTask3);
                }
                else if(numServers == 6){

                        Runnable runnableTask = () -> {
                                multResponses.set(0, stubs.get(0).multiply(requests.get(0)));
                                multResponses.set(1, stubs.get(0).multiply(requests.get(1)));
                        };
                        Runnable runnableTask1 = () -> {
                                multResponses.set(2, stubs.get(1).multiply(requests.get(2)));
                        };
                        Runnable runnableTask2 = () -> {
                                multResponses.set(3, stubs.get(2).multiply(requests.get(3)));
                        };
                        Runnable runnableTask3 = () -> {
                                multResponses.set(5, stubs.get(4).multiply(requests.get(5)));
                        };
                        Runnable runnableTask4 = () -> {
                                multResponses.set(6, stubs.get(5).multiply(requests.get(6)));
                        };

                        executor.execute(runnableTask);
                        executor.execute(runnableTask1);
                        executor.execute(runnableTask2);
                        executor.execute(runnableTask3);
                        executor.execute(runnableTask4);

                }
                else if(numServers == 7){
                        Runnable runnableTask = () -> {
                                multResponses.set(0, stubs.get(0).multiply(requests.get(0)));
                        };
                        Runnable runnableTask1 = () -> {
                                multResponses.set(1, stubs.get(1).multiply(requests.get(1)));
                        };
                        Runnable runnableTask2 = () -> {
                                multResponses.set(2, stubs.get(2).multiply(requests.get(2)));
                        };
                        Runnable runnableTask3 = () -> {
                                multResponses.set(3, stubs.get(3).multiply(requests.get(3)));
                        };
                        Runnable runnableTask4 = () -> {
                                multResponses.set(4, stubs.get(4).multiply(requests.get(4)));
                        };
                        Runnable runnableTask5 = () -> {
                                multResponses.set(5, stubs.get(5).multiply(requests.get(5)));
                        };

                        executor.execute(runnableTask);
                        executor.execute(runnableTask1);
                        executor.execute(runnableTask2);
                        executor.execute(runnableTask3);
                        executor.execute(runnableTask4);
                        executor.execute(runnableTask5);
                	multResponses.set(6, stubs.get(6).multiply(requests.get(6)));
		}

                executor.shutdown();
                while(!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
			Thread.sleep(200);
	}

       static void addRequests(ArrayList<MultiplyRequest> requests, List<java.lang.Integer> listA1, List<java.lang.Integer> listA2, List<java.lang.Integer> listB1, List<java.lang.Integer> listB2, List<java.lang.Integer> listC1, List<java.lang.Integer> listC2, List<java.lang.Integer> listD1, List<java.lang.Integer> listD2){
		requests.add(MultiplyRequest.newBuilder().addAllMatrix1((listA1)).addAllMatrix2((listA2)).build());
                requests.add(MultiplyRequest.newBuilder().addAllMatrix1((listB1)).addAllMatrix2((listC2)).build());
                requests.add(MultiplyRequest.newBuilder().addAllMatrix1((listA1)).addAllMatrix2((listB2)).build());
                requests.add(MultiplyRequest.newBuilder().addAllMatrix1((listB1)).addAllMatrix2((listD2)).build());
                requests.add(MultiplyRequest.newBuilder().addAllMatrix1((listC1)).addAllMatrix2((listA2)).build());
                requests.add(MultiplyRequest.newBuilder().addAllMatrix1((listD1)).addAllMatrix2((listC2)).build());
                requests.add(MultiplyRequest.newBuilder().addAllMatrix1((listC1)).addAllMatrix2((listB2)).build());
        }

        static void initialiseIPAddresses(List<String> ipAddresses){
                ipAddresses.add("18.234.130.166");
                ipAddresses.add("3.83.245.179");
                ipAddresses.add("54.90.1.113");
                ipAddresses.add("54.226.16.179");
                ipAddresses.add("54.160.128.185");
                ipAddresses.add("3.80.27.51");
                ipAddresses.add("54.90.71.92");
        }

        static List<ManagedChannel> initialiseStubs(List<String> ipAddresses, List<MatrixServiceGrpc.MatrixServiceBlockingStub> stubs){
                ManagedChannel channel;
		List<ManagedChannel> channels = new ArrayList<ManagedChannel>();
                MatrixServiceGrpc.MatrixServiceBlockingStub stub;

                for(String address : ipAddresses){
                        channel = ManagedChannelBuilder.forAddress(address, 9090).usePlaintext().build();
                        stub = MatrixServiceGrpc.newBlockingStub(channel);
			channels.add(channel);
                        stubs.add(stub);
                }
		return channels;
        }

        static void listToArray(List<java.lang.Integer> list, int[][] A){
                int c = 0, bSize = A.length;
                for(int i = 0; i < bSize; i++){
                        for(int j = 0; j < bSize; j++){
                                A[i][j] = list.get(c);
                                c++;
                        }
                }
        }

        static void arrayToList(int[][] matrix1, int[][] matrix2, List<java.lang.Integer> list1, List<java.lang.Integer> list2){
                for(int i = 0; i < matrix1.length; i++)
                        for(int j = 0; j < matrix2.length; j++){
                                list1.add(matrix1[i][j]);
                                list2.add(matrix2[i][j]);
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

