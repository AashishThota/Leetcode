/*
 * First visualize the problem
 * Problem statement says to generate a array of integers representing number of ones in binary representation of the ith position in array
 * 
 * ex: n = 10
 * 10 - 1010 - 2
 * 9 - 1001 - 2
 * 8 - 1000 - 1
 * 7 - 111 - 3
 * 6 - 110 - 2
 * 5 - 101 - 2
 * 4 - 100 - 1
 * 3 - 011 - 2
 * 2 - 010 - 1
 * 1 - 001 - 1
 * 0 - 000 - 0
 * 
 * Upon looking at above example you can find the pattern that if n is a even number then the number of 1's in n is equal to number of 1's in n/2
 * and number of 1's in odd number is equal to number of 1's in n/2 + 1. 
 */

class Solution {
    public int[] countBits(int n) {
        int[] resultONumberOfOnes = new int[n+1];
        HashMap<Integer, Integer> memoraizednumbers = new HashMap<>();
    	for(int i =0; i<=n;i++) {
    		resultONumberOfOnes[i] = getNumberOfDigitsInBinaryRepresentation(i, memoraizednumbers);
        }
    	
    	return resultONumberOfOnes;
    }
    
    public Integer getNumberOfDigitsInBinaryRepresentation(int number, HashMap<Integer, Integer> memoraizednumbers) {
    	if(number == 0) return 0;
    	if(number == 1) return 1;
    	
    	if(memoraizednumbers.containsKey(number)) return memoraizednumbers.get(number);
    	
    	if(number %2 == 0) {
    		memoraizednumbers.put(number, getNumberOfDigitsInBinaryRepresentation(number/2,memoraizednumbers));
    	} else {
    		memoraizednumbers.put(number, getNumberOfDigitsInBinaryRepresentation(number/2,memoraizednumbers)+1);
    	}
    	
    	return memoraizednumbers.get(number);
    }
}