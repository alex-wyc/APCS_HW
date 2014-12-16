import sys;

out = open("primeList.txt","a");

f = open(sys.argv[1], "r").read().split("\n")[1:];

while '' in f:
	f.remove('');

primeList = [];

for element in f:
	foo = element[0:-3].split(" ");
	while '' in foo:
		foo.remove('');

	primeList += foo;

for prime in primeList:
	out.write(prime + "\n");
