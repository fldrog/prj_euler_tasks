package com.florinbotis.prjeuler.task44;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2. The first ten pentagonal numbers are:

1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...

It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference, 70 − 22 = 48, is not pentagonal.

Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised; what is the value of D?
 * 
 * 
 * @author botisf
 *
 */
public class PentagonNumbers {

	private HashSet<BigInteger> pentagonals = new HashSet<BigInteger>();

	public PentagonNumbers() {
		init();
	}

	public void init() {
		pentagonals = generatePentagonals(100000);
	}

	private HashSet<BigInteger> generatePentagonals(int pentagonalsCount) {
		HashSet<BigInteger> pentagonals = new HashSet<BigInteger>();
		for (int i = 1; i < pentagonalsCount; i++) {
			pentagonals.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(3 * i - 1)).divide(BigInteger.valueOf(2L)));
		}
		return pentagonals;
	}

	public void getPair() {
		BigInteger[] pentagonalsArray = pentagonals.toArray(new BigInteger[0]);
		Arrays.sort(pentagonalsArray);
		for (int j = 0; j < pentagonals.size(); j++) {
			BigInteger pj = pentagonalsArray[j];
			System.out.println("J=" + j);
			for (int k = j + 1; k < pentagonals.size(); k++) {
				BigInteger pk = pentagonalsArray[k];
				BigInteger sum = pj.add(pk);
				if (pentagonals.contains(sum)) {
					BigInteger dif = pk.subtract(pj);
					if (pentagonals.contains(dif)) {
						System.out.println("j=" + j + " k=" + k + " pj=" + pj + " pk=" + pk + " sum=" + sum + " dif=" + dif);
						return;
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		new PentagonNumbers().getPair();
	}
}
