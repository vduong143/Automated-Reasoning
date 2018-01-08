README

Contact Information:

Name: Viet Duong
Course: CSC 242 SPRING 2017
Assignment: Project 02

**Important Notes for Graders
1. The proofs by resolution for ModusPonens, SimpleWumpusWorld and HornClauses are in the files ModusPonens.txt, SimpleWumpusWorld.txt and HornClauses.txt

2. To show proofs by resolution on cmd, please go to solver/Resolution and uncomment these two lines in the PLResolve() method:
	//System.out.println("\nClauses: " + clause_i + "\t" + clause_j);
 	//System.out.println("Resolvents: " + resolvents);
Otherwise I only show the results for both implementations.

3. In addition to the required Modus Ponens and Simple Wumpus World, my third problem is HornClauses

4. EXTRA CREDIT: Liars and Truth-tellers (a),(b), More Liars and Truth-tellers.

**Files included
	Files provided my Professor Ferguson:
		All files in pl.core package
		All files in pl.cnf package except CNFTest.java
		All files in pl.util package
	Files created by me:
		ModelImplemented.java
		ModelChecking.java
		Resolution.java
		ModusPonens.java
		SimpleWumpusWorld.java
		HornClauses.java
		LiarsAndTruthTellersA.java
		LiarsAndTruthTellersB.java
		MoreLiarsAndTruthTellers.java

**How to compile and run:

1. Change directory to the src folder in terminal.

2. Using the following commands to compile the necessary files.
	javac core/*.java
	javac util/*.java
	javac cnf/*.java
	javac solver/*.java
	javac test/*.java

3. Run the program using the commands:
-ModusPonens: 			java test.ModusPonens
-SimpleWumpusWorld: 		java test.SimpleWumpusWorld
-HornClauses:			java test.HornClauses
-LiarsAndTruthTellersA:		java test.LiarsAndTruthTellersA
-LiarsAndTruthTellersB:		java test.LiarsAndTruthTellersB
-MoreLiarsAndTruthTellers:	java test.MoreLiarsAndTruthTellers