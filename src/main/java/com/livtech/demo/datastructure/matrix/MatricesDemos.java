package com.livtech.demo.datastructure.matrix;

import java.util.Scanner;

public class MatricesDemos {
	int rows,cols;
	int[][] mat;
	Scanner scanner;
	public static void main(String[] args) {
		MatricesDemos demo=new MatricesDemos();
		demo.inserElementFromConsole();
		demo.traverse();
		demo.search();
	}
	MatricesDemos(){
		scanner=new Scanner(System.in);
	}
	private  void inserElementFromConsole(){
		System.out.print("Enter number of rows :");
		rows=scanner.nextInt();
		System.out.print("\nEnter number of cols :");
		cols=scanner.nextInt();
		mat=new int[rows][cols];
		System.out.println("\nEnter elements:");
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				mat[i][j]=scanner.nextInt();
			}
		}
	}
	private void traverse(){
		System.out.println("\nGiven Matrix :");
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	private void printSpiralFormat(){
		int i=0,j=0;
		while(true){
			for(j=0;j<cols;j++){
				System.out.print(mat[i][j]+" ");
			}
			j--;
		
		}
	}
	
	private  void search(){
		System.out.print("\nEnter the element to search :");
		int key=scanner.nextInt();
		int i=0,j=cols-1;
		while(i<rows && j>=0){
			if(mat[i][j]==key){
				System.out.println("Element found at "+i +" "+ j);
				return;
			}
			if(mat[i][j]>key)
				j--;
			else
				i++;
		}
		System.out.println("Element not found");
	}

}
