"""


"""

import sys

def check_pair(tot, item, iteml):
    for i in iteml:
        if item + i == tot:
            return i
    return -1

def find_match(credit, itemc, iteml):
    for i in range(itemc):
        res = check_pair(credit, iteml[i], iteml)
        if res > 0:
            return res,iteml[i]
    return -1,-1

fh = open(sys.argv[1], 'r')
case_count = int(fh.readline())
case_info = {}
for i in range(case_count):
    case_info[i] = {'credit':int(fh.readline()), 'itemc':int(fh.readline()), 'iteml':fh.readline()}
print case_info

for i in range(len(case_info)):
    case = case_info[i]
    print "Case #"+str(i)+": "+"%s %s" % find_match(case['credit'], case['itemc'], case['iteml'])
