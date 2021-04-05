package com.example.grpc.server.grpcserver;

import net.devh.boot.grpc.server.service.GrpcService;
import java.util.*;
import java.lang.Math;
import io.grpc.stub.StreamObserver;

@GrpcService
public class MatrixServiceImpl extends MatrixServiceGrpc.MatrixServiceImplBase{
        @Override
        public void add(AddRequest request, StreamObserver<AddResponse> reply){
                List<java.lang.Integer> matrix1 = request.getMatrix1List();
                List<java.lang.Integer> matrix2 = request.getMatrix2List();
                int size = Math.sqrt(matrix1.size());

                int C[][] = new int[size * 2][size * 2];
                int A[][] = new int[size][size];
                int B[][] = new int[size][size];
                int c = 0;

                for(int i = 0; i < size; i++){
                        for(int j = 0; j < size; j++){
                                A[i][j] = matrix1.get(c);
                                B[i][j] = matrix2.get(c);
                                c++;
                        }
                }

                List<java.lang.Integer> result = new ArrayList<>(C.length);
                for (int i=0;i<A.length;i++)
                {
                        for (int j=0;j<A.length;j++)
                        {
                                result.add(A[i][j]+B[i][j]);
                        }
                }

                AddResponse response = AddResponse.newBuilder().addAllMatrix(result).build();
                reply.onNext(response);
                reply.onCompleted();
     	}

        @Override
        public void multiply(MultiplyRequest request, StreamObserver<MultiplyResponse> reply){
		System.out.println("Request received");
                List<java.lang.Integer> matrix1 = request.getMatrix1List();
                List<java.lang.Integer> matrix2 = request.getMatrix2List();
                int size = Math.sqrt(matrix1.size());
                int C[][] = new int[size * 2][size * 2];
                int A[][] = new int[size][size];
                int B[][] = new int[size][size];
                int c = 0;
		System.out.println(size);
                for(int i = 0; i < size; i++){
                        for(int j = 0; j < size; j++){
                                A[i][j] = matrix1.get(c);
                                B[i][j] = matrix2.get(c);
                                c++;
                        }
                }

                List<java.lang.Integer> result = new ArrayList<>();

                for(int i = 0; i < size; i++){
                        for(int j = 0; j < size; j++){
                                int value = 0;
                                for(int k = 0; k < size; k++){
                                        value += A[i][k] * B[k][j];
                                }
                                C[i][j] = value;
                                result.add(value);
                        }
                }

                MultiplyResponse response = MultiplyResponse.newBuilder().addAllMatrix(result).build();
                reply.onNext(response);
                reply.onCompleted();
        }

}
