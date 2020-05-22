package com.livtech.demo.datastructure.algos;

public class SumOfSqures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n=76, maxSqr=0,temp=n, count=0;
		
		for(int i=1;i<=n/2+1;i++){
			//System.out.println(" i "+i);
			if((n-(i*i))<0){
				maxSqr=i-1;
				break;
			}
		}
		//System.out.println(" maxSqr "+maxSqr);
		while(temp>0 && maxSqr>0){
			//System.out.println(" maxSqr "+maxSqr);
			if(temp>=(maxSqr*maxSqr)){
				System.out.println(" maxSqr "+maxSqr);
				//System.out.println(" temp "+temp);
				temp=temp-maxSqr*maxSqr;
				count++;
			}
			else{
				maxSqr--;
			}
		}
		
		System.out.println(" count "+count);

	}

}
