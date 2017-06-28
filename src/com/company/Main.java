package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int arr[]=new int[4];       //记录四个砝码重量

        for (int i=1;i<9;i++){
            arr[0]=i;
            for (int j=i+1;j<(40-i)/3;j++){
                arr[1]=j;
                for (int k=j+1;k<(41-i-j)/2;k++){
                    arr[2]=k;
                    arr[3]=40-arr[0]-arr[1]-arr[2];
                    check(arr);
                }
            }
        }
    }

    //判断是否符合条件
    public static void check(int arr[]){
        int[] b={0,1,-1};           //称重系数
        int c[]=new int[40];        //所有需要称的重量
        for (int i=0;i<40;i++){
            c[i]=i+1;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    for(int n=0;n<3;n++){
                        int all=b[i]*arr[0]+b[j]*arr[1]+b[k]*arr[2]+b[n]*arr[3];
                        for (int m=0;m<40;m++){
                            if(c[m]==all) c[m]=0;//若存在一个重量=all，说明可以称取这个重量，将数组中该重量置零
                        }
                    }
                }
            }
        }

        for (int i=0;i<40;i++){
            if(c[i]!=0) break;          //有一个不为0,说明无法称取1-40间的所有重量
            if(i==39){
                System.out.print("符合条件的组合："+arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+"\n");
            }
        }

    }
}
