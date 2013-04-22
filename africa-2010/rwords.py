"""


"""

import sys

def rev(line):
    words = line.split(" ")
    return reversed(words)

fh = open(sys.argv[1], 'r')
cases = int(fh.readline())
for i in range(cases):
    print "Case #"+str(i+1)+":",' '.join(rev(fh.readline()[:-1]))
