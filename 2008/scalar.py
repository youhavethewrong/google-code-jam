"""

"""

import sys


fh = open(sys.argv[1], 'r')
cases = int(fh.readline())
case_info = {}
for i in range(cases):
    case_info[i] = {'len':int(fh.readline()), 'x':fh.readline()[:-1].split(" "), 'y':fh.readline()[:-1].split(" "))
