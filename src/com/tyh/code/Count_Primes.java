package com.tyh.code;

public class Count_Primes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		System.out.println(new Count_Primes().countPrimes(n));
	}
    public int countPrimes(int n) {
        //isPrime[i] == true means i is prime number
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]) continue;
            for(int j = i * i; j < n; j += i){
                isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}
