package krypto2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class Test {

	public static String XOR(String cipher, String key) {
		if (cipher.length() == 0) {
			return "00100000";
		}
		String result = "";
		//System.out.println(cipher + " " + key);
		for (int i = 0; i < cipher.length(); i++) {
			if (cipher.charAt(i) == key.charAt(i)) {
				result += "0";
			} else {
				result += "1";
			}
		}
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String[] kryptogramy = new String[17];
		String[] zdeszyfrowane = new String[17];
		String klucz = "";
		try {
			for (int i = 1; i < 18; i++) {
				kryptogramy[i-1] = new Scanner( new File("kryptogram" + i + ".txt") ).useDelimiter("\\A").next();
				kryptogramy[i-1] = kryptogramy[i-1].replace("\n", "\t").replace("\r", "").replace(" ", "");
				//System.out.println(kryptogramy[i-1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		try {
			Scanner kluczScanner = new Scanner(new File("klucz.txt"));
			klucz = kluczScanner.useDelimiter("\\A").next();
			kluczScanner.close();
		} catch (Exception e) {
			System.out.println("klucz.txt");
		}
		klucz.replace(" ", "").replace("\n", "\t").replace("\r", "");
		//System.out.println(klucz);
		if (klucz.length() > 0) {
			for (int i = 0; i < 17; i++) {
				String temp = "";
				for (int j = 0; j < klucz.length()/8; j++) {
					temp += (char)Integer.parseInt(XOR(kryptogramy[i].substring(j*8, (j+1)*8), klucz.substring(j*8, (j+1)*8)),2);
				}
				zdeszyfrowane[i] = temp;
				kryptogramy[i] = kryptogramy[i].substring(klucz.length());
			}
		}
		System.out.println(zdeszyfrowane[0]);
		String regexp = "[a-zA-Z0-9 .?,!()@\"'%-+]+";
		PrintWriter pw = new PrintWriter("odkodowany.txt");
		String[] odkrytyKlucz = new String[8];
		for (int k0 = 0; k0 < 255; k0++){
			odkrytyKlucz[0] = Integer.toBinaryString(k0);
			while (odkrytyKlucz[0].length() < 8) {
				odkrytyKlucz[0] = "0" + odkrytyKlucz[0];
			}
			String odkodowaneLitery = "";
			for (int i = 0; i < 17; i++) {
				odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(0, 8), odkrytyKlucz[0]), 2);
			}
			if (!odkodowaneLitery.matches(regexp)) {
				continue;
			}
			for (int k1 = 0; k1 < 255; k1++){
				odkrytyKlucz[1] = Integer.toBinaryString(k1);
				while (odkrytyKlucz[1].length() < 8) {
					odkrytyKlucz[1] = "0" + odkrytyKlucz[1];
				}
				odkodowaneLitery = "";
				for (int i = 0; i < 17; i++) {
					odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(8, 16), odkrytyKlucz[1]), 2);
				}
				if (!odkodowaneLitery.matches(regexp)) {
					continue;
				}
				for (int k2 = 0; k2 < 255; k2++){
					odkrytyKlucz[2] = Integer.toBinaryString(k2);
					while (odkrytyKlucz[2].length() < 8) {
						odkrytyKlucz[2] = "0" + odkrytyKlucz[2];
					}
					odkodowaneLitery = "";
					for (int i = 0; i < 17; i++) {
						odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(16, 24), odkrytyKlucz[2]), 2);
					}
					if (!odkodowaneLitery.matches(regexp)) {
						continue;
					}
					
					for (int k3 = 0; k3 < 255; k3++){
						odkrytyKlucz[3] = Integer.toBinaryString(k3);
						while (odkrytyKlucz[3].length() < 8) {
							odkrytyKlucz[3] = "0" + odkrytyKlucz[3];
						}
						odkodowaneLitery = "";
						for (int i = 0; i < 17; i++) {
							odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(24, 32), odkrytyKlucz[3]), 2);
						}
						if (!odkodowaneLitery.matches(regexp)) {
							continue;
						}
						for (int k4 = 0; k4 < 255; k4++){
							odkrytyKlucz[4] = Integer.toBinaryString(k4);
							while (odkrytyKlucz[4].length() < 8) {
								odkrytyKlucz[4] = "0" + odkrytyKlucz[4];
							}
							odkodowaneLitery = "";
							for (int i = 0; i < 17; i++) {
								odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(32, 40), odkrytyKlucz[4]), 2);
							}
							if (!odkodowaneLitery.matches(regexp)) {
								continue;
							}
							for (int k5 = 0; k5 < 255; k5++){
								odkrytyKlucz[5] = Integer.toBinaryString(k5);
								while (odkrytyKlucz[5].length() < 8) {
									odkrytyKlucz[5] = "0" + odkrytyKlucz[5];
								}
								odkodowaneLitery = "";
								for (int i = 0; i < 17; i++) {
									odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(40, 48), odkrytyKlucz[5]), 2);
								}
								if (!odkodowaneLitery.matches(regexp)) {
									continue;
								}
								for (int k6 = 0; k6 < 255; k6++){
									odkrytyKlucz[6] = Integer.toBinaryString(k6);
									while (odkrytyKlucz[6].length() < 8) {
										odkrytyKlucz[6] = "0" + odkrytyKlucz[6];
									}
									odkodowaneLitery = "";
									for (int i = 0; i < 17; i++) {
										odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(48, 56), odkrytyKlucz[6]), 2);
									}
									if (!odkodowaneLitery.matches(regexp)) {
										continue;
									}
									for (int k7 = 0; k7 < 255; k7++){
										odkrytyKlucz[7] = Integer.toBinaryString(k7);
										while (odkrytyKlucz[7].length() < 8) {
											odkrytyKlucz[7] = "0" + odkrytyKlucz[7];
										}
										odkodowaneLitery = "";
										for (int i = 0; i < 17; i++) {
											odkodowaneLitery += (char)Integer.parseInt(XOR(kryptogramy[i].substring(56, 64), odkrytyKlucz[7]), 2);
										}
										if (!odkodowaneLitery.matches(regexp)) {
											continue;
										} else {
											pw.println();
											for (int i = 0; i < odkrytyKlucz.length; i++) {
												pw.print(odkrytyKlucz[i] + "");
											}
											pw.println();
											for (int i = 0; i < kryptogramy.length; i++) {
												pw.print(zdeszyfrowane[i] + "|");
												for (int j = 0; j < odkrytyKlucz.length; j++) {
													pw.print((char)Integer.parseInt(XOR(kryptogramy[i].substring(8*j, 8*(j+1)), odkrytyKlucz[j]),2));
												}
												pw.println();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		pw.close();
	}
}
